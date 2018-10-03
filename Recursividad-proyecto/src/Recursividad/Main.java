package Recursividad;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int[][] matriz=new int[5][5];
		int opcion=0;
		String numeroEnValidacion;
		for(int i=0;i<matriz.length;i++)
			Arrays.fill(matriz[i], i+1);
		
		while(opcion!=5)
		{
			displayMenu();
			numeroEnValidacion=scan.next();
			while(!validarNumero(numeroEnValidacion))
			{
				System.out.println("Ingrese un valor numérico");
				numeroEnValidacion=scan.nextLine();
			}
			opcion=	Integer.parseInt(numeroEnValidacion);
			switch(opcion)
			{
			case 1:
				System.out.println("Ingrese fila a sumar");
				int fila=scan.nextInt();
				while(fila>=matriz.length)
				{
					System.out.println("La fila deseada supera la capacidad de la matriz");
					fila=scan.nextInt();
				}
				System.out.println(Recursividad.sumaRenglon(matriz, fila, 0));
				break;
			case 2:
				System.out.println(Arrays.toString(Recursividad.sumaTotalRenglones(matriz,0)));
				break;
			case 3:
				Recursividad.rellenarMatriz(matriz);
				for(int i=0;i<matriz.length;i++)
					System.out.println(Arrays.toString(matriz[i]));
				break;
			case 4:
				System.out.println("Ingrese número a convertir");
				numeroEnValidacion=scan.next();
				while(!validarNumero(numeroEnValidacion))
				{
					System.out.println("Ingrese un valor numérico");
					numeroEnValidacion=scan.nextLine();
				}
				System.out.println(Recursividad.conversorATexto(numeroEnValidacion));
				break;
			}
		}
	}
	
	
	static boolean validarNumero(String numero)
	{
		for(int i=0;i<numero.length();i++)
			if(!Character.isDigit(numero.charAt(i)))
				return false;
		return true;
	}
	
	static void displayMenu()
	{
		System.out.println("Opciones");
		System.out.println("1. Sumar fila n de la matriz");
		System.out.println("2. Consultar suma fe todas las filas de la matriz");
		System.out.println("3. Rellenar matriz");
		System.out.println("4. Convertir número a texto");
		System.out.println("5. Salir");
	}

}
