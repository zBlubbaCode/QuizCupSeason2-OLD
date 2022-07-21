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

public class SetAntwortCommand implements CommandExecutor {

    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if(args.length == 3) {
                int numberQuestion = Integer.parseInt(args[0]);
                char letter = args[1].charAt(0);
                String path = args[2];

                if(numberQuestion == StartMultipleFrage.getCurrentQuestion()) {
                    if(config.getBoolean("names." + p.getName() + "." + path)) {
                        Location loc = p.getLocation();

                        switch (letter) {
                            case 'A' -> {
                                Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).setType(Material.RED_WOOL);
                                p.sendMessage(Quizcupv2.getFinalPrefix + "Die Antwort §cA §7wurde eingetragen!");
                            }
                            case 'B' -> {
                                Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).setType(Material.BLUE_WOOL);
                                p.sendMessage(Quizcupv2.getFinalPrefix + "Die Antwort §bB §7wurde eingetragen!");
                            }
                            case 'C' -> {
                                Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).setType(Material.LIME_WOOL);
                                p.sendMessage(Quizcupv2.getFinalPrefix + "Die Antwort §aC §7wurde eingetragen!");
                            }
                            case 'D' -> {
                                Bukkit.getWorlds().get(0).getBlockAt(loc.getBlockX(), 255, loc.getBlockZ()).setType(Material.YELLOW_WOOL);
                                p.sendMessage(Quizcupv2.getFinalPrefix + "Die Antwort §eD §7wurde eingetragen!");
                            }
                        }
                    } else {
                        p.sendMessage("1");
                    }
                }else {
                    p.sendMessage("2");
                    p.sendMessage(numberQuestion+ "");
                    p.sendMessage(StartMultipleFrage.getCurrentQuestion() + "");
                }
            }else {
                p.sendMessage("3");
            }
        }else {
            sender.sendMessage("4");
        }
        return false;
    }
}
