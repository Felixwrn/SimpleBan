package de.wrn.simpleban;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class BanListener implements Listener {


    private final BanManager manager;


    public BanListener(BanManager manager) {

        this.manager = manager;

    }


    @EventHandler
    public void onLogin(PlayerLoginEvent event) {


        if (manager.isBanned(event.getPlayer().getUniqueId())) {


            event.disallow(
                    PlayerLoginEvent.Result.KICK_BANNED,
                    "§cDu bist gebannt!\n\n§7Grund: §f"
                            + manager.getReason(
                                    event.getPlayer().getUniqueId()
                            )
            );

        }

    }
}