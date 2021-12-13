package sebroar.discovery.item;

import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import sebroar.discovery.common.registry.DiscoveryBlocks;
import sebroar.discovery.common.registry.DiscoveryItems;
import sebroar.discovery.util.item.DiscoveryItemTier;

public class ChiselItem extends ToolItem {
	public static Map<Block, Item> ABYSSIUM = (new Builder<Block, Item>()).build();
	public static Map<Block, Map<Block, Item>> CHISELABLES = (new Builder<Block, Map<Block, Item>>()).build();
	public ChiselItem(Properties properties) {
		super(0, 0, DiscoveryItemTier.CHISEL, null, properties);
	}
	@Override
	public int getUseDuration(ItemStack p_77626_1_) {
		return 30;
	}
	@Override
	public UseAction getUseAnimation(ItemStack p_77661_1_) {
		return UseAction.EAT;
	}
	@Override
	public void onUseTick(World world, LivingEntity entity, ItemStack stack, int tick) {
		entity.swing(entity.getMainHandItem() == new ItemStack(this) ? Hand.MAIN_HAND : Hand.OFF_HAND);
	}
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		if(CHISELABLES.containsKey(context.getLevel().getBlockState(context.getClickedPos()).getBlock())) {
			Block[] block = new Block[1];
			context.getLevel().setBlockAndUpdate(context.getClickedPos(), CHISELABLES.get(context.getLevel().getBlockState(context.getClickedPos()).getBlock()).keySet().toArray(block)[0].defaultBlockState());
			new ItemEntity(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), new ItemStack(CHISELABLES.get(context.getLevel().getBlockState(context.getClickedPos()).getBlock()).get(block[0])));
			damageItem(context.getItemInHand(), 1, context.getPlayer(), null);
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.PASS;
		}
	}
	@Override
	public boolean useOnRelease(ItemStack stack) {
		return true;
	}
	public static void addChiselables(Block ore, Block baseBlock, Item resultItem) {
		Map<Block, Item> TMP_MAP = (new Builder<Block, Item>()).put(baseBlock, resultItem).build();
		CHISELABLES.put(baseBlock, TMP_MAP);
	}
}
