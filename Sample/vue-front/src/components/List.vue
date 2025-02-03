<!-- List.vue -->
<template>
    <div class="Body">
        <h1>기본 게시판</h1>
        <RegistBoard @refresh="GETData"/>
        <div class="board-div">
                <el-table border :data="Items" @row-click="clickRow" v-if="Items.length>0">
                    <el-table-column prop="bno" label="글번호"></el-table-column>
                    <el-table-column prop="title" label="제목"></el-table-column>
                    <el-table-column prop="content" label="내용"></el-table-column>
                    <el-table-column prop="writer" label="작성자"></el-table-column>
                    <el-table-column label="관리">
                        <template v-slot="scope">
                            <el-button @click.stop="deleteBoard(scope.row.bno)" type="danger">삭제</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <div v-else>
                    <p>등록된 게시글이 없습니다.</p>
                </div>
                <board-detail ref="detailPopup" @reload="GETData()"></board-detail>
        </div>
    </div>
</template>

<script>
import axios from 'axios' //axios 사용을 위해 import
import RegistBoard from './Regist-board.vue';
import BoardDetail from './BoardDetail.vue';

export default {
    //변수 선언
    data(){
        return{
            Items:[],
            boardDetail: [],
            openDetail: false,
        };
    },
    props:{
        msg: String,
    },
    created(){
        this.GETData();
        // axios.get("http://localhost:8081/test").then((result) => { //"/test"에 get 요청을 보낸 후 돌아온 결과값으로 아래 실행
        //         console.log('test')
        //         this.Items = result.data; //변수 items에 결과값 넣어줌
        // })
    },
    components:{
        RegistBoard,
        BoardDetail
    },

    //메소드 선언
    methods: {
        GETData(){ //클릭이벤트
            axios.get("http://localhost:8081/test").then((result) => { //"/test"에 get 요청을 보낸 후 돌아온 결과값으로 아래 실행
                console.log(result.data);
                this.Items = result.data; //변수 items에 결과값 넣어줌
            })

            // this.$router.push({
            //     name: "Board"
            // })
        },
        clickRow(row){
            this.$refs.detailPopup.getBoardDetail(row);
        },
        deleteBoard(bno){
            console.log('Deleting board with bno: ${bno}');
            axios
                .delete(`http://localhost:8081/test/${bno}`)
                .then((response) => {
                    if (response.data.status === 'success'){
                        this.GETData();
                        console.log('게시글 삭제 성공');
                    } else{
                        console.log('게시글 삭제 실패');
                    }
                })
                .catch((error) => {
                    console.error('게시글 삭제 오류', error);
                });
        }
        // getBoardDetail(row) {
        //     axios.get(`http://localhost:8081/test/${row.bno}`).then((response) => {
        //         this.boardDetail = response.data; // 상세정보를 받아서 boardDetail에 저장
        //         console.log('상세보기:', this.boardDetail); // 콘솔에 출력
        //         this.openDetail = true;
        //     }).catch((error) => {
        //         console.error('게시글 상세 조회 오류:', error);
        //     });
        // }
    },
}
</script>

<style scoped>
.Body{
    height: 400px;
}
.board-div{
    width: 100%;
    height: 100%;
    padding-top: 2%;
}
/* .board-table{
    width: 100%;
    border-collapse: collapse;
}
.board-td, .board-th{
    border: gainsboro solid 1px;
} */ 
.board-button{
    margin-left: 95%;
    margin-top: 4%;
}
</style>