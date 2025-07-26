package net.pxxel.tutorialmod.item;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import oshi.util.tuples.Pair;

import java.util.Vector;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            Vector<Pair<BlockState, Integer>> validBlocks = new Vector<>();
            for (int i = positionClicked.getY(); i > -64; i--) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.atY(i));
                if (isMetalOreBlock(state)) {
                    Pair<BlockState, Integer> oreBlockPos = new Pair<>(state, i);
                    validBlocks.add(oreBlockPos);
                }
            }
            outputMetalOreCoordinates(player, validBlocks);
            pContext.getItemInHand().hurtAndBreak(validBlocks.size() + 1, pContext.getPlayer(),
                    player1 -> player.broadcastBreakEvent(player.getUsedItemHand()));
        }
        return InteractionResult.SUCCESS;
    }

    private void outputMetalOreCoordinates(Player player, Vector<Pair<BlockState, Integer>> validBlocks) {
        if(validBlocks.isEmpty()) {
            player.sendSystemMessage(Component.literal("No metallic ores found! "));
        } else {
            for(Pair<BlockState, Integer> block: validBlocks) {
                player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getA().getBlock().getDescriptionId()) +
                        " at Y-level " + (block.getB() + 1) + ". "));
            }
        }
    }

    private boolean isMetalOreBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.GOLD_ORE) || state.is(Blocks.DEEPSLATE_GOLD_ORE) ||
                state.is(Blocks.NETHER_GOLD_ORE) || state.is(Blocks.DEEPSLATE_IRON_ORE) || state.is(Blocks.COPPER_ORE) ||
                state.is(Blocks.DEEPSLATE_COPPER_ORE) || state.is(Blocks.RAW_IRON_BLOCK) || state.is(Blocks.RAW_COPPER_BLOCK)
                || state.is(Blocks.ANCIENT_DEBRIS);
    }
}
