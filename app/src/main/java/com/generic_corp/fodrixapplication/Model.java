package com.generic_corp.fodrixapplication;

public class Model {
    private String Photographer_Type;
    private String Name;
    private String Number;
    private String Image_Url;
    private String Rating;
    private String Description;
    private Model(){}

    public Model(String photographer_Type, String name, String number, String image_Url, String rating, String description) {
        Photographer_Type = photographer_Type;
        Name = name;
        Number = number;
        Image_Url = image_Url;
        Rating = rating;
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public void setPhotographer_Type(String photographer_Type) {
        Photographer_Type = photographer_Type;
    }

    public void setImage_Url(String image_Url) {
        Image_Url = image_Url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getPhotographer_Type() {
        return Photographer_Type;
    }

    public String getImage_Url() {
        return Image_Url;
    }
}
