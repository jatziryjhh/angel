package utez.edu.mx.unidad3.utils;
/*
@Configuration:le dice a spring que esta clase de Java va a generar una
configuración durante la ejecución de la aplicación;pero esta anotación
debe siempre ir con un metodo con la anotación @Bean que le diga que va
a configurar

@Bean:le indice a spring el metodo que retonara dicha configuración
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConnection {
    //esto es igual a private final String DB_URL="url....";
    @Value("${db.url}")
    private String DB_URL;
    @Value("${db.username}")
    private String DB_USERNAME;
    @Value("${db.password}")
    private String DB_PASSWORD;

    @Bean
    public DataSource getConnection(){
        try{
            DriverManagerDataSource configuration=new DriverManagerDataSource();
            configuration.setUrl(DB_URL);
            configuration.setUsername(DB_USERNAME);
            configuration.setPassword(DB_PASSWORD);
            /*
            1.-Como si fuera página: com.mysql
            2.- GTA SA: cj
            3.- Protocolo de base de datos: jdbc
            4-- Clase: Driver
             */
            configuration.setDriverClassName("com.mysql.cj.jdbc.Driver");
            return configuration;
        }catch (Exception ex){
            System.out.println("Error al conectar a la BD");
            ex.printStackTrace();
            return null;
        }
    }
}
