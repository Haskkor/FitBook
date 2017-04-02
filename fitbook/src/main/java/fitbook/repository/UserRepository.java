package fitbook.repository;

import org.springframework.data.repository.CrudRepository;

import fitbook.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
	User findByEmail(String email);

}
