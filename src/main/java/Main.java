import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String token = rootProject.file('Token.txt').text.trim();

        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        JDA jda = null;

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
