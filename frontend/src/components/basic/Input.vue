<template>
  <input
    type="text"
    :placeholder="label"
    class="custom-input"
    @input="onInputChange($event.target.value)"
  />
</template>

<script>
export default {
  name: 'Input',
  props: {
    label: {
      type: String,
      required: true
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
</style>
