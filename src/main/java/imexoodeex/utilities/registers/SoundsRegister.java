package imexoodeex.utilities.registers;

import imexoodeex.utilities.sounds.SASounds;
import net.minecraft.util.registry.Registry;

public class SoundsRegister {
    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, SASounds.CLOUD_SOUND_ID, SASounds.CLOUD_SOUND);
    }
}
