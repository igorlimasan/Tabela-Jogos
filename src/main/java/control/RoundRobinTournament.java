package control;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.taglibs.standard.lang.jstl.ArraySuffix;

import model.Time;
import model.TimeDAO;

public class RoundRobinTournament {
	public String[][] tournament(StringBuilder nomeTimes) {
		String res1="";
		String[][] res;
		
		 
		if(nomeTimes.toString().trim().split("\\s+").length%2 == 1){
			nomeTimes.append(" ");
			nomeTimes.append("Fake");
			
		}
		String[] times = nomeTimes.toString().trim().split("\\s+");	
		System.out.println(Arrays.toString(times));
		
		
		String[][] escala = new String[times.length/2][times.length/2];
		escala[0] = Arrays.copyOfRange(times, 0, times.length/2);
		escala[1] = Arrays.copyOfRange(times, times.length/2, times.length);
		List<String> rs = Arrays.asList(escala[1]);
		escala[1] = reverseAll(escala[1]);
		System.out.println("Rodada 1");
		formatarJogos(escala[0], escala[1]);
		res = new String[times.length-1][times.length];
		res[0] = ArrayUtils.addAll(escala[0], escala[1]);
		System.out.println("Concat array "+Arrays.toString(res));
		
		System.out.println("\n");
		String[] auxArray = Arrays.copyOfRange(times, 1, times.length);
		String aux="";
		
		for(int i = 0;i < times.length-2;i++)
		{
			System.out.println("Rodada "+(i+2));
			auxArray = circular(auxArray);
			res1=escala[0][0];
			escala[0] = null;
			escala[0] = new String[times.length/2];
			escala[0][0] = res1;
			escala[0] = completeArray(escala[0],Arrays.copyOfRange(auxArray, 0, (times.length/2)-1),times.length/2);
			escala[1] = reverseAll(Arrays.copyOfRange(auxArray, 3, auxArray.length));
			res[i+1] = ArrayUtils.addAll(escala[0], escala[1]);
			System.out.println(Arrays.toString(res));
			formatarJogos(escala[0], escala[1]);
			
			
		}
		
		return res;
		
		
	}
	
	
	public static String[] reverseAll(String[] values)
	{
		List<String> rs = Arrays.asList(values);
		Collections.reverse(rs);
		return rs.toArray(values);
	}
	
	public static void formatarJogos(String[] times1,String[] times2)
	{
		for(int i = 0; i<times1.length;i++)
		{
			System.out.println(times1[i] + " X " + times2[i]);
		}
	}
	public static String[] circular(String[] array){
	    String[] result = new String[array.length];
	    int j=0;
	    int i=array.length-2;
	    while(j < array.length){
	    	i++;
	    	result[j]=array[i%array.length];
	    	j++;
	    	
	    }
	    
	    
	    return result;


	    
	}
	
	public static String[] completeArray(String[]array,String[] array2,int length){
		
		int j = 0;
		for(int i = 1; i < length ; i++){
			array[i]= array2[j];
			j++;
			
			
		}
			
		return array;
	}
}
