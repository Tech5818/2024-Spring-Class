package kr.hs.sdh.workbook2.entity;

import java.util.Objects;

public class Hamburger {
    private String name;
    private int price;
    private String imagePath;
    private boolean isNew;
    private boolean isRecommended;

    public Hamburger(String name, int price, String imagePath, boolean isNew, boolean isRecommended) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.isNew = isNew;
        this.isRecommended = isRecommended;
    }

    public Hamburger() {}

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isNew() {
        return isNew;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public void setIsRecommended(boolean isRecommended) {
        this.isRecommended = isRecommended;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if(obj instanceof Hamburger hamburger) {
            return this.name.contentEquals(hamburger.getName());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }
}
