package real.spring.realspringboot.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Country implements Serializable {
    private String code;
    private String name;
    private String continent;
    private String region;
    private String surfaceArea;
    private String indepYear;
    private Long population;
    private Double lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;
    private String code2;

}
