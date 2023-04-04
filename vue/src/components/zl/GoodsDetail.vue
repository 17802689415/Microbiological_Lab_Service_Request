

<template>

        <div>
            <el-image-viewer v-if="isShow" @close="closeImgViewer"
            :url-list="list"></el-image-viewer>
            <el-carousel :interval="4000" style="width: 800px;height=200px;" arrow="always" indicator-position="none">
                <el-carousel-item v-for="item in imgList" :key="item">
                <!-- <img :src="item.url" class="img" @click="viewBigImg"> -->
                
                    <el-image 
                        style="width: 100%; height: 100%"
                        :src="item.url" 
                        fit="contain"
                        class="img"
                        @click="showImgViewer()"
                        >
                    </el-image>
                
                
                <!-- <el-image :preview-src-list="list" :class="current===item.index ? 'campus-active': 'campus' " :src="item.url" style="position:absolute;top:0;bottom:0;left:0;right:0;width:100%;margin:auto;" fit="contain" :append-to-body="true"></el-image> -->
                </el-carousel-item>
            </el-carousel>
        </div>
  
        <div id="detail">
            <el-avatar  :size="60" fit="fill" :src="img"></el-avatar>
            <span class="spanName">****</span>
            <el-tag type="warning">上海松江</el-tag><br>
            <span class="spanItem" id="goods">机器人</span>
            <el-divider direction="vertical"></el-divider>
            <span class="spanItem" id="price">￥200</span>
            <el-divider direction="vertical"></el-divider>
            <span class="spanItem" id="want">想要</span>
            <checkBox class="checkBox"></checkBox><br>
            <el-tag type="warning" class="tag"><span class="item01">卖出209</span><span class="item02">发布过290</span></el-tag>
            <el-tag type="warning" class="tag"><span class="item01">好评79</span><span class="item02">总评价100</span></el-tag>
            <el-tag type="warning" class="tag"><span class="item01">回复率94%</span><span class="item02">平均44分钟回复</span></el-tag>
            <btnOne class="btnOne"></btnOne>
        </div>
        <el-divider><span>描述</span></el-divider>
        <div style="width: 800px;margin: auto;">
            
            <checkboxTwo></checkboxTwo>
            <p class="description">描述</p>
        </div>
        <el-divider><span>留言区</span></el-divider>
        <div style="width: 800px;margin: auto;">
            <el-row>
                <el-col :span="16"><el-input type="textarea" class="input"></el-input></el-col>
                <el-col :span="8"><btnTwo class="btnTwo"></btnTwo></el-col>
            </el-row>
        </div>
        <div style="width: 800px;margin: auto;">
            <el-descriptions class="margin-top" v-for="item in remark" :key="item.username" :title="item.username" :column="2" >
                <template #extra>
                <btnThree class="btnThree"></btnThree>
                </template>
                <el-descriptions-item><el-tag type="warning">{{ item.addr }}</el-tag></el-descriptions-item>
                <el-descriptions-item><el-tag type="warning">{{ item.sendDate }}</el-tag></el-descriptions-item>
                <el-descriptions-item>{{ item.text }}</el-descriptions-item>
                <el-descriptions-item><el-divider></el-divider></el-descriptions-item>
            </el-descriptions>
            
        </div>
        
        
        
  


</template>

<script>
// import Viewer from 'viewerjs';
import btnOne from './BtnVue01.vue'
import btnTwo from './BtnVue02.vue'
import btnThree from './BtnVue03.vue'
import checkBox from './CheckboxVue01.vue'
import checkboxTwo from './CheckboxVue02.vue'
export default {
    name: "goodsDetail",
    components:{
        btnOne,
        btnTwo,
        btnThree,
        checkBox,
        checkboxTwo
    },
    data() {
        return {
            imgList: [
                { index: 0, url: require("../../assets/goods1.png") },
                { index: 1, url: require("../../assets/goods2.png") },
                { index: 2, url: require("../../assets/goods3.png") },
                { index: 3, url: require("../../assets/goods4.png") },
                { index: 4, url: require("../../assets/goods5.png") },
            ],
            list: [
                require("../../assets/goods1.png"),
                require("../../assets/goods2.png"),
                require("../../assets/goods3.png"),
                require("../../assets/goods4.png"),
                require("../../assets/goods5.png")
            ],
            remark:[
                {
                    username:'zzzz',
                    addr:'湖北',
                    sendDate:'2023-03-29',
                    text:'亲，宝贝还在吗？'
                },
                {
                    username:'zzzz',
                    addr:'湖北',
                    sendDate:'2023-03-29',
                    text:'亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？亲，宝贝还在吗？'
                },
                {
                    username:'zzzz',
                    addr:'湖北',
                    sendDate:'2023-03-29',
                    text:'亲，宝贝还在吗？'
                }
            ],
            isShow:false,
            img:require('../../assets/logo.png'),
            value:0
        };
    },
    methods: {
        showImgViewer(){
            this.isShow = true;
            const m = (e) => { e.preventDefault() };
            document.body.style.overflow = 'hidden';
            document.addEventListener("touchmove", m, false); // 禁止页面滑动

            },
        closeImgViewer(){
            this.isShow = false;
            const m = (e) => { e.preventDefault() };
            document.body.style.overflow = 'auto';
            document.removeEventListener("touchmove", m, true);
            },
        errorHandler() {
        return true
      }
    },
 
}
</script>

<style scoped>
div{
    margin: auto;
}
#detail{
    width: 500px;
    height: 150px;
}
.btnOne{
    float: right;
    
}
.spanName{
    margin-left: 10px;
    margin-right: 10px;
}
.spanItem{
    margin-left: 10px;
    margin-right: 10px;
}
#goods{
    font-size: large;
    font-weight: 700;
}
#price{
    color: coral;
}
#want{
    font-size: smaller;
    opacity: 0.5;
}
.item02{
    font-size: smaller;
    font-weight: 700;
    color: cadetblue;
}
.tag{
    margin-top:15px;
}
.inputOne{
    margin-top: 20px;
}
.input{
    margin-top: 20px;
}
.btnTwo{
    margin-top: 13px;
    
}
.description{
    margin-top: 30px;
    margin-bottom: 30px;
}
.checkBox{
    margin-left: 50px;
}
</style>