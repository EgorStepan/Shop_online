package com.example.demo.Controllers;

import com.example.demo.models.Goods;
import com.example.demo.secvices.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;


    @GetMapping("/")
    public String goods(Model model){
        model.addAttribute("goods", goodsService.getGoods());
        return "goods";
    }
    @GetMapping("/goods/{id}")
    public String GoodsInfo(@PathVariable int id, Model model){
        model.addAttribute("goods",goodsService.getProductById(id));
        return "Goods_info";
    }

    @PostMapping("/goods/create")
    public String createProduct(Goods good){
        goodsService.setGoods(good);
        return "redirect:/";

    }
    @PostMapping("/goods/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        goodsService.DeleteProduct(id);
        return "redirect:/";
  }

}
