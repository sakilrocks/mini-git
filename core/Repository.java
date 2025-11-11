
package src.core;

import java.io.File;



public class Repository {
    private static final String MINIGIT_DIR = ".minigit";
    private static final String COMMITS_DIR = MINIGIT_DIR + "/commits";
    private static final String INDEX_FILE = MINIGIT_DIR + "/index.json";
    private static final String HEAD_FILE = MINIGIT_DIR + "/HEAD";

    public static void init() throws Exception {
        File repoDir = new File(MINIGIT_DIR);
        if (repoDir.exists()) {
            throw new Exception("repository already initialized.");
        }
        new File(COMMITS_DIR).mkdirs();
        new File(INDEX_FILE).createNewFile();
        new File(HEAD_FILE).createNewFile();
        System.out.println("initialized empty minigit repository in " + repoDir.getAbsolutePath());
    }

    public static boolean isInitialized() {
        return new File(MINIGIT_DIR).exists();
    }

    public static String getCommitsDir() {
        return COMMITS_DIR;
    }

    public static String getIndexFile() {
        return INDEX_FILE;
    }

    public static String getHeadFile() {
        return HEAD_FILE;
    }
}