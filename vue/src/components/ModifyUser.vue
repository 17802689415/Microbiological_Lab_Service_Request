<template>
  <h1>modify</h1>
</template>

<script>
export default {
    name:'modifyUser',
    
    created(){
        this.init()
    },
    methods:{
        init(){
            console.log(this.$route.query.rowData)
        }
    }
}
</script>

<style>

</style>