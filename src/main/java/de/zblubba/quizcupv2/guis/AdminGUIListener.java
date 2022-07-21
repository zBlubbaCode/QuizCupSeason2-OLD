package de.zblubba.quizcupv2.guis;

import de.zblubba.quizcupv2.commands.CloseChatCommand;
import de.zblubba.quizcupv2.commands.StateCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AdminGUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();

        if(event.getCurrentItem() == null) return;
        if(event.getView().getTitle().equals("§eQuizCup §8- §cAdminSettings")) {
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "chat" -> {
                        if(CloseChatCommand.isChatClose) {
                            p.performCommand("chat open");
                        } else p.performCommand("chat close");
                    }
                    case "serverstate" -> {
                        if(StateCommand.isIsClosed()) {
                            p.performCommand("state open");
                        } else p.performCommand("state close");
                    }
                    case "nextquestion" -> p.performCommand("startfrage next");
                    case "tpall" -> p.performCommand("tp @a -2.5 107 8.5");
                    case "gates" -> p.performCommand("gates");
                    case "tools" -> p.performCommand("tools");
                }
            }
        }
    }
}
