package com.example.demo.Controllers;

import com.example.demo.models.Goods;
import com.example.demo.secvices.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;


    @GetMapping("/")
    public String goods(@RequestParam(name = "title", required = false) String title,Principal principal, Model model){
        model.addAttribute("goods", goodsService.getGoods(title));
        model.addAttribute("user", goodsService.getUserByPrincipal(principal));
        return "goods";
    }
    @GetMapping("/goods/{id}")
    public String GoodsInfo(@PathVariable Long id, Model model){
        Goods goods = goodsService.getProductById(id);
        model.addAttribute("goods",goods);
        model.addAttribute("images",goods.getImages());
        return "Goods_info";
    }
    @PostMapping("/goods/create")
    public String createProduct(@RequestParam("files") List<MultipartFile> files,
                                Goods good, Principal principal) throws IOException {
        goodsService.setGoods(principal, good, files);
        return "redirect:/";
    }

    @PostMapping("/goods/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        goodsService.DeleteProduct(id);
        return "redirect:/";
  }

}
