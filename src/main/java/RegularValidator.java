import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegularValidator {
    private static final String IP_pattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
            "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
            "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
            "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final String GUID_pattern = "^\\{?[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-?[0-9a-fA-F]{12}}?$";
    private static final String URL_pattern = "^(https?://)?(?:www\\.)?(?!\\d)(?!.*\\.)[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$";
    public static final String Pass_pattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).?\\w{8,}$";
    public  static Boolean IP_validate(String ipAdress){
        Pattern pattern = Pattern.compile(IP_pattern);
        Matcher matcher = pattern.matcher(ipAdress);
        return matcher.matches();
    }
    public  static Boolean GUID_validate(String GUID){
        Pattern pattern = Pattern.compile(GUID_pattern);
        Matcher matcher = pattern.matcher(GUID);
        return matcher.matches();
    }
    public  static Boolean URL_validate(String URL){
        Pattern pattern = Pattern.compile(URL_pattern);
        Matcher matcher = pattern.matcher(URL);
        return matcher.matches();
    }
    public  static Boolean Pass_validate(String Pass){
        Pattern pattern = Pattern.compile(Pass_pattern);
        Matcher matcher = pattern.matcher(Pass);
        return matcher.matches();
    }
}
