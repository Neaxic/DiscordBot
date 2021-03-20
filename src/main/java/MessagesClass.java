import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessagesClass extends ListenerAdapter {

    public String contextRaw(MessageReceivedEvent e){
        return e.getMessage().getContentRaw();
    }

    public void sendchannelMsg(MessageReceivedEvent e, String msg){
        e.getChannel().sendMessage(msg).queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {

        if(e.getMessage().getContentRaw().equals(".info")){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("BOT STATUS:");
            embedBuilder.addField("COMMANDS: ","YES",false);
            embedBuilder.addField("DATABASE: ","NO",false);
            embedBuilder.addField("HOTEL: ","TRIVAGO",false);
            embedBuilder.setColor(0xa83232);

            e.getChannel().sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }

        if(contextRaw(e).equals(".KlasseLinks")){
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
        if(contextRaw(e).equals("Andre")){
            sendchannelMsg(e,"Top shotta ^");
        }
        if(e.getMessage().getContentRaw().equals(".sut")){
            e.getChannel().sendMessage(e.getMessage().getAuthor().getName() + " Sutter @las af" ).queue();
        }
        if(contextRaw(e).equals(".sucks") || e.getMessage().getContentRaw().equals(".sucks")){
            sendchannelMsg(e,e.getMessage().getAuthor().getName() + " sucks Andre off");
            sendchannelMsg(e, "and "+ e.getMessage().getAuthor().getName() + " is enjoying it!");
        }
        if(contextRaw(e).equals("Andre is gay")){
            sendchannelMsg(e,"You are wrong!");
            e.getMember().modifyNickname(e.getAuthor().getName() + "is gay");
            e.getMember().kick();
        }
        if(contextRaw(e).equals(".adminGuden")) {
            if (e.getMessage().getAuthor().getName().equals("Andre")) {
            }
        }
    }
}
