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
    <el-menu-item >Logo</el-menu-item>
    <div class="flex-grow"></div>
    <el-menu-item>
      <el-input v-model="keyWord" placeholder="搜索" class="search"></el-input>
      <el-button @click="search" class="search"><el-icon><Search /></el-icon></el-button>
    </el-menu-item>
    <el-menu-item index="myMain"><span>Home</span></el-menu-item>
    <el-menu-item index="2"><span>收藏</span></el-menu-item>
    <el-menu-item index="shopCar"><span>购物车</span></el-menu-item>
    <el-menu-item index="4"><span>我的旧物</span></el-menu-item>
    <el-menu-item index="mainLogin">
                    <el-sub-menu index="6">
                      <template #title >
                        <img src="../svg/114-user.svg">
                        <!-- <el-avatar size="30" src="../../icons/p5.png" /> -->
                        <span class="username"> {{ user }} </span>
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
            isRouter:true,
            isEllipsis:false,
            user:'登录',
            keyWord:''
        }
    },
    methods:{
      search(){
             
        this.$axios.post('http://localhost:8099/lab/postSampleTestInfo',this.test_item_list).then(function (res){
                if(res.data.code==0){
                    alert("error")
                    return
                }
            })
      },
      logout(){

      },
      login(){
        
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
.search{
  margin-top: 15px;
}
</style>