
import { createApp } from 'vue'
import App from './App.vue'
import * as ElIconModules from '@element-plus/icons-vue'
import router from './router/router.js'
import store from './store/store.js'
import axios from '@/request/index.js'
import {createI18n} from 'vue-i18n'





const app = createApp(App)
app.use(router)
app.use(store)

const VueI18n = createI18n
const i18n = new VueI18n({
  locale:'zh',
  messages:{
    'zh':require('@/components/i18n/zh.js').lang,
    'en':require('@/components/i18n/en.js').lang
  }
})

app.use(i18n)


axios.defaults.baseURL = 'https://localhost:8099'
app.config.globalProperties.$axios=axios
//引入icon
Object.keys(ElIconModules).forEach(function (key) {
    app.component(ElIconModules[key].name, ElIconModules[key])
  })


app.mount('#app')