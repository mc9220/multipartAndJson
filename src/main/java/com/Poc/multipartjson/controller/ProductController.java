package com.Poc.multipartjson.controller;

import com.Poc.multipartjson.entity.Product;
import com.Poc.multipartjson.entity.ProductDto;
import com.Poc.multipartjson.service.ProductServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveProduct(@Valid @ModelAttribute ProductDto product)
    {Product product1=new Product();
        try {
             product1=new ObjectMapper().readValue(product.getProduct(),Product.class);
                    System.out.println(product1);
            System.out.println(product.getThumb().getOriginalFilename());
            return new ResponseEntity<>(product1, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>("jason parsing error",HttpStatus.BAD_REQUEST);

        }
//        System.out.println(product1);
//        System.out.println(product);
    }
    @PostMapping("/add")
    public Product add(@Valid @RequestBody Product product)
    {
        return product;
    }
}
