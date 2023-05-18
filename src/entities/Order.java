package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment = new Date();
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order() {
    }

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }
    public Double total() {
        double sum = 0;
        for (OrderItem oi : items) {
            sum += oi.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order Summary:%n"));
        sb.append(String.format("Order moment: %s%n", sdf.format(moment)));
        sb.append(String.format("Order status: %s%n", status));
        sb.append(String.format("Client: %s%n", client));
        sb.append(String.format("Order items:%n"));
        for (OrderItem oi : items) {
            sb.append(String.format("    %s%n", oi));
        }
        sb.append(String.format("Total price: $%.2f%n", total()));
        return sb.toString();
    }
}
