<template>
  <div style="width: 1000px; margin: auto;">
    <el-page-header @back="backHome()">
        <template #content>
        <div class="flex items-center">
            <el-avatar
            :size="32"
            class="mr-3"
            :src="require('../../assets/logo.png')"
            
            />
            <span class="username"> 用户名 </span>
        </div>
        </template>
    </el-page-header>
    <div style="margin-left:700px ;">
        <span class="item" >
        关注
        <el-tag class="span" color="cadetblue">2</el-tag>
        </span>
        <el-divider direction="vertical"></el-divider>
        <span class="item" >
        粉丝
        <el-tag class="span" color="cadetblue">2</el-tag>
        </span>
        <el-divider direction="vertical"></el-divider>
        <span class="item" >
        星级
        <el-tag class="span" color="cadetblue">2</el-tag>
        </span>
    </div>
  </div>
  <div style="width: 1000px; padding-top: 10px ; padding-bottom: 10px; margin: auto;background-color: beige;">
    <div style="width: 900px; margin: auto;background-color: aliceblue;border-radius: 4px;" >
        <el-menu
            text-color="black"
            class="el-menu-demo"
            mode="horizontal"
            :router="isRouter"
            :ellipsis="isEllipsis"
            active-text-color="black"
            background-color="white"
            
        >
            
            <el-menu-item index="awaitPay">
                <img src="../svg/063-coin-yen.svg" height="26" class="img">
         
                <span class="menuItem">待付款</span>
                
            </el-menu-item>
            <div class="flex-grow"></div>
            <el-menu-item index="trackInformation"><img src="../svg/177-truck.svg" height="26" class="img"><span class="menuItem">物流信息</span></el-menu-item>
            <div class="flex-grow"></div>
            <el-menu-item index="shopCar"><img src="../svg/079-clock.svg" height="26" class="img"><span class="menuItem">历史订单</span></el-menu-item>
            <div class="flex-grow"></div>
            <el-menu-item index="4"><img src="../svg/035-file-text.svg" height="26" class="img"><span class="menuItem">待评价</span></el-menu-item>
            
        </el-menu>
    </div>
    <div style="width: 900px; margin: auto;background-color: aliceblue;border-radius: 4px;padding-top:20px ;padding-bottom: 20px;">
        <router-view></router-view>
    </div>
  </div>

</template>

<script>
export default {
    name:'userPage',
    data(){
        return{
            isEllipsis:false,
            isRouter:true
        }
    },
    methods:{
        backHome(){
            this.$router.push('myMain')
        }
    }

}
</script>

<style scoped>
.username{
    font-size: large;
    font-weight: 700;
}
.item{
    font-size: 12px;
}
.span{
    font-size: 10px;
    color: black;
    
}

.el-menu-item.is-active{
    background-color: white !important;
}
.el-menu-item:hover{
    background-color: white !important;
    font-size: large;
    font-weight: 500;
}
.flex-grow {
  flex-grow: 1;
}
.img{
    margin-top: 10px;
    margin-bottom: 10px;
}
.menuItem{
    margin-left: 10px;
    font-size: medium;
    font-weight: 600;
}
</style>