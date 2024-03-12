import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/views/Home.vue';
import Login from '@/views/LoginView.vue';
import Register from '@/views/RegisterView.vue';
import AddRogal from '@/views/AddRogalModal.vue';
import Stats from '@/components/Stats.vue';

const routes = [
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/login',
        name: 'login',
        component: Login
    },
    {
        path: '/register',
        name: 'register',
        component: Register
    },
    {
        path: '/add',
        name: 'addRogal',
        component: AddRogal
    },
    {
        path: '/stats',
        name: 'stats',
        component: Stats
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

export default router;

