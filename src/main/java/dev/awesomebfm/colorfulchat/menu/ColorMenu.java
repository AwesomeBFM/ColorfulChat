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

package dev.awesomebfm.colorfulchat.menu;


import dev.awesomebfm.colorfulchat.ColorfulChat;
import me.kodysimpson.simpapi.menu.Menu;
import me.kodysimpson.simpapi.menu.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ColorMenu extends Menu {

    private final ColorfulChat instance = ColorfulChat.getInstance();
    private static final String PREFIX = ColorfulChat.getPrefix();

    public ColorMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Chat Colors";
    }

    @Override
    public int getSlots() {
        return 36;
    }

    @Override
    public boolean cancelAllClicks() {
        return true;
    }

    @Override
    public void handleMenu(InventoryClickEvent e){
        PersistentDataContainer data = e.getWhoClicked().getPersistentDataContainer();
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        String color = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
        switch (color) {
            case "Aqua" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "AQUA");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.AQUA + "Aqua");
            }
            case "Black" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "BLACK");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.BLACK + "Black");
            }
            case "Blue" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "BLUE");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.BLUE + "Blue");
            }
            case "Dark Aqua" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_AQUA");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.DARK_AQUA + "Dark Aqua");
            }
            case "Dark Blue" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_BLUE");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.DARK_BLUE + "Dark Blue");
            }
            case "Dark Gray" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_GRAY");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.DARK_GRAY + "Dark Gray");
            }
            case "Dark Green" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_GREEN");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.DARK_GREEN + "Dark Green");
            }
            case "Purple" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_PURPLE");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.DARK_PURPLE + "Purple");
            }
            case "Dark Red" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_RED");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.DARK_RED + "Dark Red");
            }
            case "Gold" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GOLD");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.GOLD + "Gold");
            }
            case "Gray" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GRAY");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.GRAY + "Gray");
            }
            case "Green" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GREEN");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.GREEN + "Green");
            }
            case "Pink" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "LIGHT_PURPLE");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.LIGHT_PURPLE + "Pink");
            }
            case "Red" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "RED");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.RED + "Red");
            }
            case "White" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "WHITE");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.WHITE + "White");
            }
            case "Yellow" -> {
                data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "YELLOW");
                e.getWhoClicked().sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been set to " + ChatColor.YELLOW + "Yellow");
            }
        }

        e.getWhoClicked().closeInventory();
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(0, createColor( ChatColor.AQUA + "Aqua", Material.CYAN_CONCRETE));
        inventory.setItem(1, createColor(ChatColor.BLACK + "Black", Material.BLACK_CONCRETE));
        inventory.setItem(2, createColor(ChatColor.BLUE + "Blue", Material.LIGHT_BLUE_CONCRETE));
        inventory.setItem(3, createColor(ChatColor.DARK_AQUA + "Dark Aqua", Material.CYAN_WOOL));
        inventory.setItem(4, createColor(ChatColor.DARK_BLUE + "Dark Blue", Material.BLUE_CONCRETE));
        inventory.setItem(5, createColor(ChatColor.DARK_GRAY + "Dark Gray", Material.GRAY_CONCRETE));
        inventory.setItem(6, createColor(ChatColor.DARK_GREEN + "Dark Green", Material.GREEN_CONCRETE));
        inventory.setItem(7, createColor(ChatColor.DARK_PURPLE + "Purple", Material.PURPLE_CONCRETE));
        inventory.setItem(8, createColor(ChatColor.DARK_RED + "Dark Red", Material.RED_CONCRETE));
        inventory.setItem(10, createColor(ChatColor.GOLD + "Gold", Material.GOLD_BLOCK));
        inventory.setItem(11, createColor(ChatColor.GRAY + "Gray", Material.LIGHT_GRAY_CONCRETE));
        inventory.setItem(12, createColor(ChatColor.GREEN + "Green", Material.LIME_CONCRETE));
        inventory.setItem(13, createColor(ChatColor.LIGHT_PURPLE + "Pink", Material.PINK_CONCRETE));
        inventory.setItem(14, createColor(ChatColor.RED + "Red", Material.RED_WOOL));
        inventory.setItem(15, createColor(ChatColor.WHITE + "White", Material.WHITE_CONCRETE));
        inventory.setItem(16, createColor(ChatColor.YELLOW + "Yellow", Material.YELLOW_CONCRETE));


        ItemStack closeMenu = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = closeMenu.getItemMeta();
        assert closeMeta != null;
        closeMeta.setDisplayName(ChatColor.RED + "Close Menu");
        closeMeta.setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to close the menu!"
        ));
        closeMenu.setItemMeta(closeMeta);
        inventory.setItem(31, closeMenu);

    }

    private ItemStack createColor(String title, Material material) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(title);
        PersistentDataContainer data = playerMenuUtility.getOwner().getPersistentDataContainer();
        String color = data.get(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING);
        if (color != null && color.equalsIgnoreCase(ChatColor.stripColor(title))) {
            meta.setLore(List.of(
                    "",
                    ChatColor.GREEN + "Currently selected!"
            ));
        } else {
            meta.setLore(List.of(
                    "",
                    ChatColor.YELLOW + "Click to change to " + title.toLowerCase() + ChatColor.YELLOW + "!"
            ));
        }
        item.setItemMeta(meta);
        return item;
    }
}
