package sebroar.discovery.entity;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import sebroar.discovery.common.registry.DiscoveryEffects;
import sebroar.discovery.util.DiscoveryDamageSource;

public abstract class AbstractCorruptedEntity extends MonsterEntity {
	protected float healModifier = 1;
	protected float corruptionChance = 0.5f;
	protected int corruptionDuration = 60;
	protected AbstractCorruptedEntity(EntityType<? extends AbstractCorruptedEntity> entityType, World world) {
		super(entityType, world);
	}
	public AbstractCorruptedEntity(EntityType<? extends AbstractCorruptedEntity> entityType, World world, float healModifier, float corruptionChance, int corruptionDuration) {
		super(entityType, world);
		this.healModifier = healModifier;
		this.corruptionChance = corruptionChance >= 0.0f && corruptionChance <= 1.0f ? corruptionChance : 0.5f;
		this.corruptionDuration = corruptionDuration >= 0 ? corruptionDuration : 60;
	}
	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DiscoveryDamageSource.CORRUPTION) {
			this.heal(this.healModifier * amount);
			return false;
		} else return true;
	}
	@Override
	public boolean doHurtTarget(Entity target) {
		if (!super.doHurtTarget(target)) return false;
		else {
			if (target instanceof LivingEntity) {
				LivingEntity livingTarget = (LivingEntity) target;
				if (livingTarget.getMobType() != DiscoveryEntityAttribute.CORRUPTED) {
					float random = (float) Math.random();
					if (random < this.corruptionChance) livingTarget.addEffect(new EffectInstance(DiscoveryEffects.CORRUPTION.get(), this.corruptionDuration));
					return true;
				} else return false;
			} else return false;
		}
	}
	public CreatureAttribute getCreatureAttribute() {
		return DiscoveryEntityAttribute.CORRUPTED;
	}
	public float getCorruptionChance() {
		return this.corruptionChance;
	}
	public int getCorruptionDuration() {
		return this.corruptionDuration;
	}
}
