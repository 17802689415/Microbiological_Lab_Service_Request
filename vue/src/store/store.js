
import { createStore } from 'vuex'

// 创建一个新的 store 实例
const store = createStore({
  state () {
    return {
        isCollapse: true
    }
  },
  
})

export default store