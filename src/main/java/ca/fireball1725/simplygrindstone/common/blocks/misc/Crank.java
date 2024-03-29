package ca.fireball1725.simplygrindstone.common.blocks.misc;

import ca.fireball1725.firelib2.common.blocks.BlockBase;
import ca.fireball1725.firelib2.util.RotationType;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Crank extends BlockBase {
    public Crank() {
        super(Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.0f)
        );
        setRegistryName("crank");
        setCanRotate(false);
    }

    @Override
    public RotationType getRotationType() {
        return RotationType.NONE;
    }
}
