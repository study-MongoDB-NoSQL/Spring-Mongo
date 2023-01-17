package studymongodbnosql.springmongo.seonghoo1217.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studymongodbnosql.springmongo.seonghoo1217.domain.dto.GameDTO;
import studymongodbnosql.springmongo.seonghoo1217.domain.entity.Game;
import studymongodbnosql.springmongo.seonghoo1217.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;

	public String registerGame(GameDTO gameDTO){
		gameDTO.setId(UUID.randomUUID().toString());
		return gameRepository.save(gameDTO.toEntity()).getId();
	}

	public Game findByTitle(String title){
		return gameRepository.findByTitle(title).get();
	}

	public List<Game> findByOverPrice(int over_price){
		List<Game> game_list = gameRepository.findAll();
		System.out.println(game_list);
		List<Game> return_List=new ArrayList<>();
		for (Game game:game_list){
			if (game.getPrice()>over_price){
				return_List.add(game);
			}
		}

		return return_List;
	}

	public Game findById(String id){
		return gameRepository.findById(id).get();
	}

	public List<Game> findByDeveloper(String developer){
		return gameRepository.findByDeveloper(developer);
	}
}
