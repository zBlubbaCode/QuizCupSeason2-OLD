package de.zblubba.quizcupv2.commands;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.listeners.JoinQuitListener;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class GateCommand implements CommandExecutor {

    Plugin plugin = Quizcupv2.getPlugin(Quizcupv2.class);
    public static ArrayList<String> hidedList = new ArrayList<>();
    int time = 8;
    int taskid;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if(p.hasPermission("quizcup.gates")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("front")) {
                        updateFrontGate();
                        p.sendMessage(Quizcupv2.getPrefix + "§cDas Frontgate wurde aktualisiert");
                    } else if(args[0].equalsIgnoreCase("mid")) {
                        if(Bukkit.getWorlds().get(0).getBlockAt(-5, 111, -28).getType() == Material.AIR) {
                            for(Player online : Bukkit.getOnlinePlayers()) {
                                for(int i = 0; i < JoinQuitListener.allList.size(); i++) {
                                    Player player = Bukkit.getPlayer(JoinQuitListener.allList.get(i));
                                    if(!online.hasPermission("quizcup.helper")) {
                                        player.showPlayer(online);
                                    }
                                }
                            }
                            InvisCommand.setVisibility(false);
                        } else {
                            taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
                                for(Player players : Bukkit.getOnlinePlayers()) {
                                    players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§bZeit §8|| §c" + time));
                                }
                                time--;
                            }, 0, 20);
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () ->  {
                                Bukkit.getScheduler().cancelTask(taskid);
                                time = 8;
                            }, 20 * 9);

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
                            InvisCommand.setVisibility(true);
                        }
                        updateMidGate();

                    } else if(args[0].equalsIgnoreCase("end")) {
                        updateEndGate();
                    } else {
                        p.sendMessage(Quizcupv2.getPrefix + "§cNutze: /gates <front | mid | end>");
                    }
                } else {
                    p.sendMessage(Quizcupv2.getPrefix + "§cNutze: /gates <front | mid | end>");
                }
            } else {
                p.sendMessage(Quizcupv2.geNoPerms);
            }
        }
        return false;
    }

    public static void updateFrontGate() {
        if(Bukkit.getWorlds().get(0).getBlockAt(-3, 108, -7).getType() == Material.AIR) {
            Bukkit.getWorlds().get(0).getBlockAt(-2, 108, -7).setType(Material.BARRIER);
            Bukkit.getWorlds().get(0).getBlockAt(-3, 108, -7).setType(Material.BARRIER);
            Bukkit.getWorlds().get(0).getBlockAt(-4, 108, -7).setType(Material.BARRIER);
        } else {
            Bukkit.broadcastMessage(Quizcupv2.getPrefix + "§c§lLOS!");
            Bukkit.getWorlds().get(0).getBlockAt(-2, 108, -7).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(-3, 108, -7).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(-4, 108, -7).setType(Material.AIR);
        }
    }

    public static void updateMidGate() {
        if(Bukkit.getWorlds().get(0).getBlockAt(4, 111, -28).getType() == Material.AIR) {
            Bukkit.getWorlds().get(0).getBlockAt(4, 111, -28).setType(Material.YELLOW_STAINED_GLASS);
            Bukkit.getWorlds().get(0).getBlockAt(3, 111, -28).setType(Material.YELLOW_STAINED_GLASS);
            Bukkit.getWorlds().get(0).getBlockAt(2, 111, -28).setType(Material.YELLOW_STAINED_GLASS);

            Bukkit.getWorlds().get(0).getBlockAt(0, 111, -28).setType(Material.GREEN_STAINED_GLASS);
            Bukkit.getWorlds().get(0).getBlockAt(-1, 111, -28).setType(Material.GREEN_STAINED_GLASS);
            Bukkit.getWorlds().get(0).getBlockAt(-2, 111, -28).setType(Material.GREEN_STAINED_GLASS);

            Bukkit.getWorlds().get(0).getBlockAt(-4, 111, -28).setType(Material.BLUE_STAINED_GLASS);
            Bukkit.getWorlds().get(0).getBlockAt(-5, 111, -28).setType(Material.BLUE_STAINED_GLASS);
            Bukkit.getWorlds().get(0).getBlockAt(-6, 111, -28).setType(Material.BLUE_STAINED_GLASS);

            Bukkit.getWorlds().get(0).getBlockAt(-8, 111, -28).setType(Material.RED_STAINED_GLASS);
            Bukkit.getWorlds().get(0).getBlockAt(-9, 111, -28).setType(Material.RED_STAINED_GLASS);
            Bukkit.getWorlds().get(0).getBlockAt(-10, 111, -28).setType(Material.RED_STAINED_GLASS);
        } else {
            Bukkit.getWorlds().get(0).getBlockAt(4, 111, -28).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(3, 111, -28).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(2, 111, -28).setType(Material.AIR);

            Bukkit.getWorlds().get(0).getBlockAt(0, 111, -28).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(-1, 111, -28).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(-2, 111, -28).setType(Material.AIR);

            Bukkit.getWorlds().get(0).getBlockAt(-4, 111, -28).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(-5, 111, -28).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(-6, 111, -28).setType(Material.AIR);

            Bukkit.getWorlds().get(0).getBlockAt(-8, 111, -28).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(-9, 111, -28).setType(Material.AIR);
            Bukkit.getWorlds().get(0).getBlockAt(-10, 111, -28).setType(Material.AIR);
        }
    }

    public static void updateEndGate() {
        if(Bukkit.getWorlds().get(0).getBlockAt(5, 107, -19).getType() == Material.AIR) {
            //Bukkit.getWorlds().get(0).getBlockAt(5, 107, -15).setType(Material.BLUE_STAINED_GLASS);
            //Bukkit.getWorlds().get(0).getBlockAt(5, 107, -17).setType(Material.BLUE_STAINED_GLASS);
            //Bukkit.getWorlds().get(0).getBlockAt(5, 107, -19).setType(Material.BLUE_STAINED_GLASS);
            //Bukkit.getWorlds().get(0).getBlockAt(5, 107, -21).setType(Material.BLUE_STAINED_GLASS);
        } else {
            //Bukkit.getWorlds().get(0).getBlockAt(5, 107, -15).setType(Material.AIR);
            //Bukkit.getWorlds().get(0).getBlockAt(5, 107, -17).setType(Material.AIR);
            //Bukkit.getWorlds().get(0).getBlockAt(5, 107, -19).setType(Material.AIR);
            //Bukkit.getWorlds().get(0).getBlockAt(5, 107, -21).setType(Material.AIR);
        }
    }
}
