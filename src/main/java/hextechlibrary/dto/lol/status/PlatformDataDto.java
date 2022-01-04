package hextechlibrary.dto.lol.status;

import java.util.List;

public class PlatformDataDto {
    private String id;
    private String name;
    private List<String> locales;
    private List<StatusDto> maintenances;
    private List<StatusDto> incidents;
}
