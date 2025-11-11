
package src.core;

import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String sha256(File file) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int n;
        while ((n = fis.read(buffer)) != -1) {
            digest.update(buffer, 0, n);
        }
        fis.close();
        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public static String now() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static void copyFile(File src, File dest) throws IOException {
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}