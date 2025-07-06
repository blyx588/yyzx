<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <div>
          <el-row :gutter="30">
            <el-col :span="7">
              <el-input
                  placeholder="名称"
                  v-model="queryParams.customername"
                  @clear="query"
                  clearable
                  size="large"
              >
                <template #append>
                  <el-button type="info" @click="query" style="color:black">查询</el-button>
                </template>
              </el-input>
            </el-col>
            <el-col :span="17">
              <el-button type="primary" @click="addItem" color="#337ab7" style="margin-top:4px">
                <el-icon>
                  <Plus />
                </el-icon>
                <span>添加</span>
              </el-button>
            </el-col>
          </el-row>
        </div>
      </el-header>
      <el-divider style="margin:0"></el-divider>
      <el-main>
        <div>
          <!-- 表格 -->
          <el-table :data="customerList" style="width: 100% ;color:black;" stripe>
            <el-table-column
              align="center"
              type="index"
              :index="indexMethod"
              label="序号"
              width="60"
            />
            <el-table-column align="center" prop="id" label="编号" width="120" />

            <el-table-column align="center" prop="customerName" label="客户姓名" width="120" />
            <el-table-column align="center" prop="customerSex" label="性别" width="120">
              <template #default="scope">{{ scope.row.customerSex === 1 ? '男' : '女' }}</template>
            </el-table-column>
            <el-table-column align="center" prop="customerAge" label="客户年龄" width="120" />
            <el-table-column align="center" prop="idcard" label="客户身份证号" width="160" />
            <!-- <el-table-column align="center" prop="bedId" label="床位" width="100" /> -->
            <el-table-column align="center" prop="buildingNo" label="所属楼房" width="120" />
            <el-table-column align="center" prop="contactTel" label="联系电话" width="140" />
            <el-table-column align="center" prop="checkinDate" label="创建时间" width="160" />
            <el-table-column align="center" prop="expirationDate" label="合同到期时间" width="160" />
            <el-table-column align="center" prop="psychosomaticState" label="身心状况" width="140" />
            <el-table-column align="center" prop="attention" label="注意事项" width="140" />
            <el-table-column align="center" prop="birthday" label="出生日期" width="140" />
            <el-table-column align="center" prop="height" label="身高(cm)" width="100" />
            <el-table-column align="center" prop="weight" label="体重(kg)" width="100" />
            <el-table-column align="center" prop="bloodType" label="血型" width="100" />
            <el-table-column align="center" prop="filepath" label="头像" width="120">
              <template #default="scope">
                <el-image :src="scope.row.filepath" style="width: 40px; height: 40px;" fit="cover" />
              </template>
            </el-table-column>
            <el-table-column align="center" prop="userId" label="健康管家ID" width="140" >

              <template #default="scope">{{ scope.row.userId === -1 ?'无' :scope.row.userId  }}</template>
            </el-table-column>
            <el-table-column align="center" prop="levelId" label="护理等级" width="120" />
            <el-table-column align="center" prop="familyMember" label="家属" width="140" />
            <el-table-column align="center" prop="isDeleted" label="状态" width="100">
              <template #default="scope">{{ scope.row.isDeleted === 1 ? '停用' : '启用' }}</template>
            </el-table-column>

            <el-table-column align="center" fixed="right" label="操作" width="220">
              <template #default="scope">
                <el-button type="primary" icon="Edit" link @click="edit(scope.row)">修改</el-button>
                <el-button type="danger" icon="Delete" link @click="del(scope.row.id)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <!-- 分页插件 -->
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
              :page-size="page.pageSize"
              background
              :current-page="page.currentPag"
              layout=" prev, pager, next"
              :total="page.total"
              @current-change="handleCurrentChange"
          />
        </div>
      </el-main>
    </el-container>
    <!-- 修改/添加对话框 -->
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
          :rules="rules"
      >
        <el-form-item label="客户姓名" prop="customerName">
        <el-input v-model="dialog.item.customerName" />
      </el-form-item>

      <el-form-item label="客户年龄" prop="customerAge">
        <el-input v-model="dialog.item.customerAge" />
      </el-form-item>

      <el-form-item label="性别" prop="customerSex">
        <el-select v-model="dialog.item.customerSex">
          <el-option label="男" value="0" />
          <el-option label="女" value="1" />
        </el-select>
      </el-form-item>

      <el-form-item label="身份证号" prop="idCard">
        <el-input v-model="dialog.item.idcard" />
      </el-form-item>

      <el-form-item label="楼号" prop="buildingNo">
        <el-input v-model="dialog.item.buildingNo" />
      </el-form-item>

      <el-form-item label="房间号" prop="roomNo">
        <el-input v-model="dialog.item.roomNo" />
      </el-form-item>

      <!-- <el-form-item label="床位" prop="bedId">
        <el-select v-model="dialog.item.bedId" placeholder="请选择床位">
          <el-option
            v-for="bed in bedList"
            :key="bed.id"
            :label="bed.bedNo"
            :value="bed.id"
          />
        </el-select>
      </el-form-item> -->

      <el-form-item label="入住时间" prop="checkinDate">
        <el-date-picker
          v-model="dialog.item.checkinDate"
          type="date"
          placeholder="选择入住时间"
          value-format="YYYY-MM-DD"
          format="YYYY-MM-DD"
        />
      </el-form-item>

      <el-form-item label="合同到期时间" prop="expirationDate">
        <el-date-picker
          v-model="dialog.item.expirationDate"
          type="date"
          placeholder="选择到期时间"
          value-format="YYYY-MM-DD"
          format="YYYY-MM-DD"
        />
      </el-form-item>

      <el-form-item label="身心状况" prop="psychosomaticState">
        <el-input v-model="dialog.item.psychosomaticState" />
      </el-form-item>

      <el-form-item label="注意事项" prop="attention">
        <el-input
          type="textarea"
          v-model="dialog.item.attention"
          rows="2"
        />
      </el-form-item>

      <el-form-item label="出生日期" prop="birthday">
        <el-date-picker
          v-model="dialog.item.birthday"
          type="date"
          placeholder="选择出生日期"
        />
      </el-form-item>

      <el-form-item label="身高(cm)" prop="height">
        <el-input-number v-model="dialog.item.height" :min="0" />
      </el-form-item>

      <el-form-item label="体重(kg)" prop="weight">
        <el-input-number v-model="dialog.item.weight" :min="0" />
      </el-form-item>

      <el-form-item label="血型" prop="bloodType">
        <el-select v-model="dialog.item.bloodType">
          <el-option label="A" value="A" />
          <el-option label="B" value="B" />
          <el-option label="AB" value="AB" />
          <el-option label="O" value="O" />
        </el-select>
      </el-form-item>

      <el-form-item label="头像" prop="filepath">
        <el-upload
          action="/api/upload"
          list-type="picture-card"
          :on-success="handleUploadSuccess"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
      </el-form-item>

      <el-form-item label="健康管家ID" prop="userId">
        <el-input-number v-model="dialog.item.userId" :min="1" />
      </el-form-item>

      <el-form-item label="护理等级" prop="levelId">
        <el-input-number v-model="dialog.item.levelId" :min="1" />
      </el-form-item>

      <el-form-item label="家属" prop="familyMember">
        <el-input v-model="dialog.item.familyMember" />
      </el-form-item>

      <el-form-item label="状态" prop="isDeleted">
        <el-select v-model="dialog.item.isDeleted">
          <el-option
            v-for="item in dialog.statusArr"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>
      </el-form>
      <el-divider border-style="double" style="margin:0;" />
      <template #footer>
	    <span class="dialog-footer" style="padding-top: 0px">
	      <el-button type="primary" @click="save('itemForm')">保存</el-button>
	      <el-button @click="cancel">取消</el-button>
	    </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import {
  addCustomer,
  getCustomerList,
  updateCustomer,
  delCustomer,
  findAllCustomer
} from "@/api/consumerApi.js";
import {getCurDate} from "@/utils/common.js"
import {getSessionStorage} from '@/utils/common.js'
// import {queryOutwardVo} from "@/api/outwardApi.js";
export default {
  computed: {
    indexMethod() {
      return this.page.currentPag * this.page.pageSize - this.page.pageSize + 1;
    }
  },
  data() {
    return {
      //模态框数据
      dialog: {
        dialogVisible: false, //模态框状态
        tops: "", //模态框标题,
        item: {
          id: "",
          customerName: "",
          customerAge: "",
          customerSex: "",
          idcard: "",
          roomNo: "",
          isDeleted: "",//状态 1：启用；2：停用
          buildingNo:"",
          checkinDate:"",
          expirationDate:"",
          contactTel:"",
        
          psychosomaticState:"",
          attention:"",
          birthday:"",
          height:"",
          weight:"",
          bloodType:"",
          filepath:""
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
      rules: {
        customerName: [{ required: true, message: '请输入客户姓名', trigger: 'blur' }],
        customerAge: [{ required: true, message: '请输入真实年龄', trigger: 'blur' }],
        sex: [{ required: true, message: '请选择性别', trigger: 'change' }],
        idcard: [{ required: true, message: '请输入身份证号', trigger: 'blur' }],
        buildingNo: [{ required: true, message: '请输入楼号', trigger: 'blur' }],
        roomNo: [{ required: true, message: '请输入房间号', trigger: 'blur' }],
       
        checkinDate: [{ required: true, message: '请选择入住时间', trigger: 'change' }],
        expirationDate: [{ required: true, message: '请选择到期时间', trigger: 'change' }],
        isDeleted: [{ required: true, message: '请选择状态', trigger: 'change' }]
      },
      //分页属性封装
      page: {
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
      customerList: []
    };
  },
  mounted() {
    this.getCustomerList();
  },
  methods: {
    //点击查询
    query() {
      this.queryParams.pageSize = "1"; //回到第一页
      this.getCustomerList();
    },
    //点击启用
    enable() {
      this.btnFlag = true;
      this.queryParams.status = "1"; //1-启用
      this.queryParams.pageSize = "1"; //回到第一页
      this.getCustomerList();
    },
    //点击停用
    disable() {
      this.btnFlag = false;
      this.queryParams.pageSize = "1"; //2-停用
      this.queryParams.status = "2"; //0-生效床位信息
      this.getCustomerList();
    },
    //选中页码
    handleCurrentChange(curPage) {
      this.page.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getCustomerList();
    },
    //点击修改
    edit(row) {
      this.dialog.tops = "修改用户";
      this.dialog.dialogVisible = true;
      //初始化模态框数据
      this.$nextTick(() => {
      this.dialog.item.id = row.id;
      this.dialog.item.id = row.id
      this.dialog.item.customerName         = row.customerName
      this.dialog.item.customerAge          = row.customerAge
      this.dialog.item.sex                  = row.customerSex
      this.dialog.item.idcard               = row.idcard
      this.dialog.item.buildingNo           = row.buildingNo
      this.dialog.item.roomNo               = row.roomNo
      this.dialog.item.bedId                = row.bedId
      this.dialog.item.checkinDate          = row.checkinDate
      this.dialog.item.expirationDate       = row.expirationDate
      this.dialog.item.contactTel           = row.contactTel
      this.dialog.item.psychosomaticState   = row.psychosomaticState
      this.dialog.item.attention            = row.attention
      this.dialog.item.birthday             = row.birthday
      this.dialog.item.height               = row.height
      this.dialog.item.weight               = row.weight
      this.dialog.item.bloodType            = row.bloodType
      this.dialog.item.filepath             = row.filepath
      this.dialog.item.userId               = row.userId
      this.dialog.item.levelId              = row.levelId
      this.dialog.item.familyMember         = row.familyMember
      this.dialog.item.isDeleted            = row.isDeleted

      });
    },
    //点击添加按钮
    addItem() {
      this.dialog.tops = "添加客户项目";
      this.dialog.dialogVisible = true;
    },
    handleClose() {
      this.dialog.dialogVisible = false;
      this.resetForm("itemForm"); //重置表单
    },
    cancel() {
      this.handleClose();
    },
    //重置表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //api-保存(新增/编辑)
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          //通过id判断是添加还是编辑
          if (this.dialog.item.id == null || this.dialog.item.id == "") {
            addCustomer(this.dialog.item).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //刷新数据表格(回到最初查询状态)
                this.queryParams.status = "1";
                this.queryParams.pageSize = "1"; //回到第一页
                this.queryParams.itemName = "";
                this.getCustomerList();
                this.handleClose(); //关闭模态框
              } else {
                this.$message.error(res.message);
              }
            });
          } else {
            updateCustomer(this.dialog.item).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //刷新数据表格
                this.getCustomerList();
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
    //api-删除
    del(id) {
      this.$confirm("此操作删除记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
          .then(() => {
            delCustomer({ id: id }).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //重载表格
                this.getCustomerList();
              } else {
                this.$message.error(res.message);
              }
            });
          })
          .catch(() => {});
    },
    //api-查询护理项目(分页)
    getCustomerList() {
      findAllCustomer(this.queryParams).then(res => {
        this.customerList = res.data.records;
        this.page.total = res.data.total; //总记录数
        this.page.pageSize = res.data.size; //每页显示条数
        this.page.currentPag = res.data.current; //当前页码
        this.page.pagCount = res.data.pages; //总页数
      });

    }
  }
};
</script>

<style scoped >
.activeBtn {
  color: #1890ff;
  background: rgb(232, 244, 255);
}
</style>