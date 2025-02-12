package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "goods")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
    private LocalDateTime dateOfCreate;

    @PrePersist
    private void init(){
        dateOfCreate = LocalDateTime.now();
    }

    public void addImageToGoods(Image image){
        image.setGoods(this);
        images.add(image);

    }

}
