<template>
  <div>
    <form>
      <p>
        Username :
        <input
          v-model="compte.username"
          type="text"
          required
        >
      </p>
      <p>
        password :
        <textarea v-model="compte.password" />
      </p>
      <button
        type="button"
        @click="getCompte(this.compte.username, this.compte.password)"
      >
        Connexion
      </button>
    </form>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Api from '../api/Api';

export default {
  name: 'Gateway',
  data() {
    return {
      compte: {
        username: '',
        password: '',
        balance: 0,
        id: 0
      }
    };
  },
  computed: {
    ...mapGetters({
      produit: "getProduit"
    })
  },
  methods: {
    async getCompte(username, password) {
      try {
        const response = await Api.getCompte(username, password);
        this.compte = response.body;
        await Api.updateCompte(this.compte, this.produit.price * -1);
        await Api.updateProduit(this.produit, 1);
        this.$router.push('/ecommerce');
      } catch (error) {
        console.error('Impossible de récupérer le compte');
      }
    }
  }
};
</script>

<style scoped>

</style>
