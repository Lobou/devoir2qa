package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartFactoryTest {

    CartFactory cartFactory;
    final String EMAIL = "test@beaubrun.com";

    @BeforeEach
    public void setUp() {
        cartFactory = new CartFactory();
    }

    @Test
    public void givenAnEmail_whenCreateCart_ReturnsCartWithEmail() {
        Cart ca

        Cart resultCart = cartFactory.create(EMAIL);

        Assertions.assertEquals();
    }
}
