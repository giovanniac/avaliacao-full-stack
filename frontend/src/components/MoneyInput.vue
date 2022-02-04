<template>
  <div class="container">
    {{label}} (R$)
    <input
      class="custom-input"
      :value="value"
      @input="onInputChange($event.target.value)"
      :class="{ 'invalid': isInvalid }"
      type="number"
    />
    <span :class="{ 'invalid-message': isInvalid, 'hide-message': !isInvalid }">
      {{validationMessage}}
    </span>
  </div>
</template>

<script>
export default {
  name: 'MoneyInput',
  props: {
    value: {
      type: String,
      required: true
    },
    label: {
      type: String,
      required: true
    },
    isInvalid: {
      type: Boolean,
      required: true,
      default: true
    },
    validationMessage: {
      type: String,
      required: false,
      default: ''
    }
  },
  methods: {
    onInputChange (inputValue) {
      this.$emit('input', inputValue)
    }
  }
}
</script>

<style scoped>
.custom-input{
   font-weight: bold;
   min-height: 35px;
   padding: 6px 15px;
   border-radius: 5px;
   outline: none;
   border: none;
   background: #F6F7F9;
   color: #748194;
   font-size: 14px;
}
.container {
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    justify-content: space-between;
    align-content: stretch;
    align-items: left;
    font-size: 14px;
    color: #525252;
}
.invalid {
  border: 2px solid red;
  border-radius: 5px;
}
.invalid-message {
  font-size: 10px;
  color: red;
}
.hide-message {
  display: none;
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}
</style>
