<template>
  <Card class="card">
    {{dataset}}
  </Card>
</template>

<script>
import Card from '@/components/basic/Card.vue'

export default {
  name: 'History',
  data: () => {
    return {
      dataset: {}
    }
  },
  components: {
    Card
  },
  methods: {
    async getTransfers () {
      await this.$store.dispatch('Transfer/getTransfers')
      return this.$store.getters['Transfer/getTransfers']
    }
  },
  mounted () {
    this.getTransfers()
  }
}
</script>

<style scoped>
.card {
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    justify-content: flex-start;
    align-content: stretch;
    align-items: center;
    width: 300px;
}
.row {
  margin: 10px;
}
span {
    font-weight: bold;
    font-size: 20px;
}

</style>
