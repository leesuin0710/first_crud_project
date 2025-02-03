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
import RegistBoard from "./components/Regist-board.vue";
import Write from "./components/Write.vue";

export default {
  name: 'App',
  components: {
    Header,
    Footer,
    HelloWorld,
    Write,
    List,
    RegistBoard
  },
  methods:{
  }
}
</script>

<style>
#app {
  width: 95%;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
