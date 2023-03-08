<template>
  <div>
    <myHome></myHome>
    <!-- <mainHome></mainHome> -->
  </div>
  
</template>

<script>
import myHome from './components/MyHome.vue'
// import mainHome from './components/zl/MainHome.vue'

export default {
  name: 'App',
  components: {
    myHome
  }
}
</script>

<style>
div{
  -webkit-user-select: none;
  user-select: none;
}

</style>
