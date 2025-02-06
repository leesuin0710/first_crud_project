<template>
    <div>
        <el-dialog title="글 상세 보기" :visible.sync="openDetail" width="30%" center :close-on-click-modal="false">
            글 번호 : {{ boardDetail.bno }} <br>
            제목 : {{ boardDetail.title }} <br>
            내용 : {{ boardDetail.content }} <br>
            작성자 : {{ boardDetail.writer }} <br>
            <el-row type="flex" justify="end" style="margin-top: 30px;">
                <el-button type="primary" @click="clickEditButton()">수정</el-button>
            </el-row>
        </el-dialog>
        <Popup @refresh="refresh" ref="registPopup"></Popup>
    </div>
</template>

<script>
import axios from 'axios';
import Popup from './Popup.vue';

export default {
    components: {Popup},
    data(){
        return{
            openDetail: false,
            boardDetail: [],
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
    },
    methods:{
        getBoardDetail(row){
            const params = {
                bno: row.bno,
            };
            axios.get(`http://localhost:8081/test/${row.bno}`, params).then((response) => {
                this.boardDetail = response.data; // 상세정보를 받아서 boardDetail에 저장
                console.log('상세보기:', this.boardDetail); // 콘솔에 출력
                this.openDetail = true;
            }).catch((error) => {
                console.error('게시글 상세 조회 오류:', error);
            });
        },
        clickEditButton(){
            this.openDetail = false;
            this.$refs.registPopup.bno = this.boardDetail.bno;
            this.$refs.registPopup.title = this.boardDetail.title;
            this.$refs.registPopup.content = this.boardDetail.content;
            this.$refs.registPopup.writer = this.boardDetail.writer;
            this.$refs.registPopup.editMode = true;
            this.$refs.registPopup.openPopup = true;
        },
        refresh() {
            this.$emit('refresh');
            window.location.reload();
        }
    },
};
</script>

<style scoped></style>