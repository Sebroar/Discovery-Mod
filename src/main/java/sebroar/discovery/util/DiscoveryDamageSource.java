package sebroar.discovery.util;

import net.minecraft.util.DamageSource;

public class DiscoveryDamageSource extends DamageSource {
	public static final DiscoveryDamageSource CORRUPTION = (DiscoveryDamageSource) (new DiscoveryDamageSource("corruption")).bypassArmor().bypassMagic();
	public static final DiscoveryDamageSource SUPER_THORNS = (DiscoveryDamageSource) (new DiscoveryDamageSource("super_thorns")).bypassArmor().bypassMagic().bypassInvul();
	
	public static String mgsId;

	public DiscoveryDamageSource(String msgId) {
		super(mgsId);
	}
}
