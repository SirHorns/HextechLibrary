package hextechlibrary.dto.lol.status;

import java.util.List;

public class UpdateDto {
    private int id;
    private String author;
    private boolean publish;
    List<String> publish_locations;	//(Legal values: riotclient, riotstatus, game)
    List<ContentDto> translation;
    String created_a;
    String updated_a;
}
