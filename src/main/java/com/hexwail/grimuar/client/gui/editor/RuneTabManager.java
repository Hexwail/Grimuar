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

public class RuneTabManager {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Type TAB_LIST_TYPE = new TypeToken<List<RuneTab>>() {}.getType();

    private static Path getSavePath() {
        String worldName = Minecraft.getInstance().level != null ?
                Minecraft.getInstance().level.getLevelData().getLevelName() : "unknown_world";

        return Paths.get(Minecraft.getInstance().gameDirectory.getAbsolutePath(),
                "saves", worldName, "grimuar", "runes", "tabs.json");
    }

    private static List<RuneTab> tabs = new ArrayList<>();

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

    public static List<RuneTab> getTabs() {
        return tabs;
    }

    public static void addTab(RuneTab tab) {
        tabs.add(tab);
        save();
    }

    public static void removeTab(RuneTab tab) {
        tabs.remove(tab);
        save();
    }
}
