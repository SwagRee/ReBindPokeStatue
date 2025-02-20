package io.github.swagree.rebindpokestatue;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main extends JavaPlugin {
    public static Main plugin;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§7[ReBindPokeStatue] §b作者§fSwagRee §cQQ:§f352208610");
        Bukkit.getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getCommand("rbps").setExecutor(new CommandBind());
        saveDefaultConfig();
        reloadConfig();
        plugin = this;
    }

    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this); // 取消此插件的所有定时任务
    }
}
