package com.trsoftware.guipro;

import com.trsoftware.guipro.commands.CreateCommand;
import com.trsoftware.guipro.commands.MainCommand;
import com.trsoftware.guipro.commands.SetCommand;
import com.trsoftware.guipro.listeners.SetInventoryListener;
import com.trsoftware.guipro.managers.GUIManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIPro extends JavaPlugin {

    /**
     *     guipro.admin.create - /gui create <name> <title> <size>
     *     guipro.admin.set.inventory - /gui set inventory <name>
     */

    public GUIPro plugin;
    public MainCommand mc;
    public CreateCommand cc;
    public SetCommand sc;
    public GUIManager gm;
    public SetInventoryListener sil;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        initializeInstances();
        getCommand("gui").setExecutor(new MainCommand(this));
        gm.loadGUIs();
        Bukkit.getPluginManager().registerEvents(new SetInventoryListener(this), this);
    }

    @Override
    public void onDisable() {
        uninitializeInstances();
    }

    private void initializeInstances() {
        plugin = this;
        mc = new MainCommand(this);
        cc = new CreateCommand(this);
        sc = new SetCommand(this);
        gm = new GUIManager(this);
        sil = new SetInventoryListener(this);
    }

    private void uninitializeInstances() {
        plugin = null;
        mc = null;
        cc = null;
        sc = null;
        gm = null;
        sil = null;
    }

    public boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
