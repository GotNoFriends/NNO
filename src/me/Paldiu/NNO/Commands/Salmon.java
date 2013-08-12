package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Salmon implements CommandExecutor
{
    public Main plugin;
    public Salmon(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("salmon"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.salmon"))
                {
                    Location l = p.getLocation();
                    l.setY(132);
                    p.teleport(l);
                    p.setVelocity(new Vector(0, 10, 0));
                    Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " was slapped by a wet salmon.");
                    p.setHealth(20);
                    p.damage(3);
                    return true;
                }
                else
                {
                    p.sendMessage(Main.MSG_NO_PERMS);
                    return true;
                }
            }
            else
            {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return false;
    }
}