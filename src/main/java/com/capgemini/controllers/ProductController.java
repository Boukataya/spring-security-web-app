package com.capgemini.controllers;

import com.capgemini.entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public void allProducts(Model model) throws JsonProcessingException {
        String url = "https://dummyjson.com/products";
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productList;
        productList = Arrays.asList(mapper.readValue(url, Product[].class));
        System.out.println("productList = " + productList);

//        return "products";
    }

}
