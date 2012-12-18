package com.github.recklessbandit.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;


public class TestPluginCommandExecutor implements CommandExecutor {

	private TestPlugin plugin;
	
	public TestPluginCommandExecutor(TestPlugin plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
    	if (cmd.getName().equalsIgnoreCase("basic")){ 
    		sender.sendMessage("This is your basic command!");
    		
    		return true;
    		
    	} 

    	else if (cmd.getName().equalsIgnoreCase("basic2")) {
    		
    		if (!(sender instanceof Player)) {
    			sender.sendMessage("This command can only be run by a player.");
    		
    		} 
    		
    		else {

    			Player target = (Bukkit.getServer().getPlayer(args[0]));
    	        if (target == null) {
    	           sender.sendMessage(args[0] + " is not online!");
    	           return false;
    	        }
    	        
    	        PlayerInventory inventory = target.getInventory();
    	        ItemStack itemstack = new ItemStack(args[1] , args[2]);
    	        if (itemstack == null) {
    	           sender.sendMessage(args[0] + " Does not exist");
           		
    	        inventory.addItem(itemstack);
           		sender.sendMessage("Have " + args[1] + args [2]);
           		
    	           return false;
    	        
    	        }

    			
    		}
    		
    		return true;
    	
    	}
    	
    	return false;
   
	}


	
}
