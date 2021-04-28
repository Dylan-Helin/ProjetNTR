import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    produit: {
      id: 0,
      name: '',
      price: 0,
      quantity: 0
    }
  },
  mutations: {
    saveProduit(state, produit) {
      state.produit = produit;
    }
  },
  getters: {
    getProduit(state) {
      return state.produit;
    }
  }
});
