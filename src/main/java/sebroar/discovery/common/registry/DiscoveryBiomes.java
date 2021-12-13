package sebroar.discovery.common.registry;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import sebroar.discovery.Discovery;

public class DiscoveryBiomes {
	public static void postInit() {
		registerBiomeTypes();
	}
	public static void registerBiomeTypes() {
		addBiomeTypes("plains_of_nothingness", BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.PLAINS);
		addBiomeTypes("forest_of_darkness", BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.FOREST);
	}
	private static void addBiomeTypes(String id, BiomeDictionary.Type... types) {
		RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Discovery.MODID, id));
		BiomeDictionary.addTypes(key, types);
	}
}
