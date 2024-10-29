package kr.hs.sdh.toast;

import java.util.List;

public class Menu {
    private String name;

    private List<Menu> menus;

    private Boolean isActive;

    public Menu(String name) {
        this.name = name;
    }

    public Menu(String name, List<Menu> menus) {
        this.name = name;
        this.menus = menus;
    }

    public Menu(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
