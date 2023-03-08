import { createRouter,createWebHashHistory } from "vue-router";

import postCase from '../components/PostCase.vue'
import myCase from '../components/MyCase.vue'
import handleCase from '../components/HandleCase.vue'
import myLogin from '../components/Login.vue'
import mainView from '../components/MainView.vue'
import userManager from '../components/UserManager.vue'
import modifyUser from '../components/ModifyUser.vue'
import addUser from '../components/AddUser.vue'
import userPremission from '../components/UserPremission.vue'
import allCase from '../components/AllCase.vue'
import testInfo from '../components/TestInfo.vue'
import mainHome from '../components/zl/MainHome.vue'
import myHome from '../components/MyHome.vue'
const router = createRouter({
    history:createWebHashHistory(),
    routes:[


        
        {name:'postCase',path:'/postCase',component:postCase},
        {name:'myCase',path:'/myCase',component:myCase},
        {name:'handleCase',path:'/handleCase',component:handleCase},
        {name:'login',path:'/login',component:myLogin},
        {name:'mainView',path:'/mainView',component:mainView},
        {name:'userManager',path:'/userManager',component:userManager},
        {name:'modifyUser',path:'/modifyUser',component:modifyUser,props:true},
        {name:'addUser',path:'/addUser',component:addUser},
        {name:'userPremission',path:'/userPremission',component:userPremission},
        {name:'allCase',path:'/allCase',component:allCase},
        {name:'testInfo',path:'/testInfo',component:testInfo},
        {name:'mainHome',path:'/mainHome',component:mainHome},
        {name:'myHome',path:'/myHome',component:myHome},
        {path:'/',redirect:'/login'},
      
      
        

    ]

})


export default router