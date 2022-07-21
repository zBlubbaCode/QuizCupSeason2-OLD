package de.zblubba.quizcupv2.fragensystem;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.Bukkit;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TableCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.admin")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("1")) {
                    sender.sendMessage(Quizcupv2.getPrefix + "1. Crafting Frage geöffnet");
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        Chest chest = (Chest) Bukkit.getWorlds().get(0).getBlockAt(-29, 121, -16).getState();
                        players.openInventory(chest.getInventory());
                    }
                } else if(args[0].equalsIgnoreCase("2")) {
                    sender.sendMessage(Quizcupv2.getPrefix + "2. Crafting Frage geöffnet");
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        Chest chest = (Chest) Bukkit.getWorlds().get(0).getBlockAt(-29, 121, -18).getState();
                        players.openInventory(chest.getInventory());
                    }
                } else if(args[0].equalsIgnoreCase("3")) {
                    sender.sendMessage(Quizcupv2.getPrefix + "3. Crafting Frage geöffnet");
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        Chest chest = (Chest) Bukkit.getWorlds().get(0).getBlockAt(-29, 121, -20).getState();
                        players.openInventory(chest.getInventory());
                    }
                } else {
                    sender.sendMessage(Quizcupv2.getPrefix + "§cNutze /table <1 | 2 | 3>");
                }
            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§cNutze /table <1 | 2 | 3>");
            }



        }
        return false;
    }
}
