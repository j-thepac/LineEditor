import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.google.common.base.Strings;

public class TextClass {
	
	//sBuff_Main = Original Text
	//sBuff_Temp = Curent text 
	
	private StringBuffer sBuff_Main,sBuff_Temp;
	
	TextClass(){
		sBuff_Main=new StringBuffer();
	}
	
	String get_OriginalString(){
		return sBuff_Main.toString();
	}
	
	void set_CurrentString(String str){
		sBuff_Temp= new StringBuffer(str);
		if (sBuff_Main.length()==0)
			sBuff_Main.append(str);
	}
	
	String break_line(String break_string){
		String sTemp=sBuff_Temp.toString();
		sTemp=sTemp.replace(break_string, break_string+"\n");
		sTemp=sTemp.replace("\n\n", "\n");
		sTemp=sTemp.replace("\n\n\n", "\n");
		sBuff_Temp.delete(0, sBuff_Temp.length());
		
		String[] sArray= sTemp.split("\n");
	
		for(int i=0 ;i<=sArray.length-1;i++){
			if(sArray[i].charAt(0)!='\r' && sArray[i].contentEquals(".")==false ){
				sArray[i]=sArray[i].trim();
				sBuff_Temp.append(sArray[i]+"\n");
			}
		}
		return sBuff_Temp.toString();		
	}
	
	
	String add_Linenumber(){

		String[] sArray=sBuff_Temp.toString().split("\n");
		sBuff_Temp.delete(0, sBuff_Temp.length());
		
		for(int i=0;i<=sArray.length-1;i++)	
			sBuff_Temp.append(i+1+"] "+sArray[i]+"\n");

		return sBuff_Temp.toString();		
		}
	
	String sentence_case(){
		String[] s=sBuff_Temp.toString().split("\n");
		sBuff_Temp.delete(0, sBuff_Temp.length());
		
		for(int i=0;i<=s.length-1;i++){
			s[i]=s[i].substring(0, 1).toUpperCase()+s[i].substring(1);
			sBuff_Temp.append(s[i]+"\n");
		}		
		return sBuff_Temp.toString();				
	}
	
	String get_CurrentString(){
		return sBuff_Temp.toString();
	}
	
	String remove_blank(){
		String sTemp=get_CurrentString();
		//sTemp= (sTemp.replace("\n", ""));
		sTemp=sTemp.replaceAll("(?m)^[ \t]*\r?\n", "");
		
		sBuff_Temp=new StringBuffer(sTemp);
		return sTemp;
		
	}
}