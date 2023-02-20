import { createRouter,createWebHashHistory } from "vue-router";

import postCase from '../components/PostCase.vue'
import myCase from '../components/MyCase.vue'
import handleCase from '../components/HandleCase.vue'
const router = createRouter({
    history:createWebHashHistory(),
    routes:[


        
        {name:'postCase',path:'/postCase',component:postCase},
        {name:'myCase',path:'/myCase',component:myCase},
        {name:'handleCase',path:'/handleCase',component:handleCase},
      
      
        

    ]

})


export default router