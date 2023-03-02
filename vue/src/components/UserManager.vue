<template>
    <div id="userManager" style="background-color: blue;">
        <el-table
            :data="tableData"
            style="width: 100%;background-color: blue;">
            <el-table-column
            prop="username"
            label="用户名"
            >
            </el-table-column>
            <el-table-column
            prop="jobId"
            label="工号"
            >
            </el-table-column>
            <el-table-column
            prop="department"
            label="部门">
            </el-table-column>
            <el-table-column
            prop="jobTitle"
            label="职位">
            </el-table-column>
            <el-table-column
            prop="responsibility"
            label="职责">
            </el-table-column>
            <el-table-column
            prop="status"
            label="状态">
            </el-table-column>
            <el-table-column
            fixed="right"
            prop="action"
            label="操作"
            width="300px"
            >
            <template #default="scope"> 
                <el-button type="primary" size="small" @click="modify(scope.row)">编辑</el-button>
                <el-button type="primary" size="small" @click="add(scope.row)">添加</el-button>
                <el-button type="primary" size="small" @click="deleteUser(scope.row)">删除</el-button>
            </template>
            </el-table-column>
            
        </el-table>
    </div>
</template>

<script>
export default {
    name:'userManager',
    data(){
        return{
            tableData:[
                {
                username:"zhanglei",
                jobId:"3554536",
                department:"te",
                jobTitle:"/",
                responsibility:"/",
                status:"正常",
                }
            ]
        }
    },
    methods:{
        init(){

        },
        modify(row){
            console.log(row)
            this.$router.push({name:'modifyUser',query:{rowData:JSON.stringify(row)}})
        },
        add(row){
            console.log(row)
            this.$router.push('/addUser')
        },
        deleteUser(row){
            console.log(row)
            this.init()
        },
    }

}
</script>

<style>

</style>