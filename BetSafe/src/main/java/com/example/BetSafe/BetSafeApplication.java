package com.example.BetSafe;

import CsvFactory.FileReader;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.Arrays;

@SpringBootApplication
public class BetSafeApplication {
	public static void main(String[] args) throws IOException {

		String path = "BetterBet.csv";

		if(path != null){
			FileReader fileReader = new FileReader();
			fileReader.convert(path);
		}
	}

}
