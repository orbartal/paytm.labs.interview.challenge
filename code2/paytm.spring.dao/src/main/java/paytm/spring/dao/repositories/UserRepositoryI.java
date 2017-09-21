package paytm.spring.dao.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import paytm.spring.dao.model.classes.UserDEC;

@Repository
public interface UserRepositoryI extends PagingAndSortingRepository<UserDEC, Long> {
	public UserDEC findByName(String name);
}