
package src.commands;

import src.core.Repository;


public class InitCommand {
    public void run() throws Exception {
        Repository.init();
    }
}