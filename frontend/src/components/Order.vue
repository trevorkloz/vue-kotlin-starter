<template>
  <div class="order">

    <input type="text" v-model="order.orderNo" placeholder="Order No">
    <input type="text" v-model="order.name" placeholder="Name">

    <button @click="createNewOrder()">Create Order</button>

    <div v-if="showResponse"><h6>Order created with Id: {{ response }}</h6></div>

    <button v-if="showResponse" @click="retrieveOrder()">Retrieve order {{order.id}} data from database</button>

    <h4 v-if="showRetrievedOrder">Retrieved Order {{retrievedOrder.orderNo}} {{retrievedOrder.name}}</h4>

  </div>
</template>

<script>
  import api from "./backend-api";
  export default {
    name: 'order',
    data () {
      return {
        response: [],
        errors: [],
        order: {
          orderNo: '',
          name: '',
          id: 0
        },
        showResponse: false,
        retrievedOrder: {},
        showRetrievedOrder: false
      }
    },
    methods: {

      createNewOrder () {
        api.createOrder(this.order.orderNo, this.order.name).then(response => {
            this.response = response.data;
            this.order.id = response.data;
            this.showResponse = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      },

      retrieveOrder () {
        api.getOrder(this.order.id).then(response => {
            this.retrievedOrder = response.data;
            this.showRetrievedOrder = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    }
  }

</script>

<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
