<template>

  <el-card class="box-card">
    <div class="clearfix">
    <b>{{ $t('urgentItem') }}</b>
  </div>
    <div v-for="o in urgentList" :key="o.id" class="text item">
      <span>{{ $t('item') }}---<el-tag class="tag">{{ o.caseNum }} / {{ o.testType }} / {{ o.applyDate }}</el-tag></span>
    </div>
  </el-card>

  <el-scrollbar height="600px">
  <el-divider content-position="right">{{ $t('testList') }}</el-divider>
  <div class="block">
    <el-timeline>
      <el-timeline-item v-for="o in waitList" :key="o.id" :timestamp="o.beginDate" placement="top">
        <el-card>
          <h4>{{ $t('inspector') }}:{{ o.jobId }}</h4>
          <p>{{ $t('testType') }}:{{ o.testType }}</p>
          <p>{{ $t('applyNo') }}:{{ o.caseNum }}</p>
          <p>{{ $t('item') }}:
            <el-tag v-for="o in itemList" :key="o.id">{{ o.testItem }}</el-tag>
          </p>
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
            urgentList:[],
            waitList:[],
            itemList:[]
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
                   
                }
            })
        this.$axios.post('http://localhost:8099/lab/selectWaitCase').then(function (res){
            if(res.data.code==1){
                that.waitList = res.data.data;
                that.waitList.forEach(item => {
                  let formData = new FormData()
                  formData.append('caseNum',item.caseNum)

                  that.$axios.post('http://localhost:8099/lab/selectSampleTestInfo',formData).then(function (res){
                    that.itemList=res.data.data
                    console.log(res)
                  })
                });
                console.log(res)
            }
        })

      }
    }
}
</script>

<style scoped>
.tag{
  margin-top: 5px ;
}
</style>