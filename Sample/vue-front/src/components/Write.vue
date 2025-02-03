<template>
    <div class="write">
        <h1>기본 게시판</h1>
        <el-button class="write-button" @click="changeRegistPopup()">글쓰기</el-button>
        <regist-board v-if="changeRegistPopup" ref="registPopup"></regist-board>
    </div>
</template>
<script>
import RegistBoard from './Regist-board.vue';

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components: {
    RegistBoard
  },
  methods: {
    changeRegistPopup(){
      this.$refs.registPopup.openPopup = !this.$refs.registPopup.openPopup;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .write{
        height: 100%;
        margin-bottom: 10%;
    }
</style>