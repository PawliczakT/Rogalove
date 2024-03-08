import { createApp } from 'vue';
import App from './App.vue'; // Your main App.vue file
import Home from './components/Home.vue';
import Register from './components/Register.vue';
import Login from './components/Login.vue';
import VueRouter from 'vue-router';

const router = VueRouter.createRouter({
  history: VueRouter.createWebHistory(),
  routes: [
    { path: '/', component: Home },
    { path: '/register', component: Register },
    { path: '/login', component: Login },
    // Define other routes as needed
  ],
});

const app = createApp(App);
app.use(router);
app.mount('#app');

