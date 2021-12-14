package sebroar.discovery.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sebroar.discovery.Discovery;
import sebroar.discovery.entity.projectile.DarknessDartEntity;
import sebroar.discovery.item.itemgroups.DiscoveryTabs;

public class DiscoveryEntityType {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Discovery.MODID);
	public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, Discovery.MODID);
	
	public static final RegistryObject<EntityType<DarknessDartEntity>> DARKNESS_DART = register("darkness_dark", DarknessDartEntity::new, 0.125f, 0.125f, 0, false, -1, -1);
	
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.IFactory<T> factory, float width, float height, int trackingRange, boolean fireImmune, int eggColor1, int eggColor2) {
		EntityType.Builder<T> typeBuilder = EntityType.Builder.of(factory, EntityClassification.MISC).sized(width, height).setTrackingRange(trackingRange);
		if (fireImmune) {
			typeBuilder.fireImmune();
		}
		EntityType<T> entityType = typeBuilder.build(name);
		if (eggColor1 != -1 && eggColor2 != -1) SPAWN_EGGS.register(name + "spawn_egg", () -> new SpawnEggItem(entityType, eggColor1, eggColor2, new Item.Properties().tab(DiscoveryTabs.DISCOVERY_ITEMS)));
		return ENTITIES.register(name, () -> entityType);
	}
	public static void register(IEventBus eventBus) {
		ENTITIES.register(eventBus);
		SPAWN_EGGS.register(eventBus);
	}
}
