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
    <el-button @click="toggleSelection()" class="m-2" size="small">{{ $t('batchAllocation') }}</el-button>
    </div>
    
    <div>
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
            prop="applyNo"
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
                {
                    applyNo:'123',
                    testType:'sampleTest',
                    consignor:'zl',
                    sendDate:'2023 3 1',
                    status:'finished',
                }
            ],
            options_type:['sampleTest','waterTest','cleanroomTest'],
            options_status:['finished','unfinished'],
            testUser:['zl','leo'],
            typeValue:'',
            statusValue:'',
            testUserValue:'',
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
        toggleSelection(){
            console.log(this.multipleSelection)
            console.log(this.testUserValue)
        },
        toggleSelection2(){
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