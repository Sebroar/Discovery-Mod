package sebroar.discovery.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import sebroar.discovery.Discovery;
import sebroar.discovery.init.DiscoveryClientInit;

@Mod.EventBusSubscriber(modid = Discovery.MODID)
@OnlyIn(Dist.CLIENT)
public class ClientEvents {
	@SubscribeEvent
	public static void weaponArtifactSkillEvent(KeyInputEvent event) {
		if (DiscoveryClientInit.keyBindings[0].isDown()) {
			System.out.println("Key Input Event: Discovery Weapon Artifact Skill");
		}
	}
}
