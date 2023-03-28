<template>
  <div id="query">
    <el-select v-model="typeValue" class="m-2" placeholder="测试类型" size="small">
        <el-option
        v-for="item in options_type"
        :key="item"
        :label="item"
        :value="item"
        />
    </el-select>
    <el-select v-model="statusValue" class="m-2" placeholder="状态" size="small">
        <el-option
        v-for="item in options_status"
        :key="item"
        :label="item"
        :value="item"
        />
    </el-select>
    <el-button type="warning" size="small" @click="search" class="m-2"><el-icon><Search /></el-icon>查询</el-button>
    <el-select v-model="statusValue" class="m-2" placeholder="测试员" size="small">
        <el-option
        v-for="item in testUser"
        :key="item"
        :label="item"
        :value="item"
        />
    </el-select>
    <el-button @click="toggleSelection()" class="m-2" size="small">批量分配</el-button>
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
            prop="applyNo"
            label="申请单编号"
            >
            </el-table-column>
            <el-table-column
            prop="testType"
            label="测试类型"
            >
            </el-table-column>
            <el-table-column
            prop="consignor"
            label="委托人">
            </el-table-column>
            <el-table-column
            prop="testInfo"
            label="测试信息">
            <template #default="scope"> 
                <el-button type="warning" size="small" @click="view(scope.row)"><el-icon><View /></el-icon>查看</el-button>
            </template>
            </el-table-column>
            <el-table-column
            prop="sendDate"
            label="送样日期">
            </el-table-column>
            <el-table-column
            prop="status"
            label="状态">
            </el-table-column>
            <el-table-column
            fixed="right"
            prop="action"
            label="操作"
            >
            <template #default="scope"> 
                <el-button type="warning" size="small" @click="action(scope.row)"><el-icon><Tools /></el-icon>操作</el-button>
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
                {
                    applyNo:'123',
                    testType:'样品测试',
                    consignor:'zl',
                    sendDate:'2023 3 1',
                    status:'已完结',
                }
            ],
            options_type:['样品测试','纯化水测试','洁净室环境测试'],
            options_status:['已完结','未完结'],
            testUser:['zl','leo'],
            typeValue:'',
            statusValue:'',
            currentPage:1,
            pageSize:1,
            total:0,
            multipleSelection:[]
        }
    },
    methods:{
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
        },
        handleCurrentChange(val){
            console.log(val)
            this.currentPage=val
        },
        handleSelectionChange(val){
            this.multipleSelection=val
            console.log(this.multipleSelection)
        },
    }

}
</script>

<style scoped>
.m-2{
    margin-bottom: 10px;
    margin-right: 10px;
}

</style>