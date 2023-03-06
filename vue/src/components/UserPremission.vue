<template>
  <div>
        <el-collapse>
            <el-collapse-item title="Premission" name="1">
                <div>
                    <el-tag class="ml-2" type="info" v-for="item in premission" :key="item" @click="handleSelect(item)">{{ item }}</el-tag>
                </div>
            </el-collapse-item>
        </el-collapse>
    </div>
    <div id="userManager">
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
            style="width: 100%;">
            <el-table-column
            prop="username"
            label="username"
            >
            </el-table-column>
            <el-table-column
            prop="jobId"
            label="jobId"
            >
            </el-table-column>
            <el-table-column
            prop="role"
            label="role">
            </el-table-column>
            <el-table-column
            prop="station"
            label="station">
            </el-table-column>
            <el-table-column
            fixed="right"
            prop="action"
            label="操作"
            width="300px"
            >
            <template #default="scope"> 
                <el-button type="warning" size="small" @click="modify(scope.row)"><el-icon><Edit /></el-icon>编辑</el-button>
                <el-button type="success" size="small" @click="add(scope.row)"><el-icon><Plus /></el-icon>添加</el-button>
                <el-button type="danger" size="small" @click="deleteUser(scope.row)"><el-icon><Delete /></el-icon>删除</el-button>
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
    name:'userPremission',
    data(){
        return{
            isBorder:true,
            tableData:[
                {
                    username:'zl',
                    jobId:'3554536',
                    role:'admin',
                    station:'te',

                }
            ],
            premission:['admin','member'],
            currentPage:1,
            pageSize:1,
            total:0
        }
    },
    methods:{
        handleSelect(key){
            console.log(key)
        },
        handleSizeChange(val){
            console.log(val)
            this.pageSize=val
        },
        handleCurrentChange(val){
            console.log(val)
            this.currentPage=val
        }
    }

}
</script>

<style>

</style>