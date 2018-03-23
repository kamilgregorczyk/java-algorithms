package arrays;

/**
 * Basic sort by insertion algorithm, with complexity of N*N.
 */
public final class InsertionSort {

    static int[] sort(int[] integers) {
        int collectionSize = integers.length;
        for (int i = 1; i < collectionSize; i++) {
            int currentElement = integers[i];
            int currentIndex = i;
            while (currentIndex > 0 && integers[currentIndex - 1] > currentElement) {
                integers[currentIndex] = integers[currentIndex - 1];
                currentIndex--;
            }
            integers[currentIndex] = currentElement;
        }
        return integers;
    }
}
