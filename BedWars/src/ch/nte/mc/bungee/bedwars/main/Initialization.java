package ch.nte.mc.bungee.bedwars.main;

import org.bukkit.Bukkit;

import ch.nte.mc.bungee.bedwars.cosmetics.MessageManager;
import ch.nte.mc.bungee.bedwars.cosmetics.ScoreBoardManager;
import ch.nte.mc.bungee.bedwars.cosmetics.TablistUpdater;
import ch.nte.mc.bungee.bedwars.objects.Team;
import ch.nte.mc.bungee.bedwars.teams.FriendlyFireManager;
import ch.nte.mc.bungee.bedwars.teams.TeamChooser;
import ch.nte.mc.bungee.bedwars.variables.ConfigCopy;
import ch.nte.mc.bungee.bedwars.variables.MainVariables;
import ch.nte.mc.bungee.bedwars.villager.Villager;
import ch.nte.mc.bungee.bedwars.villager.VillagerProtector;
import ch.nte.mc.bungee.bedwars.world.BedListener;
import ch.nte.mc.bungee.bedwars.world.BuildDisabler;
import ch.nte.mc.bungee.bedwars.world.LobbyProtector;
import ch.nte.mc.bungee.bedwars.world.SpawnManager;
import ch.nte.mc.bungee.bedwars.world.WeatherManager;

public class Initialization {

	public static void init() {
		variablesInit();
		registerEvents();
		teamInit();
		ScoreBoardManager.initScoreBoard();
	}
	
	private static void registerEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(new SpawnManager(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new TeamChooser(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new BuildDisabler(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new TablistUpdater(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new FriendlyFireManager(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new GameStartMechanism(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new MessageManager(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new WeatherManager(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new ScoreBoardManager(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new BedListener(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new Villager(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new VillagerProtector(), MainVariables.plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new LobbyProtector(), MainVariables.plugin);
	}
	
	private static void variablesInit() {
		MainVariables.isGameRunning = false;
	}
	
	private static void teamInit() {
		switch (ConfigCopy.getTeamAmount) {
		case 2:
			MainVariables.team1 = new Team(1, ConfigCopy.getTeamSize);
			MainVariables.team2 = new Team(2, ConfigCopy.getTeamSize);
			break;
		case 3:
			MainVariables.team1 = new Team(1, ConfigCopy.getTeamSize);
			MainVariables.team2 = new Team(2, ConfigCopy.getTeamSize);
			MainVariables.team3 = new Team(3, ConfigCopy.getTeamSize);
			break;
		case 4:
			MainVariables.team1 = new Team(1, ConfigCopy.getTeamSize);
			MainVariables.team2 = new Team(2, ConfigCopy.getTeamSize);
			MainVariables.team3 = new Team(3, ConfigCopy.getTeamSize);
			MainVariables.team4 = new Team(4, ConfigCopy.getTeamSize);
			break;
		}
	}
}
