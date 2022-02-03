<template>
  <div class="container">
    {{label}}:
    <select
      class="custom-selector"
      @change="onInputChange($event.target.value)"
      :value="value"
    >
      <option v-for="option in options" :key="option.name" :value="option.value">{{option.name}}</option>
    </select>
  </div>
</template>

<script>
export default {
  name: 'Select',
  props: {
    value: {
      type: String,
      required: true
    },
    label: {
      type: String,
      required: true
    },
    options: {
      type: Array,
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
