package sebroar.discovery.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import sebroar.discovery.block.material.DiscoveryMaterial;
import sebroar.discovery.util.item.DiscoveryItemTier;

public class ChiselItem extends ToolItem {
	public ChiselItem(Properties properties) {
		super(1, -2, DiscoveryItemTier.CHISEL, null, properties.addToolType(DiscoveryToolType.CHISEL, 0));
	}
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		Material material = state.getMaterial();
		return material == DiscoveryMaterial.CHISELABLE_STONE ? this.speed : super.getDestroySpeed(stack, state);
	}
}
