package com.trsoftware.guipro;

import com.trsoftware.guipro.commands.CreateCommand;
import com.trsoftware.guipro.commands.MainCommand;
import com.trsoftware.guipro.managers.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIPro extends JavaPlugin {

    /**
     * guipro.admin.create - /gui create <name> <title> <size>
     */

    public GUIPro plugin;
    public MainCommand mc;
    public CreateCommand cc;
    public GUIManager gm;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        initializeInstances();
        getCommand("gui").setExecutor(new MainCommand(this));
        gm.loadGuiNames();
    }

    @Override
    public void onDisable() {
        uninitializeInstances();
    }

    private void initializeInstances() {
        plugin = this;
        mc = new MainCommand(this);
        cc = new CreateCommand(this);
        gm = new GUIManager(this);
    }

    private void uninitializeInstances() {
        plugin = null;
        mc = null;
        cc = null;
        gm = null;
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
