package com.trsoftware.guipro.commands;

import com.trsoftware.guipro.GUIPro;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    public GUIPro plugin;

    public MainCommand(GUIPro plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(cmd.getName().equalsIgnoreCase("gui")) {

            switch (args.length) {
                case 1:

                    break;

                case 4:
                    if(args[0].equalsIgnoreCase("create")) {
                        plugin.cc.createGUI(sender, args);
                    }
                    break;

                case 5:
                    if(args[0].equalsIgnoreCase("create")) {
                        plugin.cc.createGUI(sender, args);
                    }
                    break;

                default:
                    //TODO help menu
                    break;
            }

        }

        return true;
    }
}
