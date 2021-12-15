package sebroar.discovery.entity.boss;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import sebroar.discovery.entity.AbstractCorruptedEntity;
import sebroar.discovery.entity.DiscoveryEntityAttribute;

public class DarkbornEntity extends AbstractCorruptedEntity implements IRangedAttackMob {
	private boolean isFirstPhaseFinished;
	private int eventTime = -1;
	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (target) -> {
		return target.getMobType() != DiscoveryEntityAttribute.CORRUPTED && target.isAttackable();
	};
	protected DarkbornEntity(EntityType<? extends DarkbornEntity> entityType, World world) {
		super(entityType, world, 2, 0.75f, 25);
	}
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new RangedAttackGoal(this, 1.0, 40, 48));
		this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 48f));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MobEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
	}
	@Override
	public boolean hurt(DamageSource source, float amount) {
		float reducedAmount = amount * 0.9f;
		if (!source.isMagic() && source.getDirectEntity() instanceof LivingEntity) {
			LivingEntity attacker = (LivingEntity) source.getDirectEntity();
			attacker.hurt(source, (amount / 10) - (attacker.getArmorValue() * (amount /200)));
		}
		return super.hurt(source, reducedAmount);
	}
	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 1000).add(Attributes.ATTACK_DAMAGE, 15);
	}
	public DarkbornEntity secondPhaseReached() {
		if (!this.isFirstPhaseFinished) {
			this.isFirstPhaseFinished = true;
			this.eventTime = 200;
		}
		return this;
	}
	@Override
	public void tick() {
		this.setInvulnerable(eventTime >= 0);
		BlockPos pos = this.blockPosition();
		if (this.eventTime > 1) {
			List<LivingEntity> nearbyEntities = this.level.getNearbyEntities(null, EntityPredicate.DEFAULT, this, new AxisAlignedBB(pos.getX() - 32, pos.getY() - 32, pos.getZ() - 32, pos.getX() + 32, pos.getY() + 32, pos.getZ() + 32));
			for (LivingEntity entity : nearbyEntities) {
				BlockPos pos1 = entity.blockPosition();
				double speed = entity.getSpeed() * Math.sqrt(Math.abs((pos.distSqr((IPosition) pos1, true))));
				entity.setDeltaMovement((pos.getX() - pos1.getX()) * speed, (pos.getY() - pos1.getY()), (pos.getZ() - pos1.getZ()) * speed);
				--this.eventTime;
			}
		} else if (this.eventTime == 0) {
			this.level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 3, Mode.NONE);
			--this.eventTime;
		}
	}
	public int getEventTime() {
		return this.eventTime;
	}
	public DarkbornEntity reduceEventTime() {
		--this.eventTime;
		return this;
	}
	@Override
	public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
	}
}
