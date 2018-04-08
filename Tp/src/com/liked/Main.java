package com.liked;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
private static Main instance;
	
	public static Main getInstance() {
	        return Main.instance;
	    }

	public void onEnable() {
		System.out.println("§ePlugin de teleport habilitado com sucesso.");
		getCommand("tp").setExecutor(new Tp());
	}
}
