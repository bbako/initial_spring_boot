package com.henry.initial.home;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstimateVO {
    private String estiName;
    private String estiEmail;
    private String estiTel;
    private String estiPassword;
    private String estiTitle;
    private String estiContent;
    private String estiRegdate;
    private Integer estiSeq;
    private Integer rowNum;

}
