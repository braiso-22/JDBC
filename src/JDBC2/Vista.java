/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Brais
 */
public class Vista {

    public Scanner teclado;

    public int mostrarMenu() {
        teclado = new Scanner(System.in);
        System.out.println("selecciona una opcion:");
        System.out.println("01.) Mostrar empleados");
        System.out.println("02.) Mostrar departamentos");
        //System.out.println("2.) Subirle el sueldo a los empleados");
        System.out.println("03.) Mostrar familiares");
        System.out.println("04.) Mostrar proyectos");
        System.out.println("05.) Buscar empleados por atributo");
        System.out.println("06.) Buscar empleados contratados después de la fecha indicada");
        System.out.println("07.) Mostrar los familiares");
        System.out.println("08.) Buscar todos los familiares de un empleado");
        System.out.println("09.) Buscar empleados por departamento y salario mayor que el introducido");
        System.out.println("10.) Invertir mayusculas en empleados");
        System.out.println("11.) Aumentar comisiones de jefes");
        System.out.println("12.) Crear vistas por tipo de empleado");
        System.out.println("13.) Mostrar numero de jefes");
        System.out.println("14.) Buscar empleado por numero de empleado");
        System.out.println("15.) Insertar por batch empleados");
        System.out.println("0.) Salir");
        int opcion;
        try {
            opcion = teclado.nextInt();
            teclado.nextLine();
        } catch (InputMismatchException ime) {
            opcion = -1;
            System.out.println("Entrada de datos incorrecta");
        }
        return opcion;
    }

    public boolean showMessage(String message) {
        System.out.println(message);
        return true;
    }

    public String showMessageString(String message) {
        System.out.println(message);
        return teclado.nextLine();
    }

    public int showMessageInt(String message) {
        try {
            System.out.println(message);
            int num = teclado.nextInt();
            teclado.nextLine();
            return num;
        } catch (InputMismatchException ime) {

            System.out.println(ime.getMessage());
        }
        return -1;
    }

    public float showMessageFloat(String message) {
        System.out.println(message);
        float num = teclado.nextFloat();
        teclado.nextLine();
        return num;
    }

}
