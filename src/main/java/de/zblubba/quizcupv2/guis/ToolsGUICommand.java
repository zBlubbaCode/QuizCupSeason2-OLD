package de.zblubba.quizcupv2.guis;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class ToolsGUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if(p.hasPermission("quizcup.tools")) {

                final String clickToGet = "§7Klicke, um dieses Item zu erhalten";

                //create an inventory with 3x9
                Inventory inv = Bukkit.createInventory(null, 3*9, "§eQuizCup §8- §cTools");

                //fill the inventory with black stained glass-panes
                for(int i = 0; i < 3*9; i++) {
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§8 ").build());
                }

                inv.setItem(4, new ItemBuilder(Material.REDSTONE_BLOCK).setName("§cAlle Tools").setLore("§7Erhalte alle Tools in dein Inventar", "§7Info: Deine Hotbar wird vorher gecleart").setLocalizedName("alltools").build());
                inv.setItem(10, new ItemBuilder(Material.NETHER_STAR).setName("§cNächste Frage").setLore("§cAchtung! §7Startet automatisch die nächste Frage", clickToGet).addEnchant(Enchantment.ARROW_DAMAGE, 10).addFlag(ItemFlag.HIDE_ENCHANTS).setLocalizedName("nextquestion").build());
                inv.setItem(11, new ItemBuilder(Material.BLAZE_POWDER).setName("§9Spieler §8- §cSichtbarkeit").setLore("§7Damit lässt sich einstellen, ob", "§7die Spieler gerade andere Spieler sehen können", clickToGet).setLocalizedName("player-visibility").build());
                inv.setItem(12, new ItemBuilder(Material.ENDER_EYE).setName("§7Teleport zum §cSpawn").setLore("§7Teleportiert §calle §7sofort zum Spawn", clickToGet).setLocalizedName("tpall").build());
                inv.setItem(14, new ItemBuilder(Material.GOLD_INGOT).setName("§6Front Gate").setLore("§7Öffnet oder schließt das vorderste Gate", clickToGet).setLocalizedName("frontgate").build());
                inv.setItem(15, new ItemBuilder(Material.DIAMOND).setName("§bMid Gate").setLore("§7Öffnet oder schließt das mittlere Gate", clickToGet).setLocalizedName("midgate").build());
                inv.setItem(16, new ItemBuilder(Material.EMERALD).setName("§aEnd Gate").setLore("§7Öffnet oder schließt das letzte Gate", clickToGet).setLocalizedName("endgate").build());

                p.openInventory(inv);
            } else {
                sender.sendMessage(Quizcupv2.geNoPerms);
            }
        }
        return false;
    }
}
