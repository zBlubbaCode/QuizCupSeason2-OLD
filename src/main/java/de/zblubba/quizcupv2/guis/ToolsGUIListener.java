package de.zblubba.quizcupv2.guis;

import de.zblubba.quizcupv2.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ToolsGUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();

        if(event.getCurrentItem() == null) return;
        if(event.getView().getTitle().equals("§eQuizCup §8- §cTools")) {
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "nextquestion" -> {
                        ItemStack item = new ItemStack(Material.NETHER_STAR);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§cNächste Frage");
                        meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        ArrayList<String> lore = new ArrayList<>();
                        lore.add("§7Startet automatisch §cdie nächste Frage bei einem Klick!");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        p.getInventory().addItem(item);
                    }
                    case "tpall" -> {
                        ItemStack item = new ItemStack(Material.ENDER_EYE);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§cTP-ALL");
                        ArrayList<String> lore = new ArrayList<>();
                        lore.add("§7Teleportiert §calle §7User zum Spawn!");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        p.getInventory().addItem(item);
                    }
                    case "frontgate" -> {
                        ItemStack item = new ItemStack(Material.GOLD_INGOT);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§6Front Gate");
                        ArrayList<String> lore = new ArrayList<>();
                        lore.add("§7Öffnet oder schließt das vorderste Gate");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        p.getInventory().addItem(item);
                    }
                    case "midgate" -> {
                        ItemStack item = new ItemStack(Material.DIAMOND);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§bMid Gate");
                        ArrayList<String> lore = new ArrayList<>();
                        lore.add("§7Öffnet oder schließt das mittlere Gate");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        p.getInventory().addItem(item);
                    }
                    case "endgate" -> {
                        ItemStack item = new ItemStack(Material.EMERALD);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§aEnd Gate");
                        ArrayList<String> lore = new ArrayList<>();
                        lore.add("§7Öffnet oder schließt das letzte Gate");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        p.getInventory().addItem(item);
                    }
                    case "player-visibility" -> {
                        ItemStack item = new ItemStack(Material.BLAZE_POWDER);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§9Spieler §8- §cSichtbarkeit");
                        ArrayList<String> lore = new ArrayList<>();
                        lore.add("§7Stellt ein, ob Spieler andere Spieler sehen dürfen");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        p.getInventory().addItem(item);
                    }
                    case "alltools" -> addAllTools(p);

                }
            }
        }
    }

    public void addAllTools(Player p) {
        ItemStack netherstar = new ItemStack(Material.NETHER_STAR);
        ItemMeta metaNether = netherstar.getItemMeta();
        metaNether.setDisplayName("§cNächste Frage");
        metaNether.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        metaNether.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> loreNether = new ArrayList<>();
        loreNether.add("§7Startet automatisch §cdie nächste Frage bei einem Klick!");
        metaNether.setLore(loreNether);
        netherstar.setItemMeta(metaNether);

        ItemStack endereye = new ItemStack(Material.ENDER_EYE);
        ItemMeta metaEnder = endereye.getItemMeta();
        metaEnder.setDisplayName("§cTP-ALL");
        ArrayList<String> loreEnder = new ArrayList<>();
        loreEnder.add("§7Teleportiert §calle §7User zum Spawn!");
        metaEnder.setLore(loreEnder);
        endereye.setItemMeta(metaEnder);

        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta metaGold = gold.getItemMeta();
        metaGold.setDisplayName("§6Front Gate");
        ArrayList<String> loreGold = new ArrayList<>();
        loreGold.add("§7Öffnet oder schließt das vorderste Gate");
        metaGold.setLore(loreGold);
        gold.setItemMeta(metaGold);

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemMeta metaDiamond = diamond.getItemMeta();
        metaDiamond.setDisplayName("§bMid Gate");
        ArrayList<String> loreDiamond = new ArrayList<>();
        loreDiamond.add("§7Öffnet oder schließt das mittlere Gate");
        metaDiamond.setLore(loreDiamond);
        diamond.setItemMeta(metaDiamond);

        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemMeta metaEmerald = emerald.getItemMeta();
        metaEmerald.setDisplayName("§aEnd Gate");
        ArrayList<String> loreEmerald = new ArrayList<>();
        loreEmerald.add("§7Öffnet oder schließt das letzte Gate");
        metaEmerald.setLore(loreEmerald);
        emerald.setItemMeta(metaEmerald);

        ItemStack blaze = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta metaBlaze = blaze.getItemMeta();
        metaBlaze.setDisplayName("§9Spieler §8- §cSichtbarkeit");
        ArrayList<String> loreBlaze = new ArrayList<>();
        loreBlaze.add("§7Stellt ein, ob Spieler andere Spieler sehen dürfen");
        metaBlaze.setLore(loreBlaze);
        blaze.setItemMeta(metaBlaze);

        p.getInventory().setItem(0, netherstar);
        p.getInventory().setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§8").build());
        p.getInventory().setItem(2, blaze);
        p.getInventory().setItem(3, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§8").build());
        p.getInventory().setItem(4, endereye);
        p.getInventory().setItem(5, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§8").build());
        p.getInventory().setItem(6, gold);
        p.getInventory().setItem(7, diamond);
        p.getInventory().setItem(8, emerald);
    }
}
