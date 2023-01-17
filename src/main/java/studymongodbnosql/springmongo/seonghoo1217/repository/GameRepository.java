package studymongodbnosql.springmongo.seonghoo1217.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import studymongodbnosql.springmongo.seonghoo1217.domain.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends MongoRepository<Game,String> {
	Optional<Game> findByTitle(String title);
	List<Game> findByDeveloper(String developer);
}
