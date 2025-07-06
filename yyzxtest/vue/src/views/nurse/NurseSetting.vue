<script>
import {
  findAllCustomer,noLevel,updateLevelId
} from "@/api/consumerApi.js";
import {findAllCustomerNurseItemPage,saveCustomerNurseItem,deleted} from "@/api/customerNurseItemApi";
import {findNursingService} from "@/api/nursingServiceApi";
import {findAllNursingLevel} from "@/api/nurseLevelApi"
export default {
  computed: {
    handleChange(value) {
      console.log(value);
    },
    indexMethod() {
      return this.page.currentPag * this.page.pageSize - this.page.pageSize + 1;
    },
    options() {
      return this.levelIdList ? this.levelIdList.map(item => ({
        label: item.levelName,
        value: item.id
      })) : [];
    }
  },
  data(){

    return{
      deletedPara:{
        customerId:''
      },
      updateLevelIdParams:{
        id:"",
        levelId:""
      },
      selectedCustomerId:"",
      saveList:{
        customerId:"",
        itemId:"",
        nurseNumber:"1",
        buyTime:"",
        maturityTime:"",
        levelId:"",
        levelName:"",
        levelStatus:"",
      },
      newList:{
        nurseNumber:"1",
        buyTime:"",
        maturityTime:"",
        id:"",
        levelName:"",
        levelStatus:"",
        isDeleted:""
      },
      ServiceList:[],
      queryCustomerNurseItem:{
        levelId:""
      },
      customerNurseItemList:[],
      delParams:{
      id:""
      },
      levelIdList:[],
      Params:{

      },
      drawer: false,
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
      queryLevel:{
        levelStatus:1
      },
      customerList: []
    }
  },
  mounted() {
    this.getCustomerList();
    this.getNursingLevel();
    this.getServiceList()
  },
  methods:{
    async save() {
      if (!this.queryCustomerNurseItem.levelId) {
        this.$message.warning("请选择护理等级！");
        return;
      }

      let array = [];
      const selectedLevel = this.levelIdList.find(item => item.id === this.queryCustomerNurseItem.levelId);

      for (let i = 0; i < this.newList.length; i++) {
        let obj = {
          itemId: this.newList[i].id,
          buyTime: this.newList[i].buyTime,
          maturityTime: this.newList[i].maturityTime,
          nurseNumber: this.newList[i].nurseNumber,
          levelId: selectedLevel ? selectedLevel.id : "",
          levelName: selectedLevel ? selectedLevel.levelName : "",
          customerId: this.selectedCustomerId,
          isDeleted: 0
        };
        array.push(obj);
      }

      console.log("数据", array);

      try {
        await saveCustomerNurseItem(array);
        this.$message.success("保存成功！");
        this.updateLevelIdParams.id = this.selectedCustomerId;
        this.updateLevelIdParams.levelId = selectedLevel ? selectedLevel.id : "";
        await updateLevelId(this.updateLevelIdParams);
        this.drawer = false;
        await this.getCustomerList();  // 确保刷新是异步完成后执行的
      } catch (err) {
        this.$message.error("保存失败！");
        console.error(err);
      }
    },
    getServiceList(){
      findNursingService(this.queryCustomerNurseItem).then(res=>{
        console.log("@@@",res)
        let newList = res.data;
        for (let i = 0; i < newList.length; i++) {
          newList[i].nurseNumber=1;
          newList[i].buyTime=new Date().getFullYear()+'-'+(new Date().getMonth()+1) +'-' +new Date().getDate();
          newList[i].maturityTime=new Date().getFullYear()+'-'+(new Date().getMonth()+4) +'-' +new Date().getDate();
        }
        this.newList = newList
      })
    },
    handleCurrentChange(curPage) {
      this.page.currentPag = curPage;
      this.queryParams.pageSize = curPage; //参数pageSize是服务端接收页码参数名
      //重新渲染表格
      this.getCustomerList();
    },
    getCustomerList() {
      findAllCustomer(this.queryParams).then(res => {
        this.customerList = res.data.records;
        this.page.total = res.data.total; //总记录数
        this.page.pageSize = res.data.size; //每页显示条数
        this.page.currentPag = res.data.current; //当前页码
        this.page.pagCount = res.data.pages; //总页数
      });

    },
    getNursingLevel() {
      findAllNursingLevel(this.queryLevel).then(res =>{
        console.log("护理等级接口返回：", res);
        this.levelIdList = res.data;
      })
    },
    opendrawer(row) {
      this.selectedCustomerId = row.id; // 保存 customerId
      this.drawer = true;
    },
    del(id) {
      this.$confirm("确认移除该客户的护理级别吗？", "提示", {
        type: "warning"
      }).then(() => {
        this.delParams.id = id
        noLevel(this.delParams).then(res => {
          this.deletedPara.customerId=id
          console.log("deletedPara",this.deletedPara)
          deleted(this.deletedPara);
          this.$message.success("已移除护理级别！");
          console.log("id:::",this.delParams.id)

          this.getCustomerList(); // 确保是在接口成功后再刷新
        }).catch(err => {
          this.$message.error("操作失败，请重试！");
          console.error(err);
        });
      }).catch(() => {
        // 用户取消操作
      });
    }
  }
}
</script>

<template>
<div class="container">
  <el-container>
    <el-header>
      <div>
        <el-row :gutter="30">
          <el-col :span="7">
            <el-input>
<!--                placeholder="名称"-->
<!--                v-model="queryParams.nursingServicename"-->
<!--                @clear="query"-->
<!--                clearable-->
<!--                size="large"-->
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
           <el-table-column align="center" prop="bedId" label="床位" width="100" />
          <el-table-column align="center" prop="buildingNo" label="所属楼房" width="120" />
          <el-table-column align="center" prop="levelId" label="护理等级" width="120" />
          <el-table-column align="center" fixed="right" label="操作" width="220">
            <template #default="scope">
              <el-button v-if="scope.row.levelId === null" type="primary" icon="Edit"  @click="opendrawer(scope.row)">设置护理级别</el-button>
              <el-button v-else-if="scope.row.levelId !== null" type="danger" icon="Delete" @click="del(scope.row.id)">移除护理级别</el-button>
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

  <el-drawer size="70%" v-model="drawer" title="客户护理设置" :with-header="true">
    <el-select
        v-model="queryCustomerNurseItem.levelId"
        clearable
        placeholder="选择护理级别"
        style="width: 240px; margin-left: 10px"
        @change="getServiceList"
    >
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
      />
    </el-select>
    <el-divider></el-divider>
    <el-table :data="newList" style="width: 100% ;color:black;" stripe>
      <el-table-column
          align="center"
          type="index"
          :index="indexMethod"
          label="序号"
          width="60"
      />
      <el-table-column align="center" prop="serialNumber" label="编号" width="120" />
      <el-table-column align="center" prop="nursingName" label="名称" width="120" />
      <el-table-column align="center" prop="servicePrice" label="价格" width="100" />
      <el-table-column align="center" prop="executionCycle" label="执行周期" width="100" />
      <el-table-column align="center" prop="executionTimes" label="执行次数" width="100" />
      <el-table-column align="center" prop="nurseNumber" label="护理次数" width="200">
        <template #default="scope">
          <el-input-number v-model="scope.row.nurseNumber" :min="1" :max="1000" @change="handleChange" />
        </template>
      </el-table-column>
      <el-table-column align="center" prop="buyTime" label="购买时间" width="160" />
      <el-table-column align="center" label="到期时间" width="180">
        <template #default="scope">
          <el-date-picker
              v-model="scope.row.maturityTime"
              type="date"
              placeholder="选择日期"
              format="YYYY-MM-DD"
              value-format="YYYY-MM-DD"
              style="width: 150px"
          />
        </template>
      </el-table-column>
    </el-table>

    <template #footer>
      <div style="text-align: right;">
        <el-button type="primary" @click="save">保存</el-button>
      </div>
    </template>
  </el-drawer>
</div>
</template>

<style scoped>

</style>