<template>
  <div>
    <div v-show="dataset.length > 0">
      <Table :dataset="dataset" :headers="headers" :formatters="formatters" />
    </div>
  </div>
</template>

<script>
import Table from '@/components/Table.vue'
import { mapGetters } from 'vuex'

const formatValueToReais = (value) => parseFloat(value).toLocaleString('pt-br', { style: 'currency', currency: 'BRL' })
const formatDate = (date) => new Date(date).toLocaleDateString()

export default {
  name: 'History',
  data: () => {
    return {
      headers: {
        id: 'Id',
        fromAccount: 'Conta Origem',
        toAccount: 'Conta Destino',
        taxes: 'Taxa',
        value: 'Valor',
        scheduleDate: 'Data de Agendamento',
        transferDate: 'Data de Transferência',
        operationType: 'Tipo de Operação'
      },
      formatters: {
        taxes: formatValueToReais,
        value: formatValueToReais,
        scheduleDate: formatDate,
        transferDate: formatDate
      }
    }
  },
  components: {
    Table
  },
  computed: {
    ...mapGetters({
      dataset: 'Transfer/getTransfers'
    })
  },
  methods: {
    getTransfers () {
      this.$store.dispatch('Transfer/getTransfers')
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
