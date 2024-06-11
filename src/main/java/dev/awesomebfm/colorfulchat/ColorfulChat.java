package dev.awesomebfm.colorfulchat;

import dev.awesomebfm.colorfulchat.command.ChatColorCommand;
import dev.awesomebfm.colorfulchat.listener.ChatListener;
import dev.awesomebfm.colorfulchat.listener.JoinListener;
import me.kodysimpson.simpapi.menu.MenuManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
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

        PluginCommand command = getCommand("chatcolor");
        if (command == null) {
            Bukkit.getLogger().severe("Could not load commands! Please report at https://github.com/AwesomeBFM/ColorfulChat/issues");
            return;
        }
        command.setExecutor(new ChatColorCommand(this));


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
