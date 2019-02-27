package org.pursuit.unit4review_intent_fragment_recyclerview_picasso_weavejson.model;

public class Weave {

    private String name;
    private String texture;
    private String length;
    private String color;
    private String image;

    private Weave(){}

    public Weave(String name, String texture, String length, String color, String image) {
        this.name = name;
        this.texture = texture;
        this.length = length;
        this.color = color;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getTexture() {
        return texture;
    }

    public String getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
