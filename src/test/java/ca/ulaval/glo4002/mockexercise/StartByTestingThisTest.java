package ca.ulaval.glo4002.mockexercise;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class StartByTestingThisTest {

    private final String EMAIL = "test@beaubrun.com";

    private final String SKU = "12345";
    private final String A_NAME = "Monsieur Soleil";
    private final double A_PRICE = 2.2;

    private StartByTestingThis service;
    @Mock
    private CartFactory cartFactory;

    @Mock
    private Cart cart;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private InvoiceLine invoiceLine;

    @BeforeEach
    public void setUp() {
        service = new StartByTestingThis(cartFactory, productRepository);
        when(cartFactory.create(EMAIL)).thenReturn(cart);
    }

    @Test
    public void givenAnEmail_whenOneClickBuy_ThenCartIsCreated() {
        service.oneClickBuy(EMAIL, null);

        verify(cartFactory, times(1)).create(EMAIL);
    }

    @Test
    public void givenASKU_whenOneClickBuy_ThenProductIsFound() {
        service.oneClickBuy(EMAIL, SKU);

        verify(productRepository, times(1)).findBySku(SKU);
    }


    @Test
    public void givenProduct_whenCreatingANewProduct_ThenProductIsAdded(){
        Product product = new Product(SKU,A_NAME, A_PRICE);

        when(productRepository.findBySku(SKU)).thenReturn(product);
        service.oneClickBuy(EMAIL, SKU);

        verify(cart, times(1)).addProduct(product);
    }

    // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
    @Test
    public void givenCart_whenAddingItem_ThenInvoiceLineIsAdded(){
        Product product1 = new Product(SKU,A_NAME, A_PRICE);
        Product product2 = new Product(SKU + "2",A_NAME, A_PRICE);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(cart.getProducts()).thenReturn(productList);
        service.oneClickBuy(EMAIL, SKU);

        verify()
    }
}
