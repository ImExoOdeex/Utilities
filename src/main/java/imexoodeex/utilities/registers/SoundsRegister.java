package imexoodeex.utilities.registers;

import imexoodeex.utilities.sounds.SASounds;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SoundsRegister {
    public static void registerSounds() {
        Registry.register(Registries.SOUND_EVENT, SASounds.CLOUD_SOUND_ID, SASounds.CLOUD_SOUND);
    }
}
