<template>
  <div>
    <myHome></myHome>
  </div>
  
</template>

<script>
import myHome from './components/MyHome.vue'

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
