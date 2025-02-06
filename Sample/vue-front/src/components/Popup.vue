<!-- Regist-board.vue -->
<template>
    <div class="popup">
      <!-- 글쓰기 버튼 -->
      <!-- <el-button class="write-button" @click="openPopup = true">글쓰기</el-button> -->
      <!-- 팝업 내용 -->
      <el-dialog class="popup-content" :title="ModalTitle" :visible.sync="openPopup" width="50%" center>
        <!-- 본문 영역 -->
        <el-input placeholder="제목을 입력해 주세요" v-model="title"></el-input>
        <el-input
          style="margin-top:30px;"
          type="textarea"
          :rows="30"
          placeholder="내용을 입력해 주세요."
          v-model="content"
        >
        </el-input>
        <!-- dialog footer 영역 -->
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="Popup()">확인</el-button>
          <el-button @click="openPopup = false">취소</el-button>
        </span>
      </el-dialog>
    </div>
  </template>
  
  <script>
  import axios from 'axios';

  export default {
    name: 'Popup',
    data() {
      return {
        openPopup: false,
        bno: '',
        editMode: false,
        title: '',
        content: '',
        writer: '',
        isLoading: false,
      };
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
        },
        ModalTitle(){
          return this.editMode === true ? '글 수정' : '글 등록';
        }
    },
    methods: {
      Popup() {
      if (this.editMode){
        this.isLoading = true;
      axios
        .put(`http://localhost:8081/test/${this.bno}`, this.setParams)
        .then((response) => {
          this.isLoading = false;
          if (response.data.status === 'success') {  // 실제 응답에 맞게 수정
            console.log('게시글 수정 성공', response.data);
            this.openPopup = false; // 팝업 닫기
            this.title = ''; // 입력 필드 초기화
            this.content = ''; // 입력 필드 초기화
            this.writer = this.writer;
            this.$emit('refresh');
          } else {
            this.isLoading = false;
            console.log('게시글 수정 실패', response.data);
            this.openPopup = false; // 팝업 닫기
            this.title = ''; // 입력 필드 초기화
            this.content = ''; // 입력 필드 초기화
            this.writer = '';
            this.$emit('refresh');
          }
        })
        .catch((error) => {
          this.isLoading = false;
          console.error('게시글 수정 오류', error);
          this.openPopup = false; // 팝업 닫기
            this.title = ''; // 입력 필드 초기화
            this.content = ''; // 입력 필드 초기화
            this.writer = '';
            this.$emit('refresh');
        });
      }
      else{
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
      }
    },
  },
  };
  </script>
  
  <style scoped>
  .write-button{
    margin-right: 100%;
    margin-top: 2%;
  }
  
</style>