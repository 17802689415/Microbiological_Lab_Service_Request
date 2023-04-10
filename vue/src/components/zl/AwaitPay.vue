<template>
   <div class="book">
    
    <div class="des">
        <el-descriptions v-for="item in tableData" :key="item.shopName" :title="item.shopName" :column="2" class="box" size="small">
            <el-descriptions-item><img :src="item.img" height="30"></el-descriptions-item>
            <el-descriptions-item>
                <span style="font-size: 20px;font-weight: 700;" class="item">{{ item.goodsName }}</span><br>
                <span style="color: darkorange;" class="item">{{ item.price }}</span><br>
                <btnFive class="item"></btnFive>
            </el-descriptions-item>
        </el-descriptions>
        <div style="float:right;">
            <btnSeven></btnSeven>
        </div>
    </div>
    
    
    <div class="cover">
        <p>去付款</p>
    </div>
   </div>
</template>

<script>
import btnFive from './BtnVue05.vue'
import btnSeven from './BtnVue07.vue'
export default {
    name:'awaitPay',
    components:{
        btnSeven,
        btnFive,
    },
    data(){
        return{
            tableData:[
                {index:0,shopName:'zzz',img:require('../../assets/goods1.png'),goodsName:'xxxxxxx',price:200,quantity:1},
                {index:1,shopName:'zzz',img:require('../../assets/goods1.png'),goodsName:'xxxxxxx',price:200,quantity:1},
            ],
        }
    }

}
</script>

<style scoped>
.des{
    background-color: cadetblue;
}
.box{
    background-color: cadetblue;
    width: 300px;
    margin-top: 10px;
    margin-bottom: 10px ;
    padding: 10px;
}
.book {
  /* position: relative; */
  border-radius: 10px;
  margin: auto;
  width: 400px;
  height: 500px;
  color: lightblue;
  background-color: lightblue;
  -webkit-box-shadow: 1px 1px 12px lightblue;
  box-shadow: 1px 1px 12px lightblue;
  -webkit-transform: preserve-3d;
  -ms-transform: preserve-3d;
  transform: preserve-3d;
  -webkit-perspective: 2000px;
  perspective: 2000px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  color: #000;
}

.cover {
  top: 0;
  position: absolute;
  background-color: lightblue;
  width: 100%;
  height: 100%;
  border-radius: 10px;
  cursor: pointer;
  -webkit-transition: all 0.5s;
  transition: all 0.5s;
  -webkit-transform-origin: 0;
  -ms-transform-origin: 0;
  transform-origin: 0;
  -webkit-box-shadow: 1px 1px 12px lightblue;
  box-shadow: 1px 1px 12px lightblue;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
}

.book:hover .cover {
  -webkit-transition: all 0.5s;
  transition: all 0.5s;
  -webkit-transform: rotatey(-80deg);
  -ms-transform: rotatey(-80deg);
  transform: rotatey(-80deg);
}

p {
  font-size: 20px;
  font-weight: bolder;
}
</style>