
import { createApp } from 'vue'
import App from './App.vue'
import * as ElIconModules from '@element-plus/icons-vue'
import router from './router/router.js'
import store from './store/store.js'
import axios from '@/request/index.js'
// import Viewer from 'v-viewer'
// import 'viewerjs/dist/viewer.css'




const app = createApp(App)
app.use(router)
app.use(store)
// app.use(Viewer,{
//   defaultOptions:{
//     zIndex:9999
//   }
// })


axios.defaults.baseURL = 'https://localhost:8099'

app.config.globalProperties.$axios=axios
//引入icon
Object.keys(ElIconModules).forEach(function (key) {
    app.component(ElIconModules[key].name, ElIconModules[key])
  })


app.mount('#app')