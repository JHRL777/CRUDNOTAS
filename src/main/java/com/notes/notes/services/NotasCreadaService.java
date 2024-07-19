package com.notes.notes.services;

import com.notes.notes.models.Notascreada;
import com.notes.notes.repositorys.NotasCreadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NotasCreadaService {

    @Autowired
    private NotasCreadasRepository notasCreadasRepository;

    public List<Notascreada> todaNotas(){
        return (List<Notascreada>) notasCreadasRepository.findAll();
    }

    public Optional<Notascreada> notasId(Integer id){
        return notasCreadasRepository.findById(id);
    }

    public Notascreada guardarNota(Notascreada entity){
        entity.setFechaCreacion(new Date());
        entity.setFechaActualizacion(new Date());
        entity.setCompletado(false);
        return notasCreadasRepository.save(entity);
    }

    public Notascreada ActualizarNota(Notascreada entity){
        entity.setFechaActualizacion(new Date());
        return notasCreadasRepository.save(entity);
    }

    public void eliminarNota(Integer id){

        notasCreadasRepository.deleteById(id);
    }


}
