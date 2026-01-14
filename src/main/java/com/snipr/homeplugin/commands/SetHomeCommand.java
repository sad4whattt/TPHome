package com.snipr.homeplugin.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.snipr.homeplugin.HomePlugin;
import com.snipr.homeplugin.data.HomeLocation;

import javax.annotation.Nonnull;
import java.awt.Color;

/**
 * Command to set a player's home location.
 * For now, players will need to specify coordinates manually.
 */
public class SetHomeCommand extends CommandBase {
    
    private final HomePlugin plugin;
    
    @Nonnull
    private final RequiredArg<Double> xArg;
    
    @Nonnull
    private final RequiredArg<Double> yArg;
    
    @Nonnull
    private final RequiredArg<Double> zArg;

    public SetHomeCommand(HomePlugin plugin) {
        super("sethome", "Set your home location. Usage: /sethome <x> <y> <z>");
        this.plugin = plugin;
        
        this.xArg = this.withRequiredArg("x", "com.snipr.homeplugin.commands.sethome.arg.x", ArgTypes.DOUBLE);
        this.yArg = this.withRequiredArg("y", "com.snipr.homeplugin.commands.sethome.arg.y", ArgTypes.DOUBLE);
        this.zArg = this.withRequiredArg("z", "com.snipr.homeplugin.commands.sethome.arg.z", ArgTypes.DOUBLE);
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        // Make sure the sender is a player
        if (!(ctx.sender() instanceof Player)) {
            ctx.sendMessage(Message.raw("This command can only be used by players!").color(Color.RED));
            return;
        }
        
        Player player = (Player) ctx.sender();
        
        // Get arguments
        double x = (Double) ctx.get(this.xArg);
        double y = (Double) ctx.get(this.yArg);
        double z = (Double) ctx.get(this.zArg);
        
        HomeLocation location = new HomeLocation(x, y, z, "world"); // TODO: Get actual world name
        
        // Save the home location
        plugin.getHomeDataManager().setHome(player.getDisplayName(), location);
        
        // Send confirmation message
        ctx.sendMessage(
            Message.join(
                Message.raw("[Home] ").color(new Color(85, 255, 85)),
                Message.raw(String.format("Home location set to %.1f, %.1f, %.1f!", x, y, z)).color(Color.WHITE)
            )
        );
    }
}
