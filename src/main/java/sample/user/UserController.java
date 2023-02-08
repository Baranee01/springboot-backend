package sample.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud/user/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/getall")
	public List<UserDetails> getAllusers(){
		return this.userRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<UserDetails> getbyId(@PathVariable(value = "id") Long userid){
		return this.userRepository.findById(userid);
	}
	
	@PostMapping("/create")
	public UserDetails createuser(@RequestBody UserDetails user) {
		return this.userRepository.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteuser(@PathVariable(value = "id") Long userid) {
		this.userRepository.deleteById(userid);
		return ("Deleted ID:"+userid);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDetails> updateuser(@PathVariable(value = "id") Long userid,
			@Validated @RequestBody UserDetails user) {
		UserDetails entry = userRepository.findById(userid).orElseThrow();
		entry.setName(user.getName());
		entry.setEmail(user.getEmail());
		entry.setPassword(user.getPassword());
		return ResponseEntity.ok(this.userRepository.save(entry));
	}
}
