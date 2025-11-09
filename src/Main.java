
package src;

import src.commands.*;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("usage: minigit <command> [options]");
            return;
        }

        String command = args[0];
        try {
            switch (command) {
                case "init" -> new InitCommand().run();
                case "add" -> {
                    if (args.length < 2) {
                        System.out.println("usage: minigit add <file>");
                        return;
                    }
                    new AddCommand().run(args[1]);
                }
                case "commit" -> {
                    if (args.length < 3 || !args[1].equals("-m")) {
                        System.out.println("usage: minigit commit -m \"message\"");
                        return;
                    }
                    new CommitCommand().run(args[2]);
                }
                default -> System.out.println("unknown command: " + command);
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    
}