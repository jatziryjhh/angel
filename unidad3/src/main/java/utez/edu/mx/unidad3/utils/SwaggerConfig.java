package utez.edu.mx.unidad3.utils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //una notacion configuracion se necesita un bean,pero para swagger es una notacion especifica para //configurar la documentacion de la api
    @Bean
    public OpenAPI config() {
        return new OpenAPI().info(new Info()
                .title("API REST de almacenes")
                .description("Documentación de los endpoints del servicio de almacenes")
                .version("V1.0")

        );
    }
}



