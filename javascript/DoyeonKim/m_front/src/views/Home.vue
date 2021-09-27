<template>
    <div class="home">
        <div id="header">
            <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                Home
            </router-link>
            <router-link :to="{ name: 'Test' }"
                    class="nav-link"
                    active-class="active">
                Test
            </router-link>
           
            <router-link :to="{ name: 'BoardListPage' }"
                    class="nav-link"
                    active-class="active">
                BoardListPage
            </router-link>
            <router-link :to="{ name: 'GameMemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                GameMemberRegisterPage
            </router-link>
            <router-link :to="{ name: 'ProductListPage' }"
                    class="nav-link"
                    active-class="active">
                ProductListPage
            </router-link>
            <router-link :to="{ name: 'OnlyVuePage' }"
                    class="nav-link"
                    active-class="active">
                Only 뷰 페이지
            </router-link>
            <router-link :to="{ name: 'MaterializeTestPage' }"
                    class="nav-link"
                    active-class="active">
                Materialize 활용
            </router-link>
            <router-link :to="{ name: 'Main' }"
                    class="nav-link"
                    active-class="active">
                메인
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                Vuetify 회원 가입 활용
            </router-link>
             <router-link :to="{ name: 'MemberJoinColumnTestPage' }"
                    class="nav-link"
                    active-class="active">
                Member Join Column Test
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberLoginPage' }"
                    class="nav-link"
                    active-class="active">
                Member 로그인 Test
            </router-link>
            <router-link :to="{ name: 'AccountRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                Account 회원 가입
            </router-link>
            <router-link :to="{ name: 'SessionLoginPage' }"
                    class="nav-link"
                    active-class="active">
                Account 로그인 Test
            </router-link>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Home'
}
</script>