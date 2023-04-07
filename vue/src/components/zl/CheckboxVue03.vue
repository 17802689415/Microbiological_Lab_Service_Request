<template>
<div class="center">
		<input type="checkbox" name="" v-model="arr" :value="'checked'" @change="sendParent()" >
</div>
</template>

<script>
export default {
    name:'checkboxThree',
    props:{
      index:Number
    },
    data(){
      return{
        arr:[],

      }
    },
    methods:{
      sendParent(){
        console.log('子组件中arr')
        console.log(this.index)
       
        this.$emit('child-arr',this.index,this.arr)
      }
    }

}
</script>

<style scoped>
.center {
  width: 100%;
  transform: translate(-50, -50%);
  text-align: center;
}

input[type="checkbox"] {
  position: relative;
  top: 8px;
  width: 20px;
  height: 20px;
  -webkit-appearance: none;
  outline: none;
  transition: 0.5s;
}

input[type="checkbox"]:before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  border: 4px solid #262626;
  box-sizing: border-box;
  transition: 0.5s;
}

input:checked[type="checkbox"]:before {
  border-left: none;
  border-top: none;
  width: 10px;
  border-color: rgb(24, 196, 24);
  transform: rotate(45deg) translate(5px, -10px);
}

</style>