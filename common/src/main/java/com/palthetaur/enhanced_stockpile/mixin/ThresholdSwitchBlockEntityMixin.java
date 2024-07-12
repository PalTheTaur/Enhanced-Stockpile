package com.palthetaur.enhanced_stockpile.mixin;


import com.simibubi.create.content.contraptions.bearing.MechanicalBearingBlockEntity;
import com.simibubi.create.content.redstone.thresholdSwitch.ThresholdSwitchBlock;
import com.simibubi.create.content.redstone.thresholdSwitch.ThresholdSwitchBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnreachableCode") //it can be reached shut up intellij
@Mixin(ThresholdSwitchBlockEntity.class)
public abstract class ThresholdSwitchBlockEntityMixin {


    @Inject(method = "updateCurrentLevel", at = @At("HEAD"), remap = false)
    private void onUpdateCurrentLevel(CallbackInfo ci) {
        ThresholdSwitchBlockEntity self = (ThresholdSwitchBlockEntity) (Object) this; // I love shit code lol
        BlockPos target = self.getBlockPos().relative(ThresholdSwitchBlock.getTargetDirection(self.getBlockState()));
        BlockEntity targetBlockEntity = self.getLevel().getBlockEntity(target);

        if (targetBlockEntity instanceof MechanicalBearingBlockEntity) {
            self.setLazyTickRate(1); // Set tick rate to 1 if the target is a MechanicalBearingBlockEntity
        } else {
            self.setLazyTickRate(10); // Set tick rate to default (10) otherwise
        }
    }
}