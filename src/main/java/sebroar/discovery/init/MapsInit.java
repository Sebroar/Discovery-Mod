package sebroar.discovery.init;

import net.minecraft.item.ItemStack;
import sebroar.discovery.block.PurificationAltarBlock;
import sebroar.discovery.common.registry.DiscoveryItems;

public class MapsInit {
	public static void setup() {
		setupPurificationAltar();
	}
	private static void setupPurificationAltar() {
		PurificationAltarBlock.PURIFIABLES.put(DiscoveryItems.ABYSSIUM.get(), new ItemStack(DiscoveryItems.PURIFIED_ABYSSIUM.get()));
	}
}
