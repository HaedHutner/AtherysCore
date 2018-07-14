package com.atherys.core;

import com.atherys.core.command.CommandService;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import javax.inject.Inject;

import static com.atherys.core.AtherysCore.*;

@Plugin(id = ID, version = VERSION, name = NAME, description = DESCRIPTION)
public class AtherysCore {

    public static final String ID = "atheryscore";
    public static final String NAME = "A'therys Core";
    public static final String DESCRIPTION = "The core utilities used on the A'therys Horizons server.";
    public static final String VERSION = "1.2.3";

    private static AtherysCore instance;

    private static boolean init = false;

    @Inject
    private Logger logger;

    @Inject
    PluginContainer container;

    private void init() {
        instance = this;

        init = true;

    }

    private void start() {
    }

    private void stop() {
    }

    @Listener(order = Order.EARLY)
    public void onInit(GameInitializationEvent event) {
        init();
    }

    @Listener
    public void onStart(GameStartingServerEvent event) {
        if (init) {
            start();
        }
    }

    @Listener
    public void onStop(GameStoppingServerEvent event) {
        if (init) {
            stop();
        }
    }

    public static CommandService getCommandService() {
        return CommandService.getInstance();
    }

    public Logger getLogger() {
        return logger;
    }

    public static AtherysCore getInstance() {
        return instance;
    }
}
