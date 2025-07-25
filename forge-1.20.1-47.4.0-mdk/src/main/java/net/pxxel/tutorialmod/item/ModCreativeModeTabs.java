package net.pxxel.tutorialmod.item;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pxxel.tutorialmod.TutorialMod;
import net.pxxel.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DOOM_ARSENAL_TAB = CREATIVE_MODE_TABS.register("doom_arsenal_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SHOTGUN_SHELL.get()))
                    .title(Component.translatable("creativetab.doom_arsenal_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SHOTGUN_SHELL.get());
                        pOutput.accept(ModItems.BULLET.get());
                        pOutput.accept(ModItems.ROCKET.get());
                        pOutput.accept(ModItems.PLASMA_CELL.get());
                        pOutput.accept(ModItems.ARGENT_CELL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.END_SAPPHIRE_ORE.get());
                    })
                    .build());
}
