package rocks.tha_nino;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameFinder {

    public static String getName(String logMessage) {

        Pattern pattern = Pattern.compile("\\w*+ (?=issued)");

        Matcher matcher = pattern.matcher(logMessage);

        matcher.find();

        return matcher.group(0).trim();
    }
}
