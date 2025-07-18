package com.caffeineaddict.caffeineaddictmode.blocks.CoffeeMachine;

import com.caffeineaddict.caffeineaddictmode.CoffeeMachineBlockEntities;
import com.caffeineaddict.caffeineaddictmode.ModItems;
import com.caffeineaddict.caffeineaddictmode.TagNSpecialConstant;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
    private String lastUsedBy = "";

    public CoffeeMachineBlockEntity(BlockPos pos, BlockState state) {
        super(CoffeeMachineBlockEntities.COFFEE_MACHINE.get(), pos, state);
    }

    public void setLastUsedBy(String playerName) {
        this.lastUsedBy = playerName;
    }

    public String getLastUsedBy() {
        return lastUsedBy;
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
        tag.putString(TagNSpecialConstant.LAST_USEDBY.getText(), lastUsedBy);
        NonNullList<ItemStack> stacks = NonNullList.withSize(inventory.getContainerSize(), ItemStack.EMPTY);
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            stacks.set(i, inventory.getItem(i));
        }
        ContainerHelper.saveAllItems(tag, stacks);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains(TagNSpecialConstant.LAST_USEDBY.getText())) {
            lastUsedBy = tag.getString(TagNSpecialConstant.LAST_USEDBY.getText());
        }
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

    public void brew(int currentIndex){
        // 커피콩 소비
        inventory.removeItem(currentIndex, 1);

        // 에스프레소 추출
        int devTempQ = 1;
        ItemStack espresso = new ItemStack(ModItems.ESPRESSO.get(), 1);
        CompoundTag tag = new CompoundTag();
        tag.putInt(TagNSpecialConstant.QUALITY.getText(), devTempQ);
        tag.putString(TagNSpecialConstant.BARISTA.getText(), lastUsedBy);
        espresso.setTag(tag);
        inventory.setItem(currentIndex+2, espresso);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (!level.isClientSide) {
            for (int i = 0; i < 2; i++) {
                ItemStack input = inventory.getItem(i);
                ItemStack output = inventory.getItem(i+2);
                if (input.is(ModItems.GROUND_COFFEE.get()) && output.is(ModItems.SHOT_CUP.get())) {
                    int progress = gauges.get(i);
                    //####################################################
                    //여기에 게이지 움직임에 따른 커피 퀄리티 결정 로직으로 바꿔야함
                    //####################################################
                    if (progress >= 24) {
                        brew(i);
                    }
                    if (progress % 20 == 0) { // once per second
                        level.playSound(
                                null,         // null = all nearby players hear it
                                worldPosition,
                                SoundEvents.BREWING_STAND_BREW, // or your custom sound
                                SoundSource.BLOCKS,
                                1.0f,         // volume
                                1.0f          // pitch
                        );
                    }
                    progress = (progress + 1) % 25;
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
