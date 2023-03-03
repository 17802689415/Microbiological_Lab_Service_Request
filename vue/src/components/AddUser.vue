<template>
  <div id="add">
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
    name:'addUser',
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
    methods:{
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
#add{
    width: 600px;
    margin: auto;
}
</style>