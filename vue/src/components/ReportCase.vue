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
        <el-col :span="6" v-for="o in list" :key="o.index" :offset=1>
                <el-card :body-style="{ padding: '0px' }">
                <div style="padding: 14px;margin: auto;width: 200px;">
                    <span>{{ o.testNo }}</span>
                    <div>{{ $t('') }}
                        <span>{{ $t('consignorId') }}:{{ o.consignorId }}</span>
                        <br>
                        <sapn>{{ $t('testType') }}:{{ o.testTypeValue }}</sapn>
                        <br>
                        <el-upload
                        class="upload"
                            action="http://localhost:8080/#/reportCase"
                            multiple
                            :limit="3"
                         
                        >
                        <el-button class="m-2" size="small" type="success" round>{{ $t('upload') }}</el-button>
                        </el-upload>
                    <el-button type="text" class="button">{{ $t('print') }}</el-button>
                    </div>
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
            ]
        }
    },
    methods:{
        // handlePreview(){

        // },
        // handleRemove(file, uploadFiles){
        //     console.log(file, uploadFiles)
        // },
        // beforeRemove(){

        // },
        // handleExceed(){

        // }
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
</style>