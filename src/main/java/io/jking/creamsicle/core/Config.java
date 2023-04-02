package io.jking.creamsicle.core;

import net.dv8tion.jda.api.utils.data.DataObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Config {

    private static final Config instance = new Config();

    private DataObject data;

    private Config() {
        try {
            this.data = DataObject.fromJson(new BufferedReader(new FileReader("config.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config getInstance() {
        if (instance == null) {
            return new Config();
        }
        return instance;
    }

    public DataObject getData() {
        return data;
    }

    public String getToken() {
        return data.getString("token");
    }

}
