package dev.kugge.kaiireply.watcher;

import dev.kugge.kaiireply.Kaiireply;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class MsgWatcher implements Listener {
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        List<String> args = List.of(event.getMessage().split(" "));
        if (args.contains("/msg")) {
            if (args.size() >= 2) {
                String sender = event.getPlayer().getName();
                String recipient = args.get(1);
                if (Bukkit.getPlayer(recipient) != null) {
                    Kaiireply.playerRelation.put(sender, recipient);
                    Kaiireply.playerRelation.put(recipient, sender);
                }
            }
        }
    }
}
