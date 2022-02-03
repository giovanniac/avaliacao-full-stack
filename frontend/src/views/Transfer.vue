<template>
  <div class="home">
    <Card class="card">
      <span class="row"> <b>Transferêcia</b> </span>
      <Input
        class="fullsize-row"
        label="Conta Origem"
        mask="######"
        v-model="model.fromAccount"
      />
      <Input
        class="fullsize-row"
        label="Conta Destino"
        type="number"
        mask="######"
        v-model="model.toAccount"
      />
      <MoneyInput
        class="fullsize-row"
        label="Valor"
        type="text"
        v-model="model.value"
      />
      <Input
        class="fullsize-row"
        label="Data"
        type="date"
        v-model="model.transferDate"
      />
      <Select
        class="fullsize-row"
        label="Tipo de Operação"
        :options="operations"
        v-model="model.operationType"
      />
      <div class="row">
        <Button label="Cotar" @click="getCotation"/>
        <Button label="Enviar" @click="sendTransfer"/>
      </div>
    </Card>
  </div>
</template>

<script>
import Input from '@/components/basic/Input.vue'
import Card from '@/components/basic/Card.vue'
import Button from '@/components/basic/Button.vue'
import Select from '@/components/basic/Select.vue'
import MoneyInput from '@/components/MoneyInput.vue'

export default {
  name: 'Home',
  data: () => {
    return {
      model: {
        fromAccount: '',
        toAccount: '',
        value: '',
        transferDate: '',
        operationType: 'A'
      },
      cotation: {},
      operations: [
        {
          name: 'A',
          value: 'A'
        },
        {
          name: 'B',
          value: 'B'
        },
        {
          name: 'C',
          value: 'C'
        },
        {
          name: 'D',
          value: 'D'
        }
      ]
    }
  },
  components: {
    Input,
    Card,
    Button,
    Select,
    MoneyInput
  },
  methods: {
    async sendTransfer () {
      await this.$store.dispatch('Transfer/sendTransfer', this.model)
      this.model = {
        fromAccount: '',
        toAccount: '',
        value: '',
        scheduleDate: '',
        operationType: 'A'
      }
    },
    async getCotation () {
      await this.$store.dispatch('Transfer/getCotation', this.model)
      this.cotation = this.$store.getters['Transfer/getCotation']
    }
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
.fullsize-row {
  margin: 10px;
  width: 250px;
}
.row {
  margin: 10px;
}
span {
  font-weight: bold;
  font-size: 20px;
}

</style>
