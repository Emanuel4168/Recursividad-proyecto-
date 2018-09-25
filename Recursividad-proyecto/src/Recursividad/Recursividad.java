package Recursividad;

public class Recursividad 
{
	private static int posicionMatriz=-1;
	private static int[] sumasPorRenglon;
	
	
	public static int sumaRenglon(int[][] matriz,int renglon)
	{
		posicionMatriz+=1;
		if(posicionMatriz==matriz[renglon].length-1)
		{
			int ultimoElemento=matriz[renglon][posicionMatriz];
			posicionMatriz=-1;
			return ultimoElemento;
		}
		return matriz[renglon][posicionMatriz]+sumaRenglon(matriz,renglon);
	}
	
	
	
	public static int[] sumaTotalRenglones(int[][] matriz,int renglon)
	{
		if(renglon==0)
			sumasPorRenglon=new int[matriz.length];
		sumasPorRenglon[renglon]= sumaRenglon(matriz, renglon);
		if(renglon==matriz.length-1)
			return sumasPorRenglon;
		return sumaTotalRenglones(matriz,renglon+1);
	}
	
	
	
	public static int[][] rellenarMatriz(int fila,int columna,int[][] matriz)
	{
		if(fila==columna)
			matriz[fila][columna]=1;
		else if(fila+columna==matriz.length-1)
			matriz[fila][columna]=2;
		else if(fila>columna && fila+columna<matriz.length-1)
			matriz[fila][columna]=3;
		else if(fila<columna && fila+columna<matriz.length-1)
			matriz[fila][columna]=4;
		else if(columna-fila<0)
			matriz[fila][columna]=5;
		else if(columna-fila>0)
			matriz[fila][columna]=6;
		if(fila==matriz.length-1 && columna==matriz[matriz.length-1].length-1)
			return matriz;
		if(columna==matriz[fila].length-1)
			return rellenarMatriz(fila+1,0,matriz);
		else
			return rellenarMatriz(fila,columna+1,matriz);
	}
	
	
}
