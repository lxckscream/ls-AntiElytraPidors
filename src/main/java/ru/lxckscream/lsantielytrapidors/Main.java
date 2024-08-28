package ru.lxckscream.lsantielytrapidors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.nio.Buffer;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Inventory inventory = player.getInventory();
                    if (inventory.contains(Material.ELYTRA)) {
                        for (int i = 0; i < inventory.getSize(); i++) {
                            if (inventory.getItem(i).getType() == Material.ELYTRA) {
                                player.sendMessage(ChatColor.GOLD + "[Санкции] " + ChatColor.RED + "Элитры были удалены из вашего инвентаря.");
                                inventory.setItem(i, new ItemStack(Material.AIR));
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(this, 20, 20);
    }
}
