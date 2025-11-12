
package src.core;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;


public class Index {
    private final File indexFile;

    public Index() {
        this.indexFile = new File(Repository.getIndexFile());
    }

    public JSONArray load() throws Exception {
        if (!indexFile.exists()) return new JSONArray();
        String content = Files.readString(indexFile.toPath());
        if (content.isEmpty()) return new JSONArray();
        return new JSONArray(content);
    }

    public void addFile(String filename, String hash) throws Exception {
        JSONArray arr = load();
        JSONObject obj = new JSONObject();
        obj.put("file", filename);
        obj.put("hash", hash);
        arr.put(obj);
        save(arr);
    }

    private void save(JSONArray arr) throws Exception {
        try (FileWriter fw = new FileWriter(indexFile)) {
            fw.write(arr.toString(4));
        }
    }

}