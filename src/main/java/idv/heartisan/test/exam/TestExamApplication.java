package idv.heartisan.test.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("idv.heartisan.test.exam.dao.mapper")
public class TestExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestExamApplication.class, args);
	}

}
