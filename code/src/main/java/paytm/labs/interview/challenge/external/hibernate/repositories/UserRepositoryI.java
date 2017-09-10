package paytm.labs.interview.challenge.external.hibernate.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import paytm.labs.interview.challenge.external.hibernate.model.classes.UserDEC;

public interface UserRepositoryI extends PagingAndSortingRepository<UserDEC, Long> {}
//PageRequest