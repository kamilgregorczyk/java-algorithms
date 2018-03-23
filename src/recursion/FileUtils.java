package recursion;

import java.io.File;
import java.util.*;

public class FileUtils {

    public static Set<File> getAllNestedDirectories(File root) {
        Set<File> directoryPaths = new HashSet<>();
        directoryPaths.add(root);
        return getAllNestedDirectories(root, directoryPaths);
    }

    public static long getSizeOfAllNestedDirectories(File root) {
        long sizeOfRoot = root.length();
        if (root.isDirectory()) {
            for (String childPath : root.list()) {
                sizeOfRoot += getSizeOfAllNestedDirectories(new File(root, childPath));
            }
        }
        return sizeOfRoot;
    }

    private static Set<File> getAllNestedDirectories(File root, Set<File> paths) {
        if (root.isDirectory()) {
            paths.add(root);
            for (String childPath : root.list()) {
                getAllNestedDirectories(new File(root, childPath), paths);
            }
        }
        return paths;
    }
}
