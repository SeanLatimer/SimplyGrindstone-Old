package ca.fireball1725.firelib2;

import ca.fireball1725.firelib2.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import java.util.ArrayList;
import java.util.Objects;

public abstract class FireMod {
  private final Logger LOGGER;
  private final String MODID;
  private final IEventBus EVENTBUS;

  protected FireMod(String modId) {
    this.MODID = ModLoadingContext.get().getActiveNamespace();
    this.LOGGER = LogManager.getLogger(this.MODID);
    this.EVENTBUS = FMLJavaModLoadingContext.get().getModEventBus();
    FireLib2.registerMod(this);
  }

  public abstract ArrayList<Block> getBlocks();
  public abstract ArrayList<Item> getItems();
  public abstract ArrayList<IRecipeSerializer> getRecipeSerializers();

  public Logger getLogger() {
    return LOGGER;
  }

  public String getModId() {
    return MODID;
  }

  public IEventBus getEventBus() {
    return EVENTBUS;
  }

  private void addMod() {
    if (FireLib2.FIREMODS.containsKey(getModId())) {
      FireLib2.LOGGER.warn("Cannot add mod {} because it already exists.", getModId());
      return;
    }

    FireLib2.FIREMODS.put(Objects.requireNonNull(getModId()), this);

    FireLib2.LOGGER.info("Added mod {}", getModId());
  }
}
