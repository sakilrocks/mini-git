
package src.core;

import org.json.JSONObject;
import java.io.*;
import java.util.UUID;


public class Commit {
    private final String id;
    private final String message;
    private final String timestamp;

    public Commit(String message) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.message = message;
        this.timestamp = Utils.now();
    }

    public void save() throws Exception {
        String commitDir = Repository.getCommitsDir() + "/" + id;
        new File(commitDir).mkdirs();

        JSONObject meta = new JSONObject();
        meta.put("id", id);
        meta.put("message", message);
        meta.put("timestamp", timestamp);

        try (FileWriter fw = new FileWriter(commitDir + "/meta.json")) {
            fw.write(meta.toString(4));
        }

        File indexFile = new File(Repository.getIndexFile());
        if (indexFile.exists()) {
            Utils.copyFile(indexFile, new File(commitDir + "/index.json"));
        }

        try (FileWriter fw = new FileWriter(Repository.getHeadFile())) {
            fw.write(id);
        }

        System.out.println("committed as " + id + " - " + message);
    }

}