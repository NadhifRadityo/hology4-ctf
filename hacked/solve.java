package hacked;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class solve {
    public static void main(String[] args) throws Exception {
        File file = new File("access.log");
        FileInputStream fis = new FileInputStream(file);
        String contents = Files.readString(file.toPath());
        Pattern pattern = Pattern.compile("^192.168.100.1 - - \\[01\\/Oct\\/2021:([0-9]{2}:[0-9]{2}:[0-9]{2})\\] \"GET \\/users=ASC,\\(select \\(case when \\(substring\\(password,([0-9]+),([0-9]+)\\) = ([a-zA-Z0-9_])\\) then sleep\\(3\\) else sleep\\(1\\)\\)\\) HTTP\\/1\\.0\" 200 1200", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(contents);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        StringBuilder res = new StringBuilder();
        long last = 0;
        String before = null;
        while(matcher.find()) {
            long cur = formatter.parse(matcher.group(1)).getTime();
            if(last == 0)
                last = cur;
            if(cur - last >= 3000)
                res.append(before);
            last = cur;
            before = matcher.group(4);
        }
        System.out.println(res);
    }
}
