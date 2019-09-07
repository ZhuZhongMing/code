import Vue from 'vue'
import { USER_INFO} from "@/store/mutation-types"
const getters = {
  device: state => state.app.device,
  theme: state => state.app.theme,
  color: state => state.app.color,
  token: state => state.user.token,
  avatar: state => {state.user.avatar = Vue.ls.get(USER_INFO).avatar; return state.user.avatar},
  /*登陆账号*/
  username: state => state.user.username,
  /*真实姓名*/
  nickname: state => {state.user.realname = Vue.ls.get(USER_INFO).realname; return state.user.realname},

  tel: state => {state.user.phone = Vue.ls.get(USER_INFO).phone; return state.user.phone},
  mail: state => {state.user.email = Vue.ls.get(USER_INFO).email; return state.user.email},
  birthday: state => {state.user.birthday = Vue.ls.get(USER_INFO).birthday; return state.user.birthday},
  sex: state => {state.user.sex = Vue.ls.get(USER_INFO).sex; return state.user.sex},


  welcome: state => state.user.welcome,
  permissionList: state => state.user.permissionList,
  userInfo: state => {state.user.info = Vue.ls.get(USER_INFO); return state.user.info},
  addRouters: state => state.permission.addRouters
}

export default getters