package Recursividad;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		//int[][] matriz=new int[2][2];
		//System.out.println(Recursividad.sumaRenglon(matriz, 2));
		//System.out.println(Arrays.toString(Recursividad.sumaTotalRenglones(matriz,0)));
		//Recursividad.rellenarMatriz(matriz);
		//for(int i=0;i<matriz.length;i++)
			//System.out.println(Arrays.toString(matriz[i]));
		//System.out.println(Recursividad.conversorATexto("102"));
		//System.out.println(validarClave("123A"));
		int opcion=0;
		while(opcion!=5)
		{
			try
			{
				opcion=scan.nextInt();
			}
			catch(InputMismatchException err)
			{
				System.out.println("por favor ingrese una opción numérica");
				opcion=scan.nextInt();
			}
		}
	}
	
	
	static boolean validarClave(String clave)
	{
		for(int i=0;i<clave.length();i++)
			if(!Character.isDigit(clave.charAt(i)))
				return false;
		return true;
	}

}
