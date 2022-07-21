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
import java.io.IOException;
import java.util.ArrayList;

public class StateCommand implements CommandExecutor {

    File configFile = new File("plugins/quizcup", "allowedplayers.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);
    public static boolean isClosed;
    public static boolean isSpecMode;
    public static ArrayList<String> allowedList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.state")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("open")) {
                    setIsClosed(false);
                    setIsSpecMode(false);
                    sender.sendMessage(Quizcupv2.getPrefix + "Der Server ist nun wieder §ageöffnet§7!");
                } else if(args[0].equalsIgnoreCase("close")) {
                    setIsClosed(true);
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        config.set(players.getUniqueId().toString(), true);
                        allowedList.add(players.getName());
                    }
                    Bukkit.broadcastMessage(Quizcupv2.getPrefix + "§cDer Server ist nun geschlossen! Niemand kann noch joinen! Alle, die jetzt auf dem Server sind können jedoch wieder joinen.");
                } else if(args[0].equalsIgnoreCase("spec")) {
                    setIsSpecMode(true);
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        config.set(players.getUniqueId().toString(), true);
                        allowedList.add(players.getName());
                    }
                    Bukkit.broadcastMessage(Quizcupv2.getPrefix + "Der §9Spectator Modus §7ist nun aktiv! Alle die joinen, sind automatisch Spectator!");
                } else {
                    sender.sendMessage(Quizcupv2.getPrefix + "§cAlias: /state <open | close | spec>");
                }
            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§cAlias: /state <open | close | spec>");
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }

        try {
            config.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean isIsClosed() {return isClosed;}
    public static void setIsClosed(boolean isClosed) { StateCommand.isClosed = isClosed;}

    public static boolean getIsSpecMode() {return isSpecMode;}
    public static void setIsSpecMode(boolean isSpecMode) {StateCommand.isSpecMode = isSpecMode;}

    public static ArrayList<String> getAllowedList() {return allowedList;}
}
