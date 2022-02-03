<template>
  <table>
    <tr>
      <td
        v-for="data in dataset" :key="data.name"
      >
        Company
      </td>
    </tr>

  </table>
</template>

<script>
export default {
  name: 'Table',
  props: {
    headers: {
      label: Array,
      required: true
    },
    dataset: {
      label: Array,
      required: true
    }
  },  
}
</script>

<style>

</style>