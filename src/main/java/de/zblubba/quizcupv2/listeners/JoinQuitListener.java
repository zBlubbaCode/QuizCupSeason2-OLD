package de.zblubba.quizcupv2.listeners;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.commands.StateCommand;
import de.zblubba.quizcupv2.util.ItemBuilder;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.io.File;
import java.util.ArrayList;

public class JoinQuitListener implements Listener {

    public static ArrayList<String> allList = new ArrayList<>();
    public static ArrayList<String> helperList = new ArrayList<>();
    public static ArrayList<String> adminList = new ArrayList<>();

    File configFile = new File("plugins/quizcup", "allowedplayers.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(configFile);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        boolean isInList = config.getBoolean(p.getUniqueId().toString());
        Bukkit.getConsoleSender().sendMessage(isInList + " ");

        if(StateCommand.isIsClosed()) {
            if(!p.hasPermission("quizcup.bypass") && !StateCommand.getAllowedList().contains(p.getName())) {
                p.kickPlayer("§e§lQuizCup\n\n§cDer Server ist zurzeit geschlossen!");
            }
        }
        if(StateCommand.getIsSpecMode()) {
            if(!p.hasPermission("quizcup.helper")) {
                if(!StateCommand.allowedList.contains(p.getName())) {
                    p.setGameMode(GameMode.SPECTATOR);
                }
            }
        }


        if(p.hasPermission("quizcup.admin")) {
            event.setJoinMessage("§7[§a+§7] §cAdmin §8| §c" + p.getName());
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta itemMeta = (LeatherArmorMeta) boots.getItemMeta();
            itemMeta.setColor(Color.fromRGB(255, 0, 0));
            itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 100, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.setDisplayName("§cAdmin §8| §c" + p.getName());
            boots.setItemMeta(itemMeta);
            p.getInventory().setItem(36, boots);
            adminList.add(p.getName());
        } else if(p.hasPermission("quizcup.helper")) {
            event.setJoinMessage("§7[§a+§7] §6Helfer §8| §6" + p.getName());
            helperList.add(p.getName());
        } else {
            if(!StateCommand.isIsClosed()) {
                event.setJoinMessage("§7[§a+§7] §b" + p.getName());
                allList.add(p.getName());
                if(!StateCommand.getIsSpecMode()) {
                    p.setGameMode(GameMode.SURVIVAL);
                }
            } else {
                if(config.contains(p.getUniqueId().toString())) {
                    event.setJoinMessage("§7[§a+§7] §b" + p.getName());
                    allList.add(p.getName());
                }
            }
        }
        p.sendMessage("§aWillkommen §7auf dem §6Drachenkult QuizCup Server§7! Alle weiteren Informationen findest du auf dem §9Discord\n§9https://discord.gg/drachenkult");
        p.teleport(new Location(Bukkit.getWorlds().get(0), -2.5, 107, 8.5, 90, 0));

        Quizcupv2.getInstance().scoreboard.setScoreboard(p);
        Quizcupv2.getInstance().scoreboard.setTab(p);

        for(Player players : Bukkit.getOnlinePlayers()) {
            Quizcupv2.getInstance().scoreboard.updateTab(players);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player p = event.getPlayer();

        if(p.hasPermission("quizcup.admin")) {
            event.setQuitMessage("§7[§c-§7] §cAdmin §8| §c" + p.getName());
            allList.remove(p.getName());
            adminList.remove(p.getName());
        } else if(p.hasPermission("quizcup.helper")) {
            event.setQuitMessage("§7[§c-§7] §6Helfer §8| §6" + p.getName());
            allList.remove(p.getName());
            helperList.remove(p.getName());
        } else {
            if(!StateCommand.isIsClosed()) {
                allList.remove(p.getName());
                event.setQuitMessage("§7[§c-§7] §b" + p.getName());
            }
        }
    }

    public static ArrayList<String> getAdminList() {return adminList;}
    public static ArrayList<String> getHelperList() {return helperList;}
}
