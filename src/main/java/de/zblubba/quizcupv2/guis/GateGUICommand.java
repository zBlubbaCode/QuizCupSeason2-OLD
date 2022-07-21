package de.zblubba.quizcupv2.guis;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GateGUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p) {
            if(p.hasPermission("quizcup.gates")) {

                //create a 1 x 9 inventory
                Inventory inv = Bukkit.createInventory(null, 1*9, "§eQuizCup §8- §cGates");

                //fill the inventory with black stained-glass panes
                for(int i = 0; i < 9; i++) {
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§8 ").build());
                }

                //set the frontgate item
                inv.setItem(0, new ItemBuilder(Material.REDSTONE_BLOCK).setName("§cFront Gate").setLore("§7Klicke dieses Item,", "§7um das §cvordere Gate", "§7zu öffnen!").setLocalizedName("front").build());
                //set the midgate item
                inv.setItem(4, new ItemBuilder(Material.EMERALD_BLOCK).setName("§bMiddle Gate").setLore("§7Klicke dieses Item,", "§7um das §bmittlere Gate", "§7zu öffnen!").setLocalizedName("middle").build());
                //set the endgate item
                inv.setItem(8, new ItemBuilder(Material.DIAMOND_BLOCK).setName("§aEnd Gate").setLore("§7Klicke dieses Item,", "§7um das §aletzte Gate", "§7zu öffnen!").setLocalizedName("end").build());

                p.openInventory(inv);
            } else {
                sender.sendMessage(Quizcupv2.geNoPerms);
            }
        }
        return false;
    }
}
