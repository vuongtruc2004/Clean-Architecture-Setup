package org.yourapp.order.model;

import org.yourapp.shared.model.Money;

public class OrderItem {
    private Long id;
    private final Long productId;
    private final Quantity quantity;
    private final Money unitPrice;

    private OrderItem(Long productId, Quantity quantity, Money unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // static factory method
    public static OrderItem create(
            Long productId,
            Quantity quantity,
            Money unitPrice
    ) {
        return new OrderItem(productId, quantity, unitPrice);
    }

    public Money subtotal() {
        return unitPrice.multiply(quantity);
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }
}
