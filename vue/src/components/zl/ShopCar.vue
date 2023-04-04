<template>
<div style="width: 800px;margin: auto;">
<span style="font-size: large;font-weight: 700;">购物车</span>
<!-- 购物车总数量 -->
<el-tag type="success"><span style="color: coral;">{{ tableData.length }}</span></el-tag>   
<!-- 结算按钮 -->
<btnFour style="float:right;"></btnFour>  
<!-- 结算总金额 -->
<span style="float:right;margin-right:50px ;font-size: large;font-weight: 700;">合计:<b style="color: darkorange;">￥{{ totalCount }}</b></span>  
</div>


  <div style="width: 800px;margin: auto;" class="des">
    <el-descriptions v-for="item in tableData" :key="item.shopName" :title="item.shopName" :column="2" class="box">
        <template #extra>
            <!-- 复选框 -->
        <checkboxThree :index="item.index" @child-arr="getArr()"></checkboxThree>
        </template>
        <el-descriptions-item><img :src="item.img"></el-descriptions-item>
        <el-descriptions-item>
            <span style="font-size: 20px;font-weight: 700;" class="item">{{ item.goodsName }}</span><br>
            <span style="color: darkorange;" class="item">{{ item.price }}</span><br>
        
            <el-input-number v-model="item.quantity" :min="0" @change="handleChange" style="width: 100px;height: 30px;" class="item"/><br>
            <btnFive class="item"></btnFive>
        </el-descriptions-item>
    </el-descriptions>
  </div>
</template>

<script>
import checkboxThree from './CheckboxVue03.vue'
import btnFour from './BtnVue04.vue'
import btnFive from './BtnVue05.vue'

export default {
    name:'shopCar',
    components:{
        checkboxThree,
        btnFour,
        btnFive
    },
    data(){
        return{
            tableData:[
                {index:0,shopName:'zzz',img:require('../../assets/goods1.png'),goodsName:'xxxxxxxxxxxxxxxxxx',price:200,quantity:1},
                {index:1,shopName:'zzz',img:require('../../assets/goods1.png'),goodsName:'xxxxxxxxxxxxxxxxxx',price:200,quantity:1},
            ],
            totalCount:0,
            arr:{}
        }
    },
    methods:{
        handleChange(val){
            console.log(val)
        },
        getArr(array){
            this.arr=array
            console.log('父组件中arr')
            console.log(this.arr)
            // if(this.arr.length!=0){
            //     this.totalCount++
            // }
            // if(this.arr.length==0){
            //     this.totalCount--
            // }
        },
    }

}
</script>

<style scoped>

.box{
    box-shadow:0 0 80px 10px bisque;
    margin-top: 20px;
    padding: 10px;

}
.item{
    margin-top:10px ;
}
</style>