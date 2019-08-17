package com.example.practicas;

public class Main {
    public static void main(String[] args){
        //la palabra static permite la ejecucion si instancia

        NuevoTema("Tpos de valores");
        final short enteroCorto = 120;//Lo mayor es 32767
        int entero = 1010;
        long enteroLargo = 1292819832L;
        float decimalCorto = 25.4f;
        double decimalLargo = 23.78738923;
        char caracter = 'a';
        boolean esValido = true;
        //Cualquiera de los valores pasados, para hacerlo constante se le agrega al inicio la palabra final
        System.out.println(enteroCorto);
        System.out.println(entero);
        System.out.println(enteroLargo);
        System.out.println(decimalCorto);
        System.out.println(decimalLargo);
        System.out.println(caracter);
        System.out.println(esValido);

        NuevoTema("Operadores logicos");
//        + suma
//        - resta
//        * multiplicacion
//        / division
//        % modulo, reciduo de una division

        NuevoTema("Arreglos");
        int[] numeros = new int[]{1,2,4,5};
        String[] colores = new String[]{"rojo","negro","rosa"};
        // Se puede crear un arreglo de cualquier tipo de valores
        System.out.println(numeros[3]);
        System.out.println(colores[0]);

        NuevoTema("Ciclos y condiciones");
//        Condicion if
        if(entero<enteroCorto){
            System.out.println(entero+" es menor a "+enteroCorto);
        }
        else
            System.out.println(entero+" es mayor a "+enteroCorto);

//        Operador ternario
        System.out.println(entero < enteroCorto? "es menor" : "es mayor");//solo permite una condicion
//        Ciclo for y foreach
        for(int i=0;i<3;i++)
            System.out.println("Posicion "+i);
        for(String color:colores)//Foreach
            System.out.println(color);
//        Switch
        switch(caracter){
            case 'z':
            case 'a':
                System.out.println("10 de calificacion");
                break;
            case 'b':
                System.out.println("9 de calificacion");
                break;
            case 'c':
                System.out.println("8 de calificacion");
                break;
                default:
                    System.out.println("Reprobado");
                    break;
        }
    }

    public static void NuevoTema(String title){ //lo creamos publico para acceder a el desde otra clase
        System.out.println("\n---------------------->"+title+"<-----------------\n" );
    }
}
