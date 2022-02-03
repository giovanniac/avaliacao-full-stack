<template>
  <div class="container">
    {{label}}
    <input
      :type="type"
      class="custom-input"
      @input="onInputChange($event.target.value)"
      v-mask="mask"
      v-model="model"
    />
  </div>
</template>

<script>
export default {
  name: 'Input',
  data: () => {
    return {
      model: ''
    }
  },
  props: {
    label: {
      type: String,
      required: true
    },
    mask: {
      type: String,
      required: false,
      default: ''
    },
    type: {
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
</style>
