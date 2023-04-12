<template>

  <el-card class="box-card">
    <div class="clearfix">
    <b>{{ $t('urgentItem') }}</b>
  </div>
    <div v-for="o in urgentList" :key="o.index" class="text item">
      <span>{{ $t('item') }}---{{ o.item }}</span>
    </div>
  </el-card>

  <el-scrollbar height="600px">
  <el-divider content-position="right">{{ $t('testList') }}</el-divider>
  <div class="block">
    <el-timeline>
      <el-timeline-item v-for="o in waitList" :key="o.index" :timestamp="o.date" placement="top">
        <el-card>
          <h4>{{ $t('inspector') }}:{{ o.user }}</h4>
          <p>{{ $t('item') }}:{{ o.item }}</p>
          <p>{{ $t('rtbd') }}</p>
        </el-card>
      </el-timeline-item>
    </el-timeline>
  </div>
</el-scrollbar>

</template>

<script>
export default {
    name:'mainView',
    data(){
      return{
            urgentList:[{index:0,item:'test01'},{index:1,item:'test02'}],
            waitList:[{index:0,date:'2023 3 1',user:'zl',item:'test01'},{index:1,date:'2023 3 5',user:'zl',item:'test01'},{index:2,date:'2023 3 10',user:'zl',item:'test01'},
            {index:3,date:'2023 3 12',user:'zl',item:'test01'},{index:4,date:'2023 3 15',user:'zl',item:'test01'},{index:5,date:'2023 3 19',user:'zl',item:'test01'}
          ]
      }
    },
    created(){
      // this.init()
    },
    methods:{
      // init(){
      //   let that = this
      //   this.$axios.post('http://localhost:8099/lab/selectUrgentCase').then(function (res){
      //           if(res.data.code==1){
      //               that.urgentList = res.data.data;
      //               console.log(res)
      //               for (let i = 0; i <= res.data.data.length; i++) {
      //                 that.data.push({
      //                   key: i,
      //                   label: res.data.data[i].testItem,
      //                 });
      //               }
      //           }
      //       })
      // },
    }

}
</script>

<style>

</style>