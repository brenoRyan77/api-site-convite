package com.br.brenoryan77.api_site_convite.service;

import com.br.brenoryan77.api_site_convite.exception.ServiceException;
import com.br.brenoryan77.api_site_convite.mapper.PresenteMapper;
import com.br.brenoryan77.api_site_convite.model.Presente;
import com.br.brenoryan77.api_site_convite.repository.PresenteRepository;
import com.br.brenoryan77.api_site_convite.vo.PresenteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PresenteService {

    @Autowired
    private PresenteRepository presenteRepository;

    @Autowired
    private PresenteMapper presenteMapper;


    @Transactional
    public void incluir(PresenteVO presenteVO) {
        presenteRepository.save(presenteMapper.mapToEntity(presenteVO));
    }

    @Transactional
    public void alterar(PresenteVO presenteVO, Long id) {
        Presente presente = buscar(id);
        presenteMapper.updateEntity(presente, presenteVO);
        presenteRepository.save(presente);
    }

    public Presente buscar(Long id) {
        return presenteRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Presente não encontrado com o ID: " + id));
    }

    public List<Presente> litarTodos() {
        return presenteRepository.findAll();
    }

    @Transactional
    public void deletar(Long id) {
        Optional.ofNullable(buscar(id))
                .ifPresent(presenteRepository::delete);
    }
}
