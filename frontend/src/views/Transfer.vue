<template>
  <div class="home">
    <Card class="card">
      <Input class="input" label="Conta Origem" v-model="model.fromAccount" />
      <Input class="input" label="Conta Destino" v-model="model.toAccount" />
      <Input class="input" label="Valor" v-model="model.value" />
      <Input class="input" label="Data" v-model="model.schedulingDate" />
      <Button class="input" label="Enviar" @click="sendTransfer()"/>
    </Card>
  </div>
</template>

<script>
import Input from '@/components/basic/Input.vue'
import Card from '@/components/basic/Card.vue'
import Button from '@/components/basic/Button.vue'
import api from '@/api.js'

export default {
  name: 'Home',
  data: () => {
    return {
      model: {
        fromAccount: '',
        toAccount: '',
        value: '',
        schedulingDate: ''
      }
    }
  },
  components: {
    Input,
    Card,
    Button
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
    width: 100%;
}
.input {
  margin: 10px;
}

</style>
