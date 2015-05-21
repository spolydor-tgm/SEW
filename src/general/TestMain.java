package general;

public class TestMain {
	public static int[] generateNumbers(int amount){
		int[] nbs = new int[amount];
		int[] verw = new int[amount];
		int hilfe =999;
		int i =0;
		boolean nochFrei = true;
		
		while(i<hilfe) {
			int neu = (int) (Math.random() * (80 - 1) + 1);

			//check schon verwendet
			for (int j = 0; j < verw.length; j++) {
				if(verw[j]==neu) {
					nochFrei = false;
				}
			}
			
			//wenn nicht dann zu beiden hinzufuegen
			if(nochFrei==true) {
				nbs[i] = neu;
				verw[i] = neu;
				i++;
				if(i==amount)
					i=9999;
			}
			
			nochFrei=true;
		}
		
		return nbs;
	}
	
	public static void main(String[] args) {
		int asdf = 6;
		
		int[] asd = generateNumbers(asdf);
		for (int i = 0; i < asdf; i++) {
			System.out.println(asd[i]);
		}
	}
}
