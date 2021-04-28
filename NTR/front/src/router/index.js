import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Banque from '../components/Banque';
import Ecommerce from '../components/Ecommerce';
import Gateway from '../components/Gateway';
import VueResource from "vue-resource";

Vue.use(VueRouter);
Vue.use(VueResource);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    children: [
      {
        path: '/banque/:username/:password',
        name: 'Banque',
        component: Banque
      },
      {
        path: '/',
        name: 'Ecommerce',
        component: Ecommerce
      },
      {
        path: '/gateway',
        name: 'Gateway',
        component: Gateway
      }
    ]
  },
  {
    path: '*',
    redirect: '/'
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
