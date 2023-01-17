package studymongodbnosql.springmongo.seonghoo1217.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studymongodbnosql.springmongo.seonghoo1217.application.GameService;
import studymongodbnosql.springmongo.seonghoo1217.domain.dto.GameDTO;
import studymongodbnosql.springmongo.seonghoo1217.domain.entity.Game;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class GameAPIController {

	private final GameService gameService;

	@PostMapping("/api/v1/game/register")
	public void registerGame(@RequestBody GameDTO gameDTO){
		String id = gameService.registerGame(gameDTO);
		System.out.println(id);
	}

	@GetMapping("/api/v1/game/find/{title}")
	public ResponseEntity<Game> getGameInfoByTitle(@PathVariable String title){
		System.out.println("title="+title);
		Game findByTitle = gameService.findByTitle(title);
		return new ResponseEntity<>(findByTitle, HttpStatus.OK);
	}

	@GetMapping("/api/v1/game/find/price/{over_price}")
	public ResponseEntity<List<Game>> getGameInfoByOverPrice(@PathVariable int over_price){
		List<Game> findByOverPrice = gameService.findByOverPrice(over_price);
		return new ResponseEntity<>(findByOverPrice,HttpStatus.OK);
	}

	@GetMapping("/api/v1/game/find/id/{id}")
	public ResponseEntity<Game> getGameInfoById(@PathVariable String id){
		Game findByID = gameService.findById(id);
		return new ResponseEntity<>(findByID,HttpStatus.OK);
	}

	@GetMapping("/api/v1/gamelist")
	public void getGameInfoAll(){
		List<Game> byAll = gameService.findByAll();
		System.out.println(byAll);
	}

	@GetMapping("/api/v1/game/find/developer/{developer}")
	public ResponseEntity<List<Game>> getGameInfoByDeveloper(@PathVariable String developer){
		List<Game> byDeveloper = gameService.findByDeveloper(developer);
		return new ResponseEntity<>(byDeveloper,HttpStatus.OK);
	}
}
