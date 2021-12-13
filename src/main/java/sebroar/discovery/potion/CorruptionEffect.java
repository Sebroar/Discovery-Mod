package sebroar.discovery.potion;

import java.util.List;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import sebroar.discovery.common.registry.DiscoveryEffects;
import sebroar.discovery.util.DiscoveryDamageSource;

public class CorruptionEffect extends Effect {
	public CorruptionEffect(EffectType effectType, int color) {
		super(effectType, color);
	}
	
	@Override
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
		if (livingEntity.hasEffect(DiscoveryEffects.CORRUPTION.get())) {
			livingEntity.hurt(DiscoveryDamageSource.CORRUPTION, livingEntity.getHealth() / (2.5f / (amplifier / 2 + 1)));
			livingEntity.invulnerableTime = 0;
		}
	}
	@Override
	public boolean isDurationEffectTick(int tick, int amplifier) {
		int k = 20 >> amplifier;
		if (k >= 0) {
			return tick % k == 0;
		} else {
			return true;
		}
	}
	@Override
	public List<ItemStack> getCurativeItems() {
		return null;
	}
}
