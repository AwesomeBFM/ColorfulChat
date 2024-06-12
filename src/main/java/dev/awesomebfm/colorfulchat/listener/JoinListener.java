/*
   Copyright 2024 AwesomeBFM

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package dev.awesomebfm.colorfulchat.listener;

import dev.awesomebfm.colorfulchat.ColorfulChat;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class JoinListener implements Listener {
    private final ColorfulChat instance;
    private static final String PREFIX = ColorfulChat.getPrefix();
    private static final String CHANGE_COLOR_PERMISSION = "colorfulchat.change";
    private static final String COLOR_CODES_PERMISSION = "colorfulchat.codes";

    public JoinListener(ColorfulChat instance) {
        this.instance = instance;
    }

    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PersistentDataContainer data = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(instance, "chatcolor");

        if (!data.has(key, PersistentDataType.STRING)) {
            data.set(key, PersistentDataType.STRING, instance.getDefaultColor().toString());

            // Inform player that they have access to the command
            if (player.hasPermission(CHANGE_COLOR_PERMISSION)) {
                player.sendMessage(PREFIX +
                        ChatColor.YELLOW + "Welcome to the server, this server is running " +
                        ChatColor.translateAlternateColorCodes('&', "&cC&6o&el&ao&9r&5f&cu&6l&eC&ah&9a&5t") +
                        ChatColor.YELLOW + " and you have access! Run " + ChatColor.GREEN + "/cc " + ChatColor.YELLOW + "to change your color!");
            }

            // Inform player that they have access to color codes
            if (player.hasPermission(COLOR_CODES_PERMISSION)) {
                player.sendMessage(PREFIX +
                        ChatColor.YELLOW + "You also are able to use color codes in chat! Use them like " +
                        ChatColor.GREEN + "&b&lthis" + ChatColor.YELLOW + " to get " + ChatColor.AQUA + "" + ChatColor.BOLD + "this" + ChatColor.YELLOW + "!");
            }
        }
    }
}
