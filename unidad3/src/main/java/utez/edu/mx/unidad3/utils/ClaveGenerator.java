package utez.edu.mx.unidad3.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class ClaveGenerator {
    public static String generateCedeClave(Long idCede){
        SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy",new Locale("es-MX"));
        String formatedDate=sdf.format(new Date());
        String randomNumber=String.format("%04d", ThreadLocalRandom.current().nextInt(1,10000));
        return "C"+idCede+"-"+formatedDate+"-"+randomNumber;
    }

    public static void main(String[] args) {
        System.out.println(ClaveGenerator.generateCedeClave(1L));
    }

    public static String generateWarehouseClave(String cedeClave,Long idWarehouse){
        return null;
    }
}
