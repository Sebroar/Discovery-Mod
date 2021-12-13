package sebroar.discovery.common.registry;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import sebroar.discovery.Discovery;

public class DiscoveryDimensions {
	public static final RegistryKey<World> THE_GRIMLANDS = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Discovery.MODID, "the_grimlands"));
}
