<template>
  
    <el-container class="common-layout-main">
      <el-header>
        <myHeader></myHeader>
      </el-header>
      <el-main>
        <myMain></myMain>
      </el-main>
      <el-footer>
        <myFoot></myFoot>
      </el-footer>
    </el-container>

</template>

<script>
import myHeader from './MyHeader.vue'
import myMain from './MainContainer.vue'
import myFoot from './FooterContainer.vue'
export default {
  name:'mainHome',
  components:{
    myHeader,
    myMain,
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