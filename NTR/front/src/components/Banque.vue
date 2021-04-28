<template>
  <div>
    <form v-if="this.loggedin === false">
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
    <div v-else>
      <p>
        username : {{ this.compte.username }}
      </p>
      <p>
        solde : {{ this.compte.balance }}
      </p>
    </div>
  </div>
</template>

<script>
import Api from '../api/Api';

export default {
  name: 'Banque',
  data() {
    return {
      loggedin: false,
      compte: {
        username: '',
        password: '',
        balance: 0,
        id: 0
      }
    };
  },
  methods: {
    async getCompte(username, password) {
      try {
        const response = await Api.getCompte(username, password);
        this.compte = response.body;
        this.loggedin = true;
      } catch (error) {
        console.error('Impossible de récupérer le compte');
      }
    }
  },
  mounted() {
    if (this.$route.params.username && this.$route.params.username !== '' && this.$route.params.id !== 0 && this.$route.params.password && this.$route.params.password !== '' && this.$route.params.password !== 0) {
      this.getCompte(this.$route.params.username, this.$route.params.password);
    }
  }
};
</script>

<style scoped>

</style>
