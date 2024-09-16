package ca.ulaval.glo4002.mockexercise;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


public class StartByTestingThisTest {

    private StartByTestingThis service;
    @Mock
    private CartFactory cartFactory;

    private final String EMAIL = "test@beaubrun.com";

    @BeforeEach
    public void setUp() {
        service = new StartByTestingThis(cartFactory);
    }

    @Test
    public void givenAnEmail_whenOneClickBuy_ThenCartIsCreated() {
        Cart cart = new Cart(EMAIL);
        when(cartFactory.create(EMAIL)).thenReturn(cart);

        service.oneClickBuy(EMAIL, null);

        verify(cartFactory, times(1));
    }
}
