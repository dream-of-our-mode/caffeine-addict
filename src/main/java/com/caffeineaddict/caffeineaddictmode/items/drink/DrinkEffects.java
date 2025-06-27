package com.caffeineaddict.caffeineaddictmode.items.drink;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public enum DrinkEffects {
    ESPRESSO(Set.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST,200, 0)),
             Set.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST,200, 1)),
             Set.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST,200, 2))),

    AMERICANO(Set.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST,300, 0),
                    new MobEffectInstance(MobEffects.REGENERATION,300, 0)),
              Set.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST,300, 1)),
              Set.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST,300, 2))),;

    final List<Set<MobEffectInstance>> star;

    DrinkEffects(Set<MobEffectInstance> one, Set<MobEffectInstance> two, Set<MobEffectInstance> three){
        star = List.of(one, two, three);
    }

    public void applyStar(int count, LivingEntity user) {
        star.get(count).forEach(user::addEffect);
    }
}
