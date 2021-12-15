package sebroar.discovery.block.material;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

public class DiscoveryMaterial {
	public static final Material PURIFICATION_ALTAR = new Material(MaterialColor.DIAMOND, false, true, true, true, false, false, PushReaction.BLOCK);
	public static final Material CHISELABLE_STONE = new Material(MaterialColor.STONE, false, true, true, true, false, false, PushReaction.NORMAL);
}
