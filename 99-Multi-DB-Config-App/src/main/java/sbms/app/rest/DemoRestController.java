package sbms.app.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sbms.app.db1.entities.User;
import sbms.app.db1.repository.UserRepository;
import sbms.app.db2.entities.Book;
import sbms.app.db2.repository.BookRepository;


@RestController
public class DemoRestController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/data")
	public String addData2DB() {
		userRepository.saveAll(Stream.of(new User(101,"John","john@gmail.com"), new User(102,"Smith","smith@gmail.com")).collect(Collectors.toList()));
		bookRepository.saveAll(Stream.of(new Book(201,"Core Java",1100.0,"John"), new Book(203,"Spring Boot",1500.0,"Smith")).collect(Collectors.toList()));
		return "Data Added Successfully";
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

}
