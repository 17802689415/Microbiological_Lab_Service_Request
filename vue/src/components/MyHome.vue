<template>
  
  <el-container class="layout-container-demo">
        <el-menu class="el-menu-vertical-demo" 
        :collapse="isCollapse" 
        :router="isRouter"
        background-color="#163e6a"
        text-color="white"
        active-text-color="#559867"
        @select="selected"
        >
          <el-sub-menu index="1">
            <template #title>
              <img src="../icons/001-home.svg" class="icon" @click="this.isCollapse=!this.isCollapse;">
              <span v-show="!isCollapse" class="span">Case</span>
            </template>
            <!-- case -->
            <el-menu-item-group>
                <el-menu-item index="postCase" >
                    <el-tooltip content="Case+" placement="right" effect="light">
                <span class="span-children">case+</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="myCase" >
                    <el-tooltip content="MyCase" placement="right" effect="light">
                <span class="span-children">myCase</span>
                    </el-tooltip>
                </el-menu-item>
                <el-menu-item index="handleCase" >
                    <el-tooltip content="handleCase" placement="right" effect="light">
                <span class="span-children">handleCase</span>
                    </el-tooltip>
                </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- user -->
          <el-sub-menu index="2">
            <template #title>
              <img src="../icons/119-user-tie.svg" class="icon" @click="this.isCollapse=!this.isCollapse;">
                <span v-show="!isCollapse" class="span">UserManagement</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" >
                <el-tooltip content="authority" placement="right" effect="light">
                <span class="span-children">authority</span>
                </el-tooltip>
              </el-menu-item>
              <el-menu-item index="2-2" >
                <el-tooltip content="account" placement="right" effect="light">
                <span class="span-children">account</span>
                </el-tooltip>
              </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- setting -->
          <el-sub-menu index="3">
            <template #title>
              <img src="../icons/149-cog.svg" class="icon" @click="this.isCollapse=!this.isCollapse;">
              <span v-show="!isCollapse" class="span">Setting</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1" >
                <el-tooltip content="setting 1" placement="right" effect="light">
                <span class="span-children">setting 1</span>
                </el-tooltip>
              </el-menu-item>
              <el-menu-item index="3-2" >
                <el-tooltip content="setting 2" placement="right" effect="light">
                <span class="span-children">setting 2</span>
                </el-tooltip>
              </el-menu-item>
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
                  >
                    <el-menu-item index="0">
                      <img src="../assets/jp_logo.png" height="56">
                    </el-menu-item>
                    <div class="flex-grow" ></div>
                    <el-menu-item index="1">
                    <el-sub-menu index="2">
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
      </el-header>


      <el-main id="main">
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
            isRouter:true,
            value:0
            
            
        };
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
        selected(index){
          console.log(index)
        }

       
    }
}
</script>


<style scoped>
@import './css/MyHome.css';
</style>

