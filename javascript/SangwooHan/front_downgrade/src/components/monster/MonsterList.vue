<template>
    <div>
        <ul>
            <h3>몬스터 리스트</h3>
            <monster-element v-for="monster in monsterElements"
                    v-bind:key="monster.id"
                    v-bind:monster="monster"
                    v-bind:editingId="editingId"
                    v-on:death="onDeath"
                    v-on:editTodo="onEditTodo"
                    v-on:setEditingId="SET_EDITTING_ID"
                    v-on:resetEditingId="RESET_EDITTING_ID"/>
        </ul>
    </div>
</template>

<script>
import MonsterElement from './MonsterElement.vue'
import { mapState, mapMutations, mapGetters } from 'vuex'
import { RESET_EDITTING_ID, SET_EDITTING_ID } from '../../store/mutation-types'
export default {
    components: {
        'monster-element': MonsterElement
    },
    computed: {
        ...mapGetters ([
            'getMonsterElements'
        ]),
        ...mapState ([
            'editingId'
        ]),
        monsterElements () {
            return this.getMonsterElements
        }
    },
    methods: {
        ...mapMutations ([
            SET_EDITTING_ID,
            RESET_EDITTING_ID
        ]),
        onDeath (id) {
            this.$emit('death', id)
        },
        onEditTodo (content, id) {
            this.$emit('editTodo', content, id)
        }
    }
}
</script>