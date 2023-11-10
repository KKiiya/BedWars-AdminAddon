package me.zuyte.admin;

import com.andrei1058.bedwars.api.BedWars;
import me.zuyte.admin.support.BW1058;
import me.zuyte.admin.support.BW2023;
import me.zuyte.admin.support.BWProxy;
import me.zuyte.admin.support.IBedWars;
import me.zuyte.admin.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Admin extends JavaPlugin {

    private static Admin instance;
    public boolean isBedWarsProxy = false;
    public BedWars bw1058;
    public com.tomkeuper.bedwars.api.BedWars bw2023;
    public com.andrei1058.bedwars.proxy.api.BedWars bwProxy;
    @Override
    public void onEnable() {
        instance = this;
        IBedWars bwSupport;

        if (Bukkit.getPluginManager().getPlugin("BedWars1058") != null)
            bwSupport = new BW1058(this);
        else if (Bukkit.getPluginManager().getPlugin("BedWars2023") != null)
            bwSupport = new BW2023(this);
        else if (Bukkit.getPluginManager().getPlugin("BedWarsProxy") != null)
            bwSupport = new BWProxy(this);
        else {
            getLogger().severe("Couldn't find a bedwars supported plugin. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        // setup support
        bwSupport.setupMessages();
        bwSupport.setupCommands();
        bwSupport.initializeListeners();
        getServer().getConsoleSender().sendMessage(TextUtils.getColoredString("&aRunning BedWars1058-AdminAddon &fv" + getDescription().getVersion() + " &a(Type: " + (isBedWarsProxy ? "&cBedWarsProxy" : "&cBedWars") + "&a) &7- &eBy Zuyte"));
    }

    public static Admin getInstance(){
        return instance;
    }
}