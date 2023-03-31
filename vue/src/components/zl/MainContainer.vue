

       

<template>
    <div id="menu">
        <el-menu
            text-color="black"
            class="el-menu-demo"
            mode="horizontal"
            :router="isRouter"
            :ellipsis="isEllipsis"
            active-text-color="black"
            background-color="white"
            @select="handleSelect"
        >
            <el-menu-item>
                <el-sub-menu index="1">
                    <template #title>
                        <span class="it">热门推荐</span>
                    </template>
                    <div>
                        <dl>
                            <el-row>
                                <el-col :span="8" >
                                    <dd><el-menu-item index="手机严选"><img src="../../assets/logo02.png" height="30"><span class="submenu-span">手机严选</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="闲置房屋"><img src="../../assets/logo03.png" height="30"><span class="submenu-span">闲置房屋</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="卡劵回收"><img src="../../assets/logo04.png" height="30"><span class="submenu-span">卡劵回收</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="二手车"><img src="../../assets/logo01.png" height="30"><span class="submenu-span">二手车</span></el-menu-item></dd><br>
                                </el-col>
                                <el-col :span="8" >
                                    <dd><el-menu-item><img src="../../assets/logo02.png" height="30"><span class="submenu-span">手机严选</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo03.png" height="30"><span class="submenu-span">闲置房屋</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo04.png" height="30"><span class="submenu-span">卡劵回收</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo01.png" height="30"><span class="submenu-span">二手车</span></el-menu-item></dd><br>
                                </el-col>
                            </el-row>
                        </dl>
                    </div>
                </el-sub-menu>
            </el-menu-item>  
            <el-menu-item >
                <el-sub-menu index="2">
                    <template #title>
                        <span class="it">美容彩妆</span>
                    </template>
                    <div>
                        <dl>
                            <el-row>
                                <el-col :span="8" >
                                    <dd><el-menu-item index="手机严选"><img src="../../assets/logo02.png" height="30"><span class="submenu-span">手机严选</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="闲置房屋"><img src="../../assets/logo03.png" height="30"><span class="submenu-span">闲置房屋</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="卡劵回收"><img src="../../assets/logo04.png" height="30"><span class="submenu-span">卡劵回收</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="二手车"><img src="../../assets/logo01.png" height="30"><span class="submenu-span">二手车</span></el-menu-item></dd><br>
                                </el-col>
                                <el-col :span="8" >
                                    <dd><el-menu-item><img src="../../assets/logo02.png" height="30"><span class="submenu-span">手机严选</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo03.png" height="30"><span class="submenu-span">闲置房屋</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo04.png" height="30"><span class="submenu-span">卡劵回收</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo01.png" height="30"><span class="submenu-span">二手车</span></el-menu-item></dd><br>
                                </el-col>
                            </el-row>
                        </dl>
                    </div>
                </el-sub-menu>
            </el-menu-item>  
            <el-menu-item>
                <el-sub-menu  index="3">
                    <template #title>
                        <span class="it">家具生活</span>
                    </template>
                    <div>
                        <dl>
                            <el-row>
                                <el-col :span="8" >
                                    <dd><el-menu-item index="手机严选"><img src="../../assets/logo02.png" height="30"><span class="submenu-span">手机严选</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="闲置房屋"><img src="../../assets/logo03.png" height="30"><span class="submenu-span">闲置房屋</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="卡劵回收"><img src="../../assets/logo04.png" height="30"><span class="submenu-span">卡劵回收</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="二手车"><img src="../../assets/logo01.png" height="30"><span class="submenu-span">二手车</span></el-menu-item></dd><br>
                                </el-col>
                                <el-col :span="8" >
                                    <dd><el-menu-item><img src="../../assets/logo02.png" height="30"><span class="submenu-span">手机严选</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo03.png" height="30"><span class="submenu-span">闲置房屋</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo04.png" height="30"><span class="submenu-span">卡劵回收</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo01.png" height="30"><span class="submenu-span">二手车</span></el-menu-item></dd><br>
                                </el-col>
                            </el-row>
                        </dl>
                    </div>
                </el-sub-menu>
            </el-menu-item>  
            <el-menu-item >
                <el-sub-menu index="4">
                    <template #title>
                        <span class="it">技能服务</span>
                    </template>
                    <div>
                        <dl>
                            <el-row>
                                <el-col :span="8" >
                                    <dd><el-menu-item index="手机严选"><img src="../../assets/logo02.png" height="30"><span class="submenu-span">手机严选</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="闲置房屋"><img src="../../assets/logo03.png" height="30"><span class="submenu-span">闲置房屋</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="卡劵回收"><img src="../../assets/logo04.png" height="30"><span class="submenu-span">卡劵回收</span></el-menu-item></dd><br>
                                    <dd><el-menu-item index="二手车"><img src="../../assets/logo01.png" height="30"><span class="submenu-span">二手车</span></el-menu-item></dd><br>
                                </el-col>
                                <el-col :span="8" >
                                    <dd><el-menu-item><img src="../../assets/logo02.png" height="30"><span class="submenu-span">手机严选</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo03.png" height="30"><span class="submenu-span">闲置房屋</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo04.png" height="30"><span class="submenu-span">卡劵回收</span></el-menu-item></dd><br>
                                    <dd><el-menu-item><img src="../../assets/logo01.png" height="30"><span class="submenu-span">二手车</span></el-menu-item></dd><br>
                                </el-col>
                            </el-row>
                        </dl>
                    </div>
                </el-sub-menu>
            </el-menu-item>
            <el-menu-item index="5">
                <span class="it">全部分类</span>
            </el-menu-item>    
        </el-menu>
    </div>
    <el-carousel :interval="4000"  height="300px" style="width: 80%;margin: auto;">
        <el-carousel-item v-for="item in imagebox" :key="item.id">
            <img :src="item.idView" class="image" style="width: 100%;">
        </el-carousel-item>
    </el-carousel>
    <el-tabs v-model="activeName" class="demo-tabs" :stretch="isStretch" @tab-click="handleClick" style="width: 80%;margin: auto;">
        <el-tab-pane label="每日推荐" name="first">
            <img src="../../assets/p2.png" style="width: 100%;margin: auto;height: 100px;">
        </el-tab-pane>
        <el-tab-pane label="折扣区" name="second">
            <img src="../../assets/p1.png" style="width: 100%;margin: auto;height: 100px;">
        </el-tab-pane>
        <el-tab-pane label="品牌闲置" name="third">
            <img src="../../assets/p2.png" style="width: 100%;margin: auto;height: 100px;">
        </el-tab-pane>
        <el-tab-pane label="闲置时间" name="fourth">
            <img src="../../assets/p1.png" style="width: 100%;margin: auto;height: 100px;">
            <!-- <el-image style="width: 100%; height: 200px;margin: auto;" src="../../assets/p1.png" :fit="fit" /> -->
        </el-tab-pane>
    </el-tabs>
    <div class="h3">
        <h3>好物排行榜</h3>
    </div>
    
    <el-row class="row" justify="center">
        <el-col
        v-for="item in goodsList"
        :key="item"
        :span="3"
        :offset="item.id> 0 ? 1 : 0"
        >
        <el-card :body-style="{ padding: '0px' }">
            <el-tag
            class="mx-1"
            effect="dark"
            :type="item.info"
            >
            {{ item.id+1 }}
            </el-tag>
            <img
            :src="item.idView"
            class="image"
            />
            <div style="padding: 14px">
            <span>Yummy hamburger</span>
            <div class="bottom">
                <time class="time">${{ currentDate }}</time>
                <el-button text class="button">查看详情</el-button>
            </div>
            </div>
        </el-card>
        </el-col>
    </el-row>

    <div class="h3">
        <h3>商家排行榜</h3>
    </div>
    <el-row class="row" justify="center">
        <el-col
        v-for="item in mallList"
        :key="item"
        :span="3"
        :offset="item.id> 0 ? 1 : 0"
        >
        <el-card :body-style="{ padding: '0px' }">
            <el-tag
            class="mx-1"
            effect="dark"
            :type="item.info"
            >
            {{ item.id+1 }}
            </el-tag>
            <img
            :src="item.idView"
            class="image"
            />
            <div style="padding: 14px">
            <span>Yummy hamburger</span>
            <div class="bottom">
                <time class="time">${{ currentDate }}</time>
                <el-button text class="button">查看详情</el-button>
            </div>
            </div>
        </el-card>
        </el-col>
    </el-row>


</template>
  


<script>
export default {
    name:'myMain',
    data(){
        return{
            isRouter:false,
            isEllipsis:false,
            imagebox: [
                {id: 0, idView: require('../../icons/p1.jpg')},
                {id: 1, idView: require('../../icons/p2.jpg')},
                {id: 2, idView: require('../../icons/p3.jpg')},
                {id: 3, idView: require('../../icons/p4.jpg')},
            ],
            isStretch:true,
            fit:'cover',
            currentDate:'2023',
            activeName:'first',
            goodsList: [
                {id: 0, idView: require('../../assets/goods1.png'),info:'danger'},
                {id: 1, idView: require('../../assets/goods2.png'),info:'success'},
                {id: 2, idView: require('../../assets/goods3.png'),info:'warning'},
                {id: 3, idView: require('../../assets/goods4.png'),info:''},
                {id: 4, idView: require('../../assets/goods5.png'),info:'info'},
            ],
            mallList:[
                {id: 0, idView: require('../../assets/mall01.jpg'),info:'danger'},
                {id: 1, idView: require('../../assets/mall02.jpg'),info:'success'},
                {id: 2, idView: require('../../assets/mall03.jpg'),info:'warning'},
                {id: 3, idView: require('../../assets/mall04.jpg'),info:''},
                {id: 4, idView: require('../../assets/mall04.jpg'),info:'info'},
            ]
        }
    },
    methods:{
        handleSelect(index){
            console.log(index)
        },
        handleClick(){

        }
    }
}
</script>

<style scoped>
@import '../css/btn01.css';
.submenu-span{
    font-weight: 700;
    font-size: small;
    margin-left:10px ;
    margin-right: 10px;
    
}
.submenu-span:hover{
    color: rgb(16, 231, 159);
}
.it{
    text-shadow: 3px 3px 4px #bdcee0;
    font-weight: 600;
    text-indent: 2rem;
}
#menu{
    width: 80%;
    margin: auto;
}
.el-menu-item.is-active{
    background-color: white !important;
}
.el-menu-item:hover{
    background-color: white !important;
    font-size: large;
    font-weight: 500;
}
.image {
  width: 100%;
  height: 100%;
  object-fit: contain;
  display: block;
}
.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.row{
    width: 80%;
    margin: auto;
}
.h3{
    width: 100px;
    margin: auto;
}
</style>