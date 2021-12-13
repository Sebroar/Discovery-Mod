package sebroar.discovery.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import sebroar.discovery.common.registry.DiscoveryPotions;

public class PurificationAltarEnergyProviderBlock extends Block {
	private boolean isCharged;
	
	public PurificationAltarEnergyProviderBlock(Properties properties) {
		super(properties);
	}
	public void setCharged(boolean flag) {
		this.setCharged(flag);
	}
	public boolean isCharged() {
		return this.isCharged;
	}
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos,
			PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
		if (player.getItemInHand(hand) == new ItemStack((IItemProvider) DiscoveryPotions.DARKLIP_EXTRACT.get()) && !isCharged) {
			player.setItemInHand(hand, new ItemStack(Items.GLASS_BOTTLE));
			this.setCharged(true);
			return ActionResultType.SUCCESS;
		} else return ActionResultType.PASS;
	}
}
