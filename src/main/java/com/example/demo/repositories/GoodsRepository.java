package com.example.demo.repositories;

import com.example.demo.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findByTitle(String title);
}
