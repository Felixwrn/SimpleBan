package de.wrn.simpleban;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

    private final BanManager manager;


    public BanCommand(BanManager manager) {

        this.manager = manager;

    }


    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {


        if (args.length < 2) {

            sender.sendMessage(
                    "§cBenutzung: /" + label + " <Spieler> <Grund>"
            );

            return true;

        }


        Player target = Bukkit.getPlayer(args[0]);


        if (target == null) {

            sender.sendMessage(
                    "§cSpieler nicht gefunden!"
            );

            return true;

        }


        long expire = -1;
        int start = 1;


        if (label.equalsIgnoreCase("tempban")) {


            if (args.length < 3) {

                sender.sendMessage(
                        "§c/tempban <Spieler> <Zeit> <Grund>"
                );

                return true;

            }


            expire = System.currentTimeMillis()
                    + parseTime(args[1]);


            start = 2;

        }


        StringBuilder reason = new StringBuilder();


        for (int i = start; i < args.length; i++) {

            reason.append(args[i]).append(" ");

        }


        manager.ban(
                target.getUniqueId(),
                reason.toString(),
                expire
        );


        target.kickPlayer(
                "§cDu wurdest gebannt!\n\n"
                        + "§7Grund: §f"
                        + reason
        );


        sender.sendMessage(
                "§aSpieler wurde gebannt."
        );


        return true;
    }


    private long parseTime(String input) {


        long multiplier = 1000;


        if (input.endsWith("m"))
            multiplier *= 60;


        else if (input.endsWith("h"))
            multiplier *= 60 * 60;


        else if (input.endsWith("d"))
            multiplier *= 60 * 60 * 24;


        else if (input.endsWith("w"))
            multiplier *= 60 * 60 * 24 * 7;


        long number = Long.parseLong(
                input.substring(0, input.length() - 1)
        );


        return number * multiplier;

    }
}
