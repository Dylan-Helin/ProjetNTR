<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>Nom du produit</th>
          <th>Prix</th>
          <th>Quantité</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="(produit, index) in produits"
          :key="index"
        >
          <td>
            {{ produit.name | upperCaseFilter }}
          </td>
          <td>
            {{ produit.price }}
          </td>
          <td>
            {{ produit.quantity }}
          </td>
          <td>
            <button
              type="button"
              @click="acheterProduit(produit)"
            >
              Acheter
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Api from "../api/Api";
export default {
  name: 'Ecommerce',
  data() {
    return {
      produits: []
    };
  },
  methods: {
    acheterProduit(produit) {
      this.$store.commit('saveProduit', produit);
      this.$router.push('/gateway');
    },
    async getAllProduit() {
      try {
        const response = await Api.getAllProduit();
        this.produits = response.body.content;
      } catch (error) {
        console.error('Une erreur est survenue lors de la récupération des produits');
      }
    }
  },
  async mounted() {
    await this.getAllProduit();
  }
};
</script>

<style scoped>

</style>
