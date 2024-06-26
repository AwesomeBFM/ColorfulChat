package dev.awesomebfm.colorfulchat;

import com.google.common.reflect.TypeToken;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class Updater {

    private final String currentVersion;

    public Updater(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    record Version (
            String name,
            String versionNumber,
            String versionType,
            List<String> loaders,
            boolean featured
    ){}

    private List<Version> getVersions() throws IOException {
        URL url = URI.create("https://api.modrinth.com/v2/project/OvVrnX0V/version").toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP Error: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        Gson gson = new GsonBuilder().setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type type = new TypeToken<List<Version>>(){}.getType();
        return gson.fromJson(content.toString(), type);
    }

    public boolean shouldUpdate() throws IOException {
        List<Version> versions = getVersions();

        Version latest = versions.stream()
                .filter(v -> v.featured)
                .findFirst().orElseThrow();

        return latest.versionNumber != null && !latest.versionNumber.equals(currentVersion);
    }

}
