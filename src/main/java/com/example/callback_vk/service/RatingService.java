package com.example.callback_vk.service;

import com.example.callback_vk.dao.RatingDaoJdbc;
import com.example.callback_vk.models.Penis.PenisModel;
import com.example.callback_vk.models.message_new.Example;
import com.example.callback_vk.models.user_info.Example_user;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class RatingService {

    public void addRating(Example example){
        RatingDaoJdbc ratingDaoJdbc = new RatingDaoJdbc();
        ApiVkService apiVkService = new ApiVkService();
        ratingDaoJdbc.addRating(example.getObject().getMessage().getReplyMessage().getFromId(), ratingDaoJdbc.getRating(example.getObject().getMessage().getReplyMessage().getFromId()) + 0.1);
        Example_user userInfo = apiVkService.getUserInfo(example.getObject().getMessage().getReplyMessage().getFromId());
        apiVkService.vk(userInfo.getResponse().get(0).getFirstName() + " " + userInfo.getResponse().get(0).getLastName() + " увеличен член на 0.1см");
    }

    public void addRatingMore(Example example){
        ApiVkService apiVkService = new ApiVkService();
        try {
            String s = example.getObject().getMessage().getText().toLowerCase().split(" ")[3];
            RatingDaoJdbc ratingDaoJdbc = new RatingDaoJdbc();
            ratingDaoJdbc.addRating(example.getObject().getMessage().getReplyMessage().getFromId(), ratingDaoJdbc.getRating(example.getObject().getMessage().getReplyMessage().getFromId()) + Integer.parseInt(s));
            Example_user userInfo = apiVkService.getUserInfo(example.getObject().getMessage().getReplyMessage().getFromId());
            apiVkService.vk(userInfo.getResponse().get(0).getFirstName() + " " + userInfo.getResponse().get(0).getLastName() + " увеличен член на " + s + "см");
        } catch (Exception e){
            log.warn(e.getMessage());
            apiVkService.vk("Ошибка при увелечении члена");
        }
    }

    public String printRating(){
        ApiVkService apiVkService = new ApiVkService();
        RatingDaoJdbc ratingDaoJdbc = new RatingDaoJdbc();
        StringBuilder stringBuilder = new StringBuilder();
        List<PenisModel> allRaring = ratingDaoJdbc.getAllRaring();
        stringBuilder.append("Размеры членов:\n");
        for (PenisModel penisModel : allRaring) {
            try {
                Example_user userInfo = apiVkService.getUserInfo(penisModel.id_user);
                stringBuilder.append(userInfo.getResponse().get(0).getFirstName()).append(" ").append(userInfo.getResponse().get(0).getLastName()).append(" - ").append(penisModel.rating).append(" см\n");
            }catch (IndexOutOfBoundsException e){
                log.warn(e.getMessage());
            }
        }
        return stringBuilder.toString();
    }
}

