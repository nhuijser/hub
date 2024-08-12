package me.display.hub;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;

import java.time.Duration;

public class HubConstants {

    public static void sendWelcomeMessage(Player player) {
        var welcomeMessage = MiniMessage.miniMessage().deserialize("<light_purple>" + player.getName() + "</light_purple><yellow> has joined the server.</yellow>");

        player.sendMessage(welcomeMessage);
    }

}