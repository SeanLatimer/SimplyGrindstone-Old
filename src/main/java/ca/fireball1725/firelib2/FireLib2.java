package ca.fireball1725.firelib2;

import ca.fireball1725.firelib2.common.recipes.Recipes;
import ca.fireball1725.firelib2.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Mod("firelib2")
public class FireLib2 extends FireMod {
    public static final Logger LOGGER = LogManager.getLogger("FireLib2");
    public static final Map<String, FireMod> FIREMODS = new ConcurrentHashMap<>();

    public FireLib2() {
        super(ModLoadingContext.get().getActiveNamespace());
        OBJLoader.INSTANCE.addDomain();
    }

    public static void registerMod(FireMod fireMod) {
        if (FireLib2.FIREMODS.containsKey(fireMod.getModId())) {
            FireLib2.LOGGER.warn("Cannot register {} because it has already been registered.", fireMod.getModId());
            return;
        }

        FireLib2.FIREMODS.put(fireMod.getModId(), fireMod);

        if (fireMod.getBlocks() != null) fireMod.getBlocks().forEach(RegistrationHelper::registerBlock);
        if (fireMod.getItems() != null) fireMod.getItems().forEach(RegistrationHelper::registerItem);
        if (fireMod.getRecipeSerializers() != null)
            fireMod.getRecipeSerializers().forEach(RegistrationHelper::registerRecipeSerializer);
    }

    @Override
    public ArrayList<Block> getBlocks() {
        return null;
    }

    @Override
    public ArrayList<Item> getItems() {
        return null;
    }

    @Override
    public ArrayList<IRecipeSerializer<?>> getRecipeSerializers() {
        return Recipes.toList();
    }
}
