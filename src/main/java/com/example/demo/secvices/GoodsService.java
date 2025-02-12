package com.example.demo.secvices;

import com.example.demo.models.Goods;
import com.example.demo.models.Image;
import com.example.demo.models.User;
import com.example.demo.repositories.GoodsRepository;
import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;
    private final UserRepository userRepository;
    private List<Goods> goods = new ArrayList<>();

    public List<Goods> getGoods(String title) {

        List<Goods> goods = goodsRepository.findAll();
        if (title != null) {
            return goodsRepository.findByTitle(title);
        }
        return goodsRepository.findAll();
    }

    public void setGoods(Principal principal, Goods good, List<MultipartFile> files) throws IOException {
        good.setUser(getUserByPrincipal(principal));

        for (MultipartFile file : files) {
            if (file != null && file.getSize() > 0) {
                Image image = toImageEntity(file);
                if (good.getImages().isEmpty()) {
                    image.setPreviewImage(true);
                }
                good.addImageToGoods(image);
            }
        }

        log.info("Saving new Goods. Title: {}; Owner email: {}", good.getTitle(), good.getUser().getEmail());
        Goods goodFromDb = goodsRepository.save(good);

        if (!goodFromDb.getImages().isEmpty()) {
            goodFromDb.setPreviewImageId(goodFromDb.getImages().get(0).getId());
            goodsRepository.save(goodFromDb);
        }
    }

    public User getUserByPrincipal(Principal principal) {
        if(principal == null){
            return new User();
        }
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBites(file.getBytes());
        return image;
    }

    public void DeleteProduct(Long id) {
        goodsRepository.deleteById(id);
    }

    public Goods getProductById(Long id) {
        return goodsRepository.findById(id).orElse(null);
    }
}
