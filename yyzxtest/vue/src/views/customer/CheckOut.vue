<script>
import {
  addRecords,
  listCheckoutVoPage,
  UpdateActualBackTime,
  examineCheckout,
  recallApplication
} from "@/api/Checkout"
import {addCustomer, findAllCustomer, updateCustomer} from "@/api/consumerApi"
import {getCurDate} from "@/utils/common.js"
import {getSessionStorage} from '@/utils/common.js'
export default {
  computed:{
    indexMethodCheckout() {
      return (index) =>
          (this.page_checkout.currentPag - 1) * this.page_checkout.pageSize + index + 1;
    },
    // 客户信息表的序号方法
    indexMethodCustomer() {
      return (index) =>
          (this.page_customer.currentPag - 1) * this.page_customer.pageSize + index + 1;
    }
  },
  mounted() {
    this.roleID = getSessionStorage("user").roleId;
    this.getCustomerList()
    this.getCheckoutList()
  },
  data(){
    return{
      //管理员
      dialog_operator:{
        dialogVisible: false, //模态框状态
        tops: "", //模态框标题,
        item: {
          id:"",
          customerName:"",
          actualReturnTime:"",
          isDeleted:"",
          customerId:"",
          checkoutReason: "",      // 外出事由
          checkoutTime: "",        // 外出时间
          auditStatus: ""
        },
        statusArr: [
          {
            value: 1,
            label: "停用"
          },
          {
            value: 2,
            label: "启用"
          }
        ]
      },

      // 控制弹窗显示
      addCheckoutDialogVisible: false,

      // 新增退住登记表单数据
      addCheckoutForm: {
        customerName: "",
        customerSex: "",
        customerAge: "",
        bedId: "",
        levelId: "",
        customerId: "",  // 重要，后端关联客户id
        checkoutReason: "",
        checkoutTime: "",
        expectedReturnTime: "",
      },

      // 校验规则
      addCheckoutRules: {
        customerName: [{ required: true, message: "请选择客户", trigger: "blur" }],
        checkoutReason: [{ required: true, message: "请填写退出事由", trigger: "blur" }],
        checkoutTime: [{ required: true, message: "请选择退出时间", trigger: "change" }],
        checkoutType: [{ required: true, message: "请选择退住类型", trigger: "change" }]
      },

      // 客户匹配列表缓存
      customerSuggestions: [],

      roleID:"",
      queryParams: {
        status: "1", //查询默认状态1 -启用
        itemName: "",
        pageSize: "1" //默认第一页
      },
      customerList: [],
      checkoutList: [],
      page_customer: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
      page_checkout: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
    }
  },
  methods: {
    
    //审批的方法
    examine(row){
      this.dialog_operator.tops = "登记实际返回时间";
      this.dialog_operator.dialogVisible = true;
      this.$nextTick(() =>{
        this.dialog_operator.item.id = row.id;
        this.dialog_operator.item.customerName = row.customerName
        this.dialog_operator.item.customerId = row.customerId
        this.dialog_operator.item.isDeleted = row.isDeleted
        this.dialog_operator.item.checkoutReason = row.checkoutReason // 外出事由
        this.dialog_operator.item.checkoutTime = row.checkoutTime     // 外出时间
        this.dialog_operator.item.auditStatus = row.auditStatus
      })
    },
    //审批的实现
    examine_2(row, auditStatus) {
      const actionText = auditStatus === 1 ? '同意' : '拒绝';
      this.$confirm(`确认要${actionText}该申请吗？`, '审批确认', {
        confirmButtonText: '确认',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        examineCheckout({ id: row.id, auditStatus: auditStatus }).then(res => {
          if (res.flag) {
            this.$message.success(`已${actionText}`);
            this.getOutwardList();
            this.dialog_operator.dialogVisible = false;
          } else {
            this.$message.error(res.message || '审批失败');
          }
        });
      });
    },
    openAddCheckoutDialog() {
      this.addCheckoutDialogVisible = true;
      this.resetAddCheckoutForm();
    },

    resetAddCheckoutForm() {
      this.$refs.addCheckoutFormRef?.resetFields();
      this.addCheckoutForm = {
        customerName: "",
        customerSex: "",
        customerAge: "",
        bedId: "",
        levelId: "",
        customerId: "",
        checkoutReason: "",
        checkoutTime: "",
        expectedReturnTime: "",
      };
    },

    // 自动完成搜索建议
    querySearchCustomer(queryString, cb) {
      if (!queryString) {
        cb([]);
        return;
      }
      // 调用客户接口模糊查询
      findAllCustomer(this.queryParams)
          .then(res => {
            const suggestions = res.data.records.map(item => ({
              value: item.customerName,
              ...item,
            }));
            cb(suggestions);
          })
          .catch(() => {
            cb([]);
          });
    },

    // 选择客户后填充详细信息
    handleCustomerSelect(item) {
      this.addCheckoutForm.customerName = item.customerName;
      this.addCheckoutForm.customerSex = item.customerSex === 1 ? "男" : "女";
      this.addCheckoutForm.customerAge = item.customerAge;
      this.addCheckoutForm.bedId = item.bedId;
      this.addCheckoutForm.levelId = item.levelId;
      this.addCheckoutForm.customerId = item.id; // 关键，用于关联退住登记
    },

    // 提交新增退住登记
    submitAddCheckout() {
      this.$refs.addCheckoutFormRef.validate(valid => {
        if (!valid) return;

        if (!this.addCheckoutForm.customerId) {
          this.$message.error("请选择客户");
          return;
        }


        console.log("提交的数据：", this.addCheckoutForm);
        // 调用新增退住登记接口
        addRecords(this.addCheckoutForm).then(res => {
          if (res.flag) {
            this.$message.success("添加成功");
            this.addCheckoutDialogVisible = false;
            this.getCheckoutList(); // 刷新退住登记列表
          } else {
            this.$message.error(res.message || "添加失败");
          }
        }).catch(() => {
          this.$message.error("添加请求失败");
        });
      });
    },

    //撤销
    reCallApplication(row){
      this.$confirm('确定要撤销该申请吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }).then(() => {
        // 调用撤销接口，传入当前记录id
        recallApplication({ id: row.id }).then(res => {
          if (res.flag) {
            this.$message.success('撤销成功');
            this.getCheckoutList(); // 刷新列表
          } else {
            this.$message.error(res.message || '撤销失败');
          }
        }).catch(() => {
          this.$message.error('撤销请求失败');
        });
      }).catch(() => {
        // 取消撤销操作
      });
    },
    handleClose() {
      this.dialog.dialogVisible = false;
      this.resetForm("itemForm"); //重置表单
    },
    handleClose_operator() {
      this.dialog_operator.dialogVisible = false;
      this.resetForm("itemForm"); //重置表单
    },
    handleCurrentChange(curPage) {
      this.page_checkout.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getCheckoutList();
    },
    handleCurrentChangeCustomer(curPage) {
      this.page_customer.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getCustomerList();
    },
    cancel() {
      this.handleClose();
    },
    cancel_operator() {
      this.handleClose_operator();
    },
    getCustomerList() {
      findAllCustomer(this.queryParams).then(res => {
        this.customerList = res.data.records;
        this.page_customer.total = res.data.total; //总记录数
        this.page_customer.pageSize = res.data.size; //每页显示条数
        this.page_customer.currentPag = res.data.current; //当前页码
        this.page_customer.pagCount = res.data.pages; //总页数

      });
    },
    getCheckoutList() {
      listCheckoutVoPage(this.queryParams).then(res => {
        console.log(res.data.records)
        this.checkoutList = res.data.records.filter(item => item.isDeleted !== 1);
        this.page_checkout.total = res.data.total; //总记录数
        this.page_checkout.pageSize = res.data.size; //每页显示条数
        this.page_checkout.currentPag = res.data.current; //当前页码
        this.page_checkout.pagCount = res.data.pages; //总页数

      });
    },
  }
}
</script>

<template>
<div class="common-layout">
  <el-container>
    <el-header>
      <div>
        <el-row :gutter="30">
          <el-col :span="7">
            <el-input>
              <!--                  placeholder="名称"-->
              <!--                  v-model="queryParams.customername"-->
              <!--                  @clear="query"-->
              <!--                  clearable-->
              <!--                  size="large"-->

              <template #append>
                <el-button type="info" @click="query" style="color:black">查询</el-button>
              </template>
            </el-input>
          </el-col>
          <el-col :span="17">
            <el-button type="primary" @click="openAddCheckoutDialog" color="#337ab7" style="margin-top:4px">
              <el-icon>
                <Plus/>
              </el-icon >
              <span>退住登记</span>
            </el-button>
          </el-col>
        </el-row>
      </div>
    </el-header>

    <el-main>
      <div >
        <div  class="container" style="display: flex; justify-content: space-between; gap: 2%;">
          <el-card class="left-panel" style="width: 30%">
            <div class="header">
              <h3>客户信息</h3>
            </div>
            <el-table :data="customerList">
              <el-table-column
                  align="center"
                  type="index"
                  :index="indexMethodCustomer"
                  label="序号"
                  width="60"
              />
              <el-table-column align="center" prop="customerName" label="客户姓名" width="120" />
              <el-table-column align="center" prop="customerSex" label="性别" width="120">
                <template #default="scope">{{ scope.row.customerSex === 1 ? '男' : '女' }}</template>
              </el-table-column>
              <el-table-column align="center" prop="customerAge" label="客户年龄" width="120" />
              <el-table-column align="center" prop="bedId" label="床位" width="100" />
              <el-table-column align="center" prop="levelId" label="护理等级" width="120" />
            </el-table>
            <div style="margin-top:15px">
              <!--
                  page-size:每页显示条目个数
                  current-page:页码 配合@current-change使用
                  disabled:是否禁用分页
                  background:是否为分页按钮添加背景色
                  layout:组件布局，子组件名用逗号分隔
                  total:总条目数
              -->
              <el-pagination
                  :page-size="page_customer.pageSize"
                  background
                  :current-page="page_customer.currentPag"
                  layout=" prev, pager, next"
                  :total="page_customer.total"
                  @current-change="handleCurrentChangeCustomer"
              />
            </div>
          </el-card>

          <el-card class="right-panel" style="width: 68%">
            <div class="header">
              <h3>退住登记记录</h3>
            </div>
            <el-table :data="checkoutList" style="width: 100% ;color:black;">
              <el-table-column
                  align="center"
                  type="index"
                  :index="indexMethodCheckout"
                  label="序号"
                  width="60"
              />
              <el-table-column align="center" prop="customerName" label="客户名" width="120"/>
              <el-table-column align="center" prop="checkoutReason" label="退住事由" width="120"/>
              <el-table-column align="center" prop="checkoutTime" label="退住时间" width="120"/>
              <el-table-column prop="checkoutType" label="退住类型" width="120">
                <template #default="{ row }">
                  <span v-if="row.checkoutType === 0">死亡退住</span>
                  <span v-else-if="row.checkoutType === 1">正常退住</span>
                  <span v-else>保留床位</span>
                </template>
              </el-table-column>
              <el-table-column align="center" prop="auditStatus" label="审批状态" width="120">
                <template #default="scope">
                  <div v-if="scope.row.auditStatus===0">已提交</div>
                  <div v-else-if="scope.row.auditStatus===1">同意</div>
                  <div v-else>拒绝</div>
                </template>
              </el-table-column>
              <el-table-column align="center" fixed="right" label="操作" width="120">
                <template #default="{ row }">
                  <!-- 只有当角色是 2 且状态是 0 时，显示“撤销申请” -->
                  <el-button
                      v-if="roleID === 2 && row.auditStatus === 0"
                      type="danger"
                      @click="reCallApplication(row)"
                  >撤销申请
                  </el-button>
                  <!-- 角色是 1 且状态是 0 时，显示“审批”按钮 -->
                  <el-button
                      v-else-if="roleID === 1 && row.auditStatus === 0"
                      type="primary"
                      @click="examine(row)"
                  >审批
                  </el-button>
                  <!-- 角色是 1 且状态是 1 或 2 时，显示禁用的“审批” -->
                  <el-button
                      v-else-if="roleID === 1 && (row.auditStatus === 1 || row.auditStatus === 2)"
                      type="primary"
                      disabled
                  >审批
                  </el-button>
                </template>

              </el-table-column>
            </el-table>
            <div style="margin-top:15px">
              <!--
                  page-size:每页显示条目个数
                  current-page:页码 配合@current-change使用
                  disabled:是否禁用分页
                  background:是否为分页按钮添加背景色
                  layout:组件布局，子组件名用逗号分隔
                  total:总条目数
              -->
              <el-pagination
                  :page-size="page_checkout.pageSize"
                  background
                  :current-page="page_checkout.currentPag"
                  layout=" prev, pager, next"
                  :total="page_checkout.total"
                  @current-change="handleCurrentChange"
              />
            </div>
          </el-card>
        </div>

      </div>
    </el-main>
  </el-container>

  <!--审批-->
  <el-dialog
      v-model="dialog_operator.dialogVisible"
      :title="dialog_operator.tops"
      width="40%"
      align-center
      draggable
      :before-close="handleClose_operator">
    <el-divider border-style="double" style="margin:0;" />
    <el-form
        label-position="right"
        label-width="auto"
        style="max-width:380px;margin:20px auto"
        class="demo-form-inline"
        ref="itemForm"
        :model="dialog_operator.item"
    >
    </el-form>
    <el-form-item label="客户ID" prop="customerId">
      <el-input v-model="dialog_operator.item.customerId" disabled>客户ID</el-input>
    </el-form-item>
    <el-form-item label="客户名字" prop="customerName">
      <el-input v-model="dialog_operator.item.customerName" disabled>客户名字</el-input>
    </el-form-item>
    <el-form-item label="退出时间" prop="checkoutTime">
      <el-input v-model="dialog_operator.item.checkoutTime" disabled>外出时间</el-input>
    </el-form-item>
    <el-form-item label="退出事由" prop="checkoutReason">
      <el-input v-model="dialog_operator.item.checkoutReason" disabled>外出事由</el-input>
    </el-form-item>

    <template #footer >
	    <span class="dialog-footer" style="padding-top: 0px; display: block; text-align: center;" >
	      <el-button type="primary"  @click="examine_2(dialog_operator.item,1)">同意</el-button>
        <el-button type="primary" @click="examine_2(dialog_operator.item,2)">拒绝</el-button>
	      <el-button @click="cancel_operator">取消</el-button>
	    </span>
    </template>
  </el-dialog>
  
  <!-- 添加弹窗-->
 
  <el-dialog
      v-model="addCheckoutDialogVisible"
      title="新增退住登记"
      width="40%"
      :before-close="closeAddDialog">
    <el-form :model="addCheckoutForm" ref="addCheckoutFormRef" :rules="addCheckoutRules" label-width="100px">
      <!-- 客户名称自动匹配输入框 -->
      <el-form-item label="客户名称" prop="customerName">
        <el-autocomplete
            class="inline-input"
            v-model="addCheckoutForm.customerName"
            :fetch-suggestions="querySearchCustomer"
            placeholder="请输入客户姓名"
            @select="handleCustomerSelect"
            clearable
        />
      </el-form-item>

      <!-- 客户详细信息，选择客户后显示 -->
      <el-form-item label="客户性别">
        <el-input v-model="addCheckoutForm.customerSex" disabled />
      </el-form-item>
      <el-form-item label="客户年龄">
        <el-input v-model="addCheckoutForm.customerAge" disabled />
      </el-form-item>
      <el-form-item label="床位">
        <el-input v-model="addCheckoutForm.bedId" disabled />
      </el-form-item>
      <el-form-item label="护理等级">
        <el-input v-model="addCheckoutForm.levelId" disabled />
      </el-form-item>

      <!-- 退住登记填写项 -->
      <el-form-item label="外出事由" prop="checkoutReason">
        <el-input v-model="addCheckoutForm.checkoutReason" placeholder="填写外出事由" />
      </el-form-item>
      <el-form-item label="外出时间" prop="checkoutTime">
        <el-date-picker
            v-model="addCheckoutForm.checkoutTime"
            type="datetime"
            placeholder="选择外出时间"
            value-format="YYYY-MM-DD"
            format="YYYY-MM-DD"
        />
      </el-form-item>
      <el-form-item label="退住类型" prop="checkoutType">
        <el-select v-model="addCheckoutForm.checkoutType" placeholder="请选择退住类型">
          <el-option label="死亡退住" :value="0" />
          <el-option label="正常" :value="1" />
          <el-option label="保留床位" :value="2" />
        </el-select>
      </el-form-item>

    </el-form>

    <template #footer>
      <el-button @click="closeAddDialog">取消</el-button>
      <el-button type="primary" @click="submitAddCheckout">添加</el-button>
    </template>


  </el-dialog>
</div>
</template>

<style scoped>

</style>