package CsvFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;

public class FileReader {

    public void convert (String path) throws IOException {
        String line = "";
        BufferedReader br = new BufferedReader(new java.io.FileReader(path));
        while ((line = br.readLine()) != null){
            String[] values = line.split(",");
        }

    }
}
