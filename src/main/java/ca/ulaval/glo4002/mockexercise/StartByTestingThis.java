package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

public class StartByTestingThis {

    private final CartFactory cartFactory;
    private final ProductRepository productRepository;

    public StartByTestingThis(CartFactory cartFactory, ProductRepository productRepository) {
        this.cartFactory = cartFactory;
        this.productRepository = productRepository;
    }

    public Invoice oneClickBuy(String clientEmail, String productSku) {

        Cart cart = cartFactory.create(clientEmail);

        Product product = productRepository.findBySku(productSku);

        cart.addProduct(product);

        // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
        // Étape 5 : Retourner l'invoice
        return null;
    }
}
