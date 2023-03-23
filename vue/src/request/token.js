export function getToken() {
    return sessionStorage.token
  }
  export function getUid() {
    return sessionStorage.uId
  }
  
  export function setToken(token) {
    return sessionStorage.token = token
  }
  export function setUid(uId) {
    return sessionStorage.uId = uId
  }
  
  export function removeToken() {
    return sessionStorage.removeItem('token') 
  }
  export function removeUid() {
    return sessionStorage.removeItem('uId')
  }