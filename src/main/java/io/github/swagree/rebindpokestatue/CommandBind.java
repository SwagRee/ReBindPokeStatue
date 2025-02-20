package io.github.swagree.rebindpokestatue;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandBind implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 || args[0].equalsIgnoreCase("reload")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"plugin reload rebindpokestatue");
            return false;
        }



        return false;
    }


}
