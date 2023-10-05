import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegularValidatorTest {
    //IP tests
    @ParameterizedTest
    @ValueSource(strings = {"127.0.0.1",
            "255.255.255.0",
            "95.245.233.185",
            "49.132.223.138",
            "171.85.163.210",
            "165.151.78.93"
    })
    public void testValidIPAddresses(String ip) {
        assertTrue(RegularValidator.IP_validate(ip));
    }
    @Test
    public void negativeNumber(){
        assertFalse(RegularValidator.IP_validate("192.168.-1.1"));
    }
    @Test
    public void exceed255(){
        assertFalse(RegularValidator.IP_validate("1300.6.7.8"));
        assertFalse(RegularValidator.IP_validate("256.256.256.256"));
    }
    @Test
    public void spaceInIP(){
        assertFalse(RegularValidator.IP_validate(" 192.168.1.1"));
        assertFalse(RegularValidator.IP_validate("192.168.1.1 "));
    }
    @Test
    public void nonNumeric(){
        assertFalse(RegularValidator.IP_validate("abc.def.gha.bcd"));
        assertFalse(RegularValidator.IP_validate("-.def.gha.bcd"));
    }
    @Test
    public void incompleteIP() {
        assertFalse(RegularValidator.IP_validate("192.168.0"));
    }
    @Test
    public void tooManyComponents() {
        assertFalse(RegularValidator.IP_validate("192.168.0.4.2"));
    }
    @Test
    public void testEmptyIPAddress() {
        assertFalse(RegularValidator.IP_validate(""));
    }
    //GUID TESTS
    @ParameterizedTest
    @ValueSource(strings = { "e02fd0e4-00fd-090A-ca30-0d00a0038ba0",
            "D7F1A17E-A38F-4676-8B73-9EC3435D83D8",
            "{D7F1A17E-A38F-4676-8B73-9EC3435D83D8}",
            "9b95eab6-0164-45e7-8E2F-7A6A412F3DEA",
            "9b95eab6-0164-45e7-8E2F-7A6A412F3DEA"})
    public void correctGUID(String guid){
        assertTrue(RegularValidator.GUID_validate(guid));
    }
    @ParameterizedTest
    @ValueSource(strings= {"e02fd0e400fd090Aca300d00a0038ba0",
            "{D7F1A17EA38F46768B739EC3435D83D8}",
            "e02f0e4-00Yd-090A-ca30-0d00Z0038ba0",
            "e02fd0e4-00d-090A-ca30-0d00a0038ba0", //8-3-4-4-12
            "e02fd0e4-00fd-0490A-ca30-0d00a0038ba0", //8-4-4-4-12
            "e02fd0e4-00fd-090A-ca30-04d00a0038ba0" //8-4-4-4-13
    })
    public void incorrectFormat(String guid){
        assertFalse(RegularValidator.GUID_validate(guid));
    }

    //URL TESTS
    @ParameterizedTest
    @ValueSource(strings= {"www.google.com",
            "https://example.com/#section",
            "http://example.com:8080",
            "https://www.goo-gle.com/search?q=URL+example",
            "http://sub.sub.example.com:8000/path/to/page?param1=value1&param2=value2#section"
    })
    public void correctURL(String ip){
        assertTrue(RegularValidator.URL_validate(ip));
    }
    @Test
    public  void  IpAdress(){
        assertFalse(RegularValidator.URL_validate("123.45.67.89")); }
    @Test
    public void oneCharURL(){
        assertFalse(RegularValidator.URL_validate("http://a.com"));
    }
    @Test
    public void anothertext()
    {
        assertFalse(RegularValidator.URL_validate("Just Text"));
    }
    @Test
    public void spaceAndUnderLineInUrl()
    {
        assertFalse(RegularValidator.URL_validate("www.good job.com"));
        assertFalse(RegularValidator.URL_validate("www.good_job.com"));
    }
    @Test
    public void dashBeginEnd()
    {
        assertFalse(RegularValidator.URL_validate("www.-badwork.com"));
        assertFalse(RegularValidator.URL_validate("www.badwork-.com"));
    }
    //PASSWORD TESTS
    @Test
    public void correctPass(){
        assertTrue(RegularValidator.Pass_validate("C00l_Pass"));
        assertTrue(RegularValidator.Pass_validate("SupperPas1"));
    }
    @Test
    public void incorrectPass(){
        assertFalse(RegularValidator.Pass_validate("Cool_pass"));
        assertFalse(RegularValidator.Pass_validate("C00l"));
    }
}