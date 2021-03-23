import com.wrapper.spotify.SpotifyApi;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        JDABuilder jdaBuilder = JDABuilder.createDefault("ODIyNDgxNTE1NjI2NzU4MTQ0.YFS5mg.ji1Es3hlvW9e6zFSY_w4S9bLosA");
        JDA jda = null;

        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken("d")
                .build();

        MessagesClass messagesClass = new MessagesClass();

        jdaBuilder.addEventListeners(messagesClass);
        jdaBuilder.setActivity(Activity.watching("champen Andreas"));

        try{
            jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        try {
            jda.awaitReady();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
