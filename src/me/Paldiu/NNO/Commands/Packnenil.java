package me.Paldiu.NNO.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Packnenil implements CommandExecutor
{
    public Main plugin;
    public Packnenil(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("packnenil"))
        {
            if (sender instanceof Player)
            {
                final Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.packnenil"))
                {
                    p.sendMessage(ChatColor.YELLOW + "Engaging the Packnenil...");
                    
                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            Bukkit.getServer().broadcastMessage(ChatColor.RED + "Do you wanna see " + p.getName() + "'s nenil?");
                        }
                    }.runTaskLater(plugin, 40L * 2L);
                    return true;
                }
                else
                {
                    Main.noPermission(p);
                    return true;
                }
            } else {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return false;
    }
}