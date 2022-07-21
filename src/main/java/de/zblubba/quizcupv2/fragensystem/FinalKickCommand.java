package de.zblubba.quizcupv2.fragensystem;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.commands.KickCommand;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class FinalKickCommand implements CommandExecutor {

    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.finale.kick")) {
            if(args.length == 0) {

                TextComponent message15 = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§c§l15 §8- §7Alle Spieler §cunter 15 Punkten rausnehmen");message15.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um alle Spieler §cunter 15 Punkten rauszunehmen")));message15.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/finalkick 15"));
                TextComponent message14 = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§c§l14 §8- §7Alle Spieler §cunter 14 Punkten rausnehmen");message14.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um alle Spieler §cunter 14 Punkten rauszunehmen")));message14.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/finalkick 14"));
                TextComponent message13 = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§c§l13 §8- §7Alle Spieler §cunter 13 Punkten rausnehmen");message13.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um alle Spieler §cunter 13 Punkten rauszunehmen")));message13.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/finalkick 13"));
                TextComponent message12 = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§c§l12 §8- §7Alle Spieler §cunter 12 Punkten rausnehmen");message12.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um alle Spieler §cunter 12 Punkten rauszunehmen")));message12.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/finalkick 12"));
                TextComponent message11 = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§c§l11 §8- §7Alle Spieler §cunter 11 Punkten rausnehmen");message11.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um alle Spieler §cunter 11 Punkten rauszunehmen")));message11.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/finalkick 11"));
                TextComponent message10 = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§c§l10 §8- §7Alle Spieler §cunter 10 Punkten rausnehmen");message10.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um alle Spieler §cunter 10 Punkten rauszunehmen")));message10.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/finalkick 10"));

                sender.sendMessage(Quizcupv2.getFinalPrefix + "Klicke auf die unteren Nachrichten, um alle Spieler unter diesen Punkten zu rauszunehmen.");
                sender.spigot().sendMessage(message15);
                sender.spigot().sendMessage(message14);
                sender.spigot().sendMessage(message13);
                sender.spigot().sendMessage(message12);
                sender.spigot().sendMessage(message11);
                sender.spigot().sendMessage(message10);

            } else if(args.length == 1) {
                int lowestLevel = Integer.parseInt(args[0]);

                for(Player players : Bukkit.getOnlinePlayers()) {
                    //if(!players.hasPermission("quizcup.helper")) {
                        if(config.getInt("names." + players.getName() + ".points") > lowestLevel) {
                            players.teleport(new Location(Bukkit.getWorlds().get(0), -2.5, 109, 82.5, -180, 0));
                            config.set("names." + players.getName() + ".hfinal", true);
                            players.sendMessage(Quizcupv2.getFinalPrefix + "Du bist nun im §aHalbfinale!");
                        }
                    //}
                }

                try {
                    config.save(configFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                sender.sendMessage(Quizcupv2.getFinalPrefix + "Es wurden alle Spieler über §c" + lowestLevel + " §7Punkten teleportiert!");

            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§cNutze: /finalkick <(nichts) | nummer>");
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }

        return false;
    }
}
