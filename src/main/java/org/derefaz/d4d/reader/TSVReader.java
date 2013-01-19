package org.derefaz.d4d.reader;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class TSVReader {

    public void read(String _path, LineHandler _handler) throws IOException {
        System.out.println("[" + new Date() + "] reading " + _path);
        String name = new File(_path).getName();
        FileInputStream inputStream = new FileInputStream(_path);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(dataInputStream));
        String line;
        Long multi = new Long(0);
        Long lineNum = new Long(0);
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            try {
                _handler.load(tokenizer);
                System.out.println("reading line " + lineNum + " of " + name);
            } catch (NoSuchElementException e) {
                System.out.println("reading error on line [" + multi + "x" + lineNum + "] :'" + line + "'");
            }
            if (lineNum == Long.MAX_VALUE) {
                multi++;
                lineNum = new Long(0);
            } else {
                lineNum++;
            }
        }
        dataInputStream.close();
    }
}
