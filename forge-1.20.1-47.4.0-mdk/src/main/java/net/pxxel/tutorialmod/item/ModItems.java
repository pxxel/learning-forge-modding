package net.pxxel.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pxxel.tutorialmod.TutorialMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> SHOTGUN_SHELL = ITEMS.register("shotgun_shell",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BULLET = ITEMS.register("bullet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROCKET = ITEMS.register("rocket",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLASMA_CELL = ITEMS.register("plasma_cell",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ARGENT_CELL = ITEMS.register("argent_cell",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
