import java.io.*;
import java.util.*;

public class Main {
  public static class Jewel {
    int weight, value;

    Jewel(int w, int v) {
      this.weight = w;
      this.value = v;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Jewel[] jewelry = new Jewel[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      jewelry[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    int[] bag = new int[K];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      bag[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(jewelry, new Comparator<Jewel>() {
      @Override
      public int compare(Jewel j1, Jewel j2) {
        if (j1.weight != j2.weight) {
          return j1.weight - j2.weight; 
        } else {
          return j2.value - j1.value; 
        }
      }
    });

    Arrays.sort(bag);

    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
      @Override
      public int compare(Integer i1, Integer i2) {
        return i2-i1;
      }
    });
    long answer = 0;
    int j = 0;
    for (int i = 0; i < K; i++) {
      while (j < N && jewelry[j].weight <= bag[i]) {
        pq.offer(jewelry[j++].value);
      }
      if (!pq.isEmpty()) {
        answer += pq.poll();
      }
    }

    System.out.println(answer);
  }
}