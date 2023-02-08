package sample.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserDetails, Long>{
	
	@Query(value = "SELECT * FROM users", nativeQuery = true)
	List<UserDetails> findAllNative();

}
