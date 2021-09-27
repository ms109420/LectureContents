<template>
    <form @submit.prevent="onSubmit">
        <h3>게시물 작성 형태</h3>
        <table>
n
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'ProductListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'ProductRegisterForm',
    data () {
        return {
            product_name: '',
            producer: '',
            description: '',
            price: ''
        }
    },
    methods: {
        onSubmit () {
            const { product_name, producer, description, price } = this
            this.$emit('submit', { product_name, producer, description, price })
        }
    }
}
</script>