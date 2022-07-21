package de.zblubba.quizcupv2.fragensystem;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.commands.GateCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class WinnerCommand implements CommandExecutor {

    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    int greenXMin = -2, greenXMax = 1;
    int redXMin = -10, redXMax = -7;
    int blueXMin = -6, blueXMax = -3;
    int yellowXMin = 2, yellowXMax = 5;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("quizcup.winner")) {
                if (args.length == 1) {
                    if (args[0].contentEquals("green")) {
                        addPlayerToList(greenXMin, greenXMax, -38, -28);
                        p.sendMessage(Quizcupv2.getPrefix + "§7Es wurden alle Spieler von §agrün §7eingetragen!");
                        Bukkit.broadcastMessage(Quizcupv2.getPrefix + "§7Die Antwort §agrün §7war richtig!");
                    } else if (args[0].equalsIgnoreCase("red")) {
                        addPlayerToList(redXMin, redXMax, -38, -28);
                        p.sendMessage(Quizcupv2.getPrefix + "§7Es wurden alle Spieler von §crot §7eingetragen!");
                        Bukkit.broadcastMessage(Quizcupv2.getPrefix + "§7Die Antwort §crot §7war richtig!");
                    } else if (args[0].equalsIgnoreCase("blue")) {
                        addPlayerToList(blueXMin, blueXMax, -38, -28);
                        p.sendMessage(Quizcupv2.getPrefix + "§7Es wurden alle Spieler von §bblau §7eingetragen!");
                        Bukkit.broadcastMessage(Quizcupv2.getPrefix + "§7Die Antwort §bblau §7war richtig!");
                    } else if (args[0].equalsIgnoreCase("yellow")) {
                        addPlayerToList(yellowXMin, yellowXMax, -38, -28);
                        p.sendMessage(Quizcupv2.getPrefix + "§7Es wurden alle Spieler von §egelb §7eingetragen!");
                        Bukkit.broadcastMessage(Quizcupv2.getPrefix + "§7Die Antwort §egelb §7war richtig!");
                    }
                } else { p.sendMessage(Quizcupv2.getPrefix + "§cBenutze: /winner <green | red | blue | yellow>");}
            } else {
                p.sendMessage(Quizcupv2.geNoPerms);
            }
        } else { sender.sendMessage(Quizcupv2.getPrefix + "§cDu musst ein Spieler sein, um diesen Befehl nutzen zu können!");}
        return false;
    }
    public void addPlayerToList(int xmin, int xmax, int zmin, int zmax) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (players.getLocation().getX() >= xmin && players.getLocation().getX() <= xmax && players.getLocation().getZ() >= zmin && players.getLocation().getZ() <= zmax) {
                if(!players.hasPermission("quizcup.helper")) {
                    int pointsOfPlayer = config.getInt("names." + players.getName() + ".points");
                    config.set("names." + players.getName() + ".points", pointsOfPlayer+1);
                    try {
                        config.save(configFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}