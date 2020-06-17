import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});


export default {

    getOrder(order) {
        return AXIOS.get(`/order/` + order.id);
    },
    createOrder(orderNo, name) {
        return AXIOS.post(`/order/` + orderNo + '/' + name);
    },
    deleteOrder(order) {
        return AXIOS.delete(`/order/` + order.id);
    }
}


