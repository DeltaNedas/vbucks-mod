package deltanedas.vbucks_mod.init;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = "vbucks_mod")
public class InitConfig {
	@Comment("V-Buck Pack integration. This requires: actually additions, enderio, mekanism, galacticraftcore, rftools, wizardry and psi.")
	@RequiresMcRestart
	public static boolean vbuckPackIntegration = false;
}

