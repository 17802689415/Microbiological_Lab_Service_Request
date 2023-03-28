<template>
  <div id="log">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="Username" prop="username">
            <el-input v-model="ruleForm.username"/>
        </el-form-item>
        <el-form-item label="Password" prop="password">
            <el-input v-model="ruleForm.password" type="password"/>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm()">登录</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
  </div>
</template>

<script>
// import service from '@/request';


export default {
    name:'myLogin',
    data(){
        return{
            ruleForm: {
                username: '',
                password: ''
            },
            rules: {
                username: [
                    { required: true, message: 'Please enter the username', trigger: 'blur' },
                ],
                password: [
                    { required: true, message: 'Please enter the password', trigger: 'blur' },
                ],
            }
        }
    },
    methods:{
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        submitForm(){
            let that = this
            let formData = new FormData()
            formData.append('username',this.ruleForm.username)
            formData.append('password',this.ruleForm.password)
            this.$axios.post('http://localhost:8099/lab/login',formData).then(function (res){
                // console.log(res)
                if(res.data.code==200){
                    console.log(JSON.stringify(that.ruleForm.username))
                    // localStorage.setItem('username',that.ruleForm.username)
                    sessionStorage.setItem('username',that.ruleForm.username)
                    that.$router.push('myHome')
                }else{
                    alert(res.data.msg)
                }
            })
        }
    }

}
</script>

<style scoped>
@import './css/Login.css';
</style>