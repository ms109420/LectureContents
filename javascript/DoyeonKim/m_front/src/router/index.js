import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'



// board
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

// product
import ProductListPage from '@/views/ProductListPage.vue'
import ProductRegisterPage from '@/views/ProductRegisterPage.vue'
import ProductReadPage from '@/views/ProductReadPage.vue'
import ProductModifyPage from '@/views/ProductModifyPage.vue'



// OnlyVuePage
import OnlyVuePage from '@/views/OnlyVuePage.vue'


// Materialize
import MaterializeTestPage from '@/views/MaterializeTestPage.vue'
import Main from '@/views/Main.vue'






// JPA Test Page
import VuetifyMemberRegisterPage from '@/views/VuetifyMemberRegisterPage.vue'
import MemberJoinColumnTestPage from '@/views/MemberJoinColumnTestPage.vue'
import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'

import SessionLoginPage from '@/views/SessionLoginPage.vue'
import AccountRegisterPage from '@/views/AccountRegisterPage.vue'

Vue.use(VueRouter)

const routes = [

  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },
  {
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components: {
      default: GameMemberRegisterPage
    }
  },
  {
    path: '/product',
    name: 'ProductListPage',
    components: {
      default: ProductListPage
    }
  },
  {
    path: '/product/create',
    name: 'ProductRegisterPage',
    components: {
      default: ProductRegisterPage
    }
  },
  {
    path: '/product/:productNo',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/product/:productNo/edit',
    name: 'ProductModifyPage',
    components: {
      default: ProductModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/onlyvuepage',
    name: 'OnlyVuePage',
    components: {
      default: OnlyVuePage
    }
  },
  {
    path: '/materialize',
    name: 'MaterializeTestPage',
    components: {
      default: MaterializeTestPage
    }
  },
  {
    path: '/main',
    name: 'Main',
    components: {
      default: Main
    }
  },
  {
    path: '/vuetifyMemberRegister',
    name: 'VuetifyMemberRegisterPage',
    components: {
      default: VuetifyMemberRegisterPage
    }
  },
  {
    path: '/memberJoinColumn',
    name: 'MemberJoinColumnTestPage',
    components: {
      default: MemberJoinColumnTestPage
    }
  },
  {
    path: '/memberLogin',
    name: 'VuetifyMemberLoginPage',
    components: {
      default: VuetifyMemberLoginPage
    }
  },
  {
    path: '/sessionLogin',
    name: 'SessionLoginPage',
    components: {
      default: SessionLoginPage
    }
  },
  {
    path: '/accountRegister',
    name: 'AccountRegisterPage',
    components: {
      default: AccountRegisterPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router