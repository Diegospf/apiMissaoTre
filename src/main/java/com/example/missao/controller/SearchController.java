package com.example.missao.controller;

import com.example.missao.dto.transform.*;
import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.model.Zona;
import com.example.missao.repository.MunicipioRepository;
import com.example.missao.repository.PoloRepository;
import com.example.missao.repository.SecaoRepository;
import com.example.missao.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    private PoloRepository poloRepository;
    @Autowired
    private ZonaRepository zonaRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private SecaoRepository secaoRepository;

    //POLO
    @CrossOrigin
    @GetMapping("polo/{id}")
    public ResponseEntity<DetalhesPoloDto> polo(@PathVariable Long id) {
        Long qnt = secaoRepository.qntSecoesPorPolo(id);
        return poloRepository.findById(id)
                .map(value -> ResponseEntity.ok(new DetalhesPoloDto(value, qnt)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("polo/municipio/{id}")
    public ResponseEntity<List<MunicipiosByPoloDto>> municipioByPolo(@PathVariable Long id) {
        return poloRepository.findById(id)
                .map(value -> ResponseEntity.ok(MunicipiosByPoloDto.munPolo(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("polo/secao/{id}")
    public ResponseEntity<SecoesByPoloDto> secaoByPolo(@PathVariable Long id) {
        Long qnt = secaoRepository.qntSecoesPorPolo(id);
        return poloRepository.findById(id)
                .map(value -> ResponseEntity.ok(new SecoesByPoloDto(qnt)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("polo/sede/{id}")
    public ResponseEntity<SedeByPoloDto> sedeByPolo(@PathVariable Long id) {
        return poloRepository.findById(id)
                .map(value -> ResponseEntity.ok(new SedeByPoloDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin
    @GetMapping("polo/zona/{id}")
    public ResponseEntity<List<ZonaByPoloDto>> zonaByPolo(@PathVariable Long id) {
        return ResponseEntity.ok(ZonaByPoloDto.zonaPolo(zonaRepository.zonaPorPolo(id)));
    }

    @CrossOrigin
    @GetMapping("polo/todos/{id}")
    public ResponseEntity<TodosByPoloDto> todosByPolo(@PathVariable Long id) {
        Long qnt = secaoRepository.qntSecoesPorPolo(id);
        List<Zona> zonas = zonaRepository.zonaPorPolo(id);
        return poloRepository.findById(id)
                .map(value -> ResponseEntity.ok(new TodosByPoloDto(qnt, value, zonas)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("todosPolos")
    public ResponseEntity<List<Long>> todosPolos() {
        List<Long> todosNumerosPolo = new ArrayList<>();
        for(Polo polo : poloRepository.poloOrdenada()){
            todosNumerosPolo.add(polo.getNumero());
        }
        return ResponseEntity.ok(todosNumerosPolo);
    }
// ZONAS
    @CrossOrigin
    @GetMapping("zona/{id}")
    public ResponseEntity<DetalhesZonaDto> zona(@PathVariable Long id) {
        Long qnt = secaoRepository.qntSecoesPorZona(id);
        return zonaRepository.findById(id)
                .map(value -> ResponseEntity.ok(new DetalhesZonaDto(value, qnt)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("zona/municipio/{id}")
    public ResponseEntity<List<MunicipiosByPoloDto>> municipioByZona(@PathVariable Long id) {
        return zonaRepository.findById(id)
                .map(value -> ResponseEntity.ok(MunicipiosByPoloDto.munPolo(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("zona/secao/{id}")
    public ResponseEntity<SecoesByPoloDto> secaoByZona(@PathVariable Long id) {
        Long qnt = secaoRepository.qntSecoesPorZona(id);
        return zonaRepository.findById(id)
                .map(value -> ResponseEntity.ok(new SecoesByPoloDto(qnt)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("zona/sede/{id}")
    public ResponseEntity<SedeByPoloDto> sedeByZona(@PathVariable Long id) {
        return zonaRepository.findById(id)
                .map(value -> ResponseEntity.ok(new SedeByPoloDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("zona/todos/{id}")
    public ResponseEntity<TodosByPoloDto> todosByZona(@PathVariable Long id) {
        Long qnt = secaoRepository.qntSecoesPorZona(id);
        //List<Zona> zonas = poloRepository.zonaPorPolo(id);
        return zonaRepository.findById(id)
                .map(value -> ResponseEntity.ok(new TodosByPoloDto(qnt, value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("todasZonas")
    public ResponseEntity<List<Long>> todosZonas() {
        List<Long> todosNumerosZona = new ArrayList<>();
        for(Zona zona : zonaRepository.zonaOrdenada()){
            todosNumerosZona.add(zona.getNumero());
        }
        return ResponseEntity.ok(todosNumerosZona);
    }

    @CrossOrigin
    @GetMapping("municipio/{id}")
    public ResponseEntity<DetalhesMunicipioDto> municipio(@PathVariable Long id) {
        Long qnt = secaoRepository.qntSecoesPorMunicipio(id);
        return municipioRepository.findById(id)
                .map(value -> ResponseEntity.ok(new DetalhesMunicipioDto(value,qnt)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @GetMapping("todosMunicipios")
    public ResponseEntity<List<DetalhesMunicipioDto>> todosMunicipios() {
        List<DetalhesMunicipioDto> detalhesMunicipioDtos = new ArrayList<DetalhesMunicipioDto>();
        for(Municipio municipio : municipioRepository.findAll()){
            detalhesMunicipioDtos.add(new DetalhesMunicipioDto(municipio));
        }
        return ResponseEntity.ok(detalhesMunicipioDtos);
    }
}
