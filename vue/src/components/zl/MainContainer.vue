<template>
    
 <div class="common-layout">
    <el-container>
      <el-aside width="70%">
        <div>
            <el-carousel :interval="4000" type="card" height="600px">
                <el-carousel-item>
                <img src="../../icons/p1.jpg" height="600">
                </el-carousel-item>
                <el-carousel-item>
                <img src="../../icons/p2.jpg" height="600">
                </el-carousel-item>
                <el-carousel-item>
                <img src="../../icons/p3.jpg" height="600">
                </el-carousel-item>
                <el-carousel-item>
                <img src="../../icons/p4.jpg" height="600">
                </el-carousel-item>
            </el-carousel>
        </div>
      </el-aside>
      <el-main>
        <div id="login">
            <el-form
                id="logForm"
                :model="fromData"
            >
                <el-form-item label="Username">
                <el-input v-model="fromData.username" />
                </el-form-item>
                <el-form-item label="Password">
                <el-input v-model="fromData.password" />
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
      </el-main>
    </el-container>
  </div>
  
</template>

<script>
export default {
    name:'myMain',
    data(){
        return{
            fromData:{
                username:'',
                password:''
            }
        }
    }


}
</script>

<style scoped>
#login{
    width: 80%;
    height: 200px;
    /* border: 1px black solid; */
    margin: auto;
    margin-top:200px ;
}
#logForm{
    width: 300px;
    margin: auto;
}
</style>