package de.zblubba.quizcupv2.commands;

import de.zblubba.quizcupv2.Quizcupv2;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.TimeUnit;

public class StartQuizCupCommand implements CommandExecutor {

    Plugin plugin = Quizcupv2.getPlugin(Quizcupv2.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if(p.hasPermission("quizcup.admin.start")) {

                try {
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40 * 2000, 255));
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§8 ");
                        Bukkit.broadcastMessage("§dPig §8| §dOi §8» §7was passiert hier!?");
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 99999, 1);
                        }
                    }, 20 * 5);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§6Fillager §8| §6Zin §8» §7hä wtf was soll das ╰（‵□′）╯");
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 99999, 1);
                        }
                    }, 4 * 20 + 5*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§dPig §8| §dOi §8» §7Hilf mir D: Ich habe §cAngst.");
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§6Fillager §8| §6Zin §8» §7He! Wo bist denn du? Ich kann dich nicht sehen");
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§dPig §8| §dOi §8» §7AAAAAA HILFE DA KOMMEN §cMENSCHEN§7!");
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 99999, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§6Fillager §8| §6Zin §8» §7Oi, §cRENN, RENN OI!");
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§7");
                        Bukkit.broadcastMessage("§7Stille...");
                        Bukkit.broadcastMessage("§7");
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§dPig §8| §dOi §7fell from a high place.");
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage("§6Fillager §8| §6Zin §8» §7was killed by §cCEO §8| §czBlubba");
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cQuizCup", "§eVersion 2", 1, 60, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cviele Stunden", "§9aus reinem Coding", 1, 60, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_HOGLIN_DEATH, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cviele Stunden", "§9für die Planung", 1, 60, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_HOGLIN_DEATH, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cDas Ergebnis ist", "", 1, 60, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20 + 5*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cbesser", "", 1, 5, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20 + 5*20 + 2*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cspannender", "", 1, 5, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20 + 5*20 + 2*20 + 8);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§clagfreier", "", 1, 5, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20 + 5*20 + 2*20 + 8 + 8);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cUnd...", "", 1, 60, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20 + 5*20 + 2*20 + 8 + 8 + 2*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cStartet...", "", 1, 60, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_WITHER_HURT, 99999, 1);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20 + 5*20 + 2*20 + 8 + 8 + 2*20 + 3*20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle("§4§cJETZT", "", 1, 60, 1);
                            player.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 99999, 1);
                            player.teleport(new Location(Bukkit.getWorlds().get(0), -2.5, 107, 8.5, 90, 0));
                        }

                        Bukkit.broadcastMessage("§8-------------------------------------------");
                        Bukkit.broadcastMessage("§c§lQuizCup §e§lV2 §8- §9Powered by §c§lCombiGamerHD §9and Coded by §c§lzBlubba");
                        Bukkit.broadcastMessage("                    §c+ Drachenkult");
                        Bukkit.broadcastMessage("§8-------------------------------------------");
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20 + 5*20 + 2*20 + 8 + 8 + 2*20 + 3*20 + 20);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            player.removePotionEffect(PotionEffectType.BLINDNESS);
                        }
                    }, 4 * 20 + 5*20 + 4*20 + 5*20 + 4*20 + 4*20 + 4*20 + 5*20 + 4*20 + 5*20 + 5*20 + 5*20 + 5*20 + 2*20 + 8 + 8 + 2*20 + 3*20 + 20 + 40);

                } catch(Exception e) {
                    Bukkit.getConsoleSender().sendMessage("ERROR | " + e);
                }


            }
        }
        return false;
    }
}
