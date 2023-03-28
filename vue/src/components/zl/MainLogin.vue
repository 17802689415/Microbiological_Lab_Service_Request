<template>
        <div id="login">
            <el-form
                class="loginContainer"
                :model="fromData"
                :rules="rules"
            >
                <el-form-item prop="username" label="Username">
                <el-input v-model="fromData.username" />
                </el-form-item>
                <el-form-item prop="password" label="Password">
                <el-input v-model="fromData.password" />
                </el-form-item>
                <el-form-item prop="code" label="Code">
                    <el-input type="text" auto-complete="false" v-model="fromData.code" placeholder="点击图片更换验证码" style="width: 250px;margin-right: 5px">
                    </el-input>
                    <img :src="captchaUrl">
                </el-form-item>
                <el-form-item>
                    <el-checkbox v-model="checked" class="loginRemember">记住我</el-checkbox>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm(ruleFormRef)">
                        Create
                    </el-button>
                    <el-button type="primary" @click="resetForm(ruleFormRef)">
                        Reset
                    </el-button>
                </el-form-item>
                <el-form-item>
                    <el-link type="primary">没有账号？点击注册</el-link>
                </el-form-item>
            </el-form>
        </div>
</template>

<script>
export default {
    name:'mainLogin',
    data(){
        return{
            fromData:{
                username:'',
                password:'',
                code:''
            },
            rules:{
              username:[{required:true,message:"请输入用户名",trigger:"blur"},{ min: 5, max: 14, message: '长度在 5 到 14 个字符', trigger: 'blur' }],
              password:[{required:true,message:"请输入密码",trigger:"blur"},{ min: 6,  message: '密码长度要大于6', trigger: 'blur' }],
              code:[{required:true,message:"请输入验证码",trigger:"blur"}],
          },
          checked: true,
          captchaUrl: "",
        }
    }

}
</script>

<style>

.loginContainer{
        border-radius: 15px;
        background-clip: padding-box;
        margin: 180px auto;
        width: 350px;
        padding: 15px 35px 15px 35px;
        background: aliceblue;
        border:1px solid gainsboro;
        box-shadow: 0 0 25px gray;
    }

</style>