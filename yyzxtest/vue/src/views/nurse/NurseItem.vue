<script>
import {
  findAllNursingServicePage,
  addNursingService,
  updateNursingService,
  delNursingService
} from "@/api/nursingServiceApi";


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
          id: '',                    // 主键
          serialNumber: '',          // 编号
          nursingName: '',           // 服务名称
          servicePrice: '',          // 价格
          message: '',               // 描述
          executionCycle: '',        // 执行周期
          executionTimes: '',        // 执行次数
          status: 1,                 // 状态（1：启用；2：停用）
          isDeleted: 0
        }
      },
      //校验规则
      rules: {
        nursingServiceName: [
          { required: true, message: "请输入用户名", trigger: "blur" }
        ],
        nickname: [
          { required: true, message: "请输入真实姓名", trigger: "blur" }
        ],
        email: [
          { required: true, message: "请输入邮箱", trigger: "blur" }
        ],
        isDeleted: [{ required: true, message: "请选择状态", trigger: "change" }]
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
          pageSize: "1" //默认第一页
        },
        nursingServiceList: []
    };
  },
  mounted() {
    this.getNursingServiceList();

  },
  methods: {
    //点击查询
    query() {
      this.queryParams.pageSize = "1"; //回到第一页
      this.getNursingServiceList();
    },
    //点击启用
    enable() {
      this.btnFlag = true;
      this.queryParams.status = "1"; //1-启用
      this.queryParams.pageSize = "1"; //回到第一页
      this.getNursingServiceList();
    },
    //点击停用
    disable() {
      this.btnFlag = false;
      this.queryParams.pageSize = "1"; //2-停用
      this.queryParams.status = "2"; //0-生效床位信息
      this.getNursingServiceList();
    },
    //选中页码
    handleCurrentChange(curPage) {
      this.page.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getNursingServiceList();
    },
    //点击修改
    edit(row) {
      this.dialog.tops = "修改用户";
      this.dialog.dialogVisible = true;
      //初始化模态框数据
      this.$nextTick(() => {
        this.dialog.item.id              = row.id;
        this.dialog.item.serialNumber    = row.serialNumber;
        this.dialog.item.nursingName     = row.nursingName;
        this.dialog.item.servicePrice    = row.servicePrice;
        this.dialog.item.message         = row.message;
        this.dialog.item.executionCycle  = row.executionCycle;
        this.dialog.item.executionTimes  = row.executionTimes;
        this.dialog.item.status          = row.status;
        this.dialog.item.isDeleted       = row.isDeleted;
      });
    },
    //点击添加按钮
    addItem() {
      this.dialog.tops = "添加护理项目";
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

            addNursingService(this.dialog.item).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //刷新数据表格(回到最初查询状态)
                this.queryParams.status = "1";
                this.queryParams.pageSize = "1"; //回到第一页
                this.getNursingServiceList();
                this.handleClose(); //关闭模态框
              } else {
                this.$message.error(res.message);
              }
            });
          } else {
            updateNursingService(this.dialog.item).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //刷新数据表格
                this.getNursingServiceList();
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
            delNursingService({ id: id }).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //重载表格
                this.getNursingServiceList();
              } else {
                this.$message.error(res.message);
              }
            });
          })
          .catch(() => {});
    },
    //api-查询护理项目(分页)
    getNursingServiceList() {
      findAllNursingServicePage(this.queryParams).then(res => {
        this.nursingServiceList = res.data.records;
        this.page.total = res.data.total; //总记录数
        this.page.pageSize = res.data.size; //每页显示条数
        this.page.currentPag = res.data.current; //当前页码
        this.page.pagCount = res.data.pages; //总页数
      });
      //   queryOutwardVo().then(res=>{
      // 	  console.log(res);
      //   });
    }
  }
};
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <div>
          <el-row :gutter="30">
            <el-col :span="7">
              <el-input
                placeholder="名称"
                v-model="queryParams.nursingServicename"
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
          <el-table :data="nursingServiceList" style="width: 100% ;color:black;" stripe>
            <el-table-column
              align="center"
              type="index"
              :index="indexMethod"
              label="序号"
              width="60"
            />
              <el-table-column
                  align="center"
                  prop="id"
                  label="ID"
                  width="80"
              />

              <!-- 编号 -->
              <el-table-column
                  align="center"
                  prop="serialNumber"
                  label="编号"
                  width="120"/>

              <!-- 服务名称 -->
              <el-table-column
                  align="center"
                  prop="nursingName"
                  label="项目名称"
                  width="180"/>

              <!-- 价格 -->
              <el-table-column
                  align="center"
                  prop="servicePrice"
                  label="价格"
                  width="100"/>

              <!-- 描述 -->
              <el-table-column
                  align="center"
                  prop="message"
                  label="描述"
                  width="300"
              />
              <!-- 执行周期 -->
              <el-table-column
                  align="center"
                  prop="executionCycle"
                  label="执行周期"
                  width="120"
              />
              <!-- 执行次数 -->
              <el-table-column
                  align="center"
                  prop="executionTimes"
                  label="执行次数"
                  width="120"
              />
              <!-- 状态 -->
              <el-table-column
                  align="center"
                  prop="status"
                  label="状态"
                  width="100"
              >
                <template #default="scope">
                  {{ scope.row.status === 1 ? '启用' : '停用' }}
                </template>
              </el-table-column>



              <!-- 操作列 -->
              <el-table-column
                  align="center"
                  fixed="right"
                  label="操作"
                  width="180"
              >
                <template #default="{ row }">
                  <el-button
                      style="width: 60px"
                      size="mini"
                      type="primary"
                      icon="Edit"
                      @click="edit(row)"
                  >修改</el-button>
                  <el-button
                      style="width: 60px"
                      size="mini"
                      type="danger"
                      icon="Delete"
                      @click="del(row.id)"
                  >删除</el-button>
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
      <!-- 编号 -->
      <el-form-item label="编号" prop="serialNumber">
        <el-input v-model="dialog.item.serialNumber" placeholder="请输入编号" />
      </el-form-item>

      <!-- 项目名称 -->
      <el-form-item label="服务名称" prop="nursingName">
        <el-input v-model="dialog.item.nursingName" placeholder="请输入服务名称" />
      </el-form-item>

      <!-- 价格 -->
      <el-form-item label="价格" prop="servicePrice">
        <el-input v-model="dialog.item.servicePrice" placeholder="请输入价格" />
      </el-form-item>

      <!-- 描述 -->
      <el-form-item label="描述" prop="message">
        <el-input
            type="textarea"
            v-model="dialog.item.message"
            placeholder="请输入描述"
        />
      </el-form-item>

      <!-- 执行周期 -->
      <el-form-item label="执行周期" prop="executionCycle">
        <el-input
            v-model="dialog.item.executionCycle"
            placeholder="例如：每日、每周"
        />
      </el-form-item>

      <!-- 执行次数 -->
      <el-form-item label="执行次数" prop="executionTimes">
        <el-input
            v-model="dialog.item.executionTimes"
            placeholder="请输入执行次数"
        />
      </el-form-item>

      <!-- 状态 -->
      <el-form-item label="状态" prop="status">
        <el-radio-group v-model="dialog.item.status">
          <el-radio :label="1">启用</el-radio>
          <el-radio :label="2">停用</el-radio>
        </el-radio-group>
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


<style scoped >
.activeBtn {
  color: #1890ff;
  background: rgb(232, 244, 255);
}
</style>