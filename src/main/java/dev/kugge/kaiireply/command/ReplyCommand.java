package dev.kugge.kaiireply.command;

import dev.kugge.kaiireply.Kaiireply;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReplyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String recipient = Kaiireply.playerRelation.get(sender.getName());
        String cmd = "msg " + recipient + " " + String.join(" ", args);
        Kaiireply.logger.info(cmd);
        return Bukkit.dispatchCommand(sender, cmd);
    }
}