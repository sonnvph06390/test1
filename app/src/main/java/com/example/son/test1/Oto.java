package com.example.son.test1;

public class Oto {
    public String id;
    public String name;
    public String price;

    public Oto() {
    }

    public Oto(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Oto(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
