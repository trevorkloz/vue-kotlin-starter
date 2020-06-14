import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});


export default {

    getOrder(orderId) {
        return AXIOS.get(`/order/` + orderId);
    },
    createOrder(orderNo, name) {
        return AXIOS.post(`/order/` + orderNo + '/' + name);
    },
    deleteOrder(orderId) {
        return AXIOS.delete(`/order/` + orderId);
    }
}


