package com.hexwail.grimuar.client.gui.editor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SpellTabManager {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Type TAB_LIST_TYPE = new TypeToken<List<SpellTab>>() {}.getType();

    private static Path getSavePath() {
        String worldName = Minecraft.getInstance().level != null ?
                Minecraft.getInstance().level.getLevelData().getLevelName() : "unknown_world";

        return Paths.get(Minecraft.getInstance().gameDirectory.getAbsolutePath(),
                "saves", worldName, "grimuar", "spells", "tabs.json");
    }

    private static List<SpellTab> tabs = new ArrayList<>();

    public static void load() {
        Path path = getSavePath();
        if (Files.exists(path)) {
            try (Reader reader = Files.newBufferedReader(path)) {
                tabs = GSON.fromJson(reader, TAB_LIST_TYPE);
                if (tabs == null) tabs = new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void save() {
        Path path = getSavePath();
        try {
            Files.createDirectories(path.getParent());
            try (Writer writer = Files.newBufferedWriter(path)) {
                GSON.toJson(tabs, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SpellTab> getTabs() {
        return tabs;
    }

    public static void addTab(SpellTab tab) {
        tabs.add(tab);
        save();
    }

    public static void removeTab(SpellTab tab) {
        tabs.remove(tab);
        save();
    }
}
