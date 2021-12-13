package sebroar.discovery.block;

import com.google.common.collect.ImmutableMap.Builder;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import sebroar.discovery.common.registry.DiscoveryBlocks;
import sebroar.discovery.common.registry.DiscoveryItems;

public class PurificationAltarBlock extends Block {
	public static final Map<Item, ItemStack> PURIFIABLES = (new Builder<Item, ItemStack>()).build();
	private static final BlockState PROVIDER = DiscoveryBlocks.PURIFICATION_ALTAR_ENERGY_PROVIDER.get().defaultBlockState();
	public PurificationAltarBlock(Properties properties) {
		super(properties);
	}
	private boolean controlStructure(World world, BlockPos pos) {
		boolean p1 = world.getBlockState(new BlockPos(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2)) == PROVIDER;
		boolean p2 = world.getBlockState(new BlockPos(pos.getX() - 2, pos.getY() + 2, pos.getZ() + 2)) == PROVIDER;
		boolean p3 = world.getBlockState(new BlockPos(pos.getX() - 2, pos.getY() + 2, pos.getZ() - 2)) == PROVIDER;
		boolean p4 = world.getBlockState(new BlockPos(pos.getX() + 2, pos.getY() + 2, pos.getZ() - 2)) == PROVIDER;
		return p1 && p2 && p3 && p4;
	}
	private boolean controlCharge(World world, BlockPos pos) {
		BlockState p1 = world.getBlockState(new BlockPos(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2));
		BlockState p2 = world.getBlockState(new BlockPos(pos.getX() - 2, pos.getY() + 2, pos.getZ() + 2));
		BlockState p3 = world.getBlockState(new BlockPos(pos.getX() - 2, pos.getY() + 2, pos.getZ() - 2));
		BlockState p4 = world.getBlockState(new BlockPos(pos.getX() + 2, pos.getY() + 2, pos.getZ() - 2));
		PurificationAltarEnergyProviderBlock e1 = p1.getBlock() instanceof PurificationAltarEnergyProviderBlock ? (PurificationAltarEnergyProviderBlock) p1.getBlock() : null;
		PurificationAltarEnergyProviderBlock e2 = p2.getBlock() instanceof PurificationAltarEnergyProviderBlock ? (PurificationAltarEnergyProviderBlock) p2.getBlock() : null;
		PurificationAltarEnergyProviderBlock e3 = p3.getBlock() instanceof PurificationAltarEnergyProviderBlock ? (PurificationAltarEnergyProviderBlock) p3.getBlock() : null;
		PurificationAltarEnergyProviderBlock e4 = p4.getBlock() instanceof PurificationAltarEnergyProviderBlock ? (PurificationAltarEnergyProviderBlock) p4.getBlock() : null;
		if (e1 != null && e2 != null && e3 != null && e4 != null) {
			if (e1.isCharged() && e2.isCharged() && e3.isCharged() && e4.isCharged()) {
				e1.setCharged(false);
				e2.setCharged(false);
				e3.setCharged(false);
				e4.setCharged(false);
				return true;
			} else return false;
		} else return false;
	}
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos,
			PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
		if (controlStructure(world, pos) && controlCharge(world, pos)) {
			if (PURIFIABLES.containsKey(player.getItemInHand(hand).getItem())) {
				world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY() + 2, pos.getZ(), PURIFIABLES.get(player.getItemInHand(hand).getItem())));
				return ActionResultType.SUCCESS;
			} else return ActionResultType.PASS;
		} else {
			player.displayClientMessage(ITextComponent.nullToEmpty("It seems there isn't enough energy to do this"), true);
			return ActionResultType.FAIL;
		}
	}
}
