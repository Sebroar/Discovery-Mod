package sebroar.discovery.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import sebroar.discovery.common.registry.DiscoveryEffects;

public class CorruptionUtils {
	public static void applyCorruptionOnHit(LivingEntity entity, int duration, float failChance) {
		if (entity.level.dimension() == DiscoveryWorldUtils.THE_GRIMLANDS) entity.addEffect(new EffectInstance(DiscoveryEffects.CORRUPTION.get(), duration));
		else applyCorruptionOnHitOutsideGrimlands(entity, duration, failChance);
	}
	public static void applyCorruptionOnHitOutsideGrimlands(LivingEntity entity, int duration, float failChance) {
		float random = (float) Math.random();
		if (!entity.level.dimensionType().hasCeiling() && entity.level.canSeeSky(entity.blockPosition()) && entity.level.isDay()) {
			failChance *= 2;
		}
		if (random >= failChance) entity.addEffect(new EffectInstance(DiscoveryEffects.CORRUPTION.get(), duration));
	}
}
