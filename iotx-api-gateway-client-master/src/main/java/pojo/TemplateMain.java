package pojo;

import lombok.Data;

import java.util.List;

@Data
public class TemplateMain {
    private String name;

    private String code;

    private String version;

    private Long type;

    private Long height;

    private Long width;

    private List<TemplateElement> elementList;
}
