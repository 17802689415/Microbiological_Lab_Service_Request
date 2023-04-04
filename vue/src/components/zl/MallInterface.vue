<template>
  <div>
    <el-collapse>
            <el-collapse-item title="类型" name="1">
                <div>
                    <el-tag class="ml-2" type="info" v-for="item in usernameData" :key="item.username" @click="handleSelectUsername(item.username)">{{ item.username }}</el-tag>
                </div>
            </el-collapse-item>
            <el-collapse-item title="地区" name="2">
                <div>
                    <el-tag class="ml-2" type="info" v-for="item in locationData" :key="item.location" @click="handleSelectLocation(item.location)">{{ item.location }}</el-tag>
                </div>
            </el-collapse-item>
            <el-collapse-item title="价格" name="3">
                <div>
                    <el-form ref="form" :model="form" label-width="80px">
                        <el-row>
                            <el-col :span="5">
                                <el-form-item label="最低价格">
                                    <el-input v-model="form.minPrice"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="5">
                                <el-form-item label="最高价格">
                                    <el-input v-model="form.maxPrice"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-form>
                </div>
            </el-collapse-item>
        </el-collapse>
  </div>
  <div>
    <el-row class="row" justify="center">
        <el-col
        v-for="item in cardList"
        :key="item.index"
        :span="3"
        :offset="1"
        >
        <div class="card" @click="viewDetail(item.index)">
        <div class="card-img">
            <img
            :src="item.imgUrl"
            class="image"
            
            />
        </div>
        <div class="card-info">
            <p class="text-title">{{ item.goodsName }} <el-tag class="ml-2" type="warning">{{ item.type }}</el-tag><el-tag class="ml-2" type="warning">{{ item.despatch }}</el-tag> </p>
            <p class="text-body">{{ item.goodsDescription }}</p>
        </div>
        <div class="card-footer">
        <span class="text-price">${{ item.price }}</span>
        <div class="card-button">
            <svg class="svg-icon" viewBox="0 0 20 20">
            <path d="M17.72,5.011H8.026c-0.271,0-0.49,0.219-0.49,0.489c0,0.271,0.219,0.489,0.49,0.489h8.962l-1.979,4.773H6.763L4.935,5.343C4.926,5.316,4.897,5.309,4.884,5.286c-0.011-0.024,0-0.051-0.017-0.074C4.833,5.166,4.025,4.081,2.33,3.908C2.068,3.883,1.822,4.075,1.795,4.344C1.767,4.612,1.962,4.853,2.231,4.88c1.143,0.118,1.703,0.738,1.808,0.866l1.91,5.661c0.066,0.199,0.252,0.333,0.463,0.333h8.924c0.116,0,0.22-0.053,0.308-0.128c0.027-0.023,0.042-0.048,0.063-0.076c0.026-0.034,0.063-0.058,0.08-0.099l2.384-5.75c0.062-0.151,0.046-0.323-0.045-0.458C18.036,5.092,17.883,5.011,17.72,5.011z"></path>
            <path d="M8.251,12.386c-1.023,0-1.856,0.834-1.856,1.856s0.833,1.853,1.856,1.853c1.021,0,1.853-0.83,1.853-1.853S9.273,12.386,8.251,12.386z M8.251,15.116c-0.484,0-0.877-0.393-0.877-0.874c0-0.484,0.394-0.878,0.877-0.878c0.482,0,0.875,0.394,0.875,0.878C9.126,14.724,8.733,15.116,8.251,15.116z"></path>
            <path d="M13.972,12.386c-1.022,0-1.855,0.834-1.855,1.856s0.833,1.853,1.855,1.853s1.854-0.83,1.854-1.853S14.994,12.386,13.972,12.386z M13.972,15.116c-0.484,0-0.878-0.393-0.878-0.874c0-0.484,0.394-0.878,0.878-0.878c0.482,0,0.875,0.394,0.875,0.878C14.847,14.724,14.454,15.116,13.972,15.116z"></path>
            </svg>
        </div>
        </div>
        </div>
        </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
    name:'mainMall',
    data(){
        return{
            usernameData:[
                {username:'美容彩妆'}
            ],
            locationData:[
                {location:'上海'}
            ],
            form:{
                minPrice:0,
                maxPrice:0
            },
            usernameValue:'',
            locationValue:'',
            cardList:[
                {index:0,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
                {index:1,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
                {index:2,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
                {index:3,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
                {index:4,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
                {index:5,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
                {index:6,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
                {index:7,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
                {index:8,type:'美容彩妆',goodsName:'面膜',goodsDescription:'用剩一包面膜',attritionRate:'九成新',price:200,imgUrl:require('../../assets/goods1.png'),uploadTime:'2023-03-13',despatch:'包邮'},
            ]
        }
    },
    methods:{
        handleSelectUsername(username){
            this.usernameValue=username
            console.log(this.usernameValue)
        },
        handleSelectLocation(location){
            this.locationValue=location
            console.log(this.locationValue)
        },
        viewDetail(index){
            console.log(index)
        }
    }

}
</script>

<style scoped>
@import '../css/card01.css';
.image {
  width: 100%;
  display: block;
}
/* .bottom {
  margin-top: 13px;
  justify-content: space-between;
  align-items: center;
}
.description{
    font-size: smaller;
    color: cadetblue;
} */
.name{
    font-weight: 700;
}
.price{
    color: coral;
}
.view{
    color: blue;
}
.button{
    margin-left: 10px;
}
</style>