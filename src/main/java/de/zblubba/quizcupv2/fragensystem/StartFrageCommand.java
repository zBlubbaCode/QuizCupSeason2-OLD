package de.zblubba.quizcupv2.fragensystem;

//startet die Frage mit Titel und so, setzt den Fragenstatus auf Frage + 1
// /startfrage 1

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class StartFrageCommand implements CommandExecutor {
    static int numberOfQuestion;

    File antwortenFile = new File("plugins/quizcup", "antworten.yml");
    FileConfiguration antwortenConfig = new YamlConfiguration().loadConfiguration(antwortenFile);

    File fragenFile = new File("plugins/quizcup", "fragen.yml");
    FileConfiguration fragenConfig = new YamlConfiguration().loadConfiguration(fragenFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.frage.start")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("next")) {
                    numberOfQuestion++;
                    sendQuestion(numberOfQuestion);
                } else {
                    int numberOfFrage = Integer.parseInt(args[0]);
                    sendQuestion(numberOfFrage);
                }
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }



        return false;
    }

    public void sendQuestion(int numberOfQuestion) {
        String frage = fragenConfig.getString("Frage " + numberOfQuestion);
        String antwort1 = antwortenConfig.getString("Frage " + numberOfQuestion + ".1");
        String antwort2 = antwortenConfig.getString("Frage " + numberOfQuestion + ".2");
        String antwort3 = antwortenConfig.getString("Frage " + numberOfQuestion + ".3");
        String antwort4 = antwortenConfig.getString("Frage " + numberOfQuestion + ".4");

        antwort1 = antwort1.replaceFirst("^ *", "");
        antwort2 = antwort2.replaceFirst("^ *", "");
        antwort3 = antwort3.replaceFirst("^ *", "");
        antwort4 = antwort4.replaceFirst("^ *", "");
        frage = frage.replaceFirst("^ *", "");

        for(Player players : Bukkit.getOnlinePlayers()) {
            players.sendTitle("§aFrage " + numberOfQuestion, "", 1, 60, 1);

            players.sendMessage("§f======== §7Frage §a" + numberOfQuestion + " §f========");
            players.sendMessage("§6" + frage);
            players.sendMessage("§7[§cA§7]§a " + antwort1);
            players.sendMessage("§7[§bB§7]§a " + antwort2);
            players.sendMessage("§7[§aC§7]§a " + antwort3);
            players.sendMessage("§7[§eD§7]§a " + antwort4);
            players.sendMessage("§f======== §7Frage §a" + numberOfQuestion + " §f========");
        }
    }

    public static void setNumberOfQuestion(int number) { numberOfQuestion = number;}
    public static int getNumberOfQuestion() { return numberOfQuestion;}
}
