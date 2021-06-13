package com.example.paisadivide;


public class Data {
    int image;
    String name;
    String amount;

    public Data(int image, String name, String amount) {
        this.image = image;
        this.name = name;
        this.amount = amount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
