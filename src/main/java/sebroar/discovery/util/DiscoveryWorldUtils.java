package sebroar.discovery.util;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DiscoveryWorldUtils {
	public static final RegistryKey<World> THE_GRIMLANDS = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("the_grimlands"));
}
