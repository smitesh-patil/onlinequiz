package com.quiz.home;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QnlineQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QnlineQuizApplication.class, args);
	}
	@Bean
public ModelMapper mapper()
{
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
}
}
