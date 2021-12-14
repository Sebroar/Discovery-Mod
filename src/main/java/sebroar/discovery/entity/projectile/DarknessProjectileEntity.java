package sebroar.discovery.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import sebroar.discovery.entity.AbstractCorruptedEntity;
import sebroar.discovery.entity.DiscoveryEntityAttribute;
import sebroar.discovery.util.CorruptionUtils;

public class DarknessProjectileEntity extends DamagingProjectileEntity {
	protected float corruptionChance = 0.1f;
	protected int corruptionDuration = 25;
	protected DarknessProjectileEntity(EntityType<? extends DarknessProjectileEntity> entityType, World world) {
		super(entityType, world);
		if (this.getOwner() instanceof LivingEntity) {
			LivingEntity owner = (LivingEntity) this.getOwner();
			if (owner.getMobType() == DiscoveryEntityAttribute.CORRUPTED) {
				AbstractCorruptedEntity corruptedOwner = (AbstractCorruptedEntity) owner;
				this.corruptionChance = corruptedOwner.getCorruptionChance();
				this.corruptionDuration = corruptedOwner.getCorruptionDuration();
			}
		}
	}
	protected DarknessProjectileEntity(EntityType<? extends DarknessProjectileEntity> entityType, LivingEntity entity, World world, double x, double y, double z) {
		super(entityType, entity, x, y, z, world);
	}
	@Override
	protected void onHitEntity(EntityRayTraceResult rayTraceResult) {
		if (rayTraceResult.getEntity() instanceof LivingEntity) {
			LivingEntity target = (LivingEntity) rayTraceResult.getEntity();
			if (Math.random() < this.corruptionChance) CorruptionUtils.applyCorruptionOnHit(target, corruptionDuration, Math.max(0, corruptionChance - (float) Math.random() / 2));;
		}
	}
}
