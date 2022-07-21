package de.zblubba.quizcupv2.commands;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.listeners.JoinQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvisCommand implements CommandExecutor {

    public static boolean isVisibility;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(sender.hasPermission("quizcup.visibility")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("on")) {
                        setVisibility(true);

                        for(Player online : Bukkit.getOnlinePlayers()) {
                            for(int i = 0; i < JoinQuitListener.allList.size(); i++) {
                                Player player = Bukkit.getPlayer(JoinQuitListener.allList.get(i));
                                if(!player.hasPermission("quizcup.helper")) {
                                    if(!online.hasPermission("quizcup.helper")) {
                                        player.hidePlayer(online);
                                    }
                                }
                            }
                        }

                        sender.sendMessage(Quizcupv2.getPrefix + "Alle Spieler sind nun für andere Spieler §cunsichtbar§7!");
                    } else if(args[0].equalsIgnoreCase("off")) {
                        setVisibility(false);

                        for(Player online : Bukkit.getOnlinePlayers()) {
                            for(int i = 0; i < JoinQuitListener.allList.size(); i++) {
                                Player player = Bukkit.getPlayer(JoinQuitListener.allList.get(i));
                                if(!player.hasPermission("quizcup.helper")) {
                                    if(!online.hasPermission("quizcup.helper")) {
                                        player.showPlayer(online);
                                    }
                                }
                            }
                        }

                        sender.sendMessage(Quizcupv2.getPrefix + "Alle Spieler sind nun für andere Spieler §asichtbar§7!");
                    } else {
                        sender.sendMessage(Quizcupv2.getPrefix + "§cNutze: /invis <on | off>");
                    }
                } else {
                    sender.sendMessage(Quizcupv2.getPrefix + "§cNutze: /invis <on | off>");
                }
            } else {
                sender.sendMessage(Quizcupv2.geNoPerms);
            }
        return false;
    }

    public static void setVisibility(boolean visibility) {isVisibility = visibility;}
    public static boolean getVisibility() {return isVisibility;}
}
