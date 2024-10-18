import java.io.*;
import java.util.*;

public class Main {
  static List<Integer> prime = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    findPrime();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    for (int test = 1; test <= tc; test++) {
      System.out.println("Scenario " + test + ":");
      int m = Integer.parseInt(br.readLine());
      int[] nArr = new int[m];
      String[] strArr = br.readLine().split(" ");
      for (int i = 0; i < m; i++) {
        nArr[i] = Integer.parseInt(strArr[i]);
      }
      Arrays.sort(nArr);
      for (int i = 0; i < m; i++) {
        int tmp = nArr[i];
        nArr[i] = nArr[m - 1 - i];
        nArr[m - 1 - i] = tmp;
      }
      int[] curIdx = new int[m];
      int[] curVal = new int[m];

      for (int i=0; i<m; i++) {
        for (int idx=0; idx<nArr[i]; idx++) {
          curVal[i]+=prime.get(idx);
        }
      }

      while (true) {
        boolean flag = prime.contains(curVal[m-1]);
        if (flag) {
          for (int i=0; i<m-1; i++) {
            if (curVal[i]!=curVal[m-1]) flag = false;
          }
        }
        if (flag) break;
        curVal[m-1] = curVal[m-1]-prime.get(curIdx[m-1]) + prime.get(curIdx[m-1]+nArr[m-1]);
        curIdx[m-1]++;
        for (int i=0; i<m-1; i++) {
          while (curVal[i]<curVal[m-1]) {
            curVal[i] = curVal[i]-prime.get(curIdx[i])+prime.get(curIdx[i]+nArr[i]);
            curIdx[i]++;
          }
        }
      }

      System.out.println(curVal[m-1]);
      System.out.println("");
    }
  }

  public static void findPrime() {
    int limit = 10000000;
    boolean[] isPrime = new boolean[limit + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i * i <= limit; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= limit; j += i) {
          isPrime[j] = false;
        }
      }
    }

    for (int i = 2; i <= limit; i++) {
      if (isPrime[i])
        prime.add(i);
    }
  }
}