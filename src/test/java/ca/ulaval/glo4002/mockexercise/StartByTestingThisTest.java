package ca.ulaval.glo4002.mockexercise;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class StartByTestingThisTest {

    private StartByTestingThis service;
    @Mock
    private CartFactory cartFactory;

    @Mock
    private Cart cart;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private InvoiceLine invoiceLine;

    private final String EMAIL = "test@beaubrun.com";

    private final String SKU = "12345";

    @BeforeEach
    public void setUp() {
        service = new StartByTestingThis(cartFactory, productRepository);
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
        Product product = new Product(SKU,"A name", 2.2);

        when(cartFactory.create(EMAIL)).thenReturn(cart);
        when(productRepository.findBySku(SKU)).thenReturn(product);
        service.oneClickBuy(EMAIL, SKU);

        verify(cart, times(1)).addProduct(product);
    }

    // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
    @Test
    public void givenCart_whenAddingItem_ThenInvoiceLineIsAdded(){
        Product product = new Product(SKU,"A name", 2.2);
        Invoice invoice = new Invoice(SKU,"A name", 2.2);
        InvoiceLine invoiceLine = new InvoiceLine(invoice);

        when(cartFactory.create(EMAIL)).thenReturn(cart);
        when(cart.getProducts()).thenReturn();
        service.oneClickBuy(EMAIL, SKU);
    }
}
