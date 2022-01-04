package hextechlibrary.dto.lol.status;

import java.util.List;

public class StatusDto {
    private int id;
    private String maintenance_status; //(Legal values: scheduled, in_progress, complete)
    private String incident_severity; //(Legal values: info, warning, critical)
    private List<ContentDto> titles;
    private List<UpdateDto> updates;
    private String created_at;
    private String archive_at;
    private String updated_at;
    List<String> platforms; //(Legal values: windows, macos, android, ios, ps4, xbone, switch)
}
