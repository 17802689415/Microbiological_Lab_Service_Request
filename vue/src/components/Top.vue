<template>
  <div id="header">      
                <div class="logo">      
                    <el-menu
                    class="el-menu-demo"
                    mode="horizontal"
                    :ellipsis="false"
                  >
                    <el-menu-item index="0">
                      <img src="../icons/190-menu.svg" @click="change" height="56">
                    </el-menu-item>
                    <el-menu-item index="1">
                      <img src="../assets/jp_logo.png" height="56" >
                    </el-menu-item>
                    <div class="flex-grow" ></div>
                    <el-menu-item index="2">
                    <el-sub-menu index="3">
                      <template #title >
                        <img src="../icons/005-newspaper.svg">
                        <span class="username"> User </span>
                      </template>
                      <el-menu-item index="2-1" @click="login"><el-icon><Open /></el-icon>login</el-menu-item>
                      <el-menu-item index="2-1" @click="logout"><el-icon><TurnOff /></el-icon>logout</el-menu-item>
                    </el-sub-menu>
                    </el-menu-item>  
                  </el-menu>
                </div>
                <div id="progress">
                  <el-progress
                    :percentage="value"
                    status="success"
                    :indeterminate="false"
                    :duration="5"
                  />
                </div>
          </div>
</template>

<script>
export default {
    name:'topBar',
    data(){
        return{
            value:0
        }
    },
    created(){
      this.init()
    },
    methods:{
        init(){
          let that = this;
          setInterval(() => {
            if(that.value<100){
              that.value = (that.value % 100) + 10
            }else{
              that.value=100
            }
            
          }, 50)
        },
        
        logout(){
          alert("logout")
        },
        login(){
          alert("login")
        },
        change(){
          this.$store.state.isCollapse=!this.$store.state.isCollapse
        }
       
    }

}
</script>

<style>

</style>