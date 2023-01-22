package com.trsoftware.guipro.commands;

import com.trsoftware.guipro.GUIPro;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand {

    public GUIPro plugin;

    public SetCommand(GUIPro plugin) {
        this.plugin = plugin;
    }

    public void setInventory(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            //TODO send message must be player
            return;
        }

        if (!sender.hasPermission("guipro.admin.set.inventory")) {
            //TODO send message no permission
            return;
        }
    }

}
