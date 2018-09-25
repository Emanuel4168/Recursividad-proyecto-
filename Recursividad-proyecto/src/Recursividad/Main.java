package Recursividad;

import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		int[][] matriz=new int[3][2];
		matriz[0][0]=1;
		matriz[0][1]=1;
		matriz[1][0]=1;
		matriz[1][1]=1;
		matriz[2][0]=1;
		matriz[2][1]=1;
		//System.out.println(Recursividad.sumaRenglon(matriz, 2));
		System.out.println(Arrays.toString(Recursividad.sumaTotalRenglones(matriz,0)));
	}

}
