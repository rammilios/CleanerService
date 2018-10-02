package ru.innopolis.stc13.repository.pojo;

public class Order {
    private Integer order_id;
    private String order_status;
    private Double price;
    private String paid;
    private String comments;

    public Order(Integer order_id, String order_status, Double price, String paid, String comments) {
        this.order_id = order_id;
        this.order_status = order_status;
        this.price = price;
        this.paid = paid;
        this.comments = comments;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_status='" + order_status + '\'' +
                ", price=" + price +
                ", paid='" + paid + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
