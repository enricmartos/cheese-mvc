package com.emartos.cheesemvc.models.forms;

import com.emartos.cheesemvc.models.Cheese;
import com.emartos.cheesemvc.models.Menu;

import javax.validation.constraints.NotNull;

//Contains the information necessary to create the form
//which adds a new item to a menu
public class AddMenuItemForm {

    @NotNull
    private int menuId;

    @NotNull
    private int cheeseId;

    //To render the dropdown menu of cheeses available
    private Iterable<Cheese> cheeses;

    private Menu menu;

    public AddMenuItemForm() {}

    public int getMenuId() {
        return menuId;
    }

    public AddMenuItemForm(Iterable<Cheese> cheeses, Menu menu) {
        this.cheeses = cheeses;
        this.menu = menu;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }

    public void setCheeses(Iterable<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
