<template>
  <button>
    <span>
        删除
    </span>
</button>
</template>

<script>
export default {
    name:'btnSix'

}
</script>

<style scoped>
button {
 display: inline-block;
 border-radius: 4px;
 background-color: chocolate;
 border: none;
 color: #FFFFFF;
 text-align: center;
 font-size: 13px;
 width: 100px;
 height: 30px;
 transition: all 0.5s;
 cursor: pointer;
 margin: 5px;
}

button span {
 cursor: pointer;
 display: inline-block;
 position: relative;
 transition: 0.5s;
}

button span:after {
 content: '»';
 position: absolute;
 opacity: 0;
 top: 0;
 right: -15px;
 transition: 0.5s;
}

button:hover span {
 padding-right: 15px;
}

button:hover span:after {
 opacity: 1;
 right: 0;
}


</style>