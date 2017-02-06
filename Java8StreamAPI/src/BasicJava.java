import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class BasicJava {

	public static void main(String[] args) {
		System.out.println("java 7 : " + collectionFromJava7());
		System.out.println("java 8 : " + collectionFromJava8());
	}
	
	private static long collectionFromJava7(){
		List<Integer> list = new ArrayList<Integer>();
		long cnt = 0;
		
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		
		for (int i = 0; i < 50; i++) {
			list.set(i, list.get(i) * 2);
		}
		
		for (int i = 0; i < 50; i++) {
			if(list.get(i) % 3 == 0) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
	private static long collectionFromJava8(){
		return IntStream.range(0, 50)
				.mapToObj(val -> val * 2)
				.filter(val -> val % 3 == 0)
				.count();
	}
}
