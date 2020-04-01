import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

/**
 * Created by Administrator on 2020-4-1.
 */
public class ParseJWTTest {

    public static void main(String[] args) {
        Claims zhymgc = Jwts.parser().setSigningKey("zhymgc")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiJ6aGFuZ2hhbyIsImlhdCI6MTU4NTc1MzQ1M30.B7eqhIbofraHd1LfLzSedus3yvn9Z-xjjwhKojhImkU")
                .getBody();
        System.out.println(zhymgc.getId());
        System.out.println(zhymgc.getSubject());
        System.out.println(zhymgc.getIssuedAt());
    }
}
