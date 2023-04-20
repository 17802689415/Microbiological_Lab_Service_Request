<template>
  <div>
    
    <el-input type="text" :placeholder="$t('applyNo')" v-model="testNo" class="m-2" style="width: 200px;"></el-input>

    <el-input type="text" :placeholder="$t('consignorId')" v-model="consignorId" class="m-2" style="width: 200px;"></el-input>

    <el-select v-model="testTypeValue" :placeholder="$t('testType')" class="m-2" style="width: 200px;">
        <el-option
        v-for="o in testTypeList"
        :key="o.index"
        :label="o.item"
        :value="o.item"
        />
    </el-select>

    <el-button @click="toggleSelection()" class="m-2" size="small" type="success" round>{{ $t('query') }}</el-button>

  </div>
    <el-row>
        <el-col :span="5" v-for="o in list" :key="o.index" :offset=1>
                <el-card :body-style="{ padding: '0px' }" class="card">
                <div style="padding: 14px;margin: auto;width: 200px;">
                    <span>{{ o.testNo }}</span>
                    <div>
                        <span>{{ $t('consignorId') }}:{{ o.consignorId }}</span>
                        <br>
                        <span>{{ $t('testType') }}:{{ o.testTypeValue }}</span>
                        <br>
                        <el-upload
                        class="upload"
                            :action="url+o.testNo"
                            :headers="header"
                            :on-success="upload()"
                            :data="{'caseNum':o.testNo}"
                            multiple
                            :limit="1"
                         
                        >
                        <el-button class="m-2" size="small" type="success" round>{{ $t('upload') }}</el-button>
                        </el-upload>
                    </div>
                    <el-button class="m-2" size="small" type="success" round @click="download(o.testNo)">{{ $t('print') }}</el-button>
                    <el-tag type="info" v-show="isUpload(o.testNo)">{{ $t('reportInfo') }}</el-tag>
                </div>
                </el-card>
                
                
        </el-col>
    </el-row>
</template>

<script>


export default {
    name:'reportCase',
    data(){
        return{
            testNo:'',
            consignorId:'',
            testTypeValue:'',
            header:{
                Authorization:window.sessionStorage.getItem('token')
            },
            testTypeList:[
                {index:0,item:'SampleTest'},
                {index:1,item:'Purified Water Test'},
                {index:2,item:'Cleanroom Environment Test'}
            ],
            list:[
                {index:0,testNo:'123',consignorId:'3554536',testTypeValue:'sampleTest'},
                {index:1,testNo:'456',consignorId:'3554536',testTypeValue:'sampleTest'},
                {index:2,testNo:'789',consignorId:'3554536',testTypeValue:'sampleTest'},
                {index:3,testNo:'159',consignorId:'3554536',testTypeValue:'sampleTest'},
                {index:3,testNo:'159',consignorId:'3554536',testTypeValue:'sampleTest'},
                {index:3,testNo:'159',consignorId:'3554536',testTypeValue:'sampleTest'},
            ],
            url:'http://localhost:8099/lab/upload',
            caseNumList:[]
        }
    },
    created(){
        this.init()
    },
    methods:{
        init(){
            let that = this
            this.$axios.get('http://localhost:8099/lab/selectFiles').then(function (res){
                console.log(res)
                if(res.data.code==1){
                    res.data.data.forEach(element => {
                        that.caseNumList.push(element.caseNum)
                    });
                }
            })
        },
        isUpload(caseNum){
            let index = this.caseNumList.indexOf(caseNum)
            if(index==-1){
                return false
            }
            return true
        },
        upload(res){
            console.log(res)     
        },
        download(caseNum){
            console.log(caseNum)
            
            this.$axios.get('http://localhost:8099/lab/download'+caseNum).then(function (res){
                console.log(res)
                if(res.data.code==1){
                    window.open('http://localhost:8099'+res.data.data,'Report')
                }
            })
            
        },
      

    }
}
</script>

<style scoped>
.m-2{
    margin-bottom: 10px;
    margin-right: 10px;
}
.upload{
    margin-top: 10px;
}
.card{
    margin-top:5px
}
</style>