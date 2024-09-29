import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] applicant = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            applicant[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); 
        int C = Integer.parseInt(st.nextToken()); 
        
        long sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum++; 
            int remaining = applicant[i] - B;
            if (remaining > 0) {
                sum += (remaining + C - 1) / C; 
            }
        }
        
        System.out.println(sum);
    }
}