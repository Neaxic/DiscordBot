import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

public class MessagesClass extends ListenerAdapter {

    private String rulesID = "";

    // TODO: SMART METHODS HERE -----------------------------------------------------------------------------------------------------------------------

    public String contextRaw(MessageReceivedEvent e){
        return e.getMessage().getContentRaw();
    }

    public boolean contextequals(MessageReceivedEvent e, String str){
        return e.getMessage().getContentRaw().equals(str);
    }

    public boolean contextContains(MessageReceivedEvent e, String str){
        return e.getMessage().getContentRaw().contains(str);
    }

    public void sendchannelMsg(MessageReceivedEvent e, String msg){
        e.getChannel().sendMessage(msg).queue();
    }

    public void sendchannelMsgWithEmote(MessageReceivedEvent e, String msg, String unicode){
        if(unicode.contains(",")){
            String[] UnicodeArr = unicode.split(",",10);
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
        //e.getReaction().getMessageId().equals()
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(!e.getMessage().getAuthor().isBot()){
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

            if(contextContains(e, ".malthe") || contextContains(e, ".Malthe")){
                sendchannelMsgWithEmote(e, "OVERVEJ AT HEDDE MALTHE AHJAHAHAHA", "U+1F602,U+1F92E,U+274C,U+1F913,U+1F4A9,U+1F44E");
                //sendchannelAttachment(e, "ad");
            }

            if(contextequals(e, "queenbot") || contextequals(e, "QueenBot") ){
                sendchannelMsgWithEmote(e,"Fucking overvej at opkalde en bot queen... AHAHAHA", "U+1F92E");
            }

            if(contextContains(e, ".line") || contextContains(e, ".Line") ){
                int num = (int) Math.round(Math.random()*5);
                System.out.println(num);

                switch (num){
                    case 0:
                        sendchannelMsg(e,"you are lucky today Line");
                        break;
                    case 1:
                        sendchannelMsgWithEmote(e, "Are your name trigonometry because i have no intrest in doing you", "U+274C,U+1F9E2");
                        break;
                    case 2:
                        sendchannelMsgWithEmote(e, "Are you the sun? Because id rather have you stay 92955807 miles away from me", "U+274C,U+1F9E2");
                        break;
                    case 3:
                        sendchannelMsgWithEmote(e, "Are you a pinyata bc i need a blindfold before hitting that", "U+274C,U+1F9E2");
                        break;
                    case 4:
                        sendchannelMsgWithEmote(e, "Are you a newspaper? Cause theres a new fucking issue with you everyday", "U+274C,U+1F9E2");
                        break;
                    case 5:
                        sendchannelMsgWithEmote(e, "Do you want something warm and wet around you? Cause I really think you could use a shower.", "U+274C,U+1F9E2");
                        break;
                }
            }

            // TODO: ACTUALLY GOOD COMMANDS ----------------------------------------------------------------------------------------------------------------
            if(contextContains(e, ".CreateRules")) {
                sendchannelMsgWithEmote(e, "You are about to create a new ruleset, do you wish to continue?", "U+1F44D,U+1F44E");

                sendchannelMsg(e, "Set title: ");
                if (e.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                    String line = e.getMessage().getContentRaw();
                    line = line.replace(".CreateRules", " ");
                    sendchannelMsgWithEmote(e, line, "U+1F44D,U+1F44E");

                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle("");
                    embedBuilder.addField("SDJ","https://viadk.zoom.us/j/4059985796?pwd=SzVyNkhnMytVa3FzK3VNMGh6amxQdz09",false);
                    embedBuilder.addField("SWE","https://viadk.zoom.us/j/3380114758?pwd=VkUvazkxdTdtdVVVejdNWTVvQUpLUT09",false);
                    embedBuilder.addField("DBS","https://applications.zoom.us/lti/rich",false);
                    embedBuilder.addField("SEP","https://viadk.zoom.us/j/4059985796?pwd=SzVyNkhnMytVa3FzK3VNMGh6amxQdz09",false);
                    embedBuilder.setColor(0xa83232);

                    e.getChannel().sendMessage(embedBuilder.build()).queue();
                    embedBuilder.clear();



                } else {
                    sendchannelMsg(e, "You dont have the required permissions");
                }
            }

        /*public void rulesSetup(){
            sendchannelMsg(e, "Set title: ");
            String rulesTitle = e.getMessage().getContentRaw();
        }*/






            // TODO: FUN POINTLESS
            if(contextequals(e,".sucks") || contextequals(e,".Sucks")){
                sendchannelMsg(e, e.getMessage().getAuthor().getName() + " sucks Andre off");
                sendchannelMsgWithEmote(e, "and "+ e.getMessage().getAuthor().getName() + " is enjoying it!", "U+274C,U+1F9E2");
            }
        }

    }
}
