import {
    // TODO
    ADD_TODO,
    EDIT_TODO,
    REMOVE_TODO,
    SET_EDITTING_ID,
    RESET_EDITTING_ID,
    CLEAR_ALL,
    TOGGLE_TODO_STATUS,

    // 몬스터
    ADD_MANY_MONSTER,
    ADD_MONSTER,    
    DEATH,

    // 스프링 랜덤 데이터 통신
    SUCCESS_GEN_RAND_NUM,
    FAIL_GEN_RAND_NUM
} from './mutation-types'

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
    [ADD_TODO] (state, payload) {
        const { content } = payload
        //state.js 상에서 입력이 될때마다 id값이 하나씩 증가하게 되어있음
        state.todoItems.push({ id: state.nextTodoId, content, done: false })
        // 사용자가 입력한 내용 콘솔창에서 확인가능
        state.nextTodoId++
    },
    [REMOVE_TODO] (state, id) {
        // 현재 요청들어온 id값을 찾는다.
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        // 찾아낸 id값을 삭제시킨다.
        state.todoItems.splice(targetIndex, 1)
    },
    [EDIT_TODO] (state, payload) {
        const { id, content } = payload
        const targetIndex = state.todoItems.findIndex(v => v.id === id)
        const targetTodoItem = state.todoItems[targetIndex]
        // ...은 뒤에있는거 마져 붙인다는 의미. 따라서 splice에서 빼진만큼 content가 채워짐
        state.todoItems.splice(targetIndex, 1, { ...targetTodoItem, content })
    },
    [SET_EDITTING_ID] (state, id) {
        state.editingId = id
    },
    [RESET_EDITTING_ID] (state) {
        state.editingId = 0
    },
    [CLEAR_ALL] (state) {
        state.todoItems = []
    },
    [TOGGLE_TODO_STATUS] (state, id) {
        // todoItem은 변수, todoItems는 안에 들어있는 요소들(배열)
        // 현재 todoItems 배열에서 id로 들어온 todoItem을 찾는다
        const filtered = state.todoItems.filter(todoItem => {
            return todoItem.id === id
        })

        filtered.forEach(todoItem => {
            todoItem.done = !todoItem.done
        })
    },

    // 판타지 온라인
    [ADD_MANY_MONSTER] (state, payload) {
        for (var i = 0; i < payload.length; i++) {
            state.monsterElements.push(payload[i])
            state.nextMonsterId++
        }
    },
    [ADD_MONSTER] (state, payload) {
        const { name } = payload
        // push에 monsterId이므로 맞춰줘야함.
        state.monsterElements.push({ monsterId: state.nextMonsterId, name })
        state.nextMonsterId++
    },
    [DEATH] (state, monsterId) {
        const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
        state.monsterElements.splice(targetIndex, 1)
    },

    // 스프링 랜덤 데이터 통신
    [SUCCESS_GEN_RAND_NUM] (state, payload) {
        console.log('playload = ' + payload)
        state.randomFromSpring = payload
    },
    [FAIL_GEN_RAND_NUM] () {
        console.log('통신 에러!')        
    }
}