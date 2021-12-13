package sebroar.discovery.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sebroar.discovery.common.registry.DiscoveryEffects;

public class DarklipBlock extends FlowerBlock {
	public DarklipBlock(Effect stewEffect, int effectDuration, Properties properties) {
		super(stewEffect, effectDuration, properties);
	}
	@Override
	public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity) {
			LivingEntity livingEntity = (LivingEntity) entity;
			livingEntity.removeEffect(DiscoveryEffects.CORRUPTION.get());
			EffectInstance purificationInst = new EffectInstance(DiscoveryEffects.PURIFICATION.get());
			livingEntity.addEffect(purificationInst);
		}
	}
}
