<template>
  
  <el-container class="layout-container-demo">
        <sideBar></sideBar>
      
    <el-container>
      <el-header  >
            <topBar></topBar>
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
import sideBar from './Side.vue'
import topBar from './Top.vue'

export default {
    name: "myHome",
    components:{
      sideBar,
      topBar
     
    },
    data() {
        return {
          
        };
    },
    
 
    
}
</script>


<style scoped>
@import './css/MyHome.css';
</style>

