<template>
  <header>
    <v-btn variant="outlined" v-if="member.data == null" @click="login">로그인</v-btn>
    <v-btn variant="outlined" v-if="member.data != null" @click="logout">로그아웃</v-btn>
  </header>
</template>
<script>
export default {
  data() {
    return {
      member : Object
    }
  },
  methods: {
    login() {

    },
    logout() {

    }
  }
}


</script>