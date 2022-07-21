package de.zblubba.quizcupv2.commands;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PointsCommand implements CommandExecutor {

    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.points")) {
            if(args.length >= 2) {
                String target = args[1];
                if(args[0].equalsIgnoreCase("get")) {
                    int value = config.getInt("names." + target + ".points");
                    sender.sendMessage(Quizcupv2.getPrefix + "Der Spieler §a" + target + " §7hat §c" + value + " §7Punkte!");
                } else if(args[0].equalsIgnoreCase("add")) {
                    int value = Integer.parseInt(args[2]);
                    int points = config.getInt("names." + target + ".points");
                    config.set("names." + target + ".points", points + value);
                    sender.sendMessage(Quizcupv2.getPrefix + "Die Punkte des Spielers §a" + target + " §7wurden auf §c" + Integer.parseInt(String.valueOf(value + points)) + " §7gesetzt!");
                } else if(args[0].equalsIgnoreCase("set")) {
                    int value = Integer.parseInt(args[2]);
                    config.set("names." + target + ".points", value);
                    sender.sendMessage(Quizcupv2.getPrefix + "Die Punkte des Spielers §a" + target + " §7wurden auf §c" + value + " §7gesetzt!");
                } else {
                    sender.sendMessage(Quizcupv2.getPrefix + "§cNutze: /points <get | set | add> <name>");
                }

                try {
                    config.save(configFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§cNutze: /points <get | set | add> <name>");
            }
        }
        return false;
    }
}
