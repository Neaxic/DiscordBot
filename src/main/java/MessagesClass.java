import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.time.Duration;

public class MessagesClass extends ListenerAdapter {

    private String rulesID = "";

    // TODO: SMART METHODS HERE -----------------------------------------------------------------------------------------------------------------------

    public String contextRaw(MessageReceivedEvent e){
        return e.getMessage().getContentRaw();
    }

    public boolean contextequals(MessageReceivedEvent e, String str){
        return e.getMessage().getContentRaw().equals(str);
    }

    public boolean contexteContains(MessageReceivedEvent e, String str){
        return e.getMessage().getContentRaw().contains(str);
    }

    public void sendchannelMsg(MessageReceivedEvent e, String msg){
        e.getChannel().sendMessage(msg).queue();
    }

    public void sendchannelMsgWithEmote(MessageReceivedEvent e, String msg, String unicode){
        if(unicode.contains(",")){
            String[] UnicodeArr = unicode.split(",",7);
            e.getChannel().sendMessage(msg).queue(message -> {
                for (String a : UnicodeArr) {
                    message.addReaction(a).queue();
                }
            });
        }
        else {
            e.getChannel().sendMessage(msg).queue(message -> message.addReaction(unicode).queue());
        }
    }

    public void addReaction(MessageReceivedEvent e, String unicode){
        e.getChannel().addReactionById(e.getMessageId(), unicode).queue();
    }

    public void sendchannelAttachment(MessageReceivedEvent e, String msg){
        /*e.getChannel().sendMessage(msg)
                .addFile(new File ("Images/fireaspect.png"))
                .embed(new EmbedBuilder()
                        .setImage("attachment:./Images/fireaspect.png")
                        .build())
                .queue();
        */
        e.getChannel().sendFile(new File("./Images/BeetleNude.jpg"),"BeetleNude.jpg").queue();
    }

    // TODO: EVENTS HERE ---------------------------------------------------------------------------------------------------------------------------

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        //if(e.getChannel())
        //e.getChannel().addReactionById(e.getMessageId(), e.getReaction().getReactionEmote().getAsReactionCode());
        //e.getMember().getRoles().add(e.getMember().get)
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {

        if(contextequals(e,".info")){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("BOT STATUS:");
            embedBuilder.addField("COMMANDS: ","YES",false);
            embedBuilder.addField("DATABASE: ","NO",false);
            embedBuilder.addField("HOTEL: ","TRIVAGO",false);
            embedBuilder.setColor(0xa83232);

            e.getChannel().sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }

        // TODO: MESSAGE CHECKS HERE ---------------------------------------------------------------------------------------------------------------------
        if(contextequals(e,".KlasseLinks")){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Overview af links:");
            embedBuilder.addField("SDJ","https://viadk.zoom.us/j/4059985796?pwd=SzVyNkhnMytVa3FzK3VNMGh6amxQdz09",false);
            embedBuilder.addField("SWE","https://viadk.zoom.us/j/3380114758?pwd=VkUvazkxdTdtdVVVejdNWTVvQUpLUT09",false);
            embedBuilder.addField("DBS","https://applications.zoom.us/lti/rich",false);
            embedBuilder.addField("SEP","https://viadk.zoom.us/j/4059985796?pwd=SzVyNkhnMytVa3FzK3VNMGh6amxQdz09",false);
            embedBuilder.setColor(0xa83232);

            e.getChannel().sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }

        if(contextequals(e,"Andre")){
            sendchannelMsg(e,"Top shotta ^");
        }
        if(contextequals(e,".sut")){
            sendchannelMsg(e,e.getMessage().getAuthor().getName() + " sutter Line af");
            sendchannelMsg(e, "og "+ e.getMessage().getAuthor().getName() + " nyder det!");
        }
        if(contextequals(e,"Andre is gay")){
            sendchannelMsg(e,"You are wrong!");
            e.getMember().modifyNickname(e.getAuthor().getName() + "is gay");
            //e.getMember().kick();
        }
        if(contextequals(e,".adminGuden")) {
            if (e.getMessage().getAuthor().getName().equals("Andre")) {
            }
        }

        if(contextequals(e, "malthe") || contextequals(e, "Malthe") ){
            sendchannelAttachment(e, "ad");
        }

        // TODO: ACTUALLY GOOD COMMANDS ----------------------------------------------------------------------------------------------------------------
        if(contexteContains(e, ".CreateRules")) {
            if (e.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                String line = e.getMessage().getContentRaw();
                line = line.replace(".CreateRules", " ");
                sendchannelMsgWithEmote(e, line, "U+1F44D,U+1F44E");
            } else {
                sendchannelMsg(e, "You dont have the required permissions");
            }
        }

        // TODO: FUN POINTLESS
        if(contextequals(e,".sucks") || contextequals(e,".Sucks")){
            sendchannelMsgWithEmote(e,e.getMessage().getAuthor().getName() + " sucks Andre off", "U+274C,U+1F1F9,U+1F1E7");
            sendchannelMsg(e, "and "+ e.getMessage().getAuthor().getName() + " is enjoying it!");
        }
    }
}
