<template>
  <div class="page-wrapper">
    <Navbar :routes="routes" />
    <div class="mainContent">
      <slot></slot>
    </div>
  </div>
</template>

<script>
import Navbar from '@/components/Navbar.vue'

export default {
  name: 'MainLayout',
  data () {
    return {
      name: '',
      routes: [
        {
          name: 'Transferência',
          to: '/'
        },
        {
          name: 'Histórico',
          to: '/about'
        }
      ]
    }
  },
  components: {
    Navbar
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Lato", "Arial", sans-serif;
}
.mainContent {
  width: 100%;
  height: auto;
  display: flex;
  padding: 50px 20px;
  justify-content: space-around;
}
</style>
