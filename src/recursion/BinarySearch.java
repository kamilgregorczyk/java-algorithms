package recursion;

public class BinarySearch {

    public static boolean contains(int[] data, int target) {
        return doSearch(data, target, 0, data.length - 1) >= 0;
    }

    public static int indexOf(int[] data, int target) {
        return doSearch(data, target, 0, data.length - 1);
    }

    private static int doSearch(int[] data, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int middleElement = data[middle];
        if (middleElement == target) {
            return middleElement;
        } else if (target > middleElement) {
            return doSearch(data, target, middle + 1, right);
        } else {
            return doSearch(data, target, left, middle - 1);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(contains(data, 100));
        System.out.println(indexOf(data, 100));
    }

}
