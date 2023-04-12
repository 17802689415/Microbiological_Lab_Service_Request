<template>
  <div id="query">
    <el-select v-model="typeValue" class="m-2" :placeholder="$t('testType')" size="small">
        <el-option
        v-for="item in options_type"
        :key="item"
        :label="item"
        :value="item"
        />
    </el-select>
    <el-select v-model="statusValue" class="m-2" :placeholder="$t('status')" size="small">
        <el-option
        v-for="item in options_status"
        :key="item"
        :label="item"
        :value="item"
        />
    </el-select>
    <el-button type="warning" size="small" @click="search" class="m-2"><el-icon><Search /></el-icon>{{ $t('query') }}</el-button>
    <el-button @click="toggleSelection()" class="m-2" size="small">{{ $t('batchReception') }}</el-button>
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
            :border="isBorder"
            :data="tableData"
            @selection-change="handleSelectionChange"
            style="width: 100%;">
            <el-table-column type="selection" width="55" />
            <el-table-column
            prop="applyNum"
            :label="$t('applyNo')"
            >
            </el-table-column>
            <el-table-column
            prop="testType"
            :label="$t('testType')"
            >
            </el-table-column>
            <el-table-column
            prop="consignor"
            :label="$t('consignorId')">
            </el-table-column>
            <el-table-column
            prop="testInfo"
            :label="$t('testInfo')">
            <template #default="scope"> 
                <el-button type="warning" size="small" @click="view(scope.row)"><el-icon><View /></el-icon>{{ $t('view') }}</el-button>
            </template>
            </el-table-column>
            <el-table-column
            prop="sendDate"
            :label="$t('sendDate')">
            </el-table-column>
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
            options_type:['样品测试','纯化水测试','洁净室环境测试'],
            options_status:['已完结','未完结'],
            typeValue:'',
            statusValue:'',
            currentPage:1,
            pageSize:1,
            total:0,
            multipleSelection:[]
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
            that.$axios.post('http://localhost:8099/lab/selectCase',pageInfo).then(function (res){
                if(res.data.code==1){
                    that.tableData = res.data.data.records;
                    that.total = res.data.data.total;
                }
            })
        },
        view(row){
            console.log(row)
        },
        action(row){
            console.log(row)
        },
        search(){
            console.log(this.typeValue)
            console.log(this.statusValue)
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
        },
        toggleSelection(){
            console.log(this.multipleSelection)
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