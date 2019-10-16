package ca.fireball1725.firelib2.common.recipes;

import net.minecraft.item.crafting.IRecipeSerializer;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Supplier;

public enum Recipes {
    GRINDSTONE(() -> new GrindstoneRecipeSerializer<>(GrindstoneRecipe::new))
    ;

    private final IRecipeSerializer serializer;

    Recipes(Supplier<IRecipeSerializer<?>> serializerSupplier) {
        Objects.requireNonNull(serializerSupplier);
        this.serializer = serializerSupplier.get();
    }

    public static ArrayList<IRecipeSerializer<?>> toList() {
        ArrayList<IRecipeSerializer<?>> serializers = new ArrayList<>();
        EnumSet.allOf(Recipes.class).forEach(b -> serializers.add(b.serializer));
        return serializers;
    }

    public IRecipeSerializer getSerializer() {
        return this.serializer;
    }
}
