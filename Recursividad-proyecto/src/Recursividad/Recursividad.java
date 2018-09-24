package Recursividad;

public class Recursividad 
{
	private static int posicionMatriz=-1;
	
	public static int sumaRenglon(int[][] matriz,int renglon)
	{
		posicionMatriz+=1;
		if(posicionMatriz==matriz[renglon].length-1)
		{
			int ultimoElemento=matriz[renglon][posicionMatriz];
			posicionMatriz++;
			return ultimoElemento;
		}
		return matriz[renglon][posicionMatriz]+sumaRenglon(matriz,renglon);
	}
}
