import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int compteur = 0;

        while ( (line = br.readLine()) != null) {
            String[] levels = line.split("\\s");
            int n = levels.length;
            int[] vals = new int[n];
            for (int i = 0; i < n; i++) vals[i] = Integer.parseInt(levels[i]);

            boolean is_safe = true;
            Integer sens = null; 
            for (int i = 0; i < n - 1; i++) {
                int d = vals[i+1] - vals[i];
                if (d == 0 || Math.abs(d) > 3) {
                        is_safe = false;
                        break;
                    }
                int s = d > 0 ? 1 : -1;
                if (sens == null) sens = s;
                else if (sens != s) {
                        is_safe = false;
                        break; 
                     } 
            }
            if (is_safe){
                System.out.println("ligne en cours : " + line +" safe line");
                compteur++;
            }else{
                System.out.println("ligne en cours : " + line + " unsafe line");
            }
        }

        System.out.println("=> nombre de ligne safe: " + compteur);
    }
}
