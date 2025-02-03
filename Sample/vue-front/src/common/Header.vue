<template>
    <!-- 마우스가 헤더 부분을 벗어나면 드롭다운 메뉴가 사라짐 -->
    <header v-on:mouseleave="dropDown.list = false, dropDown.home = false">
        <!-- 메인메뉴 클릭, 기존 ul태그로 가도 무방 -->
        <div class="menuMenu">
            <!-- 마우스가 각 메뉴에 호버링 될 시 드롭다운 메뉴가 나타나도록 v-on 설정 -->
            <a v-on:mouseover="overHome">홈</a>
            <span class="line"></span>
            <a v-on:mouseover="overList">게시판</a>
            
        </div>
        <!-- 메뉴가 사라질 때 애니메이션 효과를 주기위한 태그 -->
         <!-- 드롭 다운 메뉴 -->
          <transition name="fade">
            <!-- 둘 중 하나라도 호버링 되어 dropDown이 True가 되면 드롭다운메뉴 보이기 -->
             <div class="subMenu" v-if="dropDown.list || dropDown.home">
                <table style="margin:auto;">
                    <!-- v-for문 사용하여 각 아이템별로 메뉴 생성 -->
                     <th v-for="item in subMenuItems" v-bind:key="item">
                        <!-- onClick에 파라미터 넘겨주기 -->
                         <tr class="menuItem" v-on:click="menuClick(item)">{{ item }}</tr>
                     </th>
                </table>
             </div>
          </transition>
    </header>
</template>

<script>
export default{
    data(){
        return{
            dropDown: {
                list: false,
                home: false,
            },
            subMenuItems: [],
        }
    },
    methods: {
        overList(){
            //메인 메뉴 호버링 시 실행
            this.dropDown.list = true;
            this.subMenuItems = ["글 등록", "메뉴1", "메뉴2", "메뉴3"]
        },

        overHome(){
            //홈 메뉴 호버링 시 실행
            this.dropDown.home = true;
            this.subMenuItems = ["about", "메뉴b", "메뉴c"]
        },
        menuClick(item){
            //드롭다운 메뉴 클릭 시 실행
            if(item == "글 등록"){
                this.$router.push({
                    name: "Write"
                })
            }
            else if (item == "메뉴1" || item == "메뉴2" || item == "메뉴3"){
                this.$router.push({
                    name: "List"
                })
            }
            else{
                this.$router.push({
                    name: "Home"
                })
            }
        },
    },
}
</script>

<style scoped>
header {
    width:100%;
    text-align:center;
    font-size: 30px;
    font-weight: bold;
    position: sticky;
    top: 0;
    z-index: 1000;
    height:120px;
    border-bottom:1px solid #35495e;
    margin-bottom: 10px;
}
.mainMenu {
    height: 20%;
}
.mainMenu a:hover { 
    color:darkblue;
    background: blanchedalmond;
}
.line{
    width: 10px;
    padding-left: 2px;
    margin: 5%;
    background-color:dimgray;
}
.subMenu {
    height: 50%;
    margin-top: 10px;
    background:floralwhite;
    display: flex;
}
.subMenu tr {
    font-size: 15px;
}
.subMenu tr:hover {
    color: white;
    background: black;
}

.fade-enter-active, .fade-leave-active{
    transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to {
    opacity: 0;
}



</style>