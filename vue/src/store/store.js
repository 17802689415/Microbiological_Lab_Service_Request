
import { createStore } from 'vuex'
import {getToken} from '@/request/token.js'



// 创建一个新的 store 实例
const store = createStore({
  state () {
    return {
        isCollapse: true,
        token: getToken()
    }
  },
})
  

export default store