<template>
  <Card class="card">
    {{dataset}}
  </Card>
</template>

<script>
import api from '@/api.js'
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
    getTransfers () {
      api
        .get('/transfer', this.model)
        .then((data) => { this.dataset = data })
        .catch((error) => { console.log(error) })
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
