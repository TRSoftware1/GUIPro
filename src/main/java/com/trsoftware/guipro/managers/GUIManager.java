package com.trsoftware.guipro.managers;

import com.trsoftware.guipro.GUIPro;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class GUIManager {

    public GUIPro plugin;

    public GUIManager(GUIPro plugin) {
        this.plugin = plugin;
    }

    private ArrayList<String> guiNames = new ArrayList<>();

    public void loadGuiNames() {
        guiNames.clear();
        for(String key : plugin.getConfig().getConfigurationSection("guis").getKeys(false)) {
            guiNames.add(key);
        }
    }

    public boolean doesGUIAlreadyExist(String name) {
        if(guiNames.contains(name)) {
            return true;
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
    }

}
