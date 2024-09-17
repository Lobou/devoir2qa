package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;

import java.util.ArrayList;
import java.util.List;

public class InvoiceFactory {
    public Invoice create(String email, List<Product> produits) {
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        for (Product product : produits) {
            invoiceLines.add(new InvoiceLine(product.getName(), product.getPrice()));
        }

        return new Invoice(email, invoiceLines);
    }
}
