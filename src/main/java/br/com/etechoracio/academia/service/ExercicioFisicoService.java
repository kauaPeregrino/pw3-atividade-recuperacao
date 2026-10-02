package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDto;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioFisicoService {

    @Autowired
    private ExercicioFisicoRepository exercicioFisicoRepository;

    @Autowired
    private ExercicioFisicoMapper exercicioFisicoMapper;

    public List<ExercicioFisicoResponseDto> findByAprovado() {
        var result = exercicioFisicoRepository.findByAprovadoTrue();
        return exercicioFisicoMapper.toRespostaDTOList(result);
    }

    public Optional<ExercicioFisicoResponseDto> findById(Long id) {
        return exercicioFisicoRepository.findByIdAndAprovadoTrue(id)
                .map(exercicio -> exercicioFisicoMapper.toResponseDTO(exercicio));
    }


}
