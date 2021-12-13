package sebroar.discovery.util.item;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import sebroar.discovery.common.registry.DiscoveryItems;

public enum DiscoveryArmorMaterial implements IArmorMaterial {
	ABYSSIUM("abyssium", 40, new int[] {3, 7, 8, 4}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.25f, 0.125f, () -> {
		return Ingredient.of(DiscoveryItems.ABYSSIUM.get());
	}),
	PURIFIED_ABYSSIUM("purified_abyssium", 43, new int[] {4, 7, 8, 5}, 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.3f, 0.13f, () -> {
		return Ingredient.of(DiscoveryItems.PURIFIED_ABYSSIUM.get());
	});
	
	private static final int[] HEALTH_PER_SLOT = new int[] {13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyValue<Ingredient> rapairItems;
	
	private DiscoveryArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairItems) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotProtections = slotProtections;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.rapairItems = new LazyValue<>(repairItems);
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType slot) {
		return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType slot) {
		return this.slotProtections[slot.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.rapairItems.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
