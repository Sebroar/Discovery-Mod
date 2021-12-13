package sebroar.discovery.init;

import net.minecraft.item.Items;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.Potions;
import sebroar.discovery.common.registry.DiscoveryBlocks;
import sebroar.discovery.common.registry.DiscoveryPotions;

public class DiscoveryPotionBrewing {
	public static void setup() {
		PotionBrewing.addMix(Potions.WATER, DiscoveryBlocks.DARKLIP.get().asItem(), DiscoveryPotions.DARKLIP_EXTRACT.get());
		PotionBrewing.addMix(DiscoveryPotions.DARKLIP_EXTRACT.get(), Items.GOLDEN_APPLE, DiscoveryPotions.PURIFICATION.get());
	}
}
