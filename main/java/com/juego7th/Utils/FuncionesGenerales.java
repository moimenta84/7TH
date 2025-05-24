package com.juego7th.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public
class FuncionesGenerales {

    public static
    int scanerNum() {
        Scanner scan = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Solo número enteros");
            }
        }
        return num;
    }

    public static
    double scanerDouble() {
        Scanner scan = new Scanner(System.in);
        double num;
        while (true) {
            try {

                num = scan.nextDouble();
                break;

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("solo numero entero");
            }
        }
        return num;
    }

    public static
    String scanerString() {
        Scanner scan = new Scanner(System.in);
        String string;
        while (true) {
            string = scan.nextLine();
            if (!string.equals("")) {

                break;
            } else {
                System.out.println("no puede dejar la entrada vacia");
            }
        }
        return string;
    }
    //El PROBLEMA ESTABA EN QUE NO ESTABA ASUMIENDO QUE LO QUE METE EL USUARIO ES UNA CADENA NO UN BOOOLEANO//
    public static boolean scanerBoolean() {
        Scanner scan = new Scanner(System.in);
        String  bool;
        while (true) {
            try{
                bool = scan.nextLine();
                if (bool.equals("true") || bool.equals("false")) {
                    break;
                }else{
                    System.out.println("Meta un dato booleano, vuelva a intentarlo ");
                }
            }catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("entrada no valida");
            }
        }
        return true;
    }



}
