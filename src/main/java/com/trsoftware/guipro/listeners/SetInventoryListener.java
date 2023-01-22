package com.trsoftware.guipro.listeners;

import com.trsoftware.guipro.GUIPro;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SetInventoryListener implements Listener {

    public GUIPro plugin;

    public SetInventoryListener(GUIPro plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSetInventory(PlayerInteractEvent e) {
        if (!plugin.gm.isPlayerActiveCreator(e.getPlayer())) {
            return;
        }

        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && !e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            return;
        }

        if(e.getClickedBlock().getType().equals(Material.CHEST)) {
            Chest chest = (Chest) e.getClickedBlock().getState();
            plugin.gm.setGUIInventory(e.getPlayer(), chest.getInventory(), plugin.gm.getActiveGUIName());
        }

    }

}
