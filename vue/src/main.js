
import { createApp } from 'vue'
import App from './App.vue'
import * as ElIconModules from '@element-plus/icons-vue'
import router from './router/router.js'
import store from './store/store.js'
import axios from '@/request/index.js'


const app = createApp(App)
app.use(router)
app.use(store)
axios.defaults.baseURL = 'https://localhost:8099'
// const token = window.sessionStorage.getItem("token");
// axios.defaults.headers['Authorization'] = getToken();
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
app.config.globalProperties.$axios=axios
//引入icon
Object.keys(ElIconModules).forEach(function (key) {
    app.component(ElIconModules[key].name, ElIconModules[key])
  })


app.mount('#app')