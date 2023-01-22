package com.trsoftware.guipro.managers;

import com.trsoftware.guipro.GUI;
import com.trsoftware.guipro.GUIPro;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class GUIManager {

    public GUIPro plugin;

    public GUIManager(GUIPro plugin) {
        this.plugin = plugin;
    }

    private ArrayList<GUI> guis = new ArrayList<GUI>();
    private Player activeGUICreator = null;
    private String activeGUIName = "";

    public boolean isPlayerActiveCreator(Player p) {
        if(!activeGUICreator.equals(null)) {
            if(activeGUICreator.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void loadGUIs() {
        guis.clear();
        for(String key : plugin.getConfig().getConfigurationSection("guis").getKeys(false)) {
            guis.add(new GUI(key, plugin.getConfig().getString("guis." + key + ".title"), plugin.getConfig().getInt("guis." + key + ".size"), plugin.getConfig().getString("guis." + key + ".inventory")));
        }
    }

    public boolean doesGUIAlreadyExist(String name) {
        for(int i = 0; i < guis.size(); i++) {
            if(guis.get(i).getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void createGUI(CommandSender sender, String[] args) {
        String name = args[1];
        String title = args[2];
        int size = Integer.parseInt(args[3]);
        plugin.getConfig().set("guis." + name + ".title", title.replaceAll("_", " "));
        plugin.getConfig().set("guis." + name + ".size", size);

        plugin.saveConfig();

        loadGUIs();
    }

    public void setGUIInventory(Player p, Inventory inventory, String name) {

    }

    public String getActiveGUIName() {
        return activeGUIName;
    }

    public void setActiveGUIName(String activeGUIName) {
        this.activeGUIName = activeGUIName;
    }
}
