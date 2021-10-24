package giveaway;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class solve {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("Your Address: Your Address is, ([a-zA-Z0-9]*)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(Files.readString(new File("out.txt").toPath()));
        FileOutputStream fos = new FileOutputStream("out");
        while(matcher.find()) {
            String a = matcher.group(1);
            fos.write(a.getBytes(StandardCharsets.UTF_8));
            fos.write(' ');
        }
        fos.flush();
        fos.close();
    }
}