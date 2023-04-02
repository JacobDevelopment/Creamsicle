package io.jking.creamsicle.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;

public class AudioManager {

    private final AudioPlayerManager audioPlayerManager;
    private final AudioPlayer audioPlayer;
    private final TrackScheduler trackScheduler;

    public AudioManager() {
        this.audioPlayerManager = new DefaultAudioPlayerManager();
        this.audioPlayer = audioPlayerManager.createPlayer();
        this.trackScheduler = new TrackScheduler();
        register();
    }

    private void register() {
        AudioSourceManagers.registerRemoteSources(audioPlayerManager);
    }

    public AudioPlayerManager getAudioPlayerManager() {
        return audioPlayerManager;
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public TrackScheduler getTrackScheduler() {
        return trackScheduler;
    }
}
