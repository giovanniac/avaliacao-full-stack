import api from '@/services/api.js'

const state = () => ({ transfers: {} })

const getters = {
  getTransfers: (state) => {
    return state.transfers
  }
}

const mutations = {
  setTransfers (state, payload) {
    state.transfers = payload
  }
}

const actions = {
  sendTransfer (context, payload) {
    api
      .post('/transfer', payload)
      .then(() => { console.log('Transferencia') })
      .catch((error) => { console.log(error) })
  },
  getTransfers (context, payload) {
    const setData = (data) => context.commit('setTransfers', data)
    api
      .get('/transfer')
      .then(setData)
      .catch((error) => { console.log(error) })
  }
}

export default {
  namespaced: true,
  getters,
  mutations,
  actions,
  state
}
