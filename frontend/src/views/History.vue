<template>
  <Table :dataset="dataset" :headers="headers" />
</template>

<script>
import Table from '@/components/Table.vue'

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
        scheduleDate: 'Data Agendada',
        transferDate: 'Data de Transferência',
        operationType: 'Tipo de Operação'
      }
    }
  },
  components: {
    Table
  },
  methods: {
    async getTransfers () {
      await this.$store.dispatch('Transfer/getTransfers')
      this.dataset = this.$store.getters['Transfer/getTransfers']
    }
  },
  created () {
    this.getTransfers()
  }
}
</script>

<style scoped>
.row {
  margin: 10px;
}
span {
    font-weight: bold;
    font-size: 20px;
}

</style>
