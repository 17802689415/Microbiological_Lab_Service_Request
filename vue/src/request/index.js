import axios from 'axios'
import {setToken,getToken, setUid} from '@/request/token.js'
import router from '@/router/router.js'
// 1、请求拦截
axios.interceptors.request.use(function(config){
    console.log('请求即将开始');
    if(getToken()){
        config.headers.Authorization = sessionStorage.getItem("token");
        console.log(config.headers.Authorization)
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
    if(response.data.code == 200){
        setToken(response.data.data.token)
        setUid(response.headers.uid)
    }
    
    
    return response
},function(err){
    alert("please login")
    return Promise.reject(err)
})

export default axios;
