<template>
  <div class="home">
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
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'Home',
  components: {
  }
}
</script>
