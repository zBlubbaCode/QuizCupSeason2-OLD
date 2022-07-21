package de.zblubba.quizcupv2.fragensystem;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class FinalWinnerCommand implements CommandExecutor {

    String path;

    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.helper")) {
            if(args.length >= 1) {
                char answer = args[0].charAt(0);
                if(args.length == 1) {
                    path = "hfinal";
                } else if(args.length == 2) {
                    if(args[1].equalsIgnoreCase("final")) {
                        path = "final";
                    }
                }
                for(Player players : Bukkit.getOnlinePlayers()) {
                    if(config.getBoolean("names." + players.getName() + "." + path)) {
                        Location loc = players.getLocation();

                        switch(answer) {
                            case 'A' -> {
                                players.sendMessage(Quizcupv2.getFinalPrefix + "§cA §7war die richtige Antwort!");
                                if(Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).getType() == Material.RED_WOOL) {
                                    int pointsOfPlayer = config.getInt("names." + players.getName() + ".points"); config.set("names." + players.getName() + ".points", pointsOfPlayer+1);
                                    Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).setType(Material.AIR);
                                }
                            }
                            case 'B' -> {
                                players.sendMessage(Quizcupv2.getFinalPrefix + "§bB §7war die richtige Antwort!");
                                if(Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).getType() == Material.BLUE_WOOL) {
                                    int pointsOfPlayer = config.getInt("names." + players.getName() + ".points"); config.set("names." + players.getName() + ".points", pointsOfPlayer+1);
                                    Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).setType(Material.AIR);
                                }
                            }
                            case 'C' -> {
                                players.sendMessage(Quizcupv2.getFinalPrefix + "§aC §7war die richtige Antwort!");
                                if(Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).getType() == Material.LIME_WOOL) {
                                    int pointsOfPlayer = config.getInt("names." + players.getName() + ".points"); config.set("names." + players.getName() + ".points", pointsOfPlayer+1);
                                    Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).setType(Material.AIR);
                                }
                            }
                            case 'D' -> {
                                players.sendMessage(Quizcupv2.getFinalPrefix + "§eD §7war die richtige Antwort!");
                                if(Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).getType() == Material.YELLOW_WOOL) {
                                    int pointsOfPlayer = config.getInt("names." + players.getName() + ".points"); config.set("names." + players.getName() + ".points", pointsOfPlayer+1);
                                    Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).setType(Material.AIR);
                                }
                            }

                        }
                        try {
                            config.save(configFile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§cNutze: /finalwinner <A | B | C | D>");
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }
        return false;
    }
}
