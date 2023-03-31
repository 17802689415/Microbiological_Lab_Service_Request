

<template>
  <div>
    <el-carousel :interval="4000" style="width: 500px;height=200px;float: left;" arrow="always" indicator-position="none" @change="changeCampus">
        <el-carousel-item v-for="item in imgList" :key="item">
        <!-- <img :src="item.url" class="img" @click="viewBigImg"> -->
        <!-- <el-image 
            style="width: 100%; height: 100%"
            :src="item.url" 
            fit="contain"
            class="img"
            @click="showImg"
            >
        </el-image> -->
        <el-image :preview-src-list="list" :class="current===item.index ? 'campus-active': 'campus' " :src="item.url" style="position:absolute;top:0;bottom:0;left:0;right:0;width:100%;margin:auto;" fit="contain" :append-to-body="true"></el-image>
        </el-carousel-item>
    </el-carousel>

  </div>
</template>

<script>
export default {
    name:'goodsDetail',
    data(){
        return{
            imgList:[
                {index:0,url:require('../../assets/goods1.png')},
                {index:1,url:require('../../assets/goods2.png')},
                {index:2,url:require('../../assets/goods3.png')},
                {index:3,url:require('../../assets/goods4.png')},
                {index:4,url:require('../../assets/goods5.png')},
            ],
            list:[
            require('../../assets/goods1.png'),
            require('../../assets/goods2.png'),
            require('../../assets/goods3.png'),
            require('../../assets/goods4.png'),
            require('../../assets/goods5.png')
            ],
            current:0
            // show:false
        }
    },
    methods: {
        changeCampus(val){
            this.current=val
        }
  }
}
</script>

<style scoped>
.campus{
    opacity: 0;
}
.campus-active{
    opacity: 1;
}

</style>