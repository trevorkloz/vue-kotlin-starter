<template>
  <div class="hello">
    <h1>{{ greeting }}</h1>
      <SubComponent githublink="trevorkloz/vue-kotlin-starter"/>
        <ul>
            <li><router-link to="/order">Create an Order here</router-link></li>
        </ul>
  </div>
</template>

<script>
    import SubComponent from "./SubComponent";

    export default {
        name: 'hello',
        props: {
            greeting: {type: String, required: true}
        },
        components: {
            'SubComponent': SubComponent
        }
    }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
