package _24.collection.practice;

import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

public class RandomNumberStatistics {
	private final int DATA_BOUNDARY = 50;
	Hashtable<Integer, Integer> hashtable = new Hashtable<>();

	public void getRandomNumberStatistics() {
		Random random = new Random();
		
		int cnt = 0;
		while (cnt < DATA_BOUNDARY * 100) {
			int tempNumber = random.nextInt(DATA_BOUNDARY) + 1;
			putCurrentNumber(tempNumber);
			cnt++;
		}
		printStatistics();
	}

	public void putCurrentNumber(int tempNumber) {
		if (hashtable.containsKey(tempNumber)) {
			hashtable.put(tempNumber, hashtable.get(tempNumber) + 1);
		} else {
			hashtable.put(tempNumber, 1);
		}
	}

	public void printStatistics() {
		Set<Integer> statisticsKey = hashtable.keySet();
		for (int key : statisticsKey) {
			System.out.print(key + "=" + hashtable.get(key) + " ");
			if (key % 10 - 1 == 0) System.out.println();
		}
	}

	public static void main(String[] args) {
		RandomNumberStatistics statistics = new RandomNumberStatistics();
		statistics.getRandomNumberStatistics();
	}
}
