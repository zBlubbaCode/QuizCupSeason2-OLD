package de.zblubba.quizcupv2.guis;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.listeners.JoinQuitListener;
import de.zblubba.quizcupv2.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class AdminGUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if(p.hasPermission("quizcup.admingui")) {

                //create a 6x9 inventory
                Inventory inv = Bukkit.createInventory(null, 6*9, "§eQuizCup §8- §cAdminSettings");

                //fill everything with black stained-glass
                for(int i = 0; i < 6*9; i++) {
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§8 ").build());
                }

                inv.setItem(4, new ItemBuilder(Material.REDSTONE_TORCH).setName("§cGenerelle Infos").setLore("§7Spieler online: §c" + Bukkit.getOnlinePlayers().size(), "§7Admins: §c" + JoinQuitListener.getAdminList().size(), "§7Helfer: §c" + JoinQuitListener.getHelperList().size(), "§7verbrauchter RAM: §c" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000 + "MB", "§7Max RAM: §c" + Runtime.getRuntime().maxMemory() / 1000000 + "MB").build());
                inv.setItem(20, new ItemBuilder(Material.WHITE_WOOL).setName("§7Chat §aan§8/§caus").setLocalizedName("chat").build());
                inv.setItem(24, new ItemBuilder(Material.BARRIER).setName("§7Serverstatus §ageöffnet§8/§cgeschlossen").setLocalizedName("serverstate").build());
                inv.setItem(31, new ItemBuilder(Material.EMERALD).setName("§aNächste Frage").setLore("§cAchtung! §7Startet automatisch die", "§7nächste Frage ohne bestätigung!").setLocalizedName("nextquestion").build());
                inv.setItem(37, new ItemBuilder(Material.ENDER_EYE).setName("§7TP-All").setLore("§7Teleportiert §calle §7Spieler zum Spawn").setLocalizedName("tpall").build());
                inv.setItem(43, new ItemBuilder(Material.OAK_FENCE_GATE).setName("§aGates").setLore("§7Öffnet das GUI für die Gates").setLocalizedName("gates").build());
                inv.setItem(49, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§eTools").setLocalizedName("tools").setLore("§7Öffnet das GUI für die Tools").build());

                p.openInventory(inv);
            } else {
                sender.sendMessage(Quizcupv2.geNoPerms);
            }
        }
        return false;
    }
}
