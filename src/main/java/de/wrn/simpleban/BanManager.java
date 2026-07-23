package de.wrn.simpleban;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class BanManager {

    private final File file;
    private final YamlConfiguration data;


    public BanManager(SimpleBan plugin) {

        file = new File(plugin.getDataFolder(), "bans.yml");

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        data = YamlConfiguration.loadConfiguration(file);
    }


    public void ban(UUID uuid, String reason, long expire) {

        data.set(uuid + ".reason", reason);
        data.set(uuid + ".expire", expire);

        save();
    }


    public boolean isBanned(UUID uuid) {

        if (!data.contains(uuid.toString()))
            return false;


        long expire = data.getLong(uuid + ".expire");


        if (expire != -1 && expire <= System.currentTimeMillis()) {

            data.set(uuid.toString(), null);
            save();

            return false;
        }


        return true;
    }


    public String getReason(UUID uuid) {

        return data.getString(uuid + ".reason");

    }


    public long getExpire(UUID uuid) {

        return data.getLong(uuid + ".expire");

    }


    private void save() {

        try {

            data.save(file);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
