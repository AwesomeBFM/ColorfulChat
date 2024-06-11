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

package dev.awesomebfm.colorfulchat;

import dev.awesomebfm.colorfulchat.command.ChatColorCommand;
import dev.awesomebfm.colorfulchat.listener.ChatListener;
import dev.awesomebfm.colorfulchat.listener.JoinListener;
import me.kodysimpson.simpapi.menu.MenuManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ColorfulChat extends JavaPlugin {
    private static final String PREFIX = ChatColor.translateAlternateColorCodes('&', "&8[&cC&6o&el&ao&9r&5f&cu&6l&eC&ah&9a&5t&8] ");

    private ChatColor defaultColor;

    private static ColorfulChat instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        MenuManager.setup(getServer(), this);

        defaultColor = ChatColor.valueOf(getConfig().getString("default-color"));

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);

        getCommand("chatcolor").setExecutor(new ChatColorCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static String getPrefix() {
        return PREFIX;
    }

    public ChatColor getDefaultColor() {
        return defaultColor;
    }

    public static ColorfulChat getInstance() {
        return instance;
    }
}
