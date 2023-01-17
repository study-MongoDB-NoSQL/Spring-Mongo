package studymongodbnosql.springmongo.seonghoo1217.domain.dto;

import lombok.Data;
import studymongodbnosql.springmongo.seonghoo1217.domain.entity.Game;

@Data
public class GameDTO {
	private String id;
	private String title;
	private String developer;
	private int price;

	public Game toEntity(){
		return Game.builder()
				.id(id)
				.title(title)
				.developer(developer)
				.price(price)
				.build();
	}
}
