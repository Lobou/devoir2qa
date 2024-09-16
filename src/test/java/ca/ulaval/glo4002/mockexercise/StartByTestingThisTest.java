package ca.ulaval.glo4002.mockexercise;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
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
    private ProductRepository productRepository;

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
}
