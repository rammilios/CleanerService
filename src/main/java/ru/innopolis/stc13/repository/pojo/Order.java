package ru.innopolis.stc13.repository.pojo;

public class Order {
    private Integer order_id;
    private String order_status;
    private Integer price;
    private String paid;
    private String comments;
    private String adress;

    public Order(Integer order_id, String order_status,
                 String paid, String comments, Integer price, String adress) {
        this.order_id = order_id;
        this.order_status = order_status;
        this.price = price;
        this.paid = paid;
        this.comments = comments;
        this.adress = adress;
    }

    public Order(String comments, String adress) {
        this.comments = comments;
        this.adress = adress;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_status='" + order_status + '\'' +
                ", price=" + price +
                ", paid='" + paid + '\'' +
                ", comments='" + comments + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
