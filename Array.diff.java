import static org.junit.Assert.assertArrayEquals;

import java.util.*;
import java.util.stream.Collectors;

public class prueba {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		sampleTests();
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
	}
  
    static void sampleTests() {
        assertArrayEquals(new int[] {2}, Kata.arrayDiff(new int [] {1,2}, new int[] {1}));
        assertArrayEquals(new int[] {2,2}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {1}));
        assertArrayEquals(new int[] {1}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {2}));
        assertArrayEquals(new int[] {1,2,2}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {}));
        assertArrayEquals(new int[] {}, Kata.arrayDiff(new int [] {}, new int[] {1,2}));
    }

}

class Kata {
public static int[] arrayDiff(int[] a, int[] b) {
	if (a == null || b == null){return a;}
	
	ArrayList<Integer> result = new ArrayList<Integer>();
	for (int i = 0; i < a.length; i++) {
	  Boolean same = false;
	  int j = 0;
	  while (!same && j < b.length) {
		  if (a[i] == b[j]) {same = true;}
		  j++;
	  }
	  if (!same) {result.add(a[i]);}
	}
	a = result.stream().mapToInt(Integer::intValue).toArray();
    return a;
  }
}

//Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
//
//It should remove all values from list a, which are present in list b keeping their order.
//
//Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
//If a value is present in b, all of its occurrences must be removed from the other:
//
//Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}

class Kata2 {
    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }
}
