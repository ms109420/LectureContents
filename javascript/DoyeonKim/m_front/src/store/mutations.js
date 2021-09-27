import {
   
    // 스프링 랜덤 데이터 통신
    SUCCESS_GEN_RAND_NUM,
    FAIL_GEN_RAND_NUM,
    // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    // 상품
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT,

    // 세션
    FETCH_SESSION
} from './mutation-types'

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {

    
    // 스프링 랜덤 데이터 통신
    [SUCCESS_GEN_RAND_NUM] (state, payload) {
        console.log('payload = ' + payload)
        state.randomFromSpring = payload
    },
    [FAIL_GEN_RAND_NUM] () {
        console.log('통신 에러!')
    },
    // 게시판
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    // 상품
    [FETCH_PRODUCT_LIST] (state, products) {
        state.products = products
    },
    [FETCH_PRODUCT] (state, product) {
        state.product = product
    },

   
    [CRAWL_START] (state, payload) {
        state.lists = payload
    },
    [FETCH_SESSION] (state) {
        state.session = this.$cookies.get(userSession)
    }
}