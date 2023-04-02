package io.jking.creamsicle;

import io.jking.creamsicle.core.Creamsicle;

import javax.security.auth.login.LoginException;

public class App {

    public static void main(String[] args) {
        try {
            Creamsicle.build();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
