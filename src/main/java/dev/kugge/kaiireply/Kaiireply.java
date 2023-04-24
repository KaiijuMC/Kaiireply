package dev.kugge.kaiireply;

import dev.kugge.kaiireply.command.ReplyCommand;

import dev.kugge.kaiireply.watcher.MsgWatcher;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class Kaiireply extends JavaPlugin {

    public static Logger logger;
    public static Map<String, String> playerRelation = new ConcurrentHashMap<>();

    @Override
    public void onEnable() {
        logger = getLogger();
        register();
    }

    private void register(){
        getCommand("r").setExecutor(new ReplyCommand());
        Bukkit.getPluginManager().registerEvents(new MsgWatcher(), this);
    }
}
