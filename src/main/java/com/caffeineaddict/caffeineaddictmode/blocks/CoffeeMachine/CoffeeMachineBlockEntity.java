package com.caffeineaddict.caffeineaddictmode.blocks.CoffeeMachine;

import com.caffeineaddict.caffeineaddictmode.ModBlockEntities;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CoffeeMachineBlockEntity extends BlockEntity implements MenuProvider {
    private final Container inventory = new SimpleContainer(4);
    private final ContainerData gauges = new SimpleContainerData(2);

    public CoffeeMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COFFEE_MACHINE.get(), pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Coffee Machine");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, Player player) {
        System.out.println("Opened GUI");
        return new CoffeeMachineMenu(id, playerInventory, this.worldPosition, this.inventory, this.gauges);
    }

    // Save data
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        NonNullList<ItemStack> stacks = NonNullList.withSize(inventory.getContainerSize(), ItemStack.EMPTY);
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            stacks.set(i, inventory.getItem(i));
        }
        ContainerHelper.saveAllItems(tag, stacks);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        NonNullList<ItemStack> stacks = NonNullList.withSize(inventory.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, stacks);
        for (int i = 0; i < stacks.size(); i++) {
            inventory.setItem(i, stacks.get(i));
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (!level.isClientSide) {
            for (int i = 0; i < 2; i++) {
                if (!inventory.getItem(i).isEmpty()) {
                    int progress = (gauges.get(i) + 1) % 25;
                    gauges.set(i, progress);
                } else {
                    gauges.set(i, 0); // reset if no item
                }
            }
            setChanged();
        }
    }

    public Container getInventory() {
        return inventory;
    }
}
