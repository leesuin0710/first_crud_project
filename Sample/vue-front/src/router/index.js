import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import List from '../components/List.vue'
import Popup from '../components/Popup.vue'
import Write from '../components/Write.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: HelloWorld
    },
    {
      path: '/home',
      name: 'Home',
      component: HelloWorld
    },
    {
      path: '/write',
      name: 'Write',
      component: Write
    },
    {
      path: '/list',
      name: 'List',
      component: List
    },
    {
      path: '/regist',
      name: 'Regist',
      component: Popup
    }
  ]
})


export {Router}