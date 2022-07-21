package de.zblubba.quizcupv2.guis;

import de.zblubba.quizcupv2.Quizcupv2;
import de.zblubba.quizcupv2.commands.CloseChatCommand;
import de.zblubba.quizcupv2.commands.StateCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GateGUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();

        if(event.getCurrentItem() == null) return;
        if(event.getView().getTitle().equals("§eQuizCup §8- §cGates")) {
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "front" -> p.sendMessage(Quizcupv2.getPrefix + "§cNutz die Items!");
                    case "middle" -> p.sendMessage(Quizcupv2.getPrefix + "§cNutz die Items!");
                    case "end" -> p.sendMessage(Quizcupv2.getPrefix + "§cNutz die Items!");
                }
            }
        } else if(event.getView().getTitle().equals("Frage mit Crafting Rezept")) {
            event.setCancelled(true);
        }
    }
}
