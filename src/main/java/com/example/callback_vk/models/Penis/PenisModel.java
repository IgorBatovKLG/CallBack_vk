package com.example.callback_vk.models.Penis;

public class PenisModel {

    public int id_user;
    public double rating;

    public PenisModel(int id_user, double rating) {
        this.id_user = id_user;
        this.rating = rating;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "PenisModel{" +
                "id_user=" + id_user +
                ", rating=" + rating +
                '}';
    }
}
