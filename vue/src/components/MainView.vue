<template>
  <el-row>
    <el-col :span="10">
    <el-scrollbar>
      <el-table
        :header-cell-style="{
            backgroundColor:'#06426e',
            color:'#fff',
            'text-align':'center'
        }"
        :cell-style="{
            backgroundColor:'#06426e',
            color:'#fff',
            textAlign:'center'
        }"
            :border="isBorder"
            :data="urgentList"
            style="width: 100%;">
            <el-table-column
            prop="testItem"
            label="加急项目"
            >
            </el-table-column>
            <el-table-column
            fixed="right"
            prop="action"
            label="操作"
            >
            <template #default="scope"> 
                <el-button type="warning" size="small" @click="action(scope.row)"><el-icon><Tools /></el-icon>操作</el-button>
            </template>
            </el-table-column>
      </el-table>
    </el-scrollbar>
    </el-col>
    <el-col :span="4"></el-col>
    <el-col :span="10">
      <el-scrollbar>
      <el-table
        :header-cell-style="{
            backgroundColor:'#06426e',
            color:'#fff',
            'text-align':'center'
        }"
        :cell-style="{
            backgroundColor:'#06426e',
            color:'#fff',
            textAlign:'center'
        }"
            :border="isBorder"
            :data="testList"
            style="width: 100%;">
            <el-table-column
            prop="testItem"
            label="待测项目"
            >
            </el-table-column>
            <el-table-column
            fixed="right"
            prop="action"
            label="操作"
            >
            <template #default="scope"> 
                <el-button type="warning" size="small" @click="action(scope.row)"><el-icon><Tools /></el-icon>操作</el-button>
            </template>
            </el-table-column>
      </el-table>
    </el-scrollbar>
    </el-col>
  </el-row>


  <el-transfer
    v-model="value"
    :data="data"
    target-order="push"
    :titles="titles">
  </el-transfer>

</template>

<script>
export default {
    name:'mainView',
    data(){
      return{
            isBorder:true,
            urgentList:[
               
            ],
            testList:[

            ],
            value: [],
            data:[],
            titles:['任务','待测队列']
      }
    },
    created(){
      this.init()
    },
    methods:{
      init(){
        let that = this
        this.$axios.post('http://localhost:8099/lab/selectUrgentCase').then(function (res){
                if(res.data.code==1){
                    that.urgentList = res.data.data;
                    console.log(res)
                    for (let i = 0; i <= res.data.data.length; i++) {
                      that.data.push({
                        key: i,
                        label: res.data.data[i].testItem,
                      });
                    }
                }
            })
      },
    }

}
</script>

<style>

</style>