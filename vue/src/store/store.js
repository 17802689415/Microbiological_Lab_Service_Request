
import { createStore } from 'vuex'
import {getToken,getUid} from '@/request/token.js'



// 创建一个新的 store 实例
const store = createStore({
  state () {
    return {
        isCollapse: true,
        token: getToken(),
        uId: getUid()
    }
  },
})
  

export default store