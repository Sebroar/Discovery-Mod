package sebroar.discovery.util.item;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import sebroar.discovery.common.registry.DiscoveryItems;

public enum DiscoveryItemTier implements IItemTier{
	ABYSSIUM(5, 2732, 9.5f, 5f, 17, () -> {
		return Ingredient.of(DiscoveryItems.ABYSSIUM.get());
	}),
	PURIFIED_ABYSSIUM(6, 3254, 10.0f, 6f, 20, () -> {
		return Ingredient.of(DiscoveryItems.PURIFIED_ABYSSIUM.get());
	}),
	CHISEL(0, 255, 0, 0, 1, () ->{
		return Ingredient.of(Items.IRON_INGOT);
	});
	
	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final LazyValue<Ingredient> repairItems;
	
	private DiscoveryItemTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredients) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairItems = new LazyValue<>(repairIngredients);
	}

	@Override
	public int getUses() {
		return uses;
	}

	@Override
	public float getSpeed() {
		return speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return damage;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public int getEnchantmentValue() {
		return enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairItems.get();
	}
}
