
package src.commands;

import src.core.*;
import java.io.File;

public class AddCommand {
    public void run(String filename) throws Exception {
        if (!Repository.isInitialized()) throw new Exception("not a minigit repository");

        File file = new File(filename);
        if (!file.exists()) throw new Exception("file not found: " + filename);

        String hash = Utils.sha256(file);
        new Index().addFile(filename, hash);
        System.out.println("added " + filename + " (" + hash.substring(0, 8) + ")");
    }
}
