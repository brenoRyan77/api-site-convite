package com.br.brenoryan77.api_site_convite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_presente")
@SQLRestriction("ativo = true")
@SQLDelete(sql = "UPDATE tb_presente SET ativo = false WHERE id = ?")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Presentes {

    @Id
    @SequenceGenerator(name = "seq_presente", sequenceName = "seq_presente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_presente")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "imagem_url", columnDefinition = "TEXT")
    private String imagemUrl;

    @Column(name = "valor", nullable = false, scale = 2, precision = 10)
    private BigDecimal valor;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @PrePersist
    private void prePersist(){
        this.ativo = true;
    }

}
