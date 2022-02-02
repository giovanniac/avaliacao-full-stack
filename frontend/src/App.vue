<template>
  <MainLayout>
    <router-view/>
  </MainLayout>
</template>

<script>
import MainLayout from '@/layouts/MainLayout.vue'
export default {
  name: 'App',
  components: {
    MainLayout
  }
}
</script>

<style>
body {
  background-color: #f0f0f0;
}
</style>
