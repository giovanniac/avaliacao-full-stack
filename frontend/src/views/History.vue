<template>
  <div>
    <div v-if="dataset.lenght > 0">
      <Table :dataset="dataset" :headers="headers" />
    </div>
    <div v-else>
      <Card>
        <h1 class="row"> Sem dados! </h1>
      </Card>
    </div>
  </div>
</template>

<script>
import Table from '@/components/Table.vue'
import Card from '@/components/basic/Card.vue'

export default {
  name: 'History',
  data: () => {
    return {
      dataset: [],
      headers: {
        id: 'Id',
        fromAccount: 'Conta Origem',
        toAccount: 'Conta Destino',
        taxes: 'Taxa',
        value: 'Valor',
        scheduleDate: 'Data de Agendamento',
        transferDate: 'Data de Transferência',
        operationType: 'Tipo de Operação'
      }
    }
  },
  components: {
    Table,
    Card
  },
  methods: {
    getTransfers () {
      this.$store.dispatch('Transfer/getTransfers')
      this.dataset = this.$store.getters['Transfer/getTransfers']
    }
  },
  created () {
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
</style>
