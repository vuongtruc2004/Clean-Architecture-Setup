package org.yourapp.order.model;

import org.yourapp.shared.model.Money;

public class OrderItem {
    private Long id;
    private final Long productId;
    private final Quantity quantity;
    private final Money unitPrice;

    private OrderItem(Long id, Long productId, Quantity quantity, Money unitPrice) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // create new order item
    public static OrderItem create(Long productId, Quantity quantity, Money unitPrice) {
        return new OrderItem(null, productId, quantity, unitPrice);
    }

    // reconstitute order item from DB
    public static OrderItem reconstitute(Long id, Long productId, Quantity quantity, Money unitPrice) {
        return new OrderItem(id, productId, quantity, unitPrice);
    }

    public Money subtotal() {
        return unitPrice.multiply(quantity.getValue());
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
