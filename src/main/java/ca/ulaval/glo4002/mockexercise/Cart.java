package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final String email;
    private final List<Product> products = new ArrayList<>();

    private Invoice invoice = null;

    public Cart(String email) {
        this.email = email;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Invoice processInvoice() {
        invoiceLines /* TODO */
        invoice = new Invoice();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Cart
                && email.equals(((Cart) obj).email);
    }
}
