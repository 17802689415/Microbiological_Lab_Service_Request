<template>
  <el-container class="layout-container-demo" style="height: 1000px">
    
      <!-- <el-scrollbar> -->
        <el-menu class="el-menu-vertical-demo" 
        :default-openeds="['1','2','3']" 
        :collapse="isCollapse" 
        router=true
        background-color="cadetblue"
        active-text-color="white">
            <!-- <el-icon><BellFilled /></el-icon>&nbsp;&nbsp;
            <span>JABIL</span> -->
          <el-sub-menu index="1">
            <template #title>
              <el-icon><House /></el-icon>
              <sapn v-show="!isCollapse">Case</sapn>
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
                <sapn>handleCase</sapn>
                    </el-tooltip>
                </el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- user -->
          <el-sub-menu index="2">
            <template #title>
                <el-icon><Search /></el-icon>
                <sapn v-show="!isCollapse">UserManagement</sapn>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" @click="authority">Authority</el-menu-item>
              <el-menu-item index="2-2" @click="account">Account</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- setting -->
          <el-sub-menu index="3">
            <template #title>
              <el-icon><setting /></el-icon>
              <sapn v-show="!isCollapse">Setting</sapn>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1" @click="settingO">Setting 1</el-menu-item>
              <el-menu-item index="3-2" @click="settingT">Setting 2</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <!-- <el-menu-item id="user">
            <el-avatar :size="50"  />
          </el-menu-item> -->
        </el-menu>
    
    <el-container>
      <el-header style="text-align: 30px; font-size: 30px" >
        <!-- 展开菜单 -->
        <!-- <div class="toolbar">
            <el-button id="list" :icon="List" circle @click="showMenu"/>
        </div>
        <div class="toolbar">
            <el-tooltip content="logout" placement="right" effect="light">
            <el-button id="logout" circle @click="logout">
            <el-icon><Lock /></el-icon>
            </el-button>
            </el-tooltip>
        </div> -->
        <div id="header">
        <el-page-header :icon="null" >
            <template #content>
            <div class="flex items-center">
                <el-avatar
                :size="32"
                class="mr-3"
                src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
                />
                <span class="text-large font-600 mr-3"> User </span>
                
                <el-tag @click="logout">logout</el-tag>
            </div>
            </template>
        </el-page-header>
        </div>
        
      </el-header>
      <el-divider />

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>

import { List } from '@element-plus/icons-vue'
import 'element-plus/theme-chalk/index.css'

export default {
    name: "myHome",
    data() {
        return {
            tableData: [],
            List:List,
            isShow:true,
            isCollapse:true
        };
    },
    methods:{
        showMenu(){
            this.isCollapse=!this.isCollapse;
        },
        logout(){

        }
       
    }
}
</script>


<style>


#list{
    float: left;
    margin-top: 10px ;
}
#logout{
    float: right;
    margin-top: 10px ;
    margin-right:50px ;
}
#header{
    margin-top: 30px;
}

</style>