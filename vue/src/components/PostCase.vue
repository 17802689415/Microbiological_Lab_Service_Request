<template>
    <div id="menu">
        <el-menu class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1">SampleTest</el-menu-item>
            <el-menu-item index="2">Purified Water Test </el-menu-item>
            <el-menu-item index="3">Cleanroom Environment Test</el-menu-item>
        </el-menu>
    </div>
    <div class="form">
    <div id="consignor">
        <h6>applyNo:  {{ applyNo }}</h6>
        <h4>委托人信息</h4>
        <el-form :model="consignor_info" :rules="rules" label-width="120px" class="demo-ruleForm" size="small">
            <el-row>
                <el-col :span="6">
                    <el-form-item label="委托人工号" prop="consignorId">
                        <el-input v-model="consignor_info.consignorId" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="电话" prop="phoneNum">
                        <el-input v-model="consignor_info.phoneNum" class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="6">
                    <el-form-item label="项目" prop="workCell">
                        <el-input v-model="consignor_info.workCell" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="部门" prop="department">
                        <el-input v-model="consignor_info.department" class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="6">
                    <el-form-item label="申请日期" prop="applyDate" :inline-message="isInLine">
                        <el-date-picker
                            v-model="consignor_info.applyDate"
                            type="date"
                            placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>    
                </el-col>
                <el-col :span="6">
                    <el-form-item label="送样日期" prop="sendDate" :inline-message="isInLine">
                        <el-date-picker
                            v-model="consignor_info.sendDate"
                            type="date"
                            placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="urgent?" prop="urgent">
                <el-switch v-model="consignor_info.urgent" />
            </el-form-item>
        </el-form>
    </div>
    <div id="sample" v-show="isShow==1">
        <h4>样品信息</h4>
        <el-form :model="sample_info" :rules="rules" label-width="120px" class="demo-ruleForm" size="small">
            <el-form-item label="测试目的" prop="testPurpose">
                <el-input v-model="sample_info.testPurpose" type="textarea" class="item3"></el-input>
            </el-form-item>
            <el-row>
                <el-col :span="6">
                    <el-form-item label="样品名称" prop="sampleName">
                        <el-input v-model="sample_info.sampleName"  class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="样品总数量" prop="sampleQuantity">
                        <el-input v-model="sample_info.sampleQuantity"  class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="灭菌批号" prop="batchNo">
                        <el-input v-model="sample_info.batchNo"  class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="样品处理">
                <el-radio-group v-model="sample_info.disposal">
                <el-radio label="Return sample after test测试完立即退样" name="type01"></el-radio>
                <el-radio label="Disposed by Lab after test测试完由实验室处理" name="type02"></el-radio>
                <el-radio label="Return sample when abnormal样品异常时退样" name="type03"></el-radio>
                <el-radio label="other" name="type04"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="指明处理方式" prop="disposal"  v-show="sample_info.disposal=='other'">
                <el-input v-model="sample_info.disposal" class="item2"></el-input>
            </el-form-item>
            <el-form-item label="样品存储条件">
                <el-radio-group v-model="sample_info.storageCondition">
                <el-radio label="Room temperature常温" name="type01"></el-radio>
                <el-radio label="Cold storage冷藏" name="type02"></el-radio>
                <el-radio label="Freeze冷冻" name="type03"></el-radio>
                <el-radio label="other" name="type04"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="指明存储条件" prop="storageCondition"  v-show="sample_info.storageCondition=='other'">
                <el-input v-model="sample_info.storageCondition" class="item2"></el-input>
            </el-form-item>
        </el-form>
        <h4>测试信息</h4>
        <el-form :model="test_info" :rules="rules" label-width="120px" class="demo-ruleForm"  ref="testInfo" size="small">
            <el-row>
                <el-col :span="6">
                    <el-form-item label="样品名称" prop="sampleName">
                        <el-input v-model="sample_info.sampleName" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="规格" prop="model">
                        <el-input v-model="test_info.model" class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="6">
                    <el-form-item label="批号" prop="lotNo">
                        <el-input v-model="test_info.lotNo" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="数量" prop="quantity">
                        <el-input v-model="test_info.quantity" class="item1"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="测试项目" prop="testItem">
                <el-input v-model="test_info.testItem" class="item3"></el-input>
            </el-form-item>
            <el-row>
                <el-col :span="6">
                    <el-form-item label="接收限值" prop="limitValue">
                        <el-input v-model="test_info.limitValue" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="测试方法号" prop="wiNo">
                        <el-input v-model="test_info.wiNo" class="item1"></el-input>
                    </el-form-item>
                </el-col>
                
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="备注" prop="remark">
                        <el-input v-model="test_info.remark" class="item3" type="textarea"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="3">
                     <el-form-item>
                        <el-button type="info" @click="postTestInfo('testInfo')">+1</el-button>
                    </el-form-item>
                </el-col>
            </el-row>
            
        </el-form>
    </div>
    <div id="water" v-show="isShow==2">
        <h4>测试信息</h4>
        <el-form :model="water_test_info" :rules="rules" label-width="120px" class="demo-ruleForm"  ref="waterTestInfo" size="small">
            <el-form-item label="纯化水编号" prop="waterNo">
                <el-input v-model="water_test_info.waterNo" class="item2"></el-input>
            </el-form-item>
            <el-form-item label="测试项目">
                <el-radio-group v-model="water_test_info.testItem">
                <el-radio label="Full Test Items全项目检测" name="type01"></el-radio>
                <el-radio label="Description, Acidity or alkalinity, Conductivity, Ammonia 性状、酸碱度、电导率、氨" name="type02"></el-radio>
                <el-radio label="other" name="type03"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="指明测试项目" prop="testItem"  v-show="water_test_info.testItem=='other'">
                <el-input v-model="water_test_info.testItem" class="item2"></el-input>
            </el-form-item>
            <el-row>
                <el-col :span="6">
                    <el-form-item label="WINo" prop="WINo">
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
    </div>
    <div id="cleanroom" v-show="isShow==3">
        <h4>测试信息</h4>
        <el-form :model="cleanroom_test_info" :rules="rules" label-width="120px" class="demo-ruleForm"  ref="cleanroomTestInfo" size="small">
            <el-form-item label="洁净室名称" prop="cleanroomName">
                <el-input v-model="cleanroom_test_info.cleanroomName" class="item2"></el-input>
            </el-form-item>
            <el-form-item label="测试项目">
                <el-radio-group v-model="cleanroom_test_info.testItem">
                <el-radio label="Settling microbe沉降菌" name="type01"></el-radio>
                <el-radio label="Airborne Microbe浮游菌" name="type02"></el-radio>
                <el-radio label="Microbiological of Surfaces 表面微生物" name="type03"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-row>
                <el-col :span="6">
                    <el-form-item label="WINo" prop="WINo">
                        <el-input v-model="cleanroom_test_info.WINo"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="3">
                    <el-form-item>
                        <el-button type="info" @click="postWaterTestInfo('cleanroomTestInfo')">+1</el-button>
                    </el-form-item> 
                </el-col>
            </el-row>
        </el-form>
    </div>
    <div id="btn">
        <el-row>
            <el-col :span="6">
                <el-button type="primary" class="sub">提交</el-button>
            </el-col>
            <el-col :span="6">
                <el-button type="primary" class="sub">取消</el-button>
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
            isShow:0,
            isInLine:true,
            consignor_info:{
                consignorId:"",
                phoneNum:"",
                workCell:"",
                department:"",
                applyDate:"",
                sendDate:"",
            },
            sample_info:{
                testPurpose:"",
                sampleName:"",
                sampleQuantity:0,
                batchNo:"",
                disposal:"",
                storageCondition:""
            },
            test_info:{
                model:"",
                lotNo:"",
                quantity:0,
                testItem:"",
                wiNo:"",
                limitValue:0,
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
            rules:{
                consignorId: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
                phoneNum: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
                workCell: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
                department: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
                applyDate: [
                    { required: true, message: '请选择', trigger: 'blur' },
                ],
                sendDate: [
                    { required: true, message: '请选择', trigger: 'blur' },
                ],
                testPurpose: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
                sampleName: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
                sampleQuantity: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
                batchNo: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
                storageCondition: [
                    { required: true, message: '请输入', trigger: 'blur' },
                ],
            },
            applyNo:'',
        }
    },
    created(){
        this.getNo()
    },
    methods:{
        handleSelect(index){
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
        postTestInfo(testInfo){
            let that = this
            let formData = new FormData()
            formData.append('applyNum',this.applyNo)
            formData.append('sampleName',this.sample_info.sampleName)
            formData.append('model',this.test_info.model)
            formData.append('lotNo',this.test_info.lotNo)
            formData.append('quantity',this.test_info.quantity)
            formData.append('testItem',this.test_info.testItem)
            formData.append('wiNo',this.test_info.wiNo)
            formData.append('limitValue',this.test_info.limitValue)
            that.$axios.post('http://localhost:8099/lab/postTestInfo',formData).then(function (res){
                if(res.data.code==1){
                    alert(res.data.data)
                }else{
                    alert(res.data.msg)
                }
            })
            this.$refs[testInfo].resetFields();
        },
        postWaterTestInfo(waterTestInfo){
            this.$refs[waterTestInfo].resetFields();
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
    margin: auto;
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
</style>