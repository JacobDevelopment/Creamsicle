package io.jking.creamsicle.core;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import io.jking.creamsicle.audio.AudioManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;


public class Creamsicle {

    private final Config       config;
    private final JDA          jda;
    private final AudioManager audioManager;


    private Creamsicle() throws LoginException, InterruptedException {
        this.config = Config.getInstance();
        this.jda = initializeJDA();
        this.audioManager = new AudioManager();
    }

    public static Creamsicle build() throws LoginException, InterruptedException {
        return new Creamsicle();
    }

    private JDA initializeJDA() throws LoginException, InterruptedException {
        final String token = config.getToken();
        return JDABuilder.createDefault(token)
                .build()
                .awaitReady();
    }

    public JDA getJDA() {
        return jda;
    }
}
