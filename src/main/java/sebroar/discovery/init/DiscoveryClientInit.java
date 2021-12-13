package sebroar.discovery.init;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import sebroar.discovery.common.registry.DiscoveryBlocks;

@OnlyIn(Dist.CLIENT)
public class DiscoveryClientInit {
	public static KeyBinding[] keyBindings = new KeyBinding[1];
	public static void clientInit() {
		keyBindings[0] = new KeyBinding("key.artifacts.weapon_skill", 82, "key.discovery.discovery");
		for (KeyBinding key : keyBindings) {
			ClientRegistry.registerKeyBinding(key);
		}
		
		RenderTypeLookup.setRenderLayer(DiscoveryBlocks.DARKLIP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(DiscoveryBlocks.GRIMBARK_SAPLING.get(), RenderType.cutout());
	}
}
