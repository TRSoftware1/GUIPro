package com.trsoftware.guipro.commands;

import com.trsoftware.guipro.GUIPro;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateCommand {

    public GUIPro plugin;

    public CreateCommand(GUIPro plugin) {
        this.plugin = plugin;
    }

    public void createGUI(CommandSender sender, String[] args) {
        if (!sender.hasPermission("guipro.admin.create")) {
            //TODO send no perm message
            return;
        }

        if (plugin.gm.doesGUIAlreadyExist(args[1])) {
            //TODO send message, gui name taken
            return;
        }

        if (!plugin.isInt(args[3]) || Integer.parseInt(args[3]) % 9 != 0) {
            //TODO invalid size.
            return;
        }

        plugin.gm.createGUI(sender, args);

    }

}
