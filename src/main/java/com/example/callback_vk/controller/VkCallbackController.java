package com.example.callback_vk.controller;

import com.example.callback_vk.dao.RatingDaoJdbc;
import com.example.callback_vk.db;
import com.example.callback_vk.models.message_new.Example;
import com.example.callback_vk.service.ApiVkService;
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
        ApiVkService apiVkService = new ApiVkService();
        Example example = gson.fromJson(requestBody, Example.class);
        try {
            if (example.getObject().getMessage().getText().toLowerCase().equals("дрочка игоря")||
                    example.getObject().getMessage().getText().toLowerCase().equals("дрочка")) {
                apiVkService.vk(apiVkService.rating());
            }

            if (example.getObject().getMessage().getText().toLowerCase().equals("+член")||
                    example.getObject().getMessage().getText().toLowerCase().equals("подрочить")) {
                RatingDaoJdbc ratingDaoJdbc = new RatingDaoJdbc();
                ratingDaoJdbc.addRating(example.getObject().getMessage().getReplyMessage().getFromId(), ratingDaoJdbc.getRating(example.getObject().getMessage().getReplyMessage().getFromId()) + 0.1);
                com.example.callback_vk.models.user_info.Example userInfo = apiVkService.getUserInfo(example.getObject().getMessage().getReplyMessage().getFromId());
                apiVkService.vk(userInfo.getResponse().get(0).getFirstName() + " " + userInfo.getResponse().get(0).getLastName() + " увеличен член на 0.1см");
            }

        } catch (NullPointerException e){
            e.printStackTrace();
        }

        if (db.start){
            db.start = false;
            return "a9457646";
        }

        return "ok"; // Верните "ok" в ответе ВКонтакте для подтверждения получения события
    }
    @GetMapping("/")
    public String index(){
        return "ok";
    }
}
