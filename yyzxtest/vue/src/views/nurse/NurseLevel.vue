<script>
import { findAllNursingLevelPage,UpdateNursingLevel,addNursingLevel,deleteLevelItem} from '@/api/nurseLevelApi'
import router from "@/router";

export default {
  computed:{
    indexMethod() {
      return (index) => {
        return (this.page.currentPag - 1) * this.page.pageSize + index + 1;
      };
    }
  },
  data(){
    return{
      levelRules: {
        levelName: [{ required: true, message: "请填写级别", trigger: "blur" }],
        levelStatus: [{ required: true, message: "请选择级别状态", trigger: "change" }]
      },
      //添加
      addNursingLevelDialogVisible: false,
      addNursingLevelForm: {
        id:'',
        levelName: '',
        levelStatus: 1
      },
      //更新
      updateNursingLevelDialogVisible: false,
      updateNursingLevelForm: {
        id:"",
        levelName: "",
        levelStatus: "",
      },
      page: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
      btnFlag: true,
      queryParams: {
        levelStatus: "1", //查询默认状态1 -启用
        pageSize: "1" //默认第一页
      },
      nurseLevelList:[]
    }
  },
  mounted() {
    this.getNursingLevelList();
  },
  methods:{

    openAddDialog() {
      this.addNursingLevelDialogVisible = true;
    },
    // 关闭新增对话框并重置
    closeAddDialog() {
      this.addNursingLevelDialogVisible = false;
      this.$nextTick(() => {
        this.$refs.addFormRef?.resetFields();
        this.addNursingLevelForm = { levelName: '', levelStatus: 1 };
      });
    },
    // 提交新增
    submitAdd() {
      this.$refs.addFormRef.validate(valid => {
        if (valid) {
          addNursingLevel(this.addNursingLevelForm).then(() => {
            this.$message.success('新增成功');
            this.queryParams.pageSize = "1"; //回到第一页
            this.queryParams.itemName = "";
            this.closeAddDialog();
            this.getNursingLevelList();
          }).catch(() => {
            this.$message.error('新增失败');
          });
        }
      });
    },
    openUpdateNursingLevelDialog(row) {
      this.updateNursingLevelDialogVisible = true;
      this.$nextTick(()=>{
        this.updateNursingLevelForm.id = row.id;
        this.updateNursingLevelForm.levelName = row.levelName;
        this.updateNursingLevelForm.levelStatus = row.levelStatus;
      })
    },
    setting(row){
      router.push({
        path:"/nurse/AddItemToLevel",
        query:{
          levelId:row.id,
          levelName:row.levelName,
        }
      })
    },
    handleCurrentChange(curPage) {
      this.page.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getNursingLevelList();
    },
    closeUpdateDialog() {
      this.updateNursingLevelDialogVisible = false;
      this.$nextTick(() => {
        if (this.$refs.updateNursingLevelFormRef) {
          this.$refs.updateNursingLevelFormRef.resetFields();
        }
        this.updateNursingLevelForm = { levelName: '', levelStatus: 1 };
      });
    },
    // 提交修改
    submitAddCheckout() {
      this.$refs.updateNursingLevelFormRef.validate(valid => {
        if (valid) {
          UpdateNursingLevel(this.updateNursingLevelForm).then(() => {
            this.$message.success('修改成功');
            this.closeAddDialog();
            this.getNursingLevelList();
          }).catch(() => {
            this.$message.error('修改失败');
          });
        }
      });
    },
    query() {
      this.queryParams.pageSize = "1"; //回到第一页
      this.getNursingLevelList();
    },
    doing() {
      this.btnFlag = true;
      this.queryParams.levelStatus = "1"; //0-生效床位信息
      this.queryParams.pageSize = "1"; //回到第一页
      this.getNursingLevelList();
    },
    // 使用历史
    history() {
      this.btnFlag = false;
      this.queryParams.levelStatus = "2"; //1-(历史记录)
      this.queryParams.pageSize = "1"; //回到第一页
      this.getNursingLevelList();
    },
    getNursingLevelList() {
      findAllNursingLevelPage(this.queryParams).then(res => {
        this.nurseLevelList = res.data.records
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

}
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <div>
          <el-row class="mb-4">
            <el-button
                :class="[{activeBtn: btnFlag}]"
                style="border: 1px white solid;margin-left: 0px"
                @click="doing"
            >启用</el-button>
            <el-button
                :class="[{activeBtn: !btnFlag}]"
                style="border: 1px white solid;margin-left: 0px"
                @click="history"
            >停用</el-button>
            <el-button type="primary" icon="Plus" @click="openAddDialog">新增</el-button>
          </el-row>

        </div>

      </el-header>
      <el-divider style="margin:0"></el-divider>
      <el-main>
        <div>
          <!-- 表格 -->
          <el-table :data="nurseLevelList" style="width: 100% ;color:black;" stripe>
            <el-table-column
                align="center"
                type="index"
                :index="indexMethod"
                label="序号"
                width="120"
            />
            <el-table-column align="center" prop="levelName" label="护理级别" width="230" />
            <el-table-column align="center" prop="levelStatus" label="状态" width="160">
              <template #default="scope">{{ scope.row.levelStatus==1?'启用':'停用'}}</template>
            </el-table-column>
            <el-table-column align="center" fixed="right" label="操作" width="220">
              <template #default="scope">
                <el-button type="primary" icon="Edit" link @click="openUpdateNursingLevelDialog(scope.row)">修改</el-button>
                <el-button v-if="btnFlag" type="primary" icon="Edit" link @click="setting(scope.row)">设置服务对象</el-button>
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
              layout="prev, pager, next"
              :total="page.total"
              @current-change="handleCurrentChange"
          />
        </div>
      </el-main>
    </el-container>
    <!-- 修改/添加对话框 -->
    <el-dialog
        v-model="updateNursingLevelDialogVisible"
        title="新增退住登记"
        width="40%"
        :before-close="closeAddDialog">
      <el-form :model="updateNursingLevelForm" ref="updateNursingLevelFormRef" :rules="levelRules" label-width="100px">
        <!-- 客户详细信息，选择客户后显示 -->
        <el-form-item label="护理级别">
          <el-input v-model="updateNursingLevelForm.levelName" placeholder="请修改级别"/>
        </el-form-item>
        <el-form-item label="级别状态" prop="checkoutType">
          <el-radio-group v-model="updateNursingLevelForm.levelStatus">
            <el-radio :label="1">启用</el-radio>
            <el-radio :label="2">禁用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="closeAddDialog">取消</el-button>
        <el-button type="primary" @click="submitAddCheckout">添加</el-button>
      </template>
    </el-dialog>

    <!-- 新增对话框 -->
    <el-dialog v-model="addNursingLevelDialogVisible" title="新增护理级别" width="30%" :before-close="closeAddDialog">
      <el-form :model="addNursingLevelForm" :rules="levelRules" ref="addFormRef">
        <el-form-item label="级别名称" prop="levelName">
          <el-input v-model="addNursingLevelForm.levelName"/>
        </el-form-item>
        <el-form-item label="级别状态" prop="levelStatus">
          <el-radio-group v-model="addNursingLevelForm.levelStatus">
            <el-radio :label="1">启用</el-radio>
            <el-radio :label="2">停用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="closeAddDialog">取消</el-button>
        <el-button type="primary" @click="submitAdd">保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<style>

</style>