<template>
    <div>
        <h3>Todo 입력</h3>
        <input type="text" v-model="newTodoItem" v-on:keypress.enter="addTodo">
        <button v-on:click="addTodo">추가</button>
    </div>
</template>

<script>

export default {
    data () {
        return {
            newTodoItem: ''
        }
    },
    methods: {
        addTodo () {
            if (this.newTodoItem !== '') {
                var value = this.newTodoItem && this.newTodoItem.trim()
                console.log('addTodo')

                // emit의 역할은 무엇인가 ?
                this.$emit('addTodo', value)
                this.clearInput()
            }
        },
        clearInput () {
            this.newTodoItem = ''
        }
    }
}

</script>