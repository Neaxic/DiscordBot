import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessagesClass extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {

        if(e.getMessage().getContentRaw().equals(".KlasseLinks")){
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
        if(e.getMessage().getContentRaw().equals("Andre")){
            e.getChannel().sendMessage("Top shotta ^").queue();
        }
        if(e.getMessage().getContentRaw().equals("@Andre")){
            e.getChannel().sendMessage("Top shotta ^").queue();
        }
        if(e.getMessage().getContentRaw().equals("@Andre0420")){
            e.getChannel().sendMessage("Top shotta ^").queue();
        }
    }
}
