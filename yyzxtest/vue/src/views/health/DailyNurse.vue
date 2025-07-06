<script >
import {getSessionStorage} from "@/utils/common";
import {getCustomerByUserId} from "@/api/consumerApi"
import {getNurseItemByCustomer} from "@/api/customerNurseItemApi"
import {addNurseRecord} from "@/api/nurseRecordApi"
export default {
  computed:{
    indexMethod() {
      return this.page.currentPag * this.page.pageSize - this.page.pageSize + 1;
    },
  },
  mounted() {
    this.queryParams.userId = getSessionStorage("user").id;
    this.getCustomerList();
  },
  data(){
    return{
      addNursingItemRules: {
        nursingTime: [{ required: true, message: "请选择护理时间", trigger: "blur" }],
        nursingCount: [{ required: true, message: "请填写护理次数", trigger: "blur" }],
      },
      getNurseItemByCustomerParams:{
        customerId:"",
        pageSize:"1"
      },
      innerDrawerData:{
        innerDrawer:false,
      },
      drawerData:{
        drawer:false,
      },
      customerList:[],
      page: {
        total: 0,
        pageSize: 6,
        currentPag: 1,
        pagCount: 0
      },
      btnFlag: true,
      queryParams: {
        userId:"",
        pageSize: "1" //默认第一页
      },
      NurseItemByCustomerList:[],
      diffDays:"",
      addNurseItemForm:{
        isDeleted: 1,
        customerId:"",
        itemId:"",
        nursingName:"",
        nursingContent:"",
        nursingCount:1,
        userId:"",
        customerName:"",
        serialNumber:"",
        nursingTime:''
      },
    }
  },
  methods:{
    submitAddCheckout(){
      addNurseRecord(this.addNurseItemForm).then(res => {
        if (res.flag) {
          this.$message.success("添加成功");
          this.addCheckoutDialogVisible = false;
          this.drawerData.drawer = false;
          this.innerDrawerData.innerDrawer=false;
          this.resetAddForm()
        } else {
          this.$message.error(res.message || "添加失败");
        }
      }).catch(() => {
        this.$message.error("添加请求失败");
      });
    },
    resetAddForm() {
      this.addNurseItemForm = {
        isDeleted: 1,
        customerId: "",
        itemId: "",
        nursingName: "",
        nursingContent: "",
        nursingCount: 1,
        userId: "",
        customerName: "",
        serialNumber: "",
        nursingTime: ""
      };
    },
    closeAddDrawer(){
      this.innerDrawerData.innerDrawer = false
    },
    handleCustomerSelect(item) {
      console.log("item数据",item)
      this.addNurseItemForm.customerName = item.customerName;
      this.addNurseItemForm.nursingName = item.nursingName;
      this.addNurseItemForm.serialNumber = item.serialNumber;
      this.addNurseItemForm.userId = this.queryParams.userId;
      this.addNurseItemForm.customerId = item.customerId;
      this.addNurseItemForm.itemId = item.itemId;
    },
    nurseDaily(row){
      this.drawerData.drawer=true
      this.getNurseItemByCustomerParams.customerId = row.id
      this.getNurseItemByCustomer()
    },
    nurse(row){
      this.innerDrawerData.innerDrawer=true
      this.handleCustomerSelect(row)
    },
    getCustomerList() {
      getCustomerByUserId(this.queryParams).then(res => {
        console.log("数据",res.data)
        this.customerList = res.data.records;
        this.page.total = res.data.total; //总记录数
        this.page.pageSize = res.data.size; //每页显示条数
        this.page.currentPag = res.data.current; //当前页码
        this.page.pagCount = res.data.pages; //总页数
      });
    },
    getNurseItemByCustomer(){
      getNurseItemByCustomer(this.getNurseItemByCustomerParams).then(res =>{
        this.NurseItemByCustomerList = res.data.records;
        this.page.total = res.data.total; //总记录数
        this.page.pageSize = res.data.size; //每页显示条数
        this.page.currentPag = res.data.current; //当前页码
        this.page.pagCount = res.data.pages;
      })
    },
    getExpireStatus(maturityTime) {
      const now = new Date();
      const endDate = new Date(maturityTime);
      const diffTime = endDate.getTime() - now.getTime();
      return Math.floor(diffTime / (1000 * 60 * 60 * 24));
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
        <el-table :data="customerList" style="width: 100% ;color:black;" stripe>
          <el-table-column
              align="center"
              type="index"
              :index="indexMethod"
              label="序号"
              width="60"
          />
          <el-table-column align="center" prop="customerName" label="客户姓名" width="120" />
          <el-table-column align="center" prop="customerSex" label="性别" width="120">
            <template #default="scope">{{ scope.row.customerSex === 1 ? '男' : '女' }}</template>
          </el-table-column>
          <el-table-column align="center" prop="customerAge" label="客户年龄" width="120" />
          <el-table-column align="center" prop="roomNo" label="房间号" width="120" />
          <el-table-column align="center" prop="bedId" label="床位" width="100" />
          <el-table-column align="center" prop="buildingNo" label="所属楼房" width="120" />
          <el-table-column align="center" prop="contactTel" label="联系电话" width="120" />
          <el-table-column align="center" prop="levelId" label="护理等级" width="120" />
          <el-table-column align="center" fixed="right" label="操作" width="220">
            <template #default="scope">
              <el-button  type="primary" icon="SwitchFilled"  @click="nurseDaily(scope.row)">日常护理</el-button>
            </template>
          </el-table-column>

        </el-table>
      </div>
    </el-main>
  </el-container>

  <el-drawer v-model="drawerData.drawer" title="客户护理项目" size="70%">
    <div>
      <el-divider></el-divider>
      <el-table :data="NurseItemByCustomerList" style="width: 100% ;color:black;" stripe>
        <el-table-column
            align="center"
            type="index"
            :index="indexMethod"
            label="序号"
            width="60"
        />
        <el-table-column align="center" prop="customerName" label="客户姓名" width="120" />
        <el-table-column align="center" prop="serialNumber" label="编号" width="120" />
        <el-table-column align="center" prop="nursingName" label="项目名称" width="100" />
        <el-table-column align="center" prop="servicePrice" label="价格" width="100" />
        <el-table-column align="center" prop="serviceNumber" label="余量" width="100" />
        <el-table-column align="center" prop="maturityTime" label="到期时间" width="160" />
        <el-table-column label="护理状态" align="center" width="240">
          <template #default="scope">
            <el-tag v-if="scope.row.serviceNumber>10" type="success">数量正常</el-tag>
            <el-tag v-else-if="scope.row.serviceNumber>0 && scope.row.serviceNumber<10" type="warning">即将用完</el-tag>
            <el-tag v-if="this.getExpireStatus(scope.row.maturityTime) > 10" type="success">未到期</el-tag>
            <el-tag v-else-if="this.getExpireStatus(scope.row.maturityTime) < 10 && this.getExpireStatus(scope.row.maturityTime) > 0" type="warning">即将到期</el-tag>
            <el-tag v-else-if="this.getExpireStatus(scope.row.maturityTime) <= 0" type="warning">已到期</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="120">
          <template #default="scope">
            <el-button type="primary" @click=nurse(scope.row)>护理</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-drawer
          v-model="innerDrawerData.innerDrawer"
          title="I'm inner Drawer"
          :append-to-body="true"
          size="40%"
      >
        <el-form :model="addNurseItemForm" :rules="addNursingItemRules" label-width="100px">
          <el-form-item label="客户姓名">
            <el-input v-model="addNurseItemForm.customerName" disabled  />
          </el-form-item>
          <el-form-item label="护理项目编号">
            <el-input v-model="addNurseItemForm.serialNumber" disabled />
          </el-form-item>
          <el-form-item label="护理项目名称">
            <el-input v-model="addNurseItemForm.nursingName" disabled />
          </el-form-item>
          <el-form-item label="护理时间" prop="nursingTime">
            <el-date-picker
                v-model="addNurseItemForm.nursingTime"
                type="datetime"
                placeholder="选择护理时间"
                value-format="YYYY-MM-DD"
                format="YYYY-MM-DD"
            />
          </el-form-item>
          <el-form-item label="护理项目数量" prop="nursingCount">
            <el-input v-model="addNurseItemForm.nursingCount"  />
          </el-form-item>
          <el-form-item label="护理项目内容">
            <el-input type="textarea" :autosize="{ minRows: 6 }" v-model="addNurseItemForm.nursingContent"  />
          </el-form-item>
        </el-form>

        <template #footer>
          <el-button @click="closeAddDrawer">取消</el-button>
          <el-button type="primary" @click="submitAddCheckout">添加</el-button>
        </template>
      </el-drawer>
    </div>

  </el-drawer>
</div>
</template>

<style scoped>

</style>