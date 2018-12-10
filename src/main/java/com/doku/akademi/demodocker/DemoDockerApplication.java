package com.doku.akademi.demodocker;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;

/**
 *
 * @author robihidayat
 *
 */
@SpringBootApplication
@RestController
@RequestMapping("akademi")
@Slf4j
public class DemoDockerApplication {

	@Autowired
	UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoDockerApplication.class, args);
	}


	/**
	 *
	 * @return
	 */
	@GetMapping
	public String hello(){
		return "hello world";
	}

	/**
	 *
	 * @param userName
	 * @return
	 */
	@PostMapping
	public String user(@RequestBody String  userName){
		log.info("Request {} ", userName);
		Users users = new Users();
		users.setUserName(userName);
		userRepository.save(users);
		return users.toString();
	}

	@Entity
	@Table(name = "users")
	@Setter
	@Getter
	@RequiredArgsConstructor
	@ToString
	public class Users{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@Column(name = "user_name")
		private String userName;
	}


}
