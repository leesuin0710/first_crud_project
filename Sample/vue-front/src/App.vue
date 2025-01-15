<template>
  <div id="app">
    <HeaderComponent /> <!-- 헤더 컴포넌트-->
    <h1>기본 게시판</h1>
    <el-button class="write-button" @click="openRegistPopup()">글쓰기</el-button>
    <regist-board @refresh="reload" ref="registPopup"></regist-board>
    <router-view/>
  </div>
</template>

<script>
import HeaderComponent from "./components/HeaderComponent.vue";
import HelloWorld from './components/HelloWorld.vue'
import List from './components/List.vue';
import RegistBoard from "./components/Regist-board.vue";

export default {
  name: 'App',
  components: {
    HeaderComponent,
    HelloWorld,
    List,
    RegistBoard
  },
  methods:{
    reload() {
        window.location.reload();
        },
    openRegistPopup(){
      this.$refs.registPopup.openPopup = true;
    }
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
.write-button{
  margin-right: 92%;
}
</style>
