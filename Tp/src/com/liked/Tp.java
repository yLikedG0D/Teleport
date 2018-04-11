package com.liked;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Tp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("tp")) {
			
			if(!p.hasPermission("sender.cmd.tp")) {
				p.sendMessage(Main.getInstance().getConfig().getString("Tp.NoPerm").replace("&", "§"));
			 return true;	
			}
			
			if(args.length == 0) {
			    p.sendMessage(Main.getInstance().getConfig().getString("Tp.UsageArg").replace("&", "§"));
				return true;
			}
			if(args.length == 1) {
				Player z = Bukkit.getPlayer(args[0]);
				
				if(z != null) {
					if(z == p) {
						p.sendMessage(Main.getInstance().getConfig().getString("Tp.YouSelf").replace("&", "§"));
					} else {
						p.teleport(z);
						p.sendMessage(Main.getInstance().getConfig().getString("Tp.Teleported").replace("&", "§"));
					}
				} else {
					p.sendMessage(Main.getInstance().getConfig().getString("Tp.NotFoundPlayer").replace("&", "§"));
				}
			}
			if(args.length == 2) {
				if(p.hasPermission("sender.cmd.tp.admin")) {
				Player z2 = Bukkit.getPlayerExact(args[0]);
				Player s2 = Bukkit.getPlayerExact(args[1]);
				
				if(z2 != null && s2 != null) {
					if(z2 == s2 && s2 != z2) {
						p.sendMessage("§cVocê não pode teletransportar outro jogador para ele mesmo.");
					} else {
						s2.teleport(z2);
						z2.sendMessage("§eVocê foi puxado até o jogador§7 " + s2.getName() + "§e.");
						s2.sendMessage("");
						s2.sendMessage("§eVocê foi puxado pelo staffer §b" + p.getName() + " para o jogador §7" + z2.getName() + "§e.");
						s2.sendMessage("");
					}
				} else {
					p.sendMessage(Main.getInstance().getConfig().getString("Tp.NotFoundPlayer").replace("&", "§"));
				}
				
				} else {
					p.sendMessage(Main.getInstance().getConfig().getString("Tp.NoPerm").replace("&", "§"));
				}
			}
			
		}
		
		return false;
	}
	
	

}
