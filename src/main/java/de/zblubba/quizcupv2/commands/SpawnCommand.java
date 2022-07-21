package de.zblubba.quizcupv2.commands;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

//1: -14.5 108.5 -30.5 ---- 9.5 109 -17.4
        if(sender instanceof Player p) {

            Material block = p.getLocation().subtract(0D, 2D, 0D).getBlock().getType();

            if(!(block == Material.DIAMOND_BLOCK)) {
                p.teleport(new Location(Bukkit.getWorlds().get(0), -2.5, 107, 8.5, 90, 0));
                p.sendMessage(Quizcupv2.getPrefix + "§aDu wurdest zum Spawn teleportiert!");
            } else {
                p.sendMessage(Quizcupv2.getPrefix + "§cDu kannst diesen Befehl in den Boxen nicht verwenden!");
            }

        }
        return false;
    }
}
