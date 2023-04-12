<template>
    <div id="menu">
        <el-menu class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="SampleTest">{{ $t('sampleTest') }}</el-menu-item>
            <el-menu-item index="Purified Water Test">{{ $t('waterTest') }} </el-menu-item>
            <el-menu-item index="Cleanroom Environment Test">{{ $t('cleanroomTest') }}</el-menu-item>
        </el-menu>
    </div>
    <div class="form">
    <div id="consignor">
        <h6>{{ $t('applyNo') }}:  {{ applyNo }}</h6>
        <h4>{{ $t('consignorInformation') }}</h4>
        <el-form :model="consignor_info" label-width="150px" class="demo-ruleForm" size="small">
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('consignorId')" prop="consignorId">
                        <el-input v-model="consignor_info.consignorId" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item :label="$t('phoneNum')" prop="phoneNum">
                        <el-input v-model="consignor_info.phoneNum" class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('workCell')" prop="workCell">
                        <el-input v-model="consignor_info.workCell" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item :label="$t('department')" prop="department">
                        <el-input v-model="consignor_info.department" class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('applyDate')" prop="applyDate" :inline-message="isInLine">
                        <el-date-picker
                            v-model="consignor_info.applyDate"
                            type="date"
                            :placeholder="$t('date')"
                            value-format="YYYY-MM-DD">
                        </el-date-picker>
                    </el-form-item>    
                </el-col>
                <el-col :span="6">
                    <el-form-item :label="$t('sendDate')" prop="sendDate" :inline-message="isInLine">
                        <el-date-picker
                            v-model="consignor_info.sendDate"
                            type="date"
                            :placeholder="$t('date')"
                            value-format="YYYY-MM-DD">
                        </el-date-picker>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item :label="$t('urgent')" prop="urgent">
                <el-switch v-model="consignor_info.urgent" />
            </el-form-item>
        </el-form>
    </div>
    <div id="sample" v-show="isShow=='SampleTest'">
        <h4>{{ $t('sampleInformation') }}</h4>
        <el-form :model="sample_info"  label-width="150px" class="demo-ruleForm" size="small">
            <el-form-item :label="$t('testPurpose')" prop="testPurpose">
                <el-input v-model="sample_info.testPurpose" type="textarea" class="item3"></el-input>
            </el-form-item>
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('sampleName')" prop="sampleName">
                        <el-input v-model="sample_info.sampleName"  class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item :label="$t('sampleQuantity')" prop="sampleQuantity">
                        <el-input v-model="sample_info.sampleQuantity"  class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item :label="$t('batchNo')" prop="batchNo">
                        <el-input v-model="sample_info.batchNo"  class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item :label="$t('sampleTreatment')">
                <el-radio-group v-model="sample_info.disposal">
                <el-radio :label="$t('treatment01')" name="type01"></el-radio>
                <el-radio :label="$t('treatment01')" name="type02"></el-radio>
                <el-radio :label="$t('treatment01')" name="type03"></el-radio>
                <el-radio :label="$t('other')" name="type04"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item :label="$t('processMode')" prop="disposal"  v-show="sample_info.disposal==$t('other')">
                <el-input v-model="sample_info.disposal" class="item2"></el-input>
            </el-form-item>
            <el-form-item :label="$t('storageCondition')">
                <el-radio-group v-model="sample_info.storageCondition">
                <el-radio :label="$t('condition01')" name="type01"></el-radio>
                <el-radio :label="$t('condition02')" name="type02"></el-radio>
                <el-radio :label="$t('condition03')" name="type03"></el-radio>
                <el-radio :label="$t('other')" name="type04"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item :label="$t('specifiedCondition')" prop="storageCondition"  v-show="sample_info.storageCondition==$t('other')">
                <el-input v-model="sample_info.storageCondition" class="item2"></el-input>
            </el-form-item>
        </el-form>
        <h4>{{ $t('testInfo') }}</h4>
        <el-form :model="sample_test_info"  label-width="150px" class="demo-ruleForm"  ref="sampleTestInfo" size="small">
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('sampleName')" prop="sampleName">
                        <el-input v-model="sample_info.sampleName" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item :label="$t('specification')" prop="model">
                        <el-input v-model="sample_test_info.model" class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('batchNum')" prop="lotNo">
                        <el-input v-model="sample_test_info.lotNo" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item :label="$t('quantity')" prop="quantity">
                        <el-input v-model="sample_test_info.quantity" class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item :label="$t('testItem')" prop="testItem">
                <el-input v-model="sample_test_info.testItem" class="item3"></el-input>
            </el-form-item>
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('limitValue')" prop="limitValue">
                        <el-input v-model="sample_test_info.limitValue" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item :label="$t('wiNo')" prop="wiNo">
                        <el-input v-model="sample_test_info.wiNo" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item :label="$t('remark')" prop="remark">
                        <el-input v-model="sample_test_info.remark" class="item3" type="textarea"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="3">
                     <el-form-item>
                        <el-button type="info" @click="postSampleTestInfo('sampleTestInfo')">+1</el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <el-card class="box-card">
            <template #header>
                <div class="card-header">
                    <span>{{ $t('testItem') }}</span>
                </div>
            </template>
                <div v-for="o in test_item_list" :key="o" class="text item">
                    <span>{{ $t('testItem') }}:{{ o.testItem }},{{ $t('quantity') }}:{{ o.quantity }},{{ $t('remark') }}:{{ o.remark }}</span>
                    <el-button circle size="small" @click="cancel_test_info(o)"><el-icon><Close /></el-icon></el-button><br>
                </div>
        </el-card>
    </div>
    <div id="water" v-show="isShow=='Purified Water Test'">
        <h4>{{ $t('testInfo') }}</h4>
        <el-form :model="water_test_info" label-width="150px" class="demo-ruleForm"  ref="waterTestInfo" size="small">
            <el-form-item :label="$t('waterNo')" prop="waterNo">
                <el-input v-model="water_test_info.waterNo" class="item2"></el-input>
            </el-form-item>
            <el-form-item :label="$t('testItem')">
                <el-radio-group v-model="water_test_info.testItem">
                <el-radio :label="$t('waterItem01')" name="type01"></el-radio>
                <el-radio :label="$t('waterItem02')" name="type02"></el-radio>
                <el-radio :label="$t('other')" name="type03"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item :label="$t('specifiedItem')" prop="testItem"  v-show="water_test_info.testItem==$t('other')">
                <el-input v-model="water_test_info.testItem" class="item2"></el-input>
            </el-form-item>
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('wiNo')" prop="WINo">
                        <el-input v-model="water_test_info.WINo"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="3">
                    <el-form-item>
                        <el-button type="info" @click="postWaterTestInfo('waterTestInfo')">+1</el-button>
                    </el-form-item> 
                </el-col>
            </el-row>
        </el-form>
        <el-card class="box-card">
            <template #header>
                <div class="card-header">
                    <span>{{ $t('testItem') }}</span>
                </div>
            </template>
                <div v-for="o in test_item_list" :key="o" class="text item">
                        <span>{{ $t('testItem') }}:{{ o.testItem }},{{ $t('waterNo') }}:{{ o.waterNo }},{{ $t('wiNo') }}:{{ o.WINo }}</span>
                        <el-button circle size="small" @click="cancel_test_info(o)"><el-icon><Close /></el-icon></el-button><br>
                </div>
        </el-card>
    </div>
    <div id="cleanroom" v-show="isShow=='Cleanroom Environment Test'">
        <h4>{{ $t('testInfo') }}</h4>
        <el-form :model="cleanroom_test_info"  label-width="150px" class="demo-ruleForm"  ref="cleanroomTestInfo" size="small">
            <el-form-item :label="$t('cleanroomName')" prop="cleanroomName">
                <el-input v-model="cleanroom_test_info.cleanroomName" class="item2"></el-input>
            </el-form-item>
            <el-form-item :label="$t('testItem')">
                <el-radio-group v-model="cleanroom_test_info.testItem">
                <el-radio :label="$t('cleanroomItem01')" name="type01"></el-radio>
                <el-radio :label="$t('cleanroomItem02')" name="type02"></el-radio>
                <el-radio :label="$t('cleanroomItem03')" name="type03"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-row>
                <el-col :span="6">
                    <el-form-item :label="$t('wiNo')" prop="WINo">
                        <el-input v-model="cleanroom_test_info.WINo"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="3">
                    <el-form-item>
                        <el-button type="info" @click="postCleanroomTestInfo('cleanroomTestInfo')">+1</el-button>
                    </el-form-item> 
                </el-col>
            </el-row>
        </el-form>
        <el-card class="box-card">
            <template #header>
                <div class="card-header">
                    <span>{{ $t('testItem') }}</span>
                </div>
            </template>
                <div v-for="o in test_item_list" :key="o" class="text item">
                    <span>{{ $t('testItem') }}:{{ o.testItem }},{{ $t('cleanroomName') }}:{{ o.cleanroomName }},{{ $t('wiNo') }}:{{ o.WINo }}</span>
                    <el-button circle size="small" @click="cancel_test_info"><el-icon><Close /></el-icon></el-button><br>
                </div>
        </el-card>
    </div>
    <div id="btn">
        <el-row>
            <el-col :span="6">
                <el-button type="primary" class="sub" @click="postForm">{{ $t('submit') }}</el-button>
            </el-col>
            <el-col :span="6">
                <el-button type="primary" class="sub" @click="cancle">{{ $t('cancel') }}</el-button>
            </el-col>
        </el-row>
        
        
    </div>
    </div>
</template>

<script>
export default {

    name:'postCase',
    data(){
        return{
            isShow:'',
            isInLine:true,
            consignor_info:{
                consignorId:"",
                phoneNum:"",
                workCell:"",
                department:"",
                applyDate:"",
                sendDate:"",
                urgent:false
            },
            sample_info:{
                testPurpose:"",
                sampleName:"",
                sampleQuantity:0,
                batchNo:"",
                disposal:"",
                storageCondition:""
            },
            sample_test_info:{
                model:"",
                lotNo:"",
                quantity:0,
                testItem:"",
                wiNo:"",
                limitValue:0,
                remark:""
            },
            water_test_info:{
                waterNo:'',
                testItem:'',
                WINo:''
            },
            cleanroom_test_info:{
                cleanroomName:'',
                testItem:'',
                WINo:''
            },
            test_item_list:[],
            applyNo:'',
            quantity_sum:0,

        }
    },
    created(){
        this.getNo()
    },
    methods:{
        handleSelect(index){
            this.test_item_list=[]
            this.isShow=index
        },
        getNo(){
            let that = this
            this.$axios.get('http://localhost:8099/lab/getNo').then(function (res){
                if(res.data.code==1){
                    that.applyNo=res.data.data
                }else{
                    that.applyNo='出错啦'
                }
            })
        },
        postSampleTestInfo(sampleTestInfo){
            
            this.quantity_sum=Number(this.quantity_sum)+Number(this.sample_test_info.quantity)
            console.log(this.quantity_sum)
            if(this.quantity_sum>this.sample_info.sampleQuantity){
                alert('数量超出')
                this.quantity_sum=this.quantity_sum-this.sample_test_info.quantity
                return
            }
            let obj={
                sampleName:this.sample_info.sampleName,
                applyNum:this.applyNo,
                model:this.sample_test_info.model,
                lotNo:this.sample_test_info.lotNo,
                quantity:this.sample_test_info.quantity,
                testItem:this.sample_test_info.testItem,
                wiNo:this.sample_test_info.wiNo,
                limitValue:this.sample_test_info.limitValue,
                remark:this.sample_test_info.remark,
            }
            this.test_item_list.push(obj)
            this.$refs[sampleTestInfo].resetFields();
        },

        postWaterTestInfo(waterTestInfo){
            let obj={
                waterNo:this.water_test_info.waterNo,
                testItem:this.water_test_info.testItem,
                WINo:this.water_test_info.WINo,
            }
            this.test_item_list.push(obj)
            this.$refs[waterTestInfo].resetFields();
        },
        postCleanroomTestInfo(cleanroomInfo){
            let obj={
                cleanroomName:this.cleanroom_test_info.cleanroomName,
                testItem:this.cleanroom_test_info.testItem,
                WINo:this.cleanroom_test_info.WINo,
            }
            this.test_item_list.push(obj)

            this.$refs[cleanroomInfo].resetFields();
        },
        cancel_test_info(info){
            console.log(info)
            this.quantity_sum=this.quantity_sum-info.quantity
            this.test_item_list.splice(this.test_item_list.indexOf(info),1)

        },
        postForm(){
            let that = this
            
            // 委托人数据
            let consignorInfo = new FormData()
            consignorInfo.append('applyNum',this.applyNo)
            consignorInfo.append('consignorId',this.consignor_info.consignorId)
            consignorInfo.append('phoneNum',this.consignor_info.phoneNum)
            consignorInfo.append('workCell',this.consignor_info.workCell)
            consignorInfo.append('department',this.consignor_info.department)
            consignorInfo.append('applyDate',this.consignor_info.applyDate)
            consignorInfo.append('sendDate',this.consignor_info.sendDate)
            consignorInfo.append('urgent',this.consignor_info.urgent)
            // 样品信息
            let sampleInfo = new FormData()
            sampleInfo.append('applyNum',this.applyNo)
            sampleInfo.append('testPurpose',this.sample_info.testPurpose)
            sampleInfo.append('sampleName',this.sample_info.sampleName)
            sampleInfo.append('sampleQuantity',this.sample_info.sampleQuantity)
            sampleInfo.append('batchNo',this.sample_info.batchNo)
            sampleInfo.append('disposal',this.sample_info.disposal)
            sampleInfo.append('storageCondition',this.sample_info.storageCondition)
            //mycaseTable信息
            let caseTable = new FormData()
            caseTable.append('applyNum',this.applyNo)
            caseTable.append('testType',this.isShow)
            caseTable.append('consignor',this.consignor_info.consignorId)
            caseTable.append('sendDate',this.consignor_info.sendDate)
            
            
            that.$axios.post('http://localhost:8099/lab/postSampleTestInfo',this.test_item_list).then(function (res){
                if(res.data.code==0){
                    alert("error")
                    return
                }
            })

            that.$axios.post('http://localhost:8099/lab/postSampleInfo',sampleInfo).then(function (res){
                if(res.data.code==0){
                    alert("error")
                    return
                }
            })

            that.$axios.post('http://localhost:8099/lab/postConsignorInfo',consignorInfo).then(function (res){
                if(res.data.code==0){
                    alert("error")
                    return
                }
            })

            that.$axios.post('http://localhost:8099/lab/postCase',caseTable).then(function (res){
                if(res.data.code==0){
                    alert("error")
                    return
                }
            })

            alert('success')
        }
        
    }
}
</script>

<style scoped>
.form{
    width: 1200px;
    margin: auto;
}

#btn{
    width: 1200px;
    margin-top: 10px;
    
}
.sub{
    display: block;
    margin: auto;
}
.item1{
    width: 200px;
}
.item2{
    width: 300px;
}
.item3{
    width: 600px;
}
.item {
  padding: 18px 0;
}
.box-card{
    width: 70%;
}
</style>