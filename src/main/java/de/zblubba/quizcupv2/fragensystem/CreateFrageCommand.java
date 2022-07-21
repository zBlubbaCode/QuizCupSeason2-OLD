package de.zblubba.quizcupv2.fragensystem;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CreateFrageCommand implements CommandExecutor {

    File fragenFile = new File("plugins/quizcup", "fragen.yml");
    FileConfiguration fragenConfig = new YamlConfiguration().loadConfiguration(fragenFile);

    String frage;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.frage.add")) {

            // /createfrage 1 Wie viele Nudeln gibt es Heute?

            if(args.length >= 2) {
                int numberOfFrage = Integer.parseInt(args[0]);

                for (int i = 1; i < args.length; i++) {
                    frage = frage + args[i] + " ";
                    frage = frage.replaceAll("null", "");
                }

                fragenConfig.set("Frage " + numberOfFrage + "", frage);

                sender.sendMessage(Quizcupv2.getPrefix + "§7Die Frage Nr. §a" + numberOfFrage + " §7wurde gesetzt zu: §a" + frage);

                frage = "";

                try {
                    fragenConfig.save(fragenFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§7Nutze §c/addfrage <frageNummer> <frage>");
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }
        return false;
    }
}
