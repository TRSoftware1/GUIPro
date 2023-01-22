package com.trsoftware.guipro;

public class GUI {

    private String name;
    private String title;
    private int size;
    private String inventory;

    public GUI(String name, String title, int size, String inventory) {
        setName(name);
        setTitle(title);
        setSize(size);
        setInventory(inventory);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
}
