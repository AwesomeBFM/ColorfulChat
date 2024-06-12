package dev.awesomebfm.colorfulchat.menu;

import dev.awesomebfm.colorfulchat.ColorfulChat;
import mc.obliviate.inventory.Gui;
import mc.obliviate.inventory.Icon;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ColorGui extends Gui {

    private final ColorfulChat instance = ColorfulChat.getInstance();
    private static final String PREFIX = ColorfulChat.getPrefix();

    public ColorGui(Player player) {
        super(player, "colors-gui", "Chat Colors", 4);
        //player, id, title, row
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        PersistentDataContainer data = event.getPlayer().getPersistentDataContainer();


        addItem(0, new Icon(Material.CYAN_CONCRETE).setName(ChatColor.AQUA + "Aqua").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "AQUA");
        }));
        addItem(1, new Icon(Material.BLACK_CONCRETE).setName(ChatColor.BLACK + "Black").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "BLACK");
        }));
        addItem(2, new Icon(Material.BLUE_CONCRETE).setName(ChatColor.BLUE + "Blue").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "BLUE");
        }));
        addItem(3, new Icon(Material.CYAN_WOOL).setName(ChatColor.DARK_AQUA + "Dark Aqua").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_AQUA");
        }));
        addItem(4, new Icon(Material.BLUE_CONCRETE).setName(ChatColor.DARK_BLUE + "Dark Blue").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_BLUE");
        }));
        addItem(5, new Icon(Material.GRAY_CONCRETE).setName(ChatColor.DARK_GRAY + "Dark Gray").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_GRAY");
        }));
        addItem(6, new Icon(Material.GREEN_CONCRETE).setName(ChatColor.DARK_GREEN + "Dark Green").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_GREEN");
        }));
        addItem(7, new Icon(Material.PURPLE_CONCRETE).setName(ChatColor.DARK_PURPLE + "Purple").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_PURPLE");
        }));
        addItem(8, new Icon(Material.RED_CONCRETE).setName(ChatColor.DARK_RED + "Dark Red").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_RED");
        }));
        addItem(9, new Icon(Material.GOLD_BLOCK).setName(ChatColor.GOLD + "Gold").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GOLD");
        }));
        addItem(10, new Icon(Material.LIGHT_GRAY_CONCRETE).setName(ChatColor.GRAY + "Gray").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GRAY");
        }));
        addItem(11, new Icon(Material.LIME_CONCRETE).setName(ChatColor.GREEN + "Green").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GREEN");
        }));
        addItem(12, new Icon(Material.PINK_CONCRETE).setName(ChatColor.LIGHT_PURPLE + "Pink").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "LIGHT_PURPLE");
        }));
        addItem(13, new Icon(Material.RED_WOOL).setName(ChatColor.RED + "Red").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "RED");
        }));
        addItem(14, new Icon(Material.WHITE_CONCRETE).setName(ChatColor.WHITE + "White").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "WHITE");
        }));
        addItem(15, new Icon(Material.YELLOW_CONCRETE).setName(ChatColor.YELLOW + "Yellow").onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "YELLOW");
        }));

        addItem(31, new Icon(Material.BARRIER).setName(ChatColor.RED + "Close Menu").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to close the menu!"
        )).onClick(e -> {
            e.getWhoClicked().closeInventory();
        }));
    }

}
