package sebroar.discovery.entity.projectile;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class DarknessDartEntity extends DarknessProjectileEntity {
	@Nullable
	private UUID targetId;
	public DarknessDartEntity(EntityType<? extends DarknessDartEntity> entityType, World world) {
		super(entityType, world);
		this.noPhysics = true;
	}
	public DarknessDartEntity(EntityType<? extends DarknessDartEntity> entityType, LivingEntity entity, World world, double x, double y, double z) {
		super(entityType, entity, world, x, y, z);
	}
	@Override
	public void move(MoverType moverType, Vector3d vector) {
		super.move(moverType, vector);
		this.checkInsideBlocks();
	}
	@Override
	protected boolean canHitEntity(Entity entity) {
		return super.canHitEntity(entity) && !entity.noPhysics;
	}
}
