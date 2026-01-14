package com.snipr.homeplugin.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.snipr.homeplugin.HomePlugin;
import com.snipr.homeplugin.data.HomeLocation;

import javax.annotation.Nonnull;
import java.awt.Color;

/**
 * Command to teleport a player to their home location.
 * Note: Actual teleportation will need proper World API access when available.
 */
public class HomeCommand extends CommandBase {
    
    private final HomePlugin plugin;

    public HomeCommand(HomePlugin plugin) {
        super("home", "Teleport to your home location");
        this.plugin = plugin;
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        // Make sure the sender is a player
        if (!(ctx.sender() instanceof Player)) {
            ctx.sendMessage(Message.raw("This command can only be used by players!").color(Color.RED));
            return;
        }
        
        Player player = (Player) ctx.sender();
        
        // Get the player's home location
        HomeLocation home = plugin.getHomeDataManager().getHome(player.getDisplayName());
        
        if (home == null) {
            ctx.sendMessage(
                Message.join(
                    Message.raw("[Home] ").color(Color.RED),
                    Message.raw("You don't have a home set! Use /sethome first.").color(Color.WHITE)
                )
            );
            return;
        }
        
        // TODO: Implement actual teleportation when World API is available
        // For now, just show the home coordinates
        ctx.sendMessage(
            Message.join(
                Message.raw("[Home] ").color(new Color(255, 215, 0)),
                Message.raw(String.format("Your home is at: %.1f, %.1f, %.1f in %s", 
                    home.getX(), home.getY(), home.getZ(), home.getWorldName())).color(Color.WHITE)
            )
        );
        ctx.sendMessage(
            Message.join(
                Message.raw("[Home] ").color(new Color(255, 165, 0)),
                Message.raw("(Teleportation coming soon - API limitation)").color(Color.GRAY)
            )
        );
    }
}
