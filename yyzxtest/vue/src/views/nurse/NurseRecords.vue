<script >
import {queryNurseRecord,deleted} from "@/api/nurseRecordApi"
import {getSessionStorage} from "@/utils/common";
import {getCustomerByUserId,findAllCustomer} from "@/api/consumerApi";
import {getNurseItemByCustomer} from "@/api/customerNurseItemApi"


export default {
  computed:{
    indexMethodNurseItem() {
      return (index) =>
          (this.page_nurseItem.currentPag - 1) * this.page_nurseItem.pageSize + index + 1;
    },
    // 客户信息表的序号方法
    indexMethodCustomer() {
      return (index) =>
          (this.page_customer.currentPag - 1) * this.page_customer.pageSize + index + 1;
    }
  },
  data(){
    return{
      selectedCustomerId:"",
      //table的数据源
      customerList:[],
      nurseItemList:[],

      page_customer: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
      page_nurseItem: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
      queryParams_nurseItem: {
        customerId:"",
        pageSize: "1",
        isDeleted:1//默认第一页
      },
      queryParams:{
        userId:"",
        pageSize:"1"
      },
      deletedParam:{
        id:""
      }
    }
  },
  mounted() {
    this.queryParams.userId = getSessionStorage("user").id;
    this.getCustomerList();
  },
  methods:{
    deleted(row) {
      this.$confirm("此操作删除记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
          .then(() => {
            this.deletedParam.id = row.id
            deleted(this.deletedParam).then(res => {
              if (res.flag) {
                this.$message.success(res.message);
                //重载表格
                this._fetchNurseItemList();
              } else {
                this.$message.error(res.message);
              }
            });
          })
          .catch(() => {});
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
    handleCurrentChangeCustomer(curPage) {
      this.page_customer.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getCustomerList();
    },
    handleCurrentChange(curPage) {
      this.page_nurseItem.currentPag = curPage;
      this.queryParams_nurseItem.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this._fetchNurseItemList();
    },
    getNurseItemList(row) {
      this.selectedCustomerId = row.id;
      this._fetchNurseItemList()
    },
    _fetchNurseItemList() {
      this.queryParams_nurseItem.customerId = this.selectedCustomerId;
      queryNurseRecord(this.queryParams_nurseItem).then(res => {
        this.nurseItemList = res.data.records;
        this.page_nurseItem.total      = res.data.total;
        this.page_nurseItem.pageSize   = res.data.size;
        this.page_nurseItem.currentPag = res.data.current;
        this.page_nurseItem.pagCount   = res.data.pages;
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
          </el-row>
        </div>
      </el-header>
      <el-divider style="margin:0"></el-divider>

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
                <el-table-column align="center" fixed="right" label="操作" width="120">
                  <template #default="scope">
                    <el-button
                        type="danger"
                        @click="getNurseItemList(scope.row)"
                    >查看</el-button>
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
                <h3>护理记录</h3>
              </div>
              <el-table :data="nurseItemList" style="width: 100% ;color:black;">
                <el-table-column
                    align="center"
                    type="index"
                    :index="indexMethodNurseItem"
                    label="序号"
                    width="60"
                />
                <el-table-column align="center" prop="serialNumber" label="护理项目编号" width="120"/>
                <el-table-column align="center" prop="itemName" label="护理项目名" width="120"/>
                <el-table-column align="center" prop="serviceNumber" label="护理次数" width="120"/>
                <el-table-column align="center" prop="nursingContent" label="护理内容" width="120"/>
                <el-table-column align="center" prop="userName" label="护理人员" width="120"/>
                <el-table-column align="center" prop="phoneNumber" label="护理人员号码" width="120"/>
                <el-table-column align="center" prop="nursingTime" label="护理时间" width="120"/>
                <el-table-column align="center" fixed="right" label="操作" width="120">
                  <template #default="scope">
                    <el-button @click="deleted(scope.row)" type="danger">移除</el-button>
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
                    :page-size="page_nurseItem.pageSize"
                    background
                    :current-page="page_nurseItem.currentPag"
                    layout=" prev, pager, next"
                    :total="page_nurseItem.total"
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