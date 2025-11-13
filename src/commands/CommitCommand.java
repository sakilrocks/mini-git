
package src.commands;

import src.core.*;


public class CommitCommand {
    public void run(String message) throws Exception {
        if (!Repository.isInitialized()) throw new Exception("not a minigit repository");

        Commit commit = new Commit(message);
        commit.save();
    }
}
