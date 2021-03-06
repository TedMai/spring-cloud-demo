package spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User findOne = this.userRepository.findOne(id);
		return findOne;
	}

	@Value("${profile}")
	private String profile;

	@Value("${test_prop}")
	private String aaa;

	@GetMapping("/profile")
	public String hello() {
		return this.profile + "_" + aaa;
	}
}
