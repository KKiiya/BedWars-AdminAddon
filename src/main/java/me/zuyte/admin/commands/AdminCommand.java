package me.zuyte.admin.commands;

import me.zuyte.admin.Admin;
import me.zuyte.admin.commands.subcommands.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class AdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r\n&8&lþ &6BedWars1058 Admin v" + Admin + " &7- &cCommands\n \n&6• &7/bwa forcejoin <player> <arena> &8- &eForcejoin player into a arena\n&6• &7/bwa setteam <player> <team> &8- &eSet the player's team\n&6• &7/bwa setbed <player> <true ┃ false> &8 &eSet a team's bed status\n&6• &7/bwa nextevent <arena> <event> &8- &eSet an arena's next event\n&6• &7/bwa skipevent <arena> &8- &eSkip upcoming event\n \n&6• &7/bwa troll mlg <player> &8- &eMakes the player complete an mlg\n&6• &7/bwa troll cage <player> &8- &eTraps the player in a breakable glass cage\n&6• &7/bwa troll blind <player> <seconds> &8- &eBlinds the player\n&6• &7/bwa troll slowhands <player> <seconds> &8- &eSlows mining speed of the player\n&6• &7/bwa troll kaboom <player> &8- &eLaunched player in the air\n&6• &7/bwa troll toystick <player> &8- &eGives the player an explosive toystick\n&6• &7/bwa troll ghast <player> &8- &eSpawns ghast at the player\n&6• &7/bwa troll mobattack <player> &8- &eSpawns Zombies & Skeletons at the player"));
                return true;
            } else if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r\n&8&lþ &6BedWars1058 Admin v" + Admin.version + " &7- &cCommands\n \n&6• &7/bwa forcejoin <player> <arena> &8- &eForcejoin player into a arena\n&6• &7/bwa setteam <player> <team> &8- &eSet the player's team\n&6• &7/bwa setbed <player> <true ┃ false> &8 &eSet a team's bed status\n&6• &7/bwa nextevent <arena> <event> &8- &eSet an arena's next event\n&6• &7/bwa skipevent <arena> &8- &eSkip upcoming event\n \n&6• &7/bwa troll mlg <player> &8- &eMakes the player complete an mlg\n&6• &7/bwa troll cage <player> &8- &eTraps the player in a breakable glass cage\n&6• &7/bwa troll blind <player> <seconds> &8- &eBlinds the player\n&6• &7/bwa troll slowhands <player> <seconds> &8- &eSlows mining speed of the player\n&6• &7/bwa troll kaboom <player> &8- &eLaunched player in the air\n&6• &7/bwa troll toystick <player> &8- &eGives the player an explosive toystick\n&6• &7/bwa troll ghast <player> &8- &eSpawns ghast at the player\n&6• &7/bwa troll mobattack <player> &8- &eSpawns Zombies & Skeletons at the player"));
                    return true;
                } else if (args[0].equalsIgnoreCase("forcejoin")) {
                    new ForceJoinSubCommand(sender, args);
                    return true;
                } else if (args[0].equalsIgnoreCase("setteam")) {
                    new SetTeamSubCommand().player(p, args);
                    return true;
                } else if (args[0].equalsIgnoreCase("setbed")) {
                    new SetBedSubCommand().player(p, args);
                    return true;
                } else if (args[0].equalsIgnoreCase("skipevent")) {
                    new SkipEventSubCommand().player(p, args);
                    return true;
                } else if (args[0].equalsIgnoreCase("nextevent")) {
                    new NextEventSubCommand().player(p, args);
                    return true;
                } else if (args[0].equalsIgnoreCase("troll")) {
                    new TrollSubCommand().player(p, args);
                    return true;
                }
                    p.sendMessage(ChatColor.RED + "Command not found.");
                    return true;
            }
        }
                c.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r\n&8&lþ &6BedWars1058 Admin v" + Admin.version + " &7- &cCommands\n \n&6• &7/bwa forcejoin <player> <arena> &8- &eForcejoin player into a arena\n&6• &7/bwa setteam <player> &8- &eSet the player's team\n&6• &7/bwa setbed <player> <true ┃ false> &8 &eSet a team's bed status\n&6• &7/bwa nextevent <arena> <event> &8- &eSet an arena's next event\n&6• &7/bwa skipevent <arena> &8- &eSkip upcoming event\n \n&6• &7/bwa troll mlg <player> &8- &eMakes the player complete an mlg\n&6• &7/bwa troll cage <player> &8- &eTraps the player in a breakable glass cage\n&6• &7/bwa troll blind <player> <seconds> &8- &eBlinds the player\n&6• &7/bwa troll slowhands <player> <seconds> &8- &eSlows mining speed of the player\n&6• &7/bwa troll kaboom <player> &8- &eLaunched player in the air\n&6• &7/bwa troll toystick <player> &8- &eGives the player an explosive toystick\n&6• &7/bwa troll ghast <player> &8- &eSpawns ghast at the player\n&6• &7/bwa troll mobattack <player> &8- &eSpawns Zombies & Skeletons at the player"));
        return false;
    }
}
