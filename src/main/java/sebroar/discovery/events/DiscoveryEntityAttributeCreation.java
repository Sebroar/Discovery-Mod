package sebroar.discovery.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import sebroar.discovery.Discovery;
import sebroar.discovery.entity.boss.DarkbornEntity;

@Mod.EventBusSubscriber(modid = Discovery.MODID)
public class DiscoveryEntityAttributeCreation {
	@SubscribeEvent
	public static void setAttributes(EntityAttributeCreationEvent event) {
		DarkbornEntity.setAttributes();
	}
}
