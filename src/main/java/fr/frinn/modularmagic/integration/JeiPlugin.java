package fr.frinn.modularmagic.integration;

import com.google.common.collect.Lists;
import fr.frinn.modularmagic.ModularMagic;
import fr.frinn.modularmagic.integration.jei.helper.*;
import fr.frinn.modularmagic.integration.jei.ingredient.DemonWill;
import fr.frinn.modularmagic.integration.jei.ingredient.Grid;
import fr.frinn.modularmagic.integration.jei.ingredient.LifeEssence;
import fr.frinn.modularmagic.integration.jei.ingredient.Starlight;
import fr.frinn.modularmagic.integration.jei.render.*;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import thaumcraft.api.aspects.AspectList;

@JEIPlugin
public class JeiPlugin implements IModPlugin {

    public static IGuiHelper GUI_HELPER;

    @Override
    public void register(IModRegistry registry) {
        GUI_HELPER = registry.getJeiHelpers().getGuiHelper();
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {
        if(ModularMagic.bloodmagicLoaded) {
            registry.register(DemonWill.class, Lists.newArrayList(), new DemonWillHelper<DemonWill>(), new DemonWillRenderer());
            registry.register(LifeEssence.class, Lists.newArrayList(), new LifeEssenceHelper<LifeEssence>(), new LifeEssenceRenderer());
        }
        if(ModularMagic.thaumcraftLoaded && !ModularMagic.thaumicJEILoaded) {
            registry.register(AspectList.class, Lists.newArrayList(), new AspectHelper<AspectList>(), new AspectRenderer());
        }
        if(ModularMagic.extraUtils2Loaded) {
            registry.register(Grid.class, Lists.newArrayList(), new GridHelper<Grid>(), new GridRenderer());
        }
        if(ModularMagic.astralLoaded) {
            registry.register(Starlight.class, Lists.newArrayList(), new StarlightHelper<Starlight>(), new StarlightRenderer());
        }
    }
}
