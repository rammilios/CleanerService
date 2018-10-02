package ru.innopolis.stc13.repository.pojo;

public class Client {
    private Integer client_d;
    private String name;
    private String adress;

    public Client(Integer client_d, String name, String adress) {
        this.client_d = client_d;
        this.name = name;
        this.adress = adress;
    }

    public Integer getClient_d() {
        return client_d;
    }

    public void setClient_d(Integer client_d) {
        this.client_d = client_d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_d=" + client_d +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
