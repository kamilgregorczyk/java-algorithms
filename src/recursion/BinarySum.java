package recursion;

public class BinarySum {

    public static long binarySum(int[] data) {
        return binarySum(data, 0, data.length);
    }

    private static long binarySum(int[] data, int left, int right) {
        if (left > right) {
            return 0;
        }

        if (left == right) {
            return data[left];
        }

        int mid = (left + right) / 2;
        return binarySum(data, left, mid) + binarySum(data, mid + 1, right);
    }
}
