<template>
  
  <el-container class="layout-container-demo" style="height: 100%;top: 0px;left: 0px;position: absolute;width: 100%;" >
        <el-menu class="el-menu-vertical-demo" 
        :collapse="isCollapse" 
        router=true
        background-color="cadetblue"
        active-text-color="white">
          <el-sub-menu index="1">
            <template #title>
              <el-icon @click="showMenu"><House /></el-icon>
              <span v-show="!isCollapse" class="span">Case</span>
            </template>
            <!-- case -->
            <el-menu-item-group>
                <el-menu-item index="/postCase" >
                    <el-tooltip content="Case+" placement="right" effect="light">
                <span>Case+</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="/myCase" >
                    <el-tooltip content="MyCase" placement="right" effect="light">
                <span>MyCase</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="/handleCase" >
                    <el-tooltip content="handleCase" placement="right" effect="light">
                <span>handleCase</span>
                    </el-tooltip>
                </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- user -->
          <el-sub-menu index="2">
            <template #title>
                <el-icon @click="showMenu"><Search /></el-icon>
                <span v-show="!isCollapse" class="span">UserManagement</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" >Authority</el-menu-item>
              <el-menu-item index="2-2" >Account</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- setting -->
          <el-sub-menu index="3">
            <template #title>
              <el-icon @click="showMenu"><setting /></el-icon>
              <span v-show="!isCollapse" class="span">Setting</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1" >Setting 1</el-menu-item>
              <el-menu-item index="3-2" >Setting 2</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
        </el-menu>
      
      
      
    
    <el-container>
      <el-header  >
        <div id="header">      
                <div class="logo">      
                    <el-menu
                    class="el-menu-demo"
                    mode="horizontal"
                    :ellipsis="false"
                    @select="handleSelect"
                  >
                    <el-menu-item index="0">
                      <img src="../assets/jp_logo.png" height="56">
                    </el-menu-item>
                  
                    <el-menu-item index="1">
                       <el-avatar
                      src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
                      
                      />
                    <span class="text-large font-600 mr-3"> User </span>
                    </el-menu-item>

                    <el-sub-menu index="2">
                      <template #title ><el-icon><Position /></el-icon></template>
                      <el-menu-item index="2-1" @click="login"><el-icon><Open /></el-icon>login</el-menu-item>
                      <el-menu-item index="2-1" @click="logout"><el-icon><TurnOff /></el-icon>logout</el-menu-item>
                    </el-sub-menu>
                  </el-menu>
                </div>  
          </div>    
      </el-header>


      <el-main style="background-color: aliceblue;">
        <router-view></router-view>
      </el-main>
      <el-footer id="footer">Footer</el-footer>
    </el-container>
  </el-container>

</template>

<script>


import 'element-plus/theme-chalk/index.css'


export default {
    name: "myHome",
    components:{
     
    },
    data() {
        return {
            isCollapse:true,
            
        };
    },
    methods:{
        showMenu(){
            this.isCollapse=!this.isCollapse;
        },
        logout(){
          alert("logout")
        },
        login(){
          alert("login")
        },
        handleSelect(){

        }

       
    }
}
</script>


<style>


#user{
  margin-left: 30px ;
}
#footer{
  text-align: center;
}
.span{
  font-size: 20px;
  font-weight: 300;
  
}





</style>