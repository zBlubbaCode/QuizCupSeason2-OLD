package de.zblubba.quizcupv2.fragensystem;

import de.zblubba.quizcupv2.Quizcupv2;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class StartMultipleFrage implements CommandExecutor {

    public static int currentQuestion;

    File antwortenFile = new File("plugins/quizcup", "antworten.yml");
    FileConfiguration antwortenConfig = new YamlConfiguration().loadConfiguration(antwortenFile);
    File fragenFile = new File("plugins/quizcup", "fragen.yml");
    FileConfiguration fragenConfig = new YamlConfiguration().loadConfiguration(fragenFile);
    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("quizcup.frage.start")) {
            if(args.length >= 1) {
                int numberOfFrage = Integer.parseInt(args[0]);
                if(args.length > 1) {
                    if(args[1].equalsIgnoreCase("final")) {
                        sendQuestion(numberOfFrage, "final");
                    }
                } else {
                    sendQuestion(numberOfFrage, "hfinal");
                }
            } else {
                sender.sendMessage(Quizcupv2.getPrefix + "§cNutze: /startmultiplefrage <nummer> <optional: final>");
            }
        } else {
            sender.sendMessage(Quizcupv2.geNoPerms);
        }

        return false;
    }

    public void sendQuestion(int numberOfQuestion, String finalePath) {
        setCurrentQuestion(numberOfQuestion);

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

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(config.getBoolean("names." + p.getName() + "." + finalePath) || p.hasPermission("quizcup.helper")) {
                TextComponent messageA = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§7[§cA§7]§a " + antwort1);messageA.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um §cA §7einzuloggen!")));messageA.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/setantwort " + numberOfQuestion + " A " + finalePath));
                TextComponent messageB = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§7[§bB§7]§a " + antwort2);messageB.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um §bB §7einzuloggen!")));messageB.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/setantwort " + numberOfQuestion + " B " + finalePath));
                TextComponent messageC = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§7[§aC§7]§a " + antwort3);messageC.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um §aC §7einzuloggen!")));messageC.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/setantwort " + numberOfQuestion + " C " + finalePath));
                TextComponent messageD = new net.md_5.bungee.api.chat.TextComponent(Quizcupv2.getFinalPrefix + "§7[§eD§7]§a " + antwort4);messageD.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Klicke um §eD §7einzuloggen!")));messageD.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/setantwort " + numberOfQuestion + " D " + finalePath));

                p.sendMessage(Quizcupv2.getFinalPrefix + "§a§lNeue Frage §8- §7Klicke auf den Buchstaben, um deine Antwort einzuloggen!");
                p.sendMessage("§8--------------------------------------------");
                p.sendMessage(Quizcupv2.getFinalPrefix + "§6" + frage);
                p.spigot().sendMessage(messageA);
                p.spigot().sendMessage(messageB);
                p.spigot().sendMessage(messageC);
                p.spigot().sendMessage(messageD);
            } else {
            }
        }
    }

    public static int getCurrentQuestion() {return currentQuestion;}
    public static void setCurrentQuestion(int currentQuestion) {StartMultipleFrage.currentQuestion = currentQuestion;}
}
