package dev.awesomebfm.colorfulchat.command;

import dev.awesomebfm.colorfulchat.ColorfulChat;
import dev.awesomebfm.colorfulchat.menu.ColorMenu;
import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.MenuManager;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ChatColorCommand implements CommandExecutor {

    private final ColorfulChat instance;
    private static final String PREFIX = ColorfulChat.getPrefix();

    public ChatColorCommand(ColorfulChat instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage(ChatColor.RED + "ERROR: You must be a player to run this command!");
            return true;
        }

        if (args.length < 1) {
            try {
                MenuManager.openMenu(ColorMenu.class, p);
            } catch (MenuManagerException | MenuManagerNotSetupException e) {
                p.sendMessage(PREFIX + ChatColor.RED + "ERROR: Something went wrong while opening the menu!");
            }
            return true;
        }

        PersistentDataContainer data = p.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(instance, "chatcolor");

        String color = args[0].toLowerCase();
        switch (color) {
            case "black" -> data.set(key, PersistentDataType.STRING, "BLACK");
            case "dark_blue" -> data.set(key, PersistentDataType.STRING, "DARK_BLUE");
            case "dark_green" -> data.set(key, PersistentDataType.STRING, "DARK_GREEN");
            case "dark_aqua" -> data.set(key, PersistentDataType.STRING, "DARK_AQUA");
            case "dark_red" -> data.set(key, PersistentDataType.STRING, "DARK_RED");
            case "dark_purple" -> data.set(key, PersistentDataType.STRING, "DARK_PURPLE");
            case "gold" -> data.set(key, PersistentDataType.STRING, "GOLD");
            case "gray" -> data.set(key, PersistentDataType.STRING, "GRAY");
            case "dark_gray" -> data.set(key, PersistentDataType.STRING, "DARK_GRAY");
            case "blue" -> data.set(key, PersistentDataType.STRING, "BLUE");
            case "green" -> data.set(key, PersistentDataType.STRING, "GREEN");
            case "aqua" -> data.set(key, PersistentDataType.STRING, "AQUA");
            case "red" -> data.set(key, PersistentDataType.STRING, "RED");
            case "pink" -> data.set(key, PersistentDataType.STRING, "LIGHT_PURPLE"); // 'pink' is not available in ChatColor, using LIGHT_PURPLE instead
            case "yellow" -> data.set(key, PersistentDataType.STRING, "YELLOW");
            case "white" -> data.set(key, PersistentDataType.STRING, "WHITE");
            default -> {
                try {
                    MenuManager.openMenu(ColorMenu.class, p);
                } catch (MenuManagerException | MenuManagerNotSetupException e) {
                    p.sendMessage(PREFIX + ChatColor.RED + "ERROR: Something went wrong while opening the menu!");
                }
                return true;
            }
        }

        if (args[0].equalsIgnoreCase("pink")) {
            args[0] = "light_purple";
        }
        p.sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been successfully changed to " + ChatColor.valueOf(args[0].toUpperCase()) + args[0] + ChatColor.GREEN + "!");
        return true;
    }
}
