package me.zuyte.admin.commands.subcommands;

import com.andrei1058.bedwars.api.BedWars;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.NextEvent;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import me.zuyte.admin.Admin;
import me.zuyte.admin.utils.TextUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SkipEventSubCommand {

    BedWars.ArenaUtil arenaUtil = Admin.getInstance().bw.getArenaUtil();

    public SkipEventSubCommand(CommandSender commandSender, String[] args) {
        if (commandSender instanceof Player)
            player((Player) commandSender, args);
        else if (commandSender instanceof ConsoleCommandSender)
            console((ConsoleCommandSender) commandSender, args);
    }

    public void player(Player p, String[] args) {
        if (!p.hasPermission("bw.admin.skipevent")) {
            TextUtils.sendPlayerConfigString("defaults.no-permission", p);
            return;
        }
        if (args.length > 1) {
            if (arenaUtil.getArenaByName(args[1]) == null) {
                TextUtils.sendPlayerConfigString("defaults.arena-not-found", p);
                return;
            }
            IArena arena = arenaUtil.getArenaByName(args[1]);
            if (arena.getNextEvent().equals(NextEvent.DIAMOND_GENERATOR_TIER_II)) {
                arena.setNextEvent(NextEvent.DIAMOND_GENERATOR_TIER_III);
            } else if (arena.getNextEvent().equals(NextEvent.DIAMOND_GENERATOR_TIER_III)) {
                arena.setNextEvent(NextEvent.EMERALD_GENERATOR_TIER_II);
            } else if (arena.getNextEvent().equals(NextEvent.EMERALD_GENERATOR_TIER_II)) {
                arena.setNextEvent(NextEvent.EMERALD_GENERATOR_TIER_III);
            } else if (arena.getNextEvent().equals(NextEvent.EMERALD_GENERATOR_TIER_III)) {
                arena.setNextEvent(NextEvent.BEDS_DESTROY);
            } else if (arena.getNextEvent().equals(NextEvent.BEDS_DESTROY)) {
                for (ITeam team : arena.getTeams()) {
                    if (!team.isBedDestroyed())
                        team.setBedDestroyed(true);
                }
                arena.setNextEvent(NextEvent.ENDER_DRAGON);
            } else if (arena.getNextEvent().equals(NextEvent.ENDER_DRAGON)) {
                arena.setNextEvent(NextEvent.GAME_END);
            } else if (arena.getNextEvent().equals(NextEvent.GAME_END)) {
                TextUtils.sendPlayerConfigString("admin-message.skipevent.error", p);
                return;
            }
            TextUtils.sendPlayerConfigString("defaults.success", p);
            return;
        }
        TextUtils.sendPlayerConfigString("usage.skipevent", p);
    }

    public void console(ConsoleCommandSender c, String[] args) {
        if (args.length > 1) {
            if (arenaUtil.getArenaByName(args[1]) == null) {
                TextUtils.sendDefaultConfigString("defaults.arena-not-found", c);
                return;
            }
            IArena arena = arenaUtil.getArenaByName(args[1]);
            if (arena.getNextEvent().equals(NextEvent.DIAMOND_GENERATOR_TIER_II)) {
                arena.setNextEvent(NextEvent.DIAMOND_GENERATOR_TIER_III);
            } else if (arena.getNextEvent().equals(NextEvent.DIAMOND_GENERATOR_TIER_III)) {
                arena.setNextEvent(NextEvent.EMERALD_GENERATOR_TIER_II);
            } else if (arena.getNextEvent().equals(NextEvent.EMERALD_GENERATOR_TIER_II)) {
                arena.setNextEvent(NextEvent.EMERALD_GENERATOR_TIER_III);
            } else if (arena.getNextEvent().equals(NextEvent.EMERALD_GENERATOR_TIER_III)) {
                arena.setNextEvent(NextEvent.BEDS_DESTROY);
            } else if (arena.getNextEvent().equals(NextEvent.BEDS_DESTROY)) {
                for (ITeam team : arena.getTeams()) {
                    if (!team.isBedDestroyed())
                        team.setBedDestroyed(true);
                }
                arena.setNextEvent(NextEvent.ENDER_DRAGON);
            } else if (arena.getNextEvent().equals(NextEvent.ENDER_DRAGON)) {
                arena.setNextEvent(NextEvent.GAME_END);
            } else if (arena.getNextEvent().equals(NextEvent.GAME_END)) {
                TextUtils.sendDefaultConfigString("admin-message.skipevent.error", c);
                return;
            }
            TextUtils.sendDefaultConfigString("defaults.success", c);
            return;
        }
        TextUtils.sendDefaultConfigString("usage.skipevent", c);
    }
}
