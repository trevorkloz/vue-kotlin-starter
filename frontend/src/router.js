import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Order from '@/components/Order'

Vue.use(Router);

const router = new Router({
    mode: 'history',
    routes: [
        { path: '/', component: Hello },
        { path: '/order', component: Order },
        // otherwise redirect to home
        { path: '*', redirect: '/' }
    ]
});

router.beforeEach((to, from, next) => {
    next();
});

export default router;