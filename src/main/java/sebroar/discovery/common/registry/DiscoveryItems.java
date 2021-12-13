package sebroar.discovery.common.registry;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sebroar.discovery.Discovery;
import sebroar.discovery.item.*;
import sebroar.discovery.item.itemgroups.DiscoveryTabs;
import sebroar.discovery.util.item.DiscoveryArmorMaterial;
import sebroar.discovery.util.item.DiscoveryItemTier;

public class DiscoveryItems {
	//Useful numbers. Hoes above iron(exclusive) use 0.0f as attack speed value. Unless required, ALWAYS USE THESE as ATTACK SPEEDS
	private static final float SWORD_SPEED = -2.4f;
	private static final float PICKAXE_SPEED = -2.8f;
	@SuppressWarnings("unused")
	private static final float WOODEN_AND_STONE_AXE_SPEED = -3.2f;
	@SuppressWarnings("unused")
	private static final float IRON_AXE_SPEED = -3.1f;
	@SuppressWarnings("unused")
	private static final float STONE_HOE_SPEED = -2.0f;
	@SuppressWarnings("unused")
	private static final float IRON_HOE_SPEED = -1.0f;
	private static final float OTHERS_SPEED = -3.0f;
	
	//Useful numbers. Unless required, ALWAYS USE THESE as ATTACK DAMAGE. For hoes, use (int) -DiscoveryItem.ITEM_TIER.getAttackDamageBonus, where ITEM_TIER is the same used in the IItemTier field
	private static final int SWORD_DAMAGE = 3;
	private static final int PICKAXE_DAMAGE = 1;
	private static final float SHOVEL_DAMAGE = 1.5f;
	@SuppressWarnings("unused")
	private static final float WOODEN_GOLDEN_AND_IRON_AXE_DAMAGE = 6.0f;
	@SuppressWarnings("unused")
	private static final float STONE_AXE_DAMAGE = 7.0f;
	private static final float DIAMOND_AND_NETHERITE_AXE_DAMAGE = 5.0f;
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Discovery.MODID);
	
	public static final RegistryObject<Item> CHISEL = registerItem("chisel", () -> new ChiselItem(new Item.Properties().tab(DiscoveryTabs.DISCOVERY_TOOLS)));
	
	public static final RegistryObject<Item> ABYSSIUM = registerItem("abyssium", () -> new Item(new Item.Properties().tab(DiscoveryTabs.DISCOVERY_ITEMS)));
	public static final RegistryObject<Item> ABYSSIUM_SWORD = registerItem("abyssium_sword", () -> new SwordItem(DiscoveryItemTier.ABYSSIUM, SWORD_DAMAGE, SWORD_SPEED, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_COMBAT)));
	public static final RegistryObject<Item> ABYSSIUM_PICKAXE = registerItem("abyssium_pickaxe", () -> new PickaxeItem(DiscoveryItemTier.ABYSSIUM, PICKAXE_DAMAGE, PICKAXE_SPEED, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_TOOLS)));
	public static final RegistryObject<Item> ABYSSIUM_AXE = registerItem("abyssium_axe", () -> new AxeItem(DiscoveryItemTier.ABYSSIUM, DIAMOND_AND_NETHERITE_AXE_DAMAGE, OTHERS_SPEED, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_TOOLS)));
	public static final RegistryObject<Item> ABYSSIUM_SHOVEL = registerItem("abyssium_shovel", () -> new ShovelItem(DiscoveryItemTier.ABYSSIUM, SHOVEL_DAMAGE, OTHERS_SPEED, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_TOOLS)));
	public static final RegistryObject<Item> ABYSSIUM_HOE = registerItem("abyssium_hoe", () -> new HoeItem(DiscoveryItemTier.ABYSSIUM, (int) -DiscoveryItemTier.ABYSSIUM.getAttackDamageBonus(), 0.0f, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_TOOLS)));
	public static final RegistryObject<Item> ABYSSIUM_HELMET = registerItem("abyssium_helmet", () -> new ArmorItem(DiscoveryArmorMaterial.ABYSSIUM, EquipmentSlotType.HEAD, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_COMBAT)));
	public static final RegistryObject<Item> ABYSSIUM_CHESTPLATE = registerItem("abyssium_chestplate", () -> new ArmorItem(DiscoveryArmorMaterial.ABYSSIUM, EquipmentSlotType.CHEST, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_COMBAT)));
	public static final RegistryObject<Item> ABYSSIUM_LEGGINGS = registerItem("abyssium_leggings", () -> new ArmorItem(DiscoveryArmorMaterial.ABYSSIUM, EquipmentSlotType.LEGS, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_COMBAT)));
	public static final RegistryObject<Item> ABYSSIUM_BOOTS = registerItem("abyssium_boots", () -> new ArmorItem(DiscoveryArmorMaterial.ABYSSIUM, EquipmentSlotType.FEET, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_COMBAT)));
	public static final RegistryObject<Item> PURIFIED_ABYSSIUM = registerItem("purified_abyssium", () -> new Item(new Item.Properties().tab(DiscoveryTabs.DISCOVERY_ITEMS)));
	public static final RegistryObject<Item> PURIFIES_ABYSSIUM_SWORD = registerItem("purified_abyssium_sword", () -> new SwordItem(DiscoveryItemTier.PURIFIED_ABYSSIUM, SWORD_DAMAGE, SWORD_SPEED, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_COMBAT)));
	
	private static <T extends Item>RegistryObject<T> registerItem(String name, Supplier<T> supplier) {
		RegistryObject<T> item = ITEMS.register(name, supplier);
		return item;
	}
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
