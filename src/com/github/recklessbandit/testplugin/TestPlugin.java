package com.github.recklessbandit.testplugin;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;


public final class TestPlugin extends JavaPlugin {

	@Override
	public void onEnable(){
		getLogger().info("...Test Plugin Enabled...");
		getCommand("basic").setExecutor(new TestPluginCommandExecutor(this));
		getCommand("basic2").setExecutor(new TestPluginCommandExecutor(this));
		
	}
	
	@Override
	public void onDisable() {
		getLogger().info("...Test Plugin Disabled...");

	}
	
}
