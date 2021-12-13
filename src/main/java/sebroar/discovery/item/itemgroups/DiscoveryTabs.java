package sebroar.discovery.item.itemgroups;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import sebroar.discovery.common.registry.DiscoveryBlocks;
import sebroar.discovery.common.registry.DiscoveryItems;

public class DiscoveryTabs {
	public static final ItemGroup DISCOVERY_GENERATION_BLOCKS = new ItemGroup("discoveryGenBlocksTab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DiscoveryBlocks.GRIM_GRASS.get());
		}
	};
	public static final ItemGroup DISCOVERY_CONSTUCTION_BLOCKS = new ItemGroup("discoveryConstructionBlocksTab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DiscoveryBlocks.GRIMBARK_PLANKS.get());
		}
	};
	public static final ItemGroup DISCOVERY_ITEMS = new ItemGroup("discoveryItems") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DiscoveryItems.ABYSSIUM.get());
		}
	};
	public static final ItemGroup DISCOVERY_COMBAT = new ItemGroup("discoveryCombat") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DiscoveryItems.ABYSSIUM_SWORD.get());
		}
	};
	public static final ItemGroup DISCOVERY_TOOLS = new ItemGroup("discoveryTools") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DiscoveryItems.ABYSSIUM_PICKAXE.get());
		}
	};
}
