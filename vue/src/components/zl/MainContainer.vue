

       

<template>
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
</template>
  


<script>
export default {
    name:'myMain',
    data(){
        return{
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
        }
    },
}
</script>

<style scoped>
.image {
  width: 100%;
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