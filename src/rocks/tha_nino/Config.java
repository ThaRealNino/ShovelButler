package rocks.tha_nino;

public class Config {

    public static String logFile = ""; // path to logfile. E.g.: /home/minecraft/log.txt
    public static String command = "gimmeShovel"; // command to give a shovel
    public static String rconServer = "localhost"; // minecraft server address. Default localhost
    public static int rconPort = 25575; // rcon port. Default 25575
    public static String rconPassword = ""; // rcon password
    public static int delay = 5; // delay until you can request next shovel in seconds. May not be null

}
