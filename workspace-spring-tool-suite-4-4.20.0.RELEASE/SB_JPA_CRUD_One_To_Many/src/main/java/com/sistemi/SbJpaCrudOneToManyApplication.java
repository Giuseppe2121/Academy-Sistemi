package com.sistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.entity.Course;
import com.sistemi.entity.Review;
import com.sistemi.repository.CourseReviewRepository;

@SpringBootApplication
public class SbJpaCrudOneToManyApplication implements CommandLineRunner {
	
	@Autowired
	private CourseReviewRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SbJpaCrudOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Course course = new Course ("Spring", "Java Framework");
		//INSERIMENTO DI UN CORSO
		repository.addCourse(course);
		
		Review reviewOne = new Review("Roma");
		Review reviewTwo = new Review("Milano");
		
		reviewOne.setCourse(course);
		reviewTwo.setCourse(course);
		//AVREMMO POTUTO ALTRIMENTI USARE LA FK NEL COSTRUTORE CUSTOM
		//PER ASSOCIARE LE REVIEW AL CORSO
		
		//INSERIMENTO DI DUE REVIEW ASSOCIATE AL PRECEDENTE CORSO
		repository.addReview(reviewOne);
		repository.addReview(reviewTwo);
		
		//RICHIESTA D TUTTE LE RIEVEW ASSOCIATE AL COURSE CON ID=1 ,CIOE' SPRING
		repository.findAllReviewsByCourse(1).forEach(review->System.out.println(review.toString()));
		


		
		
		
	}

}
