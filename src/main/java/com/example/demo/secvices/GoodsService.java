package com.example.demo.secvices;

import com.example.demo.models.Goods;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    private List<Goods> goods = new ArrayList<>();
    private long ID=0;

    {
        goods.add(new Goods(++ID,"milk","Goods price",1234.2,"Kharkiv","Egor"));
        goods.add(new Goods(++ID,"toy","Goods price",2334.2,"Kharkiv","Gleb"));
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Goods good) {
        good.setId(++ID);
        goods.add(good);
    }
    public void DeleteProduct(int id){
        goods.removeIf(product->product.getId()== id);
    }

    public Goods getProductById(int id) {
        for(Goods good: goods){
            if(good.getId()==id){
                return good;
            }
        }
        return null;
    }
}
