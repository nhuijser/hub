package me.display.hub.command;

import me.vaperion.blade.annotation.argument.Sender;
import me.vaperion.blade.annotation.command.Command;
import me.vaperion.blade.annotation.command.Description;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import me.display.hub.Hub;

import static net.kyori.adventure.text.format.NamedTextColor.GREEN;

public class SetSpawnCommand {

    @Command(value = "setspawn")
    @Description("Set the server's spawn location")
    public static void setSpawn(@Sender Player sender) {
        Location location = sender.getLocation();

        // Save the spawn location in the config
        Hub.getInstance().getConfig().set("spawn", location);
        Hub.getInstance().saveConfig();

        sender.sendMessage(Component.text("Spawn location set to your exact location!", GREEN));
    }
}
