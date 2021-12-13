package sebroar.discovery.world.gen.feature;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import sebroar.discovery.common.registry.DiscoveryBlocks;

public class DiscoveryFeatures {
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GRIMBARK = register("grimbark", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(DiscoveryFeatures.States.GRIMBARK_LOG), new SimpleBlockStateProvider(DiscoveryFeatures.States.GRIMBARK_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(1), 4), new StraightTrunkPlacer(7, 5, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
	}
	
	public static final class States {
		protected static final BlockState GRIMBARK_LOG = DiscoveryBlocks.GRIMBARK_LOG.get().defaultBlockState();
		protected static final BlockState GRIMBARK_LEAVES = DiscoveryBlocks.GRIMBARK_LEAVES.get().defaultBlockState();
	}
}
