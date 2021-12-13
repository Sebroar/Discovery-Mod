package sebroar.discovery.tags;

import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.util.ResourceLocation;

public class DiscoveryBlockTags {
	protected static final TagRegistry<Block> HELPER = TagRegistryManager.create(new ResourceLocation("Block"), ITagCollectionSupplier::getBlocks);
	public static final ITag.INamedTag<Block> GRIMBARK_LOGS = bind("grimbark_logs");
	public static ITag.INamedTag<Block> bind(String tagName) {
		return HELPER.bind(tagName);
	}
}
