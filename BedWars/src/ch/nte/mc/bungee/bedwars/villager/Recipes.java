package ch.nte.mc.bungee.bedwars.villager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import ch.nte.mc.bungee.bedwars.objects.Enchantments;

public class Recipes {
	
	public static void addBlocks(Merchant villager) {
		MerchantOffer sandstone = new MerchantOffer(new ItemStack(Material.CLAY_BRICK),
				getItemForOffer(Material.SANDSTONE, 2, (byte) 0, "�eBB - Building Block", null));
		villager.addOffer(sandstone);
		
		MerchantOffer endStone = new MerchantOffer(new ItemStack(Material.CLAY_BRICK, 7),
				getItemForOffer(Material.ENDER_STONE, 1, (byte) 0, "�eEnd stone", null));
		villager.addOffer(endStone);
		
		MerchantOffer ironBlock = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 3), 
				getItemForOffer(Material.IRON_BLOCK, 1, (byte) 0, "�64IronBlock(1pumpkinhead)", null));
		villager.addOffer(ironBlock);
	}
	
	public static void addArmor(Merchant villager, Color color) {
		List<Enchantments> enchantments = new ArrayList<>();
		MerchantOffer letherHelmet = new MerchantOffer(new ItemStack(Material.CLAY_BRICK),
				getColoredArmor(Material.LEATHER_HELMET, 1, (byte) 0, "Suprem Cap", null, color));
		
		MerchantOffer leatherLeggins = new MerchantOffer(new ItemStack(Material.CLAY_BRICK),
				getColoredArmor(Material.LEATHER_LEGGINGS, 1, (byte) 0, "Tommy Jeans", null, color));
		
		MerchantOffer leatherBoots = new MerchantOffer(new ItemStack(Material.CLAY_BRICK),
				getColoredArmor(Material.LEATHER_BOOTS, 1, (byte) 0, "Adiletten", null, color));
		
		enchantments.add(new Enchantments(Enchantment.PROTECTION_ENVIRONMENTAL, 1));
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		MerchantOffer chainPlate1 = new MerchantOffer(new ItemStack(Material.IRON_INGOT),
				getItemForOffer(Material.CHAINMAIL_CHESTPLATE, 1, (byte) 0, enchantments, "�7Levis Shirt Lv.1", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.PROTECTION_ENVIRONMENTAL, 2));
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		MerchantOffer chainPlate2 = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 3),
				getItemForOffer(Material.CHAINMAIL_CHESTPLATE, 1, (byte) 0, enchantments, "�7Levis Shirt Lv.2", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.PROTECTION_ENVIRONMENTAL, 3));
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		MerchantOffer chainPlate3 = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 7),
				getItemForOffer(Material.CHAINMAIL_CHESTPLATE, 1, (byte) 0, enchantments, "�7Levis Shirt Lv.3", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.PROTECTION_FALL, 3));
		MerchantOffer goldenShoes = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 3),
				getItemForOffer(Material.GOLD_BOOTS, 1, (byte) 0, enchantments, "�bYeezy", null));
		enchantments.clear();
		
		villager.addOffer(letherHelmet);
		villager.addOffer(leatherLeggins);
		villager.addOffer(leatherBoots);
		villager.addOffer(chainPlate1);
		villager.addOffer(chainPlate2);
		villager.addOffer(chainPlate3);
		villager.addOffer(goldenShoes);
	}
	
	public static void addTools(Merchant villager) {
		List<Enchantments> enchantments = new ArrayList<>();
		enchantments.add(new Enchantments(Enchantment.DIG_SPEED, 1));
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		MerchantOffer woodenPickAxe = new MerchantOffer(new ItemStack(Material.CLAY_BRICK, 4),
				getItemForOffer(Material.WOOD_PICKAXE, 1, (byte) 0, enchantments, "Miner's Friend Lv.1", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.DIG_SPEED, 1));
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		MerchantOffer stonePickAxe = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 2),
				getItemForOffer(Material.STONE_PICKAXE, 1, (byte) 0, enchantments, "Miner's Friend Lv.2", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.DIG_SPEED, 3));
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		MerchantOffer ironPickAxe = new MerchantOffer(new ItemStack(Material.GOLD_INGOT, 1),
				getItemForOffer(Material.IRON_PICKAXE, 1, (byte) 0, enchantments, "Miner's Friend Lv.3", null));
		enchantments.clear();
		
		MerchantOffer fishingRod = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 5),
				getItemForOffer(Material.FISHING_ROD, 1, (byte) 0, "Fishermans Friend", null));
		
		MerchantOffer flintAndSteal = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 7),
				getItemForOffer(Material.FLINT_AND_STEEL, 1, (byte) 0, "�cS Br�dlifr�sser Spielze��g", null));
		
		villager.addOffer(woodenPickAxe);
		villager.addOffer(stonePickAxe);
		villager.addOffer(ironPickAxe);
		villager.addOffer(fishingRod);
		villager.addOffer(flintAndSteal);
	}
	
	public static void addWeapons(Merchant villager) {
		List<Enchantments> enchantments = new ArrayList<>();
		enchantments.add(new Enchantments(Enchantment.KNOCKBACK, 1));
		MerchantOffer stick = new MerchantOffer(new ItemStack(Material.CLAY_BRICK, 8),
				getItemForOffer(Material.STICK, 1, (byte) 0, enchantments, "�9Albin", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		enchantments.add(new Enchantments(Enchantment.DAMAGE_ALL, 1));
		MerchantOffer sword1 = new MerchantOffer(new ItemStack(Material.IRON_INGOT),
				getItemForOffer(Material.GOLD_SWORD, 1, (byte) 0, enchantments, "�cSchwiizer Armee Sackm�sser Lv.1", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		enchantments.add(new Enchantments(Enchantment.DAMAGE_ALL, 2));
		MerchantOffer sword2 = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 3),
				getItemForOffer(Material.GOLD_SWORD, 1, (byte) 0, enchantments, "�cSchwiizer Armee Sackm�sser Lv.2", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.DURABILITY, 1));
		enchantments.add(new Enchantments(Enchantment.DAMAGE_ALL, 2));
		enchantments.add(new Enchantments(Enchantment.KNOCKBACK, 1));
		MerchantOffer sword3 = new MerchantOffer(new ItemStack(Material.GOLD_INGOT, 5),
				getItemForOffer(Material.IRON_SWORD, 1, (byte) 0, enchantments, "�cSchwiizer Armee Sackm�sser Lv.2", null));
		enchantments.clear();
		
		villager.addOffer(stick);
		villager.addOffer(sword1);
		villager.addOffer(sword2);
		villager.addOffer(sword3);
	}
	
	public static void addBows(Merchant villager) {
		List<Enchantments> enchantments = new ArrayList<>();
		enchantments.add(new Enchantments(Enchantment.ARROW_INFINITE, 1));
		MerchantOffer bow1 = new MerchantOffer(new ItemStack(Material.GOLD_INGOT, 3),
				getItemForOffer(Material.BOW, 1, (byte) 0, enchantments, "�4S B�gli machts m�gli! Lv.1", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.ARROW_INFINITE, 1));
		enchantments.add(new Enchantments(Enchantment.ARROW_DAMAGE, 1));
		MerchantOffer bow2 = new MerchantOffer(new ItemStack(Material.GOLD_INGOT, 7),
				getItemForOffer(Material.BOW, 1, (byte) 0, enchantments, "�4S B�gli machts m�gli! Lv.2", null));
		enchantments.clear();
		
		enchantments.add(new Enchantments(Enchantment.ARROW_INFINITE, 1));
		enchantments.add(new Enchantments(Enchantment.ARROW_DAMAGE, 1));
		enchantments.add(new Enchantments(Enchantment.ARROW_KNOCKBACK, 1));
		MerchantOffer bow3 = new MerchantOffer(new ItemStack(Material.GOLD_INGOT, 13),
				getItemForOffer(Material.BOW, 1, (byte) 0, enchantments, "�4De Urs Lv.3", null));
		enchantments.clear();
		
		MerchantOffer arrow = new MerchantOffer(new ItemStack(Material.GOLD_INGOT),
				getItemForOffer(Material.ARROW, 1, (byte) 0, "�8Der Schelm", null));
		
		villager.addOffer(bow1);
		villager.addOffer(bow2);
		villager.addOffer(bow3);
		villager.addOffer(arrow);
	}
	
	public static void addFood(Merchant villager) {
		MerchantOffer apple = new MerchantOffer(new ItemStack(Material.CLAY_BRICK),
				getItemForOffer(Material.APPLE, 1, (byte) 0, "Elektroschrott", null));
		MerchantOffer steak = new MerchantOffer(new ItemStack(Material.CLAY_BRICK, 2),
				getItemForOffer(Material.COOKED_BEEF, 1, (byte) 0, "4Islam", null));
		MerchantOffer cake = new MerchantOffer(new ItemStack(Material.IRON_INGOT),
				getItemForOffer(Material.CAKE, 1, (byte) 0, "LEEEGGER", null));
		MerchantOffer gap = new MerchantOffer(new ItemStack(Material.GOLD_INGOT, 2),
				getItemForOffer(Material.GOLDEN_APPLE, 1, (byte) 0, "�6Heroin", null));
		
		villager.addOffer(apple);
		villager.addOffer(steak);
		villager.addOffer(cake);
		villager.addOffer(gap);
	}
	
	public static void addPotions(Merchant villager) {
		MerchantOffer heal1 = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 3),
				getPotion(Material.POTION, (byte) 8197, "HelthBooster1000"));
		MerchantOffer heal2 = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 5),
				getPotion(Material.POTION, (byte) 8229, "HelthBooster2000"));
		MerchantOffer speed = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 7),
				getPotion(Material.POTION, (byte) 8194, "Sport ist Mord!"));
		MerchantOffer jump = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 15),
				getPotion(Material.POTION, (byte) 8235, "Hochsprung mit H�nggli"));
		MerchantOffer invis = new MerchantOffer(new ItemStack(Material.IRON_INGOT, 32),
				getPotion(Material.POTION, (byte) 8206, "Wear armor for best results"));
		MerchantOffer strengh = new MerchantOffer(new ItemStack(Material.GOLD_INGOT, 7),
				getPotion(Material.POTION, (byte) 8201, "�bVolg Energy Drink"));
		
		villager.addOffer(heal1);
		villager.addOffer(heal2);
		villager.addOffer(speed);
		villager.addOffer(jump);
		villager.addOffer(invis);
		villager.addOffer(strengh);
	}
	
	public static void addChests(Merchant villager) {
		MerchantOffer chest = new MerchantOffer(new ItemStack(Material.IRON_INGOT),
				getItemForOffer(Material.CHEST, 1, (byte) 0, "Chest", null));
		villager.addOffer(chest);
	}
	
	public static void addSpecials(Merchant villager) {
		MerchantOffer ladder = new MerchantOffer(new ItemStack(Material.CLAY_BRICK),
				getItemForOffer(Material.LADDER, 1, (byte) 0, "Leiter(w�gli)", null));
		MerchantOffer cob = new MerchantOffer(new ItemStack(Material.CLAY_BRICK, 16),
				getItemForOffer(Material.WEB, 1, (byte) 0, "Poishii", null));
		MerchantOffer ep = new MerchantOffer(new ItemStack(Material.GOLD_INGOT, 13),
				getItemForOffer(Material.ENDER_PEARL, 1, (byte) 0, "John Cena Tool", null));
		villager.addOffer(ladder);
		villager.addOffer(cob);
		villager.addOffer(ep);
	}
	
	private static ItemStack getItemForOffer(Material material, int amount, byte damage, String name, String[] lore) {
		ItemStack item = new ItemStack(material, amount, damage);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		if(lore != null) {
			List<String> loreList = Arrays.asList(lore);
			meta.setLore(loreList);
		}
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack getItemForOffer(Material material, int amount, byte damage, List<Enchantments> enchantments, String name, String[] lore) {
		ItemStack item = new ItemStack(material, amount, damage);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		if(lore != null) {
			List<String> loreList = Arrays.asList(lore);
			meta.setLore(loreList);
		}
		item.setItemMeta(meta);
		if(enchantments != null) {
			for(int i = 0; i<enchantments.size(); i++) {
				System.out.println("added enchantment: " + enchantments.get(i).getEnchantment().getName() + " " + String.valueOf(enchantments.get(i).getLevel()));
				item.addUnsafeEnchantment(enchantments.get(i).getEnchantment(), enchantments.get(i).getLevel());
			}
		}
		return item;
	}
	
	private static ItemStack getColoredArmor(Material material, int amount, byte damage, String name, String[] lore, Color color) {
		ItemStack item = new ItemStack(material, amount, damage);
		item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		item.addEnchantment(Enchantment.DURABILITY, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setDisplayName(name);
		if(lore != null) {
			List<String> loreList = Arrays.asList(lore);
			meta.setLore(loreList);
		}
		if(color != null) {
			meta.setColor(color);
		}
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack getPotion(Material material, byte data, String name) {
		ItemStack item = new ItemStack(material, 1, data);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
}
