import api from '@/services/api.js'

const state = () => ({
  transfers: {},
  cotation: {}
})

const getters = {
  getTransfers: (state) => {
    return state.transfers
  },
  getCotation: (state) => {
    return state.cotation
  }
}

const mutations = {
  setTransfers (state, payload) {
    state.transfers = payload
  },
  setCotation (state, payload) {
    state.cotation = payload
  }
}

const actions = {
  sendTransfer (context, payload) {
    api
      .post('/transfer', payload)
      .catch((error) => { console.log(error) })
  },
  getTransfers (context, payload) {
    const setData = (data) => context.commit('setTransfers', data.data)
    api
      .get('/transfer')
      .then(setData)
      .catch((error) => { console.log(error) })
  },
  getCotation (context, payload) {
    const setData = (data) => context.commit('setCotation', data.data)
    api
      .post('/transfer/cotation', payload)
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
