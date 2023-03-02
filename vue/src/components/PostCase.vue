<template>
    <div id="menu">
        <el-menu class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1">SampleTest</el-menu-item>
            <el-menu-item index="2">Purified Water Test </el-menu-item>
            <el-menu-item index="3">Cleanroom Environment Test</el-menu-item>
        </el-menu>
    </div>
    <div id="consignor">
        <h4>委托人信息</h4>
        <el-form :model="consignor_info" :rules="rules" label-width="120px" class="demo-ruleForm" :inline="isInLine">
            <el-form-item label="委托人工号" prop="consignorId">
                <el-input v-model="consignor_info.consignorId"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="phoneNum">
                <el-input v-model="consignor_info.phoneNum"></el-input>
            </el-form-item>
            <el-form-item label="项目" prop="workCell">
                <el-input v-model="consignor_info.workCell"></el-input>
            </el-form-item>
            <el-form-item label="部门" prop="department">
                <el-input v-model="consignor_info.department"></el-input>
            </el-form-item>
            <el-form-item label="申请日期" prop="applyDate">
                <el-date-picker
                    v-model="consignor_info.applyDate"
                    type="date"
                    placeholder="选择日期">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="送样日期" prop="sendDate">
                <el-date-picker
                    v-model="consignor_info.sendDate"
                    type="date"
                    placeholder="选择日期">
                </el-date-picker>
            </el-form-item>
        </el-form>
    </div>
    <div id="sample" v-show="isShow==1">
        <h4>样品信息</h4>
        <el-form :model="sample_info" :rules="rules" label-width="120px" class="demo-ruleForm" :inline="isInLine">
            <el-form-item label="测试目的" prop="testPurpose">
                <el-input v-model="sample_info.testPurpose" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="样品名称" prop="sampleName">
                <el-input v-model="sample_info.sampleName"></el-input>
            </el-form-item>
            <el-form-item label="样品总数量" prop="sampleQuantity">
                <el-input v-model="sample_info.sampleQuantity"></el-input>
            </el-form-item>
            <el-form-item label="灭菌批号" prop="batchNo">
                <el-input v-model="sample_info.batchNo"></el-input>
            </el-form-item>
            <el-form-item label="样品处理">
                <el-radio-group v-model="sample_info.disposal">
                <el-radio label="Return sample after test测试完立即退样" name="type01"></el-radio>
                <el-radio label="Disposed by Lab after test测试完由实验室处理" name="type02"></el-radio>
                <el-radio label="Return sample when abnormal样品异常时退样" name="type03"></el-radio>
                <el-radio label="other" name="type04"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="指明处理方式" prop="disposal"  v-show="sample_info.disposal=='other'">
                <el-input v-model="sample_info.disposal" ></el-input>
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
                <el-input v-model="sample_info.storageCondition" ></el-input>
            </el-form-item>
        </el-form>
        <h4>测试信息</h4>
        <el-form :model="test_info" :rules="rules" label-width="120px" class="demo-ruleForm" :inline="isInLine">
            <el-form-item label="样品名称" prop="sampleName">
                <el-input v-model="sample_info.sampleName"></el-input>
            </el-form-item>
            <el-form-item label="规格" prop="model">
                <el-input v-model="test_info.model"></el-input>
            </el-form-item>
            <el-form-item label="批号" prop="lotNo">
                <el-input v-model="test_info.lotNo"></el-input>
            </el-form-item>
            <el-form-item label="数量" prop="quantity">
                <el-input v-model="test_info.quantity"></el-input>
            </el-form-item>
            <el-form-item label="测试项目" prop="testItem">
                <el-input v-model="test_info.testItem"></el-input>
            </el-form-item>
            <el-form-item label="测试方法号" prop="wiNo">
                <el-input v-model="test_info.wiNo"></el-input>
            </el-form-item>
            <el-form-item label="接收限值" prop="limitValue">
                <el-input v-model="test_info.limitValue"></el-input>
            </el-form-item>
        
        </el-form>
    </div>
    <div id="water" v-show="isShow==2">
        <h1>water</h1>
    </div>
    <div id="cleanroom" v-show="isShow==3">
        <h1>cleanroom</h1>
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
                sampleQuantity:"",
                batchNo:"",
                disposal:"",
                storageCondition:""
            },
            test_info:{
                model:"",
                lotNo:"",
                quantity:"",
                testItem:"",
                wiNo:"",
                limitValue:"",
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
            }
        }
    },
    methods:{
        handleSelect(index){
            this.isShow=index
        }
    }
}
</script>

<style>

</style>