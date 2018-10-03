package Recursividad;

public class Recursividad 
{
	private static int[] sumasPorRenglon;
	
	private final static String[] UNIDADES = {"","un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve ","diez ", "once ", "doce ", "trece ",
			"catorce ", "quince ", "dieciseis ","diecisiete ", "dieciocho ", "diecinueve", "veinte ","veintiuno ","veintidos ","veintitres ","veinticuatro ","veinticinco ",
	        "veintiseis ","veintisiete ", "veintiocho ","veintinueve "};
    private final static String[] DECENAS = {"","treinta ", "cuarenta ","cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
	private final static String[] CENTENAS = {"ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
	        "setecientos ", "ochocientos ", "novecientos "};
	
	
	
	
	public static int sumaRenglon(int[][] matriz,int renglon,int posicionRenglon)
	{
		if(posicionRenglon==matriz[renglon].length-1)
			return matriz[renglon][posicionRenglon];
		return matriz[renglon][posicionRenglon]+sumaRenglon(matriz,renglon,posicionRenglon+1);
	}
	
	
	
	public static int[] sumaTotalRenglones(int[][] matriz,int renglon)
	{
		if(renglon==0)
			sumasPorRenglon=new int[matriz.length];
		sumasPorRenglon[renglon]= sumaRenglon(matriz, renglon,0);
		if(renglon==matriz.length-1)
			return sumasPorRenglon;
		return sumaTotalRenglones(matriz,renglon+1);
	}
	
	
	
	public static void rellenarMatriz(int[][] matriz)
	{
		recorrerFila(0,0,matriz);
	}
	
	public static String conversorATexto(String numero)
	{
		while(numero.length()%3!=0)
			numero="0"+numero;
		if(numero.length()==3)
		{
			if(Integer.parseInt(numero)<30)
				return UNIDADES[Integer.parseInt(numero)];
			if (Integer.parseInt(numero)<100)
				return DECENAS[Integer.parseInt(numero.substring(1,2))-2]+" y "+UNIDADES[Integer.parseInt(numero.substring(2))];
			if(Integer.parseInt(numero)==100)
				return "cien";
			if(Integer.parseInt(numero)<1000);
			    return (numero.charAt(1)=='0')?CENTENAS[Integer.parseInt(numero.substring(0,1))-1]+UNIDADES[Integer.parseInt(numero.substring(1))]:
			    	CENTENAS[Integer.parseInt(numero.substring(0,1))-1]+DECENAS[Integer.parseInt(numero.substring(1,2))-2]+" y "+UNIDADES[Integer.parseInt(numero.substring(2))];
		}
		if(Integer.parseInt(numero)<1000000 && Integer.parseInt(numero)>0)
			return conversorATexto(numero.substring(0,3))+" mil "+conversorATexto(numero.substring(3));
		else if(Integer.parseInt(numero)<2000000 && numero.charAt(2)=='1')
			return conversorATexto(numero.substring(0,3))+" millon "+conversorATexto(numero.substring(3));
		else if(Integer.parseInt(numero)>0)
			return conversorATexto(numero.substring(0,3))+" millones "+conversorATexto(numero.substring(3));
		return "";
	}
	
	
	//Métodos auxiliares	
	private static void recorrerFila(int fila,int columna,int[][] matriz)
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
		
		if(fila==matriz.length-1)
			recorrerColumna(fila,columna,matriz);
		else
			recorrerFila(fila+1,columna,matriz);
		if(fila!=matriz.length-1 && columna!=matriz[matriz.length-1].length-1)
			return;
	}
	
	
	private static void recorrerColumna(int fila,int columna,int[][] matriz)
	{
		if(columna!=matriz[matriz.length-1].length-1)
			recorrerFila(0,columna+1,matriz);
	}
	

}
