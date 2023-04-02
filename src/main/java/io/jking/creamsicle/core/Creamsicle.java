package io.jking.creamsicle.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;

import javax.security.auth.login.LoginException;

public class Creamsicle {

    private final Config config;
    private final JDA    jda;

    private Creamsicle() throws LoginException, InterruptedException {
        this.config = Config.getInstance();
        this.jda = initializeJDA();
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
