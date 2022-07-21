package de.zblubba.quizcupv2.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdListener implements Listener {

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        event.setMotd("                 §eQu§6iz §eCup §6V2 §8- §7[§a1.8§8-§a1.19§7]\n              §cEvent startet am 24.06.2022!");
    }
}