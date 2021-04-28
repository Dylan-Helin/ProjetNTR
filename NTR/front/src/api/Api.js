import Vue from 'vue';
const BASE_URL_ECOMMERCE = 'http://localhost:5001/';
const BASE_URL_BANQUE = 'http://localhost:5000/';

export default {
  getCompteById(Id) {
    return Vue.http.get(`${BASE_URL_BANQUE}/comptes/${Id}`);
  },
  getCompte(username, password) {
    return Vue.http.get(`${BASE_URL_BANQUE}/comptes/${username}/${password}`);
  },
  getAllCompte() {
    return Vue.http.get(`${BASE_URL_BANQUE}/comptes`);
  },
  createCompte(compte) {
    return Vue.http.post(`${BASE_URL_BANQUE}/comptes`, {
      ...compte
    });
  },
  updateCompte(compte, montant) {
    return Vue.http.put(`${BASE_URL_BANQUE}/comptes/${compte.id}/${montant}`);
  },
  getProduit(Id) {
    return Vue.http.get(`${BASE_URL_ECOMMERCE}/produits/${Id}`);
  },
  getAllProduit() {
    return Vue.http.get(`${BASE_URL_ECOMMERCE}/produits`);
  },
  createProduit(produit) {
    return Vue.http.post(`${BASE_URL_ECOMMERCE}/produits`, {
      ...produit
    });
  },
  updateProduit(produit, montant) {
    return Vue.http.put(`${BASE_URL_ECOMMERCE}/${produit.id}/${montant}`);
  }
};
