package ca.fireball1725.simplygrindstone;

import ca.fireball1725.firelib2.FireLib2;
import ca.fireball1725.firelib2.FireMod;
import ca.fireball1725.firelib2.util.RegistrationHelper;
import ca.fireball1725.simplygrindstone.common.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;

@Mod("simplygrindstone")
public class SimplyGrindstone extends FireMod {

  public SimplyGrindstone() {
    super(ModLoadingContext.get().getActiveNamespace());
  }

  @Override
  public ArrayList<Block> getBlocks() {
    return Blocks.toList();
  }

  @Override
  public ArrayList<Item> getItems() {
    return null;
  }

  @Override
  public ArrayList<IRecipeSerializer<?>> getRecipeSerializers() {
    return null;
  }
}
