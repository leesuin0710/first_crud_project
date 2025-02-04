<template>
  <div id="app">
    <Header /> <!-- 헤더 컴포넌트-->
    <router-view/>
    <Footer/>
  </div>
</template>

<script>
import Footer from "./common/Footer.vue";
import Header from "./common/Header.vue";
import HelloWorld from './components/HelloWorld.vue'
import List from './components/List.vue';
import Popup from "./components/Popup.vue";
import Write from "./components/Write.vue";

export default {
  name: 'App',
  components: {
    Header,
    Footer,
    HelloWorld,
    Write,
    List,
    Popup
  },
  methods:{
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
