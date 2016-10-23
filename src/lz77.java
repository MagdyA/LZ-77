import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import org.omg.CORBA.DataOutputStream;

public class lz77 {

	public void compress( String fileName ) {
		File file = new File(fileName+".txt");
		String s;
		Scanner in = null ;
		try{
			in = new Scanner(file);
		}catch(FileNotFoundException e){JOptionPane.showMessageDialog(null, "Error! File not found !!");}
		s = in.nextLine();
		
		tag t = new tag();
		ArrayList<tag> arr = new ArrayList<tag>(10000);
		String buffer="" , window ;
		int bufferSize = 0 ;
		for(int i =0 ; i<s.length();++i){
			
			bufferSize = 1;
			buffer = s.substring(i,i+bufferSize);
			window = s.substring(0,i);
			while(window.contains(buffer) && i+bufferSize<s.length()){
				buffer+=s.charAt(i+bufferSize);
				bufferSize++;
			}
			String temp = buffer.substring(0,buffer.length()-1);
			int tem = i-window.lastIndexOf(temp);
			t.jump= (tem < 0 ? 0 : tem);
			t.length=temp.length();
			t.ne=buffer.charAt(buffer.length()-1);
			i+=temp.length();
			arr.add(t);
			t = new tag();
			
				
			
		}
		
		File f = new File("z-"+fileName+".txt");
		try{
		PrintWriter p = new PrintWriter(f);
		
		
		
		
		for( tag x : arr)
			p.println(x.jump + " "  + x.length + " " + x.ne);
		p.close();
		}catch(Exception e){}
		
	}
	
	
	//////////////////////////////////////////////////////////////////
	public void decompress(String fileName){
		File file = new File(fileName+".txt");
		Scanner in = null ;
		String s = "" , temp = "";
		int jump , length  , i=0;
		char c;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error! File not found !!");
		}
		while(in.hasNext()){
			jump = in.nextInt();
			length = in.nextInt();
			c = in.next().charAt(0);
			if(jump==0 && length==0){
				s+=c;
				i++;
				continue;
			}
			else{
				temp=s.substring(i-jump,i-jump+length);
				s+=temp;
				s+=c;
				i+=length+1;
			}
		}
		
		File f = new File("e-" + fileName + ".txt");
	
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter p;
		try {
			p = new PrintWriter(f);
			p.print(s);
			p.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	

}