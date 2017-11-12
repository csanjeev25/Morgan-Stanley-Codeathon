import java.io.*;
import java.util.*;

public class orderStrings {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> input = new ArrayList<>();
        for(int i = 0;i < n;i++){
        	input.add(br.readLine());
        }
        String randomShit = br.readLine();
        String[] randomShit_1 = randomShit.split(" ");
        final int key = (Integer.parseInt(randomShit_1[0])) - 1;
        boolean reversal = Boolean.parseBoolean(randomShit_1[1]);
        String comparisonType = randomShit_1[2];
        if(comparisonType.equals("lexicographic")){
        ArrayList<String[]> input_1 = new ArrayList<>();
        for(int i = 0;i < input.size();i++){
        	String a = input.get(i);
        	input_1.add(a.split("\\s"));
        }
        	Collections.sort(input_1,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[key].compareTo(otherStrings[key]);
            }
        });

        	if(!reversal){
        for (int i = 0;i < n;i++) {
            String[] a = input_1.get(i);
            for(int j = 0;j < a.length;j++){
            	System.out.print(a[j] + " ");
            	//System.out.println(" Valar Morghulis ");
            }
            System.out.println();
        }
    }
    else{
    	for(int i = n - 1;i >= 0;i--){
    		String[] a = input_1.get(i);
    		for(int j = 0;j < a.length;j++)
    			System.out.print(a[j] + " ");
    		System.out.println();
    	}
    }
        }
        else{
        	if(comparisonType.equals("numeric")){
        		ArrayList<int[]> input_1 = new ArrayList<>();
        		for(int i = 0;i < input.size();i++){
        		String a = input.get(i);
        		String[] b = a.split("\\s");
        		int[] c = new int[b.length];
        		for(int j = 0;j < b.length;j++){
        			c[j] = Integer.parseInt(b[j].trim());
        		}
        		input_1.add(c);
        	}
        	Collections.sort(input_1, new Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return Integer.valueOf(a[key]).compareTo(Integer.valueOf(b[key]));
    }
});
        	if(!reversal){
        			for(int i = 0;i < n;i++){
        				int[] a = input_1.get(i);
        				for(int j = 0;j < a.length;j++){
        					System.out.print(a[j] + " ");
        				}
        				System.out.println();
        			}
        		}
        		else{
        			for(int i = n - 1;i >= 0;i--){
        				int[] a = input_1.get(i);
        				for(int j = 0;j < a.length;j++)
        					System.out.print(a[j] + " ");
        				System.out.println();
        			}
        		}

        }
    }
}
}