package de.zblubba.quizcupv2.util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;


public class Scoreboard {

    public void setScoreboard(Player p) {
        org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("QuizCup", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.setDisplayName("   §e§lQuiz§6§lCup §eV2  ");

        obj.getScore("§b").setScore(15);
        obj.getScore("§3➥ §7Server by").setScore(14);
        obj.getScore("  §8● §9CombiGamerHD").setScore(13);
        obj.getScore("§a").setScore(12);
        obj.getScore("§3➥ §7Coded by").setScore(11);
        obj.getScore("  §8● §bzBlubba").setScore(10);
        obj.getScore("§3 ").setScore(9);
        obj.getScore("§3➥ §7Dein Rang").setScore(8);
        if(p.hasPermission("quizcup.admin")) {obj.getScore("  §8● §cAdmin").setScore(7);
        } else if(p.hasPermission("quizcup.helper")) {obj.getScore("  §8● §6Helfer").setScore(7);
        } else {if(p.getGameMode() != GameMode.SPECTATOR) {obj.getScore("  §8● §bSpieler").setScore(7);} else {obj.getScore("  §8● §9Spectator").setScore(7);}}
        obj.getScore("§8").setScore(6);
        obj.getScore("§3➥ §cby Drachen Kult").setScore(5);
        obj.getScore("  §8● §9dsc.gg/drachenkult").setScore(4);
        obj.getScore("§0").setScore(3);
        obj.getScore("       §cdrachenkult.com").setScore(1);

        p.setScoreboard(board);
    }

    public void setTab(Player p) {
        org.bukkit.scoreboard.Scoreboard board = p.getScoreboard();

        Team admin = board.registerNewTeam("0000Admin");
        Team helper = board.registerNewTeam("0005Helfer");
        Team spieler = board.registerNewTeam("1111Spieler");
        Team specs = board.registerNewTeam("2222Spectator");

        admin.setPrefix("§cAdmin §8| §c");
        helper.setPrefix("§6Helfer §8| §6");
        spieler.setPrefix("§bSpieler §8| §b");
        specs.setPrefix("§9Spec §8| §9");

        for(Player players : Bukkit.getOnlinePlayers()) {
            if(players.hasPermission("quizcup.admin")) {
                admin.addEntry(players.getName());
            } else if(players.hasPermission("quizcup.helper")) {
                helper.addEntry(players.getName());
            } else {
                if(players.getGameMode() == GameMode.SPECTATOR) {
                    specs.addEntry(players.getName());
                } else {
                    spieler.addEntry(players.getName());
                }
            }
        }
    }

    public void updateTab(Player p) {
        org.bukkit.scoreboard.Scoreboard board = p.getScoreboard();

        Team admin = board.getTeam("0000Admin");
        Team helper = board.getTeam("0005Helfer");
        Team spieler = board.getTeam("1111Spieler");
        Team specs = board.getTeam("2222Spectator");

        if(admin == null || helper == null || spieler == null) {
            setTab(p);
            return;
        }

        for(Player players : Bukkit.getOnlinePlayers()) {
            if(players.hasPermission("quizcup.admin")) {
                admin.addEntry(players.getName());
            } else if(players.hasPermission("quizcup.helper")) {
                helper.addEntry(players.getName());
            } else {
                if(players.getGameMode() == GameMode.SPECTATOR) {
                    specs.addEntry(players.getName());
                } else {
                    spieler.addEntry(players.getName());
                }
            }
        }
    }

}
