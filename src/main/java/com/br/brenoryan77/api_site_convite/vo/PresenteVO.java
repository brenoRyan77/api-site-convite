package com.br.brenoryan77.api_site_convite.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PresenteVO {

    private Long id;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private String linkProduto;
    private BigDecimal valor;
}
