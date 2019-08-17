package com.example.practicas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Un POJO (Plain Old Java Object)es un termino utilizado por programadores Java para enfatizar
//        el uso de clases simples y que no dependen de un framework en especial.
public class POO {
    public static void main(String[] args){
        Casa miCasa = new Casa("independencia" ,'a',(short) 9,100000,
                978307200000L,3.5f,20333.32,true);
        // para la fecha buscamos en google date to long online,
        // https://www.fileformat.info/tip/java/date2millis.htm y escogemos la fecha
        // aqui nos arrojara el valor en long
        System.out.println(miCasa);

        Casa tuCasa = new Casa("lopez mateos",'a',(short) 190);
        System.out.println(tuCasa);

        Casa deNadie = new Casa();
        System.out.println(deNadie);

        Main.NuevoTema("Listas");
        // Arreglos de objetos
        List<Casa> casasList = new ArrayList<>();
        casasList.add(miCasa);
        casasList.add(tuCasa);
        casasList.add(deNadie);

        casasList.remove(1);
        casasList.set(1, miCasa);

        for(Casa actual: casasList)
            System.out.println(actual);

        Main.NuevoTema("Diccionarios");
        //Arreglos de objetos con clave
        Map<String, Casa> casaMap = new HashMap<>();
        casaMap.put("juan", miCasa);
        casaMap.put("luis", tuCasa);
        casaMap.put("nadie", deNadie);

        System.out.println(casaMap.size());
        casaMap.remove("nadie");
        System.out.println(casaMap.size());
//        aqui no nos referimos a posiciones

        System.out.println(casaMap.get("nadie"));

    Main.NuevoTema("Herencia");
    Apartamento miDepartamento = new Apartamento("independencia" ,'a',(short) 9,
            100000,	978307200000L,3.5f,20333.32,
            false,(short) 26);
    System.out.println(miDepartamento);

    Main.NuevoTema("Polimorfismo");
    // Gracias al polimorfismo se puede usar un mismo metodo varios tipos de objetos(igual gracias
        // a la herencia)
    VenderPropiedad(miCasa);
    VenderPropiedad(miDepartamento);

    Casa tuApartamento = new Apartamento("independencia" ,'a',(short) 9,
            100000,	978307200000L,3.5f,20333.32,
            false,(short) 26);
    VenderPropiedad(tuApartamento);

    Casa casaNueva = new Casa();
    casaNueva.setCalle("Mateo");
    System.out.println(casaNueva);

    Main.NuevoTema("Equals y hashCode");
        Casa miCasa2 = new Casa("independencia" ,'a',(short) 9,100000,
                978307200000L,3.5f,20333.32,true);
        Casa miCasa3 = new Casa("independencia2" ,'a',(short) 91,1000004,
                9783072000005L,3.55f,2033333.32,false);
        System.out.println(miCasa.equals(miCasa2));//son iguales
        System.out.println(miCasa.equals(miCasa3));//no son iguales
        System.out.println(miCasa.hashCode());//regresa un numero
        System.out.println(miCasa2.hashCode());
        System.out.println(casaMap.containsValue(miCasa2)); //funciona igualmente en un diccionario
    }

    private static void VenderPropiedad(Casa casa) {
        if(casa.isHipotecada())
            System.out.println("No puedes ver la casa");
        else
            System.out.println("Puedes vender la casa");
    }
}
