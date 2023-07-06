package com.example.growgh;
import com.google.gson.annotations.SerializedName;

public class ProductResult {
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
