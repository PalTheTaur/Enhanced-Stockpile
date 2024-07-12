package com.palthetaur.enhanced_stockpile.mixin;

import com.simibubi.create.content.contraptions.bearing.MechanicalBearingBlockEntity;
import com.simibubi.create.content.redstone.thresholdSwitch.ThresholdSwitchObservable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MechanicalBearingBlockEntity.class)
public abstract class MechanicalBearingBlockEntityMixin implements ThresholdSwitchObservable {
    @Shadow protected float angle;

    @Override
    public float getPercent() {
        return (this.angle / 360) * 100;
    }
}