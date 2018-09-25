package Recursividad;

import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		int[][] matriz=new int[4][4];
		//System.out.println(Recursividad.sumaRenglon(matriz, 2));
		//System.out.println(Arrays.toString(Recursividad.sumaTotalRenglones(matriz,0)));
		matriz=Recursividad.rellenarMatriz(0, 0, matriz);
		for(int i=0;i<matriz.length;i++)
			System.out.println(Arrays.toString(matriz[i]));
	}

}
