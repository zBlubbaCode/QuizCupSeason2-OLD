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

public class SetFinaleCommand implements CommandExecutor {

    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.finale")) {
            if(args.length == 4) {
                Player p1 = Bukkit.getPlayer(args[0]);
                Player p2 = Bukkit.getPlayer(args[1]);
                Player p3 = Bukkit.getPlayer(args[2]);
                Player p4 = Bukkit.getPlayer(args[3]);

                String finaleMessage = Quizcupv2.getFinalPrefix + "Du bist nun im §aFinale§7!";
                p1.sendMessage(finaleMessage);
                p2.sendMessage(finaleMessage);
                p3.sendMessage(finaleMessage);
                p4.sendMessage(finaleMessage);

                config.set("names." + p1.getName() + ".final", true);
                config.set("names." + p2.getName() + ".final", true);
                config.set("names." + p3.getName() + ".final", true);
                config.set("names." + p4.getName() + ".final", true);

                try {
                    config.save(configFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Bukkit.broadcastMessage(Quizcupv2.getFinalPrefix + "Folgende Spieler sind nun im Finale: \n§a" + p1.getName() + " §8- §a" + p2.getName() + " §8- §a" + p3.getName() + " §8- §a" + p4.getName());
            }
        }
        return false;
    }
}
