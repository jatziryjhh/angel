package utez.edu.mx.unidad3.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

//4 paso: generar las utilerias para jwt
@Service
public class JWTUtils {
    @Value("${secret.key}")
    private String SECRET_KEY;

    //Este función ayuda a extraer todas las propiedades del token
    //es decir, el cuerpo del token
    public Claims exctractAllClaims(String token) {
        return Jwts.parser()//esto es para descencriptar el token
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    //Esta funcion nos ayuda a poder extraer las propiedades del token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims CLAIMS = exctractAllClaims(token);
        return claimsResolver.apply(CLAIMS);
    }

    //Esta función extrae el nombre de usuario del token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //Esta funcion extrae la fecha de expiracion
    public Date extractExpirationDate(String token){
        return extractClaim(token, Claims::getExpiration);
    }
}

