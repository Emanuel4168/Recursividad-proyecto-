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
	
	
	
	
	
	
}
