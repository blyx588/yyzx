<script>
import {
  addRecords,
  listOutwardVoPage,
  UpdateActualBackTime,
  examineOutward,
  recallApplication
} from "@/api/outRecord"
import {addCustomer, findAllCustomer, updateCustomer} from "@/api/consumerApi"
import {getCurDate} from "@/utils/common.js"
import {getSessionStorage} from '@/utils/common.js'
export default {
  computed: {
    indexMethodOutward() {
      return (index) =>
          (this.page_outward.currentPag - 1) * this.page_outward.pageSize + index + 1;
    },
    // 客户信息表的序号方法
    indexMethodCustomer() {
      return (index) =>
          (this.page_customer.currentPag - 1) * this.page_customer.pageSize + index + 1;
    }
  },
  data() {
    return {
      // 控制弹窗显示
      addOutwardDialogVisible: false,

      // 新增外出登记表单数据
      addOutwardForm: {
        customerName: "",
        customerSex: "",
        customerAge: "",
        bedId: "",
        levelId: "",
        customerId: "",  // 重要，后端关联客户id
        outgoingReason: "",
        outgoingTime: "",
        expectedReturnTime: "",
      },

      // 校验规则
      addOutwardRules: {
        customerName: [{ required: true, message: "请选择客户", trigger: "blur" }],
        outgoingReason: [{ required: true, message: "请填写外出事由", trigger: "blur" }],
        outgoingTime: [{ required: true, message: "请选择外出时间", trigger: "change" }],
        expectedReturnTime: [{ required: true, message: "请选择预计回院时间", trigger: "change" }],
      },

      // 客户匹配列表缓存
      customerSuggestions: [],

      roleID:"",
      //模态框数据
      dialog_operator:{
        dialogVisible: false, //模态框状态
        tops: "", //模态框标题,
        item: {
          id:"",
          customerName:"",
          actualReturnTime:"",
          isDeleted:"",
          customerId:"",
          outgoingReason: "",      // 外出事由
          outgoingTime: "",        // 外出时间
          expectedReturnTime: "",  // 预计回院时间
          escorted: "",            // 陪同人
          relation: "",            // 与老人关系
          escortedTel: "",         // 陪同人电话
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
      queryParams_out:{
        status: "1", //查询默认状态1 -启用
        itemName: "",
        pageSize: "1" //默认第一页
      },
      dialog: {
        dialogVisible: false, //模态框状态
        tops: "", //模态框标题,
        item: {
          id:"",
          actualReturnTime:"",
          isDeleted:"",
          customerId:"",
          outgoingReason: "",      // 外出事由
          outgoingTime: "",        // 外出时间
          expectedReturnTime: "",  // 预计回院时间
          escorted: "",            // 陪同人
          relation: "",            // 与老人关系
          escortedTel: "",         // 陪同人电话
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
      //校验规则
      rules: {},
      page_outward: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
      //分页属性封装
      page_customer: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
      btnFlag: true,
      queryParams: {
        status: "1", //查询默认状态1 -启用
        itemName: "",
        pageSize: "1" //默认第一页
      },
      outwardList: [],
      customerList: []
    };
  },
  mounted() {
    this.roleID = getSessionStorage("user").roleId;
    this.getOutwardList();
    this.getCustomerList();
  },
  methods: {

    openAddOutwardDialog() {
      this.addOutwardDialogVisible = true;
      this.resetAddOutwardForm();
    },

    resetAddOutwardForm() {
      this.$refs.addOutwardFormRef?.resetFields();
      this.addOutwardForm = {
        customerName: "",
        customerSex: "",
        customerAge: "",
        bedId: "",
        levelId: "",
        customerId: "",
        outgoingReason: "",
        outgoingTime: "",
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
      this.addOutwardForm.customerName = item.customerName;
      this.addOutwardForm.customerSex = item.customerSex === 1 ? "男" : "女";
      this.addOutwardForm.customerAge = item.customerAge;
      this.addOutwardForm.bedId = item.bedId;
      this.addOutwardForm.levelId = item.levelId;
      this.addOutwardForm.customerId = item.id; // 关键，用于关联外出登记
    },

    // 提交新增外出登记
    submitAddOutward() {
      this.$refs.addOutwardFormRef.validate(valid => {
        if (!valid) return;

        if (!this.addOutwardForm.customerId) {
          this.$message.error("请选择客户");
          return;
        }


        console.log("提交的数据：", this.addOutwardForm);
        // 调用新增外出登记接口
        addRecords(this.addOutwardForm).then(res => {
          if (res.flag) {
            this.$message.success("添加成功");
            this.addOutwardDialogVisible = false;
            this.getOutwardList(); // 刷新外出登记列表
          } else {
            this.$message.error(res.message || "添加失败");
          }
        }).catch(() => {
          this.$message.error("添加请求失败");
        });
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
    cancel() {
      this.handleClose();
    },
    cancel_operator() {
      this.handleClose_operator();
    },
    examine_2(row, auditStatus) {
      const actionText = auditStatus === 1 ? '同意' : '拒绝';
      this.$confirm(`确认要${actionText}该申请吗？`, '审批确认', {
        confirmButtonText: '确认',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        examineOutward({ id: row.id, auditStatus: auditStatus }).then(res => {
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
    examine(row){
      this.dialog_operator.tops = "登记实际返回时间";
      this.dialog_operator.dialogVisible = true;
      this.$nextTick(() =>{
        this.dialog_operator.item.id = row.id;
        this.dialog_operator.item.customerName = row.customerName
        this.dialog_operator.item.customerId = row.customerId
        this.dialog_operator.item.isDeleted = row.isDeleted
        this.dialog_operator.item.actualReturnTime = row.actualReturnTime
        this.dialog_operator.item.outgoingReason = row.outgoingReason // 外出事由
        this.dialog_operator.item.outgoingTime = row.outgoingTime     // 外出时间
        this.dialog_operator.item.expectedReturnTime = row.expectedReturnTime // 预计返回时间
        this.dialog_operator.item.escorted = row.escorted             // 陪同人
        this.dialog_operator.item.relation = row.relation             // 与老人关系
        this.dialog_operator.item.escortedTel = row.escortedTel       // 陪同人电话
        this.dialog_operator.item.auditStatus = row.auditStatus
      })
    },
    getOutwardList() {
      listOutwardVoPage(this.queryParams_out).then(res => {
        this.outwardList = res.data.records.filter(item => item.isDeleted !== 1);
        this.page_outward.total = res.data.total; //总记录数
        this.page_outward.pageSize = res.data.size; //每页显示条数
        this.page_outward.currentPag = res.data.current; //当前页码
        this.page_outward.pagCount = res.data.pages; //总页数
      });
    },
    handleCurrentChange(curPage) {
      this.page_outward.currentPag = curPage;
      this.queryParams_out.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getOutwardList();
    },
    handleCurrentChangeCustomer(curPage) {
      this.page_customer.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getCustomerList();
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
    register(row){
      this.dialog.tops = "登记实际返回时间";
      this.dialog.dialogVisible = true;
      this.$nextTick(() =>{
        this.dialog.item.id = row.id;
        this.dialog.item.customerId = row.customerId
        this.dialog.item.isDeleted = row.isDeleted
        this.dialog.item.actualReturnTime = row.actualReturnTime
        this.dialog.item.outgoingReason = row.outgoingReason // 外出事由
        this.dialog.item.outgoingTime = row.outgoingTime     // 外出时间
        this.dialog.item.expectedReturnTime = row.expectedReturnTime // 预计返回时间
        this.dialog.item.escorted = row.escorted             // 陪同人
        this.dialog.item.relation = row.relation             // 与老人关系
        this.dialog.item.escortedTel = row.escortedTel       // 陪同人电话
        this.dialog.item.auditStatus = row.auditStatus
      })
    },
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
            this.getOutwardList(); // 刷新列表
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
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          //通过id判断是添加还是编辑
          if (this.dialog.item.id == null || this.dialog.item.id == "") {
            addRecords(this.dialog.item).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //刷新数据表格(回到最初查询状态)
                this.queryParams.status = "1";
                this.queryParams.pageSize = "1"; //回到第一页
                this.queryParams.itemName = "";
                this.getOutwardList();
                this.handleClose(); //关闭模态框
              } else {
                this.$message.error(res.message);
              }
            });
          } else {
            UpdateActualBackTime(this.dialog.item).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //刷新数据表格
                this.getOutwardList();
                this.handleClose(); //关闭模态框
              } else {
                this.$message.error(res.message);
              }
            });
          }
        } else {
          return false;
        }
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
              <el-button type="primary" @click="openAddOutwardDialog" color="#337ab7" style="margin-top:4px">
                <el-icon>
                  <Plus />
                </el-icon >
                <span>外出登记</span>
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
                <h3>外出登记记录</h3>
              </div>
              <el-table :data="outwardList" style="width: 100% ;color:black;">
                <el-table-column
                    align="center"
                    type="index"
                    :index="indexMethodOutward"
                    label="序号"
                    width="60"
                />
                <el-table-column align="center" prop="customerName" label="客户名" width="120"/>
                <el-table-column align="center" prop="outgoingReason" label="外出事由" width="120"/>
                <el-table-column align="center" prop="outgoingTime" label="外出时间" width="120"/>
                <el-table-column align="center" prop="expectedReturnTime" label="预计回院时间" width="120"/>
                <el-table-column align="center" prop="actualReturnTime" label="实际回院时间" width="120"/>
                <el-table-column align="center" prop="escorted" label="陪同人" width="120"/>
                <el-table-column align="center" prop="relation" label="与老人关系" width="120"/>
                <el-table-column align="center" prop="escortedTel" label="陪同人电话" width="120"/>
                <el-table-column align="center" prop="auditStatus" label="审批状态" width="120">
                  <template #default="scope">
                    <div v-if="scope.row.auditStatus===0">已提交</div>
                    <div v-else-if="scope.row.auditStatus===1">同意</div>
                    <div v-else>拒绝</div>
                  </template>
                </el-table-column>
                <el-table-column align="center" fixed="right" label="操作" width="120">
                  <template #default="scope">
                    <template v-if="roleID === 2">
                      <el-button
                          type="success"
                          @click="register(scope.row)"
                          v-if="scope.row.auditStatus === 1 && (!scope.row.actualReturnTime || scope.row.actualReturnTime === '')"
                      >登记回院时间
                      </el-button>
                      <el-button
                          type="success"
                          disabled
                          v-else-if="scope.row.auditStatus === 1 && scope.row.actualReturnTime"
                      >登记回院时间
                      </el-button>
                      <el-button @click="reCallApplication(scope.row)" type="danger" v-else-if="scope.row.auditStatus === 0  && (!scope.row.actualReturnTime || scope.row.actualReturnTime === '')">撤销申请</el-button>
                    </template>
                    <template v-else-if="roleID === 1 && scope.row.auditStatus === 0">
                      <el-button  type="primary" @click="examine(scope.row)">审批</el-button>
                    </template>
                    <template v-else-if="roleID === 1 && (scope.row.auditStatus === 1 || scope.row.auditStatus === 2)">
                      <el-button disabled type="primary">审批</el-button>
                    </template>
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
                    :page-size="page_outward.pageSize"
                    background
                    :current-page="page_outward.currentPag"
                    layout=" prev, pager, next"
                    :total="page_outward.total"
                    @current-change="handleCurrentChange"
                />
              </div>
            </el-card>
          </div>

        </div>
      </el-main>
    </el-container>
  <el-dialog
      v-model="dialog.dialogVisible"
      :title="dialog.tops"
      width="40%"
      align-center
      draggable
      :before-close="handleClose"
  >
    <el-divider border-style="double" style="margin:0;" />
    <el-form
        label-position="right"
        label-width="auto"
        style="max-width:380px;margin:20px auto"
        class="demo-form-inline"
        ref="itemForm"
        :model="dialog.item"
    >
      <el-form-item label="实际返回时间时间" prop="checkinDate">
        <el-date-picker
            v-model="dialog.item.actualReturnTime"
            type="date"
            placeholder="选择实际返回时间时间"
            value-format="YYYY-MM-DD"
            format="YYYY-MM-DD"
        />
      </el-form-item>
      <el-form-item label="客户ID" prop="customerId">
        <el-input v-model="dialog.item.customerId" disabled>客户ID</el-input>
      </el-form-item>
    </el-form>
    <el-divider border-style="double" style="margin:0;" />
    <template #footer>
	    <span class="dialog-footer" style="padding-top: 0px; display: block; text-align: center;" >
	      <el-button type="primary" @click="save('itemForm')">保存</el-button>
	      <el-button @click="cancel">取消</el-button>
	    </span>
    </template>
  </el-dialog>
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
    <el-form-item label="外出时间" prop="outgoingTime">
      <el-input v-model="dialog_operator.item.outgoingTime" disabled>外出时间</el-input>
    </el-form-item>
    <el-form-item label="预计回院时间" prop="expectedReturnTime">
      <el-input v-model="dialog_operator.item.expectedReturnTime" disabled>预计回院时间</el-input>
    </el-form-item>
    <el-form-item label="外出事由" prop="outgoingReason">
      <el-input v-model="dialog_operator.item.outgoingReason" disabled>外出事由</el-input>
    </el-form-item>

    <template #footer >
	    <span class="dialog-footer" style="padding-top: 0px; display: block; text-align: center;" >
	      <el-button type="primary"  @click="examine_2(dialog_operator.item,1)">同意</el-button>
        <el-button type="primary" @click="examine_2(dialog_operator.item,2)">拒绝</el-button>
	      <el-button @click="cancel_operator">取消</el-button>
	    </span>
    </template>
  </el-dialog>

  <el-dialog
      v-model="addOutwardDialogVisible"
      title="新增外出登记"
      width="40%"
      :before-close="closeAddDialog">
    <el-form :model="addOutwardForm" ref="addOutwardFormRef" :rules="addOutwardRules" label-width="100px">
      <!-- 客户名称自动匹配输入框 -->
      <el-form-item label="客户名称" prop="customerName">
        <el-autocomplete
            class="inline-input"
            v-model="addOutwardForm.customerName"
            :fetch-suggestions="querySearchCustomer"
            placeholder="请输入客户姓名"
            @select="handleCustomerSelect"
            clearable
        />
      </el-form-item>

      <!-- 客户详细信息，选择客户后显示 -->
      <el-form-item label="客户性别">
        <el-input v-model="addOutwardForm.customerSex" disabled />
      </el-form-item>
      <el-form-item label="客户年龄">
        <el-input v-model="addOutwardForm.customerAge" disabled />
      </el-form-item>
      <el-form-item label="床位">
        <el-input v-model="addOutwardForm.bedId" disabled />
      </el-form-item>
      <el-form-item label="护理等级">
        <el-input v-model="addOutwardForm.levelId" disabled />
      </el-form-item>

      <!-- 外出登记填写项 -->
      <el-form-item label="外出事由" prop="outgoingReason">
        <el-input v-model="addOutwardForm.outgoingReason" placeholder="填写外出事由" />
      </el-form-item>
      <el-form-item label="外出时间" prop="outgoingTime">
        <el-date-picker
            v-model="addOutwardForm.outgoingTime"
            type="datetime"
            placeholder="选择外出时间"
            value-format="YYYY-MM-DD"
            format="YYYY-MM-DD"
        />
      </el-form-item>
      <el-form-item label="预计回院时间" prop="expectedReturnTime">
        <el-date-picker
            v-model="addOutwardForm.expectedReturnTime"
            type="datetime"
            placeholder="选择预计回院时间"
            value-format="YYYY-MM-DD"
            format="YYYY-MM-DD"
        />
      </el-form-item>
    </el-form>

    <template #footer>
      <el-button @click="closeAddDialog">取消</el-button>
      <el-button type="primary" @click="submitAddOutward">添加</el-button>
    </template>


  </el-dialog>
</div>
</template>

<style scoped>

</style>