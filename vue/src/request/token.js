export function getToken() {
    return sessionStorage.token
  }
  
  export function setToken(token) {
    return sessionStorage.token = token
  }
  
  export function removeToken() {
    return sessionStorage.removeItem('token')
  }