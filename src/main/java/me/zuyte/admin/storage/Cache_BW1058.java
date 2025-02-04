package me.zuyte.admin.storage;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cache_BW1058 {
    private static Map<Player, ITeam> playerTeamCache = new HashMap<>();
    private static Map<Player, ITeam> playerPreviousTeamCache = new HashMap<>();
    private static Map<Player, ItemStack> playerMLGCache = new HashMap<>();
    private static HashSet<Player> playerKaboomCache = new HashSet<>();
    private static Map<ITeam, BlockFace> arenaBedsCache = new HashMap<>();

    public static void setPlayerTeam(Player player, ITeam team) {
        playerTeamCache.put(player, team);
    }
    public static void setPreviousPlayerTeam(Player player, ITeam team) {
        playerPreviousTeamCache.put(player, team);
    }
    public static void removePlayerTeam(Player player) {
        playerTeamCache.remove(player);
    }
    public static ITeam getPlayerTeam(Player player) {
        return playerTeamCache.get(player);
    }
    public static ITeam getPreviousPlayerTeam(Player player) {
        return playerPreviousTeamCache.get(player);
    }
    public static boolean containsPlayerTeam(Player player) {
        return playerTeamCache.containsKey(player);
    }
    public static void setMLGCache(Player player, ItemStack replacedItem) {
        playerMLGCache.put(player, replacedItem);
    }
    public static void removeMLGCache(Player player) {
        playerMLGCache.remove(player);
    }
    public static ItemStack getMLGCache(Player player) {
        return playerMLGCache.get(player);
    }
    public static boolean containsMLGCache(Player player) {
        return playerMLGCache.containsKey(player);
    }
    public static void addKaboomCache(Player player) {
        playerKaboomCache.add(player);
    }
    public static void removeKaboomCache(Player player) {
        playerKaboomCache.remove(player);
    }
    public static boolean containsKaboomCache(Player player) {
        return playerKaboomCache.contains(player);
    }
    public static void setArenaBedsCache(ITeam team, BlockFace blockFace) {
        arenaBedsCache.put(team, blockFace);
    }
    public static void removeArenaBedsCache(ITeam team) {
        arenaBedsCache.remove(team);
    }
    public static BlockFace getArenaBedsCache(ITeam team) {
        return arenaBedsCache.get(team);
    }
}
