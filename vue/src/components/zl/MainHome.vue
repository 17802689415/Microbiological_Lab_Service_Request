<template>
  
    <el-container class="common-layout-main">
      <el-header>
        <myHeader></myHeader>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
      <el-footer>
        <myFoot></myFoot>
      </el-footer>
    </el-container>

</template>

<script>
import myHeader from './MyHeader.vue'
import myFoot from './FooterContainer.vue'
export default {
  name:'mainHome',
  components:{
    myHeader,
    myFoot
  }

}
</script>

<style scoped>
.common-layout-main{
    height: 100%;
    width: 100%;
    top: 0px;
    left: 0px;
    position: absolute;
}
</style>