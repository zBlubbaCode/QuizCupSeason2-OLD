package de.zblubba.quizcupv2;

import de.zblubba.quizcupv2.commands.*;
import de.zblubba.quizcupv2.fragensystem.*;
import de.zblubba.quizcupv2.guis.*;
import de.zblubba.quizcupv2.listeners.*;
import de.zblubba.quizcupv2.util.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Quizcupv2 extends JavaPlugin {

    public static final String getPrefix = "§eQuizCup §8| §7";
    public static final String getFinalPrefix = "§c§lFinale §8| §7";
    public static final String geNoPerms = getPrefix + "§cDazu hast du keine Berechtigungen!";

    private static Quizcupv2 instance;
    public Scoreboard scoreboard = new Scoreboard();

    @Override
    public void onEnable() {

        registerListeners();
        registerCommands();

        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new GeneralListeners(), this);
        pm.registerEvents(new JoinQuitListener(), this);
        pm.registerEvents(new MotdListener(), this);
        pm.registerEvents(new AdminGUIListener(), this);
        pm.registerEvents(new ToolsGUIListener(), this);
        pm.registerEvents(new InteractionListener(), this);
        pm.registerEvents(new GateGUIListener(), this);
    }

    public void registerCommands() {
        getCommand("addfrage").setExecutor(new CreateFrageCommand());
        getCommand("addantwort").setExecutor(new AddAntwortCommand());
        getCommand("startfrage").setExecutor(new StartFrageCommand());
        getCommand("chat").setExecutor(new CloseChatCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("state").setExecutor(new StateCommand());
        getCommand("zumstart").setExecutor(new ZumStartCommand());
        getCommand("gate").setExecutor(new GateCommand());
        getCommand("start").setExecutor(new StartQuizCupCommand());
        getCommand("winner").setExecutor(new WinnerCommand());
        getCommand("invis").setExecutor(new InvisCommand());
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("finalkick").setExecutor(new FinalKickCommand());
        getCommand("getpoints").setExecutor(new GetPointsCommand());
        getCommand("startmultiplefrage").setExecutor(new StartMultipleFrage());
        getCommand("setfinal").setExecutor(new SetFinaleCommand());
        getCommand("setantwort").setExecutor(new SetAntwortCommand());
        getCommand("finalwinner").setExecutor(new FinalWinnerCommand());
        getCommand("points").setExecutor(new PointsCommand());
        getCommand("b").setExecutor(new BuzzerCommand());
        getCommand("tablequestion").setExecutor(new TableCommand());

        //gates / gui's
        getCommand("gates").setExecutor(new GateGUICommand());
        getCommand("admin").setExecutor(new AdminGUICommand());
        getCommand("tools").setExecutor(new ToolsGUICommand());
    }

    public static Quizcupv2 getInstance() {return instance;}
}
