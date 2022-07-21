package de.zblubba.quizcupv2.fragensystem;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class AddAntwortCommand implements CommandExecutor {

    File antwortenFile = new File("plugins/quizcup", "antworten.yml");
    FileConfiguration antwortenConfig = new YamlConfiguration().loadConfiguration(antwortenFile);

    String antwort;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.frage.antwort.add")) {
            if(args.length > 2) {
                int fragenNummer = Integer.parseInt(args[0]);
                int abcOderD = Integer.parseInt(args[1]);

                for (int i = 1; i < args.length; i++) {
                    antwort = antwort + args[i] + " ";
                    antwort = antwort.replaceAll("null", "");
                }
                antwort = antwort.substring(1);

                antwortenConfig.set("Frage " + fragenNummer + "." + abcOderD, antwort);
                sender.sendMessage(Quizcupv2.getPrefix + "§7Die Antwort Nr. §a" + abcOderD + " §7der Frage §c" + fragenNummer + " §7wurde gesetzt zu:§a" + antwort);

                try {
                    antwortenConfig.save(antwortenFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                antwort = "";

            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§7Nutze: §c/addantwort <Fragennummer> <1 | 2 | 3 | 4> <Antwort>");
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }

        return false;
    }
}
