package com.example.demo.models;

import lombok.*;
@NoArgsConstructor
@Data
public class Goods {
    private long Id;
    private String title;
    private String description;
    private double price;
    private String city;
    private String owner;

    public Goods(long Id, String title, String description, double price, String city, String owner) {
        this.Id = Id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.city = city;
        this.owner = owner;
    }

    public long getId() {
        return this.Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Goods;
    }

}
