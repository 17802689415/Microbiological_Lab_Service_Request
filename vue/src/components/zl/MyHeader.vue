<template>
<div id="header">
  <el-menu
    text-color="black"
    class="el-menu-demo"
    mode="horizontal"
    :router="isRouter"
    :ellipsis="isEllipsis"
    active-text-color="black"
    background-color="white"
    
  >
    <el-menu-item index="0">Logo</el-menu-item>
    <div class="flex-grow"></div>
    <el-menu-item index="1"><span>Home</span></el-menu-item>
    <el-menu-item index="2"><span>收藏</span></el-menu-item>
    <el-menu-item index="3"><span>购物车</span></el-menu-item>
    <el-menu-item index="4"><span>我的旧物</span></el-menu-item>
    <el-menu-item index="5">
                    <el-sub-menu index="6">
                      <template #title >
                        <img src="../svg/114-user.svg">
                        <!-- <el-avatar size="30" src="../../icons/p5.png" /> -->
                        <span class="username"> User </span>
                      </template>
                      <el-menu-item index="6-1" @click="login"><el-icon><Open /></el-icon>login</el-menu-item>
                      <el-menu-item index="6-2" @click="logout"><el-icon><TurnOff /></el-icon>logout</el-menu-item>
                    </el-sub-menu>
    </el-menu-item>  
  </el-menu>
</div>
</template>

<script>
export default {
    name:'myHeader',
    data(){
        return{
            isRouter:false,
            isEllipsis:false
        }
    }

}
</script>

<style scoped>
.el-menu-item.is-active{
    background-color: white !important;
}
.el-menu-item:hover{
    background-color: white !important;
    font-size: large;
    font-weight: 500;
}
#header{
    box-shadow: 0 10px 10px 2px #bdcee0;
}
.flex-grow {
  flex-grow: 1;
}
.username{
    margin-right:15px ;
}
</style>