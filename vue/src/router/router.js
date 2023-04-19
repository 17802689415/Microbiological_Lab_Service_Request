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
import mainHome from '../components/zl/MainHome.vue'
import myMain from '../components/zl/MainContainer.vue'
import mainLogin from '../components/zl/MainLogin.vue'
import mainMall from '../components/zl/MallInterface.vue'
import goodsDetail from '../components/zl/GoodsDetail.vue'
import loaderVue from '../components/zl/LoaderVue.vue'
import shopCar from '../components/zl/ShopCar.vue'
import userPage from '../components/zl/UserPage.vue'
import awaitPay from '../components/zl/AwaitPay.vue'
import trackInformation from '../components/zl/TrackInformation.vue'
import myHome from '../components/MyHome.vue'
import reportCase from '../components/ReportCase.vue'

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
        {name:'mainHome',path:'/mainHome',component:mainHome},
        {name:'myHome',path:'/myHome',component:myHome},
        {name:'myMain',path:'/myMain',component:myMain},
        {name:'mainLogin',path:'/mainLogin',component:mainLogin},
        {name:'reportCase',path:'/reportCase',component:reportCase},
        {name:'goodsDetail',path:'/goodsDetail',component:goodsDetail},
        {name:'mainMall',path:'/mainMall',component:mainMall},
        {name:'loaderVue',path:'/loaderVue',component:loaderVue},
        {name:'shopCar',path:'/shopCar',component:shopCar},
        {name:'userPage',path:'/userPage',component:userPage,children:[
            {name:'awaitPay',path:'/awaitPay',component:awaitPay},
            {name:'trackInformation',path:'/trackInformation',component:trackInformation},
        ]},
        {path:'/',redirect:'/login'},
      
      
        

    ]

})


export default router