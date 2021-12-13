package sebroar.discovery.common.registry;

import java.util.function.Supplier;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sebroar.discovery.Discovery;
import sebroar.discovery.potion.CorruptionEffect;
import sebroar.discovery.potion.DiscoveryBasicEffect;

public class DiscoveryEffects {
	public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Discovery.MODID);
	
	//Registries
	public static final RegistryObject<Effect> CORRUPTION = registerEffect("corruption", () -> new CorruptionEffect(EffectType.HARMFUL, 3673173).addAttributeModifier(Attributes.MOVEMENT_SPEED, "7A996A8B-666A-47E7-83F7-FCFD17768B58", -1d, AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.ATTACK_SPEED, "004CB77F-666D-4A59-B5B7-2192065CC517", -1.0d, Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.ATTACK_DAMAGE, "14FAF0DC-1F29-4A6F-A41D-50A1F2B2010C", -1.0d, Operation.MULTIPLY_TOTAL));
	public static final RegistryObject<Effect> PURIFICATION = registerEffect("purification", () -> new DiscoveryBasicEffect(EffectType.BENEFICIAL, 16184420));
	
	//Registry methods
	private static <T extends Effect> RegistryObject<T> registerEffect(String registryName, Supplier<T> supplier) {
		return EFFECTS.register(registryName, supplier);
	}
	public static void register(IEventBus eventBus) {
		EFFECTS.register(eventBus);
	}
}
