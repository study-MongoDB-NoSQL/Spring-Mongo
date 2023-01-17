package studymongodbnosql.springmongo.seonghoo1217.domain.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "game")
@Builder
@Getter
public class Game {

	@Id
	private String id;

	private String title;

	private String developer;

	private int price;

	@Builder
	public Game(String id, String title, String developer, int price) {
		this.id = id;
		this.title = title;
		this.developer = developer;
		this.price = price;
	}
}
