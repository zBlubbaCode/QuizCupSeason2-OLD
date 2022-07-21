package de.zblubba.quizcupv2.commands;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZumStartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.start")) {

            Bukkit.broadcastMessage("§8 ");
            Bukkit.broadcastMessage("§8 ");
            Bukkit.broadcastMessage("§8 ");
            Bukkit.broadcastMessage("§8 ");
            Bukkit.broadcastMessage("§8 ");
            Bukkit.broadcastMessage("§8------------------------------------");
            Bukkit.broadcastMessage("§cACHTUNG §8| §7Es sollen sich bitte §calle sofort zum Start §7begeben!");
            Bukkit.broadcastMessage("§7Die nächste Frage folgt in Kürze!");
            Bukkit.broadcastMessage("§8------------------------------------");

            for(Player players : Bukkit.getOnlinePlayers()) {
                players.sendTitle("§4§c⚠", "§cSofort zum Start!", 1, 180, 1);
            }

        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }
        return false;
    }
}
