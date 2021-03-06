package ch.nte.mc.bungee.bedwars.main;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ch.nte.mc.bungee.bedwars.cosmetics.ScoreBoardManager;
import ch.nte.mc.bungee.bedwars.teams.TeamForcer;
import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.world.BorderWorld;
import ch.nte.mc.bungee.bedwars.world.Spawner;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class GameStartMechanism implements Listener {
	
	private static int counter;
	private static int task;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Bukkit.getServer().getOnlinePlayers().size() >= ConfigCopy.getTeamAmount*ConfigCopy.getTeamSize) {
			startCountdown();
		}
	}

	public static void start() {
		TeamForcer.fillTeams();
		MainVariables.isCountdownRunning = false;
		MainVariables.isGameRunning = true;
		for(Player p: Bukkit.getOnlinePlayers()) {
			p.getInventory().clear();
			p.teleport(MainVariables.playerTeamMap.get(p).getSpawn());
		}
		clearInvs();
		ScoreBoardManager.updateScoreBoard();
		BorderWorld.createBorder();
		Spawner.startSpawner();
		//Spawn Villager
	}
	
	public static void startCountdown() {
		MainVariables.isCountdownRunning = true;
		counter = 5;
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainVariables.plugin, new Runnable() {
			
			@Override
			public void run() {
				if(counter == 0) {
					start();
					Bukkit.getScheduler().cancelTask(task);
					return;
				}
				for(Player p: Bukkit.getOnlinePlayers()) {
					System.out.println(counter);
					((CraftPlayer)p).getHandle().playerConnection.sendPacket(generateNumbers(counter));
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 20, 1);
				}
				counter -= 1;
			}
		}, 0l, 20l);
	}
	
	private static PacketPlayOutTitle generateNumbers(int number) {
		switch (number) {
		case 1:
			return  new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"1\",\"bold\":true,\"color\":\"yellow\"}"), 0, 10, 10);
		case 2:
			return  new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"2\",\"bold\":true,\"color\":\"green\"}"), 0, 10, 10);
		case 3:
			return  new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"3\",\"bold\":true,\"color\":\"blue\"}"), 0, 10, 10);
		case 4:
			return  new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"4\",\"bold\":true,\"color\":\"dark_blue\"}"), 0, 10, 10);
		case 5:
			return  new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"5\",\"bold\":true,\"color\":\"dark_purple\"}"), 0, 10, 10);
		}
		return null;
	}
	
	private static void clearInvs() {
		for(Player p: Bukkit.getOnlinePlayers()) {
			p.getInventory().clear();
		}
	}
	
}
