package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;

public class StartByTestingThis {

    private final CartFactory cartFactory;
    public StartByTestingThis(CartFactory cartFactory){
        this.cartFactory = cartFactory;
    }

    public Invoice oneClickBuy(String clientEmail, String productSku) {
        // Étape 1 : Créer le cart avec le CartFactory
        // Étape 2 : Trouver le produit avec le ProductRepository
        // Étape 3 : Ajouter le produit au cart
        // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
        // Étape 5 : Retourner l'invoice
        return null;
    }
}
