package de.zblubba.quizcupv2.fragensystem;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.awt.*;
import java.io.File;

public class BuzzerCommand implements CommandExecutor {

    File configFile = new File("plugins/quizcup", "winnerlist.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if(config.getBoolean("names." + p.getName() + ".hfinal")) {
                Location loc = p.getLocation();

                FireworkEffect effect = FireworkEffect.builder().with(FireworkEffect.Type.BURST).withColor(Color.fromRGB(255, 0, 0)).withFade(Color.fromRGB(0,0,0)).build();
                Firework firework = loc.getWorld().spawn(loc, Firework.class);
                FireworkMeta fireworkMeta = firework.getFireworkMeta();
                fireworkMeta.addEffect(effect);
                fireworkMeta.setPower(127);
                firework.setFireworkMeta(fireworkMeta);
                firework.setTicksLived(2);
                firework.detonate();

                Bukkit.broadcastMessage("§8----------------------------");
                Bukkit.broadcastMessage("§a§l" + p.getName() + " §7hat den Buzzer ausgelöst!");
                Bukkit.broadcastMessage("§8----------------------------");            }
        } else {
            sender.sendMessage("Musst nen Spieler sein");
        }
        return false;
    }
}
