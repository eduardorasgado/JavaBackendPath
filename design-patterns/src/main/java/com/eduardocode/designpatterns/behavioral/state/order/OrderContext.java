package com.eduardocode.designpatterns.behavioral.state.order;

public class OrderContext {
    private OrderState currentState;
    private int orderId;
    private double totalCost;
    private boolean paid;
    private boolean delivered;
    private String address = "";

    public OrderContext(int orderId, double totalCost) {
        this.orderId = orderId;
        this.totalCost = totalCost;
        this.paid = false;
        this.delivered = false;
        currentState = new OrderPlaced();
    }

    public void pay(double payment) {
        if(payment == getTotalCost()) {
            setPaid(true);
            System.out.println("Thanks for your payment!");
        } else {
            setPaid(false);
            System.out.println("Please pay the total cost.");
        }

        update();
    }

    public void deliver() {
        update();
    }

    public void getStatus() {
        update();
        System.out.println("Status: " + getCurrentState().getName());
    }

    public void setAddressToDeliver(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isPaid() {
        return paid;
    }

    private void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public void update() {
        currentState.updateState(this);
    }

    public void setCurrentState(OrderState state) {
        currentState = state;
    }

    private OrderState getCurrentState() {
        return currentState;
    }
}
