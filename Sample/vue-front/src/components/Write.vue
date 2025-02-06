<template>
    <div class="write">
        <h1>기본 게시판</h1>
        <div class="write-button-div">
        </div>

        <div class="write-board">
          <span>
            <el-input placeholder="작성자를 입력해 주세요" v-model="writer"></el-input>
            <el-input placeholder="제목을 입력해 주세요" v-model="title"></el-input>
          </span>
          
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
          <el-button type="primary" @click="postBoard()">등록</el-button>
          <el-button @click="backPage()">취소</el-button>
        </span>
    </div>
</template>
<script>
import Popup from './Popup.vue';
import axios from 'axios';

export default {
  name: 'HelloWorld',
  data () {
    return {
      bno: '',
      title: '',
      content: '',
      writer: '',
      isLoading: false,
    }
  },
  components: {
    Popup
  },
  computed:{
        setParams(){
            const params = {
                bno: this.bno,
                title: this.title,
                content: this.content,
                writer: this.writer
            };
            return params;
        }
    },
  methods: {
    changeRegistPopup(){
      this.$refs.registPopup.openPopup = !this.$refs.registPopup.openPopup;
    },
    postBoard(){
      this.isLoading = true;
      axios
        .post('http://localhost:8081/test', this.setParams)
        .then((response) => {
          this.isLoading = false;
          if (response.data.status === 'success') {  // 실제 응답에 맞게 수정
            console.log('게시글 등록 성공', response.data);
            this.openPopup = false; // 팝업 닫기
            this.title = ''; // 입력 필드 초기화
            this.content = ''; // 입력 필드 초기화
            this.writer = '';
            this.$emit('refresh');
          } else {
            this.isLoading = false;
            console.log('게시글 등록 실패', response.data);
            this.openPopup = false; // 팝업 닫기
            this.title = ''; // 입력 필드 초기화
            this.content = ''; // 입력 필드 초기화
            this.writer = '';
            this.$emit('refresh');
          }
        })
        .catch((error) => {
          this.isLoading = false;
          console.error('게시글 등록 오류', error);
          this.openPopup = false; // 팝업 닫기
            this.title = ''; // 입력 필드 초기화
            this.content = ''; // 입력 필드 초기화
            this.writer = '';
            this.$emit('refresh');
        });
    },
    backPage(){
    this.$router.push({ name: 'List' });
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