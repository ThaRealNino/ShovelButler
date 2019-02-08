package rocks.tha_nino;

import org.apache.commons.io.input.TailerListenerAdapter;
import net.kronos.rkon.core.Rcon;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ShovelTailer extends TailerListenerAdapter {

    private List<String> playerList = new ArrayList<String>();
    private Timer timer = new Timer();

    public ShovelTailer() {

        timer.schedule( new TimerTask() {
            public void run() {
                playerList.clear();
            }
        }, 0, 60*1000*Config.delay);
    }


    public void handle(String line) {

        if(line.contains("issued server command: /" + Config.command)) {

            String name = NameFinder.getName(line);

            if(playerList.contains(name)) {
                dontGiveShovel(name);
            } else {
                giveShovel(name);
                playerList.add(name);
            }

        }
    }

    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    public void dontGiveShovel(String name) {
        try {
            Rcon rcon = new Rcon(Config.rconServer, Config.rconPort, Config.rconPassword.getBytes());
            rcon.command("msg " + name + " Nicht so gierig!");
            rcon.disconnect();

        } catch (Exception e) {

        }
    }

    public void giveShovel(String name) {
        try {
            Rcon rcon = new Rcon(Config.rconServer, Config.rconPort, Config.rconPassword.getBytes());
            rcon.command("give " + name + " minecraft:golden_shovel");
            rcon.disconnect();

        } catch (Exception e) {

        }
    }
}
