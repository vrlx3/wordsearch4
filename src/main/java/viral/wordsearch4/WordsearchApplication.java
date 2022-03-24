package viral.wordsearch4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import viral.wordsearch4.controllers.TestContoller;

@SpringBootApplication
//@ComponentScan(basePackageClasses = TestContoller.class)
public class WordsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordsearchApplication.class, args);
	}

}
