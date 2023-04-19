<template>
    <div id="query">
        <el-select v-model="typeValue" class="m-2" :placeholder="$t('testType')" size="small">
            <el-option
            v-for="item in options_type"
            :key="item"
            :label="$t(item)"
            :value="item"
            />
        </el-select>
        <el-select v-model="statusValue" class="m-2" :placeholder="$t('status')" size="small">
            <el-option
            v-for="item in options_status"
            :key="item"
            :label="$t(item)"
            :value="item"
            />
        </el-select>
        <el-button type="warning" size="small" @click="search" class="m-2"><el-icon><Search /></el-icon>{{ $t('query') }}</el-button>
    </div>
    <div>
        <el-select v-model="testUserValue" class="m-2" :placeholder="$t('inspector')" size="small">
        <el-option
        v-for="item in testUser"
        :key="item"
        :label="item"
        :value="item"
        />
    </el-select>
    <!-- 批量分配 -->
    <el-button @click="toggleSelection()" class="m-2" size="small">{{ $t('batchAllocation') }}</el-button>
    </div>
    
    <div>
        <!-- 批量接收 -->
        <el-button @click="toggleSelection2()" class="m-2" size="small">{{ $t('batchReception') }}</el-button>
    </div>
    

    

  <div id="allCase">
        <el-table
        :header-cell-style="{
            backgroundColor:'#06426e',
            color:'#fff',
            'text-align':'center'
        }"
        :cell-style="{
            backgroundColor:'#06426e',
            color:'#fff',
            textAlign:'center'
        }"
            ref="multipleTableRef"
            :border="isBorder"
            :data="tableData"
            @selection-change="handleSelectionChange"
            style="width: 100%;">
            <el-table-column type="selection" width="55" />
            <el-table-column
            prop="caseNum"
            :label="$t('applyNo')"
            >
            </el-table-column>
            <el-table-column
            prop="testType"
            :label="$t('testType')"
            >
            </el-table-column>
            <el-table-column
            prop="consignorId"
            :label="$t('consignorId')">
            </el-table-column>
            <el-table-column
            prop="testInfo"
            :label="$t('testInfo')">
            <template #default="scope"> 
                <el-button type="warning" size="small" @click="view(scope.row)"><el-icon><View /></el-icon>{{ $t('view') }}</el-button>
            </template>
            </el-table-column>
            <!-- <el-table-column
            prop="sendDate"
            :label="$t('sendDate')">
            </el-table-column> -->
            <el-table-column
            prop="status"
            :label="$t('status')">
            </el-table-column>
            <el-table-column
            fixed="right"
            prop="action"
            :label="$t('action')"
            >
            <template #default="scope"> 
                <el-button type="warning" size="small" @click="action(scope.row)"><el-icon><Tools /></el-icon>{{ $t('action') }}</el-button>
            </template>
            </el-table-column>
        </el-table>
        <el-pagination
        v-model:current-page="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[10, 15, 20, 25]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        />
        <el-drawer v-model="drawer" title="Test Info">
            <div v-for="o in viewItem" :key="o.id">
                <p>testItem:{{ o.testItem }}</p>
                <p>quantity:{{ o.quantity }}</p>
                <p>limitValue:{{ o.limitValue }}</p>
                <p>wino:{{ o.wino }}</p>
                <p>remark:{{ o.remark }}</p>
                <el-divider />
            </div>
            
        </el-drawer>
    </div>
</template>

<script>
export default {
    name:'myCase',
    data(){
        return{
            isBorder:true,
            tableData:[
             
            ],
            options_type:['sampleTest','waterTest','cleanroomTest'],
            options_status:['finished','unfinished'],
            testUser:['zl','leo'],
            typeValue:'',
            statusValue:'unfinished',
            testUserValue:'',
            currentPage:1,
            pageSize:10,
            total:0,
            multipleSelection:[],
            drawer:false,
            viewItem:[]
        }
    },
    created(){
        this.init()
    },
    methods:{
        init(){
            let that = this
            let pageInfo = new FormData()
            pageInfo.append('page',this.currentPage)
            pageInfo.append('pageSize',this.pageSize)
            pageInfo.append('typeValue',this.typeValue)
            pageInfo.append('statusValue',this.statusValue)
            this.$axios.post('http://localhost:8099/lab/selectHandleCase',pageInfo).then(function (res){
                console.log(res)
                if(res.data.code==1){
                    that.tableData = res.data.data.records;
                    that.total = res.data.data.total;
                }
            })
        },
        view(row){
            console.log(row)
            console.log(row)
            console.log(row.testType)
            let that = this
            this.drawer=true
            let formData = new FormData()
            formData.append('caseNum',row.caseNum)
            if(row.testType=='sampleTest'){
                this.$axios.post('http://localhost:8099/lab/selectSampleTestInfo',formData).then(function (res){
                    console.log(res)
                    if(res.data.code==1){
                        that.viewItem=res.data.data
                    }
                })
            }
        },
        action(row){
            console.log(row)
        },
        search(){
            console.log(this.typeValue)
            console.log(this.statusValue)
            let that = this
            console.log(this.typeValue)
            console.log(this.statusValue)
            let pageInfo = new FormData()
            pageInfo.append('page',this.currentPage)
            pageInfo.append('pageSize',this.pageSize)
            pageInfo.append('typeValue',this.typeValue)
            pageInfo.append('statusValue',this.statusValue)
            this.$axios.post('http://localhost:8099/lab/selectHandleCase',pageInfo).then(function (res){
                if(res.data.code==1){
                    that.tableData = res.data.data.records;
                    that.total = res.data.data.total;
                }
            })
        },
        handleSizeChange(val){
            console.log(val)
            this.pageSize=val
            this.init()
        },
        handleCurrentChange(val){
            console.log(val)
            this.currentPage=val
            this.init()
        },
        handleSelectionChange(val){
            this.multipleSelection=val
            console.log(this.multipleSelection)
            this.init()
        },
        toggleSelection(){
            console.log(this.multipleSelection)
            console.log(this.testUserValue)
            if(this.testUserValue==''){
                alert("请选择操作员")
                return
            }
            let that = this
            let caseList =[]
            this.multipleSelection.forEach(element => {
                caseList.push(element.caseNum)
            });
            console.log(caseList)
            let formData = new FormData()
            formData.append('caseList',caseList)
            formData.append('testUserValue',this.testUserValue)
            this.$axios.post('http://localhost:8099/lab/batchAllocation',formData).then(function (res){
                if(res.data.code==1){
                    console.log("测试")
                    alert("success")
                    that.init()
                }
            })

        },
        toggleSelection2(){
            console.log(this.multipleSelection)
            console.log(sessionStorage.getItem('username'))
            let that = this
            let caseList =[]
            this.multipleSelection.forEach(element => {
                caseList.push(element.caseNum)
            });
            console.log(caseList)
            let formData = new FormData()
            formData.append('caseList',caseList)
            formData.append('testUserValue',sessionStorage.getItem('username'))
            this.$axios.post('http://localhost:8099/lab/batchReception',formData).then(function (res){
                if(res.data.code==1){
                    console.log("测试")
                    alert("success")
                    that.init()
                }
            })
        }
    }

}
</script>

<style scoped>
.m-2{
    margin-bottom: 10px;
    margin-right: 10px;
}

</style>