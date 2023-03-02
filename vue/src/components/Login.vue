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
            <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
  </div>
</template>

<script>
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
                    { required: true, message: 'Please enter the username', trigger: 'blur' },
                ],
            }
        }
    },
    methods:{
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }

}
</script>

<style scoped>
@import './css/Login.css';
</style>