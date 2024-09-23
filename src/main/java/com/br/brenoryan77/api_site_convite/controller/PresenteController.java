package com.br.brenoryan77.api_site_convite.controller;

import com.br.brenoryan77.api_site_convite.mapper.PresenteMapper;
import com.br.brenoryan77.api_site_convite.service.PresenteService;
import com.br.brenoryan77.api_site_convite.vo.PresenteVO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presente")
@Tag(name = "Presente", description = "Operações referente a presentes.")
@ApiResponse(responseCode = "200", description = "Operação realizada com sucesso.")
@ApiResponse(responseCode = "201", description = "Recurso criado com sucesso.")
@ApiResponse(responseCode = "400", description = "Requisição inválida.")
@ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
@ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
@CrossOrigin(origins = "*")
public class PresenteController {

    @Autowired
    private PresenteService presenteService;

    @Autowired
    private PresenteMapper presenteMapper;

    @PostMapping
    public ResponseEntity<Void> incluir(@RequestBody PresenteVO presenteVO) {
        presenteService.incluir(presenteVO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterar(@RequestBody PresenteVO presenteVO, @PathVariable Long id) {
        presenteService.alterar(presenteVO, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        presenteService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresenteVO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(presenteMapper.mapToVO(presenteService.buscar(id)));
    }

    @GetMapping
    public ResponseEntity<List<PresenteVO>> listarTodos() {
        return ResponseEntity.ok(presenteService.litarTodos().stream()
                .map(presenteMapper::mapToVO)
                .toList());
    }
}
