<template>
<div id="modify">
  <el-form :model="form" label-width="120px">
    <el-form-item label="用户名" prop="username">
      <el-input v-model="form.username" class="el"/>
    </el-form-item>
    <el-form-item label="工号">
      <el-input v-model="form.jobId" class="el"/>
    </el-form-item>
    <el-form-item label="部门">
      <el-input v-model="form.department" class="el"/>
    </el-form-item>
    <el-form-item label="职位">
      <el-input v-model="form.jobTitle" class="el"/>
    </el-form-item>
    <el-form-item label="职责">
      <el-input v-model="form.responsibility" class="el"/>
    </el-form-item>
    <el-form-item label="状态">
      <el-input v-model="form.status" class="el"/>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button type="primary" @click="onReturn">Cancel</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
export default {
    name:'modifyUser',
    data(){
        return{
            form:{
                username:"",
                jobId:"",
                department:"",
                jobTitle:"",
                responsibility:"",
                status:"",
            }
        }
    },
    
    created(){
        this.init()
    },
    methods:{
        init(){
            console.log(this.$route.query.rowData) 
            console.log(JSON.parse(this.$route.query.rowData).username)
            this.form.username=JSON.parse(this.$route.query.rowData).username
            this.form.jobId=JSON.parse(this.$route.query.rowData).jobId
            this.form.department=JSON.parse(this.$route.query.rowData).department
            this.form.jobTitle=JSON.parse(this.$route.query.rowData).jobTitle
            this.form.responsibility=JSON.parse(this.$route.query.rowData).responsibility
            this.form.status=JSON.parse(this.$route.query.rowData).status
        },
        onSubmit(){

        },
        onReturn(){
            this.$router.push("/userManager")
        }
    }
}
</script>

<style scoped>
.el{
    width: 400px;
}
#modify{
    width: 600px;
    margin: auto;
}
</style>