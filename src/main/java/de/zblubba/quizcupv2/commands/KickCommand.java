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

public class KickCommand implements CommandExecutor {

    static File configFile = new File("plugins/quizcup", "allowedplayers.yml");
    static FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);
    static ArrayList<String> allowedList = StateCommand.getAllowedList();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.kick")) {
            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {

                    kickPlayer(target);
                    sender.sendMessage(Quizcupv2.getPrefix + "Spieler §c" + target.getName() + " §7wurde erfolgreich §causgeschieden§7!");

                } else {
                    sender.sendMessage(Quizcupv2.getPrefix + "§cError §8- §7Spieler Offline is eine Möglichkeit");
                }
            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§cNutze: /kick <spieler>");
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }
        return false;
    }

    public static void kickPlayer(Player p) {
        p.kickPlayer("§e§lQuiCup\n\n§cDu bist ausgeschieden!\n\n§7Alle weiteren Informationen erfolgen auf dem §9Discord§7!\n§7Du kannst wenn nur wieder als §9Spectator §7joinen!");

        allowedList.remove(p.getName());
        config.set(p.getUniqueId().toString(), false);
        try {
            config.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
