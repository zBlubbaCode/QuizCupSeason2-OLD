package de.zblubba.quizcupv2.commands;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CloseChatCommand implements CommandExecutor {

    public static boolean isChatClose;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("quizcup.chat.close")) {

            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("close")) {
                    isChatClose = true;
                    Bukkit.broadcastMessage(Quizcupv2.getPrefix + "§cDer Chat ist nun geschlossen!");
                } else if(args[0].equalsIgnoreCase("open")){
                    isChatClose = false;
                    Bukkit.broadcastMessage(Quizcupv2.getPrefix + "§cDer Chat ist nun wieder geöffnet!");
                } else {
                    sender.sendMessage(Quizcupv2.getPrefix + "Nutze §c/chat <close | open>");
                }
            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "Nutze §c/chat <close | open>");
            }

        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }

        return false;
    }
}