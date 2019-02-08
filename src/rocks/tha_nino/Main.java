package rocks.tha_nino;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        TailerListener listener = new ShovelTailer();

        File file = new File(<PATH_TO_SERVER_LOG>); // INSERT HERE

        Tailer tailer = new Tailer(file, listener, 200);

        Thread thread = new Thread(tailer);

        thread.setDaemon(false);

        thread.start();

        try {
            System.in.read();
        } catch (Exception e) {

        }
    }
}
