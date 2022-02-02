<template>
  <select
    class="custom-selector"
    @input="onInputChange($event.target.value)"
  >
    <option v-for="option in options" :key="option.name" value="option.value">{{option.name}}</option>
  </select>
</template>

<script>
export default {
  name: 'Select',
  props: {
    options: {
      type: Array,
      required: true
    }
  },
  methods: {
    onInputChange (inputValue) {
      this.$emit('change', inputValue)
    }
  }
}
</script>

<style scoped>
.custom-selector{
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
