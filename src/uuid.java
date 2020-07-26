import java.math.BigInteger;
import java.util.UUID;

public class uuid {

    public static void main(String[] args) {
        String s = "43b6f08a4b2942b686580b25899559aa";
        String s2 = s.replace("-", "");
        UUID uuid = new UUID(
                new BigInteger(s2.substring(0, 16), 16).longValue(),
                new BigInteger(s2.substring(16), 16).longValue());
        System.out.println(uuid);
    }
}
