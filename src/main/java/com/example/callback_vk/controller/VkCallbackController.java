package com.example.callback_vk.controller;

import com.example.callback_vk.dao.RatingDaoJdbc;
import com.example.callback_vk.db;
import com.example.callback_vk.models.message_new.Example;
import com.example.callback_vk.models.user_info.Example_user;
import com.example.callback_vk.service.ApiVkService;
import com.example.callback_vk.service.RatingService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VkCallbackController {

    @PostMapping("/callback")
    public String handleCallback(@RequestBody String requestBody) {
        Gson gson = new Gson();
        RatingService ratingService= new RatingService();
        Example example = gson.fromJson(requestBody, Example.class);
        try {
            switch (example.getObject().getMessage().getText().toLowerCase()) {
                case ("дрочка игоря"):
                case ("дрочка"):
                    ratingService.printRating();
                    break;
                case ("+член"):
                case ("подрочить"):
                    ratingService.addRating(example);
                    break;
            }
            if(example.getObject().getMessage().getText().toLowerCase().contains("увеличить член на")){
                ratingService.addRatingMore(example);
            }
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        return "ok";
    }
    @GetMapping("/")
    public String index(){
        return "ok";
    }
}
