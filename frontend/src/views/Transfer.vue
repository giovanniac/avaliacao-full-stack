<template>
  <div class="home">
    <Card class="card">
      <span class="row"> <b>Transferêcia</b> </span>
      <Input
        class="fullsize-row"
        label="Conta Origem"
        mask="######"
        v-model="model.fromAccount"
        :isInvalid="validations.fromAccount"
        validationMessage="Conta de origem inválida"
      />
      <Input
        class="fullsize-row"
        label="Conta Destino"
        type="text"
        mask="######"
        v-model="model.toAccount"
        :isInvalid="validations.toAccount"
        validationMessage="Conta destino inválida"
      />
      <MoneyInput
        class="fullsize-row"
        label="Valor"
        v-model="model.value"
        :isInvalid="validations.value"
        validationMessage="Valor inválido"
      />
      <Input
        class="fullsize-row"
        label="Data"
        type="datetime-local"
        v-model="model.transferDate"
        :isInvalid="validations.transferDate"
        validationMessage="Data inválida"
      />
      <Select
        class="fullsize-row"
        label="Tipo de Operação"
        :options="operations"
        v-model="model.operationType"
      />
      <Button class="fullsize-row" label="Enviar" @click="sendTransfer"/>
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
      validations: {
        fromAccount: false,
        toAccount: false,
        value: false,
        transferDate: false,
        operationType: false
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
    Select,
    MoneyInput
  },
  methods: {
    async sendTransfer () {
      if (this.validate(this.model)) {
        return
      }
      await this.$store.dispatch('Transfer/sendTransfer', this.model)
      this.model = {
        fromAccount: '',
        toAccount: '',
        value: '',
        transferDate: '',
        operationType: 'A'
      }
    },
    async getCotation () {
      await this.$store.dispatch('Transfer/getCotation', this.model)
      this.cotation = this.$store.getters['Transfer/getCotation']
    },
    validate (model) {
      const validations = this.validations
      const today = new Date()
      const transferDate = new Date(model.transferDate)
      validations.fromAccount = model.fromAccount.length < 6
      validations.toAccount = model.toAccount.length < 6
      validations.value = model.value <= 0
      validations.transferDate = model.transferDate.length <= 0 || transferDate < today // TODO: Desbugar
      return !!Object.keys(validations).find((key) => { return validations[key] === true })
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
