package com.example.callback_vk.service;

import com.example.callback_vk.dao.RatingDaoJdbc;

public class ratingService {

    public void idRating(int id){
        RatingDaoJdbc ratingDaoJdbc = new RatingDaoJdbc();
        double rating = ratingDaoJdbc.getRating(id);
        ratingDaoJdbc.addRating(id, rating + 0.1);
    }
}
