<template>
   <button class="btn" @click="onClickChange">{{label}}</button>
</template>

<script>
export default {
  name: 'Button',
  props: {
    label: {
      label: String,
      required: true
    }
  },
  methods: {
    onClickChange (e) {
      this.$emit('click', e)
    }
  }
}
</script>

<style scoped>
.btn {
  font-weight: bold;
  width: 230px;
  margin: 0 35px 20px ;
  height: 45px;
  padding: 6px 15px;
  border-radius: 5px;
  outline: none;
  border: none;
  background: #23ada4;
  color: white;
  font-size: 14px;
}
.btn:hover{
  background: #1e968e;
}
</style>
