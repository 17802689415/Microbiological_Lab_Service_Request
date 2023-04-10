<template>
<div class="card">
    <el-timeline>
        <el-timeline-item
        v-for="(activity, index) in activities"
        :key="index"
        :timestamp="activity.timestamp"
        >
        {{ activity.content }}
        </el-timeline-item>
    </el-timeline>
</div>
</template>

<script>
export default {
    name:'trackInformation',
    data(){
        return{
            activities : [
                {
                    content: 'Event start',
                    timestamp: '2018-04-15',
                },
                {
                    content: 'Approved',
                    timestamp: '2018-04-13',
                },
                {
                    content: 'Success',
                    timestamp: '2018-04-11',
                },
            ]
        }
    }

}
</script>

<style scoped>
.card {
  position: relative;
  margin: auto;
  width: 400px;
  height: 500px;
  background: mediumturquoise;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 25px;
  font-weight: bold;
  border-radius: 15px;
  cursor: pointer;
}

.card::before,
.card::after {
  position: absolute;
  content: "";
  width: 20%;
  height: 20%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 25px;
  font-weight: bold;
  background-color: lightblue;
  transition: all 0.5s;
}

.card::before {
  top: 0;
  right: 0;
  border-radius: 0 15px 0 100%;
}

.card::after {
  bottom: 0;
  left: 0;
  border-radius: 0 100%  0 15px;
}
/* 
.card:hover::before,
.card:hover:after {
  width: 100%;
  height: 100%;
  border-radius: 15px;
  transition: all 0.5s;
} */

/* .card:hover:after {
  content: "HELLO";
} */
</style>