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
				p.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			 return true;	
			}
			
			if(args.length == 0) {
			    p.sendMessage("�cVoc� precisa usar /tp <jogador> para teletransportar-se.");
				return true;
			}
			if(args.length == 1) {
				Player z = Bukkit.getPlayer(args[0]);
				
				if(z != null) {
					if(z == p) {
						p.sendMessage("�cVoc� n�o pode se teletransportar para is mesmo.");
					} else {
						p.teleport(z);
						p.sendMessage("");
						p.sendMessage("�eVoc� teletransportou-se para o jogador�7 " + z.getName() + "�e.");
						p.sendMessage("");
					}
				} else {
					p.sendMessage("�eN�o foi poss�vel encontrar este jogador.");
				}
			}
			if(args.length == 2) {
				
				Player z2 = Bukkit.getPlayerExact(args[0]);
				Player s2 = Bukkit.getPlayerExact(args[1]);
				
				if(z2 != null) {
					if(z2 == s2) {
						p.sendMessage("�cVoc� n�o pode teleportar o jogador para ele mesmo.");
					} else {
						s2.teleport(z2);
						z2.sendMessage("�eVoc� foi puxado at� o jogador�7 " + s2.getName() + "�e.");
						s2.sendMessage("");
						s2.sendMessage("�eVoc� foi puxado pelo staffer �b" + p.getName() + " para o jogador �7" + s2.getName() + "�e.");
						s2.sendMessage("");
					}
				} else {
					p.sendMessage("�eN�o foi poss�vel encontrar este jogador.");
				}
				
			}
			
		}
		
		return false;
	}
	
	

}
