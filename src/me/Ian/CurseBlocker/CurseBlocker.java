package me.Ian.CurseBlocker;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class CurseBlocker extends JavaPlugin implements Listener {
	//Declaring the counter, the player, and the muted player
	int num = 0;
	Player mutedplayer;
	Player player1;
	//When it is enabled, do this:
	public void onEnable(){
		getLogger().info("Curse-Blocker Has Been Enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	//When the it is disabled do this:
	public void onDisable(){
		getLogger().info("Curse-Blocker Has Been Disabled!");
	}
	//On the event of a person saying a message in GLOBAL CHAT
	
	
	
	
	@EventHandler
		public void onChat(final AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
			if (mutedplayer == event.getPlayer() && num == 1){
				 Bukkit.broadcastMessage(ChatColor.BLUE + "[Event] " + ChatColor.GRAY + "Your still muted");
	                event.setCancelled(true);
	               
	                
	            	final Timer timer = new Timer ();
	        		TimerTask hourlyTask = new TimerTask () {

	        			
	        		    @Override
	        		    public void run () {
	        		    	if (num == 1){
	        		    		
	        		    	
	        		    	 Bukkit.broadcastMessage(ChatColor.BLUE + "[Event] " + ChatColor.GRAY + "Your unmuted, don't curse again!");
		     	                player1 = event.getPlayer();
	     	                event.setCancelled(false);
	     	                num--;

	        				}else{
		        		    	 player1 = event.getPlayer();
		        		    	 num = 0;
	        		    }
	        		    }
	        		    	

	        		
	        		    
	        		};
	        		    	
	        			timer.schedule (hourlyTask, 60000);
	                
	  
	                
	                
	 
			}else if (player == event.getPlayer() | player1 == event.getPlayer() && num == 0){
				
			String y = event.getMessage();

				 
			 //Sorry for having the curse words in the code I'm still working on a configuration file.
			 
			 if (y.contains("fuck") | (y.contains("bitch") | (y.contains("puss") | (y.contains("nigger") | (y.contains("cunt")
					 | (y.contains("dick") | (y.contains("shit") | (y.contains("ass") | 
			 
			 
				 (y.contains("Fuck") | (y.contains("Bitch") | (y.contains("Puss") | (y.contains("Nigger") | (y.contains("Cunt")
						 | (y.contains("Dick") | (y.contains("Shit") | (y.contains("Ass") |
			 
				 (y.contains("FUCK") | (y.contains("BITCH") | (y.contains("PUSSY") | (y.contains("NIGGER") | (y.contains("CUNT")
						 | (y.contains("DICK") | (y.contains("SHIT") | (y.contains("ASS") ))))))))))))))))))))))))
			 
			 
			 
			 {

				player = event.getPlayer();
					Bukkit.broadcastMessage(ChatColor.BLUE + "[Event] " + ChatColor.GRAY + "Dont say that word, you have been muted for 1 minute");
	                mutedplayer = event.getPlayer();
	                num++;
	                event.setCancelled(true);
	                
	                
	                
	                
				
				 
			 }
			 
			 
	                
			 }
				


	
		}
	
	
}
