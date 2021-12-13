package sebroar.discovery.common.registry;

import java.util.function.Supplier;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sebroar.discovery.Discovery;

public class DiscoveryPotions {
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Discovery.MODID);
	
	public static final RegistryObject<Potion> DARKLIP_EXTRACT = registerPotion("darklip_extract", () -> new Potion());
	public static final RegistryObject<Potion> PURIFICATION = registerPotion("purification", () -> new Potion(new EffectInstance(DiscoveryEffects.PURIFICATION.get(), 3600)));
	
	private static <T extends Potion> RegistryObject<T> registerPotion(String name, Supplier<T> supplier) {
		return POTIONS.register(name, supplier);
	}
	public static void register(IEventBus eventBus) {
		POTIONS.register(eventBus);
	}
}
