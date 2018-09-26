package Recursividad;

public class Recursividad 
{
	private static int posicionRenglon=-1;
	private static int[] sumasPorRenglon;
	
	private final static String[] UNIDADES = {"","un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final static String[] DECENAS = {"","diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
	        "diecisiete ", "dieciocho ", "diecinueve", "veintiuno ","veintidos ","veintitres ","veinticuatro ","veinticinco ",
	        "veintiseis ","veintisiete ", "veintiocho ","veintinueve ","treinta ", "cuarenta ",
	        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
	private final static String[] CENTENAS = {"ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
	        "setecientos ", "ochocientos ", "novecientos "};
	
	
	
	
	public static int sumaRenglon(int[][] matriz,int renglon)
	{
		posicionRenglon+=1;
		if(posicionRenglon==matriz[renglon].length-1)
		{
			int ultimoElemento=matriz[renglon][posicionRenglon];
			posicionRenglon=-1;
			return ultimoElemento;
		}
		return matriz[renglon][posicionRenglon]+sumaRenglon(matriz,renglon);
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
	
	public static String conversorATexto(String numero)
	{
		while(numero.length()%3!=0)
			numero="0"+numero;
		if(numero.length()==3)
		{
			if(Integer.parseInt(numero)==10)
				return "diez";
			if(Integer.parseInt(numero)<10)
				return UNIDADES[Integer.parseInt(numero)];
			if(Integer.parseInt(numero)<100)	
				return getDecenas(numero);
			if(Integer.parseInt(numero)<1000);
			    return CENTENAS[Integer.parseInt(numero.substring(0,1))-1]+getDecenas(numero.substring(1,3));
		}
		if(Integer.parseInt(numero)<1000000)
			return conversorATexto(numero.substring(0,3))+" mil "+conversorATexto(numero.substring(3,6));
		return "";
	}
	
	
	
	private static String getDecenas(String numero)
	{
		if(Integer.parseInt(numero)==20)
			return "veinte";
		if(Integer.parseInt(numero)<30)
			return DECENAS[Integer.parseInt(numero)-9];
		if(Integer.parseInt(numero)==100)
			return "cien";
		return DECENAS[Integer.parseInt(numero.substring(0,1))+17]+" y "+UNIDADES[Integer.parseInt(numero.substring(1))];
	}
}
