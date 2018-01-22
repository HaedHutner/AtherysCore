package com.atherys.core.damage.listeners;

import com.atherys.core.AtherysCore;
import com.atherys.core.damage.sources.AtherysEntityDamageSource;
import com.atherys.core.damage.sources.AtherysEntityMultiDamageSource;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;

public class DamageListeners {

    @Listener ( order = Order.FIRST )
    public void onDirectMultiDamage ( DamageEntityEvent event, @Root AtherysEntityMultiDamageSource source ) {
        event.setCancelled( true );
        source.getDamageDistribution().forEach((k, v) -> event.getTargetEntity().damage( event.getBaseDamage() * v, k) );
    }

    @Listener ( order = Order.FIRST )
    public void onSingleDamage (DamageEntityEvent event, @Root AtherysEntityDamageSource source ) {
        AtherysCore.getInstance().getLogger().info( "Detected " + source.getType().getName() + " on " + event.getTargetEntity() + " for " + event.getBaseDamage() );
    }

}
