<template>
    <div class="write">
        <h1>기본 게시판</h1>
        <div class="write-button-div">
            <el-button class="write-button" @click="changeRegistPopup()">글쓰기</el-button>
        </div>

        <div class="write-board">
          <el-input placeholder="제목을 입력해 주세요" v-model="title"></el-input>
            <el-input
              style="margin-top:30px;"
              type="textarea"
              :rows="30"
              placeholder="내용을 입력해 주세요."
              v-model="content"
            >
            </el-input>
            
        </div>
        <!-- dialog footer 영역 -->
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="Popup()">확인</el-button>
          <el-button @click="openPopup = false">취소</el-button>
        </span>
    </div>
</template>
<script>
import Popup from './Popup.vue';

export default {
  name: 'HelloWorld',
  data () {
    return {
      title: '',
      content: '',
    }
  },
  components: {
    Popup
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
    .write-button-div{
        text-align: end;
    }
    .write-board{
      padding: 20px 0;
    }
</style>