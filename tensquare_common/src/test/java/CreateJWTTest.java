import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Created by Administrator on 2020-4-1.
 */
public class CreateJWTTest {

    public static void main(String[] args) {
        JwtBuilder builder = Jwts.builder().setId("111").setSubject("zhanghao").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "zhymgc");
        System.out.println(builder.compact());
    }
}
