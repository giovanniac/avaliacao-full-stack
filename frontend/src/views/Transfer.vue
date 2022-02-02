<template>
  <div class="home">
    <Card class="card">
      <span class="row"> <b>Transferêcia</b> </span>
      <Input class="row" label="Conta Origem" type="number" max="999999" v-model="model.fromAccount" />
      <Input class="row" label="Conta Destino" type="number" max="999999" v-model="model.toAccount" />
      <Input class="row" label="Valor" type="text" v-model="model.value" />
      <Input class="row" label="Data" type="datetime-local" v-model="model.schedulingDate" />
      <Select class="row" label="Tipo de Operação" :options="operations" v-model="model.operationType"/>
      <Button class="row" label="Enviar" @click="sendTransfer"/>
    </Card>
  </div>
</template>

<script>
import Input from '@/components/basic/Input.vue'
import Card from '@/components/basic/Card.vue'
import Button from '@/components/basic/Button.vue'
import Select from '@/components/basic/Select.vue'
import api from '@/api.js'

export default {
  name: 'Home',
  data: () => {
    return {
      model: {
        fromAccount: '',
        toAccount: '',
        value: '',
        schedulingDate: '',
        operationType: 'A'
      },
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
    Select
  },
  methods: {
    sendTransfer () {
      api
        .post('/transfer', this.model)
        .then(() => { console.log('Transferencia') })
        .catch((error) => { console.log(error) })
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
.row {
  margin: 10px;
}
span {
    font-weight: bold;
    font-size: 20px;
}

</style>
