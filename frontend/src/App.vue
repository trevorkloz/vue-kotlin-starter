<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Greetings</router-link> |
      <router-link to="/order">Order</router-link>
    </div>
    <router-view :greeting="msg"></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
  data () {
    return {
      msg: 'Simple Vue-Frontend with Kotlin-Backend Starter'
    }
  }
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}

#nav {
  padding: 30px;
  a {
    font-weight: bold;
    color: #2c3e50;
    &.router-link-exact-active {
     color: #42b983;
    }
  }
}
</style>
