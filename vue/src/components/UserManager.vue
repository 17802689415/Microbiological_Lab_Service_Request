<template>
    <div>
        <el-collapse>
            <el-collapse-item title="Username" name="1">
                <div>
                    <el-tag class="ml-2" type="info" v-for="item in tableData" :key="item.username" @click="handleSelect(item.username)">{{ item.username }}</el-tag>
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
            prop="backup"
            label="backup for">
            <template #default="scope">
                <el-button type="primary" size="small" @click="backup(scope.row)"><el-icon><Pointer /></el-icon>for</el-button>
            </template>
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
    <div id="">
        <el-drawer v-model="drawer" >
            <template #header>
                <h4>backup for</h4>
            </template>
            <template #default>
                <div>
                    <el-radio-group v-model="radio" v-for="item in tableData" :key="item.username">
                    <el-radio :label="item.username" :name="item.username">{{ item.username }}</el-radio><br>
                    </el-radio-group>
                </div>
            </template>
            <template #footer>
                <div style="flex: auto">
                    <el-button type="primary" @click="confirmClick">confirm</el-button>
                </div>
            </template>
        </el-drawer>
    </div>
</template>

<script>
export default {
    name:'userManager',
    data(){
        return{
            isBorder:true,
            tableData:[
                {
                username:"zhanglei",
                jobId:"3554536",
                department:"te",
                jobTitle:"/",
                responsibility:"/",
                status:"正常",
                },
                {
                username:"zl",
                jobId:"3554536",
                department:"te",
                jobTitle:"/",
                responsibility:"/",
                status:"正常",
                },
            ],
            drawer:false,
            radio:"",
            currentPage:1,
            pageSize:1,
            total:0
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
        backup(row){
            console.log(row)
            this.drawer=true
        },
        handleSelect(key){
            console.log(key)
        },
        handleBackup(key){
            console.log(key)
        },
        confirmClick(){
            console.log(this.radio)
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

<style scoped>

</style>