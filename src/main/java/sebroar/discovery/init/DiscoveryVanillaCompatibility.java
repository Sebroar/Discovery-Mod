package sebroar.discovery.init;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import sebroar.discovery.common.registry.DiscoveryBlocks;

public class DiscoveryVanillaCompatibility {
	public static void setup() {
		//Log Stripping
		registerStrippable(DiscoveryBlocks.GRIMBARK_LOG.get(), DiscoveryBlocks.STRIPPED_GRIMBARK_LOG.get());
		registerStrippable(DiscoveryBlocks.GRIMBARK_WOOD.get(), DiscoveryBlocks.STRIPPED_GRIMBARK_WOOD.get());
	}
	public static void registerStrippable(Block log, Block strippedLog) {
		AxeItem.STRIPABLES = Maps.newHashMap(AxeItem.STRIPABLES);
		AxeItem.STRIPABLES.put(log, strippedLog);
	}
}
