<script>
import {findAllNursingServicePage,findNursingServicePage,addLevelItem,deleteLevelItem} from "@/api/nursingServiceApi"
export default {
  computed:{
    indexMethod_nursingService() {
      return this.leftPage.currentPag * this.leftPage.pageSize - this.leftPage.pageSize + 1;
    },
    indexMethod_nurseByItemIdList() {
      return this.rightPage.currentPag * this.rightPage.pageSize - this.rightPage.pageSize + 1;
    }
  },
  data(){
    return{
      deletedLevelItemForm:{
        levelId:this.$route.query.levelId,
        itemId:""
      },
      addLevelItemForm:{
        id:'',
        levelId:this.$route.query.levelId,
        itemId:""
      },

      nickname:this.$route.query.levelName,
      queryParams_right: {
        nickname:this.$route.query.levelName,
        levelId:this.$route.query.levelId,
        status: "1",
        pageSize: "1" //默认第一页
      },
      //分页属性封装
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
      btnFlag: true,
      queryParams_left: {
        status: "1", //查询默认状态1 -启用
        pageSize: "1" //默认第一页
      },

      nursingServiceList: [],
      nurseByItemIdList:[]
    }
  },
  methods:{
    handleDelete(row) {
        deleteLevelItem({levelId:this.deletedLevelItemForm.levelId,itemId:row.id}).then(() => {
          this.$message.success('删除成功');
          this.getNursingServiceListById();
        })

    },
    save(row){
      addLevelItem({levelId:this.addLevelItemForm.levelId, itemId:row.id}).then(
          res => {
            if(res.flag){
              this.$message.success('分配成功');
              this.getNursingServiceListById();
            }else{
              this.$message.error(res.message)
            }

          }
      ).catch(err => this.$message.error(err.message));
    },
    //选中页码
    handleCurrentChangeService(curPage) {
      this.leftPage.currentPag = curPage;
      this.queryParams_left.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getNursingServiceList();
    },
    handleCurrentChange(curPage) {
      this.rightPage.currentPag = curPage;
      this.queryParams_right.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getNursingServiceListById();
    },
    getNursingServiceList() {
      findAllNursingServicePage(this.queryParams_left).then(res => {
        console.log("12123123"+res.data.records)
        this.nursingServiceList = res.data.records;
        this.leftPage.total = res.data.total; //总记录数
        this.leftPage.pageSize = res.data.size; //每页显示条数
        this.leftPage.currentPag = res.data.current; //当前页码
        this.leftPage.pagCount = res.data.pages; //总页数
      });
    },
    getNursingServiceListById() {
      findNursingServicePage(this.queryParams_right).then(res => {
        console.log("122123123"+res.data.records)
        this.nurseByItemIdList = res.data.records;
        this.rightPage.total = res.data.total; //总记录数
        this.rightPage.pageSize = res.data.size; //每页显示条数
        this.rightPage.currentPag = res.data.current; //当前页码
        this.rightPage.pagCount = res.data.pages; //总页数
      });
    },
  },
  mounted() {
    this.getNursingServiceList();
    this.getNursingServiceListById()
    },

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
                <!--                  v-model="queryParams_left.customername"-->
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
                <h3>护理项目</h3>
              </div>
              <el-table :data="nursingServiceList">
                <el-table-column
                    align="center"
                    type="index"
                    :index="indexMethod_nursingService"
                    label="序号"
                    width="60"
                />
                <el-table-column align="center" prop="serialNumber" label="编号" width="120" />
                <el-table-column align="center" prop="nursingName" label="名称" width="120" />
                <el-table-column align="center" prop="servicePrice" label="价格" width="100" />
                <el-table-column align="center" prop="executionCycle" label="执行周期" width="100" />
                <el-table-column align="center" prop="executionTimes" label="执行次数" width="120" />
                <el-table-column align="center" label="操作" width="120">
                  <template #default="scope">
                    <el-button type="primary" size="small" @click="save(scope.row)">分配护理登记</el-button>
                  </template>
                </el-table-column>
              </el-table>
               <div style="margin-top:15px">
                <!--
                    leftPage-size:每页显示条目个数
                    current-leftPage:页码 配合@current-change使用
                    disabled:是否禁用分页
                    background:是否为分页按钮添加背景色
                    layout:组件布局，子组件名用逗号分隔
                    total:总条目数
                -->
                <el-pagination
                    :page-size="leftPage.pageSize"
                    background
                    :current-Page="leftPage.currentPag"
                    layout=" prev, pager, next"
                    :total="leftPage.total"
                    @current-change="handleCurrentChangeService"
                />
              </div>
            </el-card>

            <el-card class="right-panel" style="width: 68%">
              <div class="header">
                <h3>护理项目({{ this.queryParams_right.nickname }})</h3>
              </div>
              <el-table :data="nurseByItemIdList">
                <el-table-column
                    align="center"
                    type="index"
                    :index="indexMethod_nurseByItemIdList"
                    label="序号"
                    width="60"
                />
                <el-table-column align="center" prop="serialNumber" label="编号" width="120" />
                <el-table-column align="center" prop="nursingName" label="名称" width="120" />
                <el-table-column align="center" prop="servicePrice" label="价格" width="100" />
                <el-table-column align="center" prop="executionCycle" label="执行周期" width="100" />
                <el-table-column align="center" prop="executionTimes" label="执行次数" width="120" />
                <el-table-column align="center" label="操作" width="120">
                  <template #default="scope">
                    <el-button type="danger" class="el-icon-delete" @click="handleDelete(scope.row)"/>
                  </template>
                </el-table-column>
              </el-table>

              <div style="margin-top:15px">
                <!--
                    leftPage-size:每页显示条目个数
                    current-leftPage:页码 配合@current-change使用
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