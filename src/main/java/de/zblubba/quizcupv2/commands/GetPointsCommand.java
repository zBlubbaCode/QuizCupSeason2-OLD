package de.zblubba.quizcupv2.commands;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class GetPointsCommand implements CommandExecutor {

    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.points")) {
            if(args.length == 1) {
                int value = Integer.parseInt(args[0]);
                sender.sendMessage(Quizcupv2.getFinalPrefix + "Spieler mit §c" + value + " §7Punkten");

                for(Player players : Bukkit.getOnlinePlayers()) {
                    int points = config.getInt("names." + players.getName() + ".points");

                    if(points == value) {
                        sender.sendMessage("§a" + players.getName());
                    }
                }

            } else {
                sender.sendMessage("§cNutze: /getpoints <punkte>");
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }
        return false;
    }
}
