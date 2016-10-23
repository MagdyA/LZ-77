import javax.swing.*;

public class Run {
	public void run(){
		while(true){
			String s = JOptionPane.showInputDialog("choose an option:\n1) compress\n2) de-compress\n3) exit");
			if(Integer.parseInt(s)==1)com();
			if(Integer.parseInt(s)==2)decom();
			else break;
		}

		
		
	}
	public void com(){
		
		String f1 = JOptionPane.showInputDialog("Enter file name to be compressed");
		lz77 z = new lz77();
		z.compress(f1);
		JOptionPane.showMessageDialog(null, "Compressed successfully!");
		
	}
	public void decom(){
		
		String f2 = JOptionPane.showInputDialog("Enter file name to be de-compressed");
		lz77 z = new lz77();
		z.decompress(f2);
		JOptionPane.showMessageDialog(null, "d-ecompressed successfully!");
		
	}

}