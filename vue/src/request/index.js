import axios from 'axios'
import store from '@/store/store.js'
import {setToken,getToken} from '@/request/token.js'
import router from '@/router/router.js'
// 1、请求拦截
axios.interceptors.request.use(function(config){
    console.log('请求即将开始');
    if(getToken()){
        console.log(store.state.token)
    }else{
        router.push("/")
    }
    return config;
},function(err){
    //请求错误之前可以进行处理
    return Promise.reject(err)
});
// 2、拦截响应
axios.interceptors.response.use(function(response){
    //对返回的数据进行操作
    console.log('即将返回我们想要的数据');
    console.log(response);
    if(response.data.code == 1){
        setToken(response.data.data)
    }
    
    
    return response
},function(err){
    return Promise.reject(err)
})
