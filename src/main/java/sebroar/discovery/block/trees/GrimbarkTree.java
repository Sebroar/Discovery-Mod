package sebroar.discovery.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import sebroar.discovery.world.gen.feature.DiscoveryFeatures;

public class GrimbarkTree extends Tree {
	@Nullable
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random random, boolean bool) {
		return DiscoveryFeatures.GRIMBARK;
	}
}
