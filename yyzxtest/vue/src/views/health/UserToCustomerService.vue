<script>
import router from "@/router";
import {findAllCustomer,listkhxxPage,noSteward} from "@/api/consumerApi";
import {listOutwardVoPage} from "@/api/outRecord";

export default {
  computed: {
   indexMethodLeft() {
      return (index) =>
          (this.leftPage.currentPag - 1) * this.leftPage.pageSize + index + 1;
    },
    indexMethodRight() {
      return (index) =>
          (this.rightPage.currentPag - 1) * this.rightPage.pageSize + index + 1;
    }
  },
  data(){
    return{
      queryParams_right: {
        nickname:this.$route.query.nickname,
        userId:this.$route.query.userId,
        pageSize: "1" //默认第一页
      },
      queryParams: {
        userId:-1,
        nickname: "",
        pageSize: "1" //默认第一页
      },
      updateParams: {
        userId:-1,
        id:''//默认第一页
      },
      userId:this.$route.query.userId,
      leftList: [],   // 完整的客户列表
      rightList: [],
      leftPage: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
      rightPage: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
    }
  },
  methods: {
    // 拉完整的客户列表
     fetchLeft() {
       listkhxxPage(this.queryParams).then(res => {
         this.leftList = res.data.records;
         this.leftPage.total = res.data.total; //总记录数
         this.leftPage.pageSize = res.data.size; //每页显示条数
         this.leftPage.currentPag = res.data.current; //当前页码
         this.leftPage.pagCount = res.data.pages; //总页数
       });
    },
    // 拉完整的外出登记列表
    fetchRight() {
      listkhxxPage(this.queryParams_right).then(res => {
        console.log("222"+res.data.records);
        this.rightList = res.data.records;
        this.rightPage.total = res.data.total; //总记录数
        this.rightPage.pageSize = res.data.size; //每页显示条数
        this.rightPage.currentPag = res.data.current; //当前页码
        this.rightPage.pagCount = res.data.pages; //总页数
      });
    },

    handleCurrentChange(curPage) {
      this.rightPage.currentPag = curPage;
      this.queryParams_right.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格

      this.fetchRight();
    },
    handleCurrentChangeCustomer(curPage) {
      this.leftPage.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.fetchLeft();
    },
    deleted(row){
      this.updateParams.userId=-1
      this.updateParams.id=row.id

      noSteward(this.updateParams).then(res =>{
        if (res.flag) {
          this.$message.success('撤销成功');
          this.fetchRight();
          this.fetchLeft(); // 刷新列表
        } else {
          this.$message.error(res.message || '撤销失败');
        }
      })
    },
    update(row){
      this.updateParams.userId=this.$route.query.userId
      this.updateParams.id=row.id

      noSteward(this.updateParams).then(res =>{
        if (res.flag) {
          this.$message.success('修改成功');
          this.fetchRight();
          this.fetchLeft(); // 刷新列表
        } else {
          this.$message.error(res.message || '撤销失败');
        }
      })
    }
  },
  mounted() {
    this.fetchLeft()
    this.fetchRight()
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
          </el-row>
        </div>
      </el-header>

      <el-main>
        <div >
          <div  class="container" style="display: flex; justify-content: space-between; gap: 2%;">
            <el-card class="left-panel" style="width: 30%">
              <div class="header">
                <h3>无健康管家的客户信息</h3>
              </div>
              <el-table :data="leftList">
                <el-table-column
                    align="center"
                    type="index"
                    :index="indexMethodLeft"
                    label="序号"
                    width="60"
                />
                <el-table-column align="center" prop="customerName" label="客户姓名" width="120" />
                <el-table-column align="center" prop="customerSex" label="性别" width="120">
                  <template #default="scope">{{ scope.row.customerSex === 1 ? '男' : '女' }}</template>
                </el-table-column>
                <el-table-column align="center" prop="customerAge" label="客户年龄" width="120" />
                <el-table-column align="center" prop="roomId" label="房间号" width="100" />
                <el-table-column align="center" prop="bedId" label="床位" width="100" />
                <el-table-column align="center" prop="levelId" label="护理等级" width="120" />
                <el-table-column align="center" label="操作" width="120">
                  <template #default="scope">
                    <el-button type="primary" size="small" @click="update(scope.row)">分配管家</el-button>
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
                    :page-size="leftPage.pageSize"
                    background
                    :current-page="leftPage.currentPag"
                    layout=" prev, pager, next"
                    :total="leftPage.total"
                    @current-change="handleCurrentChangeCustomer"
                />
              </div>
            </el-card>

            <el-card class="right-panel" style="width: 68%">
              <div class="header">
                <h3>{{ this.queryParams_right.nickname }}的客户信息</h3>
              </div>
              <el-table :data="rightList">
                <el-table-column
                    align="center"
                    type="index"
                    :index="indexMethodRight"
                    label="序号"
                    width="60"
                />
                <el-table-column align="center" prop="customerName" label="客户姓名" width="120" />
                <el-table-column align="center" prop="customerSex" label="性别" width="120">
                  <template #default="scope">{{ scope.row.customerSex === 1 ? '男' : '女' }}</template>
                </el-table-column>
                <el-table-column align="center" prop="customerAge" label="客户年龄" width="120" />
                <el-table-column align="center" prop="roomId" label="房间号" width="100" />
                <el-table-column align="center" prop="bedId" label="床位" width="100" />
                <el-table-column align="center" prop="levelId" label="护理等级" width="120" />
                <el-table-column align="center" label="操作" width="120">
                  <template #default="scope">
                    <el-button type="danger" class="el-icon-delete" @click="deleted(scope.row)"/>
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
                    :page-size="rightPage.pageSize"
                    background
                    :current-page="rightPage.currentPag"
                    layout=" prev, pager, next"
                    :total="rightPage.total"
                    @current-change="handleCurrentChange"
                />
              </div>
            </el-card>
          </div>

        </div>
      </el-main>
    </el-container>
  </div>
</template>

<style scoped>

</style>