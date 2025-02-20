package io.github.swagree.rebindpokestatue;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityStatue;
import net.minecraft.server.v1_12_R1.Entity;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;
import java.util.Set;

public class GuiListener implements Listener {


    @EventHandler
    public void onPlayerClickEntity(PlayerInteractEntityEvent event) {
        // 检查是否为主手点击
        if (event.getHand() != EquipmentSlot.HAND) {
            return; // 忽略副手触发
        }
        CraftEntity entity = (CraftEntity)(event.getRightClicked());
        Entity handle = entity.getHandle();
        if ((net.minecraft.entity.Entity)(Object)handle instanceof EntityStatue){
            Set<String> keys = Main.plugin.getConfig().getKeys(false);
            for (String key : keys) {
                if(((EntityStatue)(Object)handle).getLabel().equalsIgnoreCase(key)){
                    List<String> commands = Main.plugin.getConfig().getStringList(key);
                    for (String command : commands) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),command.replace("%player%",event.getPlayer().getName()));
                    }
                }
            }

        }
    }



}
