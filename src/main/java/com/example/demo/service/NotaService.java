package com.example.demo.service;

import com.example.demo.converter.Convertidor;
import com.example.demo.entity.Nota;
import com.example.demo.model.MNota;
import com.example.demo.repository.NotaRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private Convertidor convertidor;

//Log es org.apache.juli.logging.Log;
    private static final Log logger = LogFactory.getLog(NotaService.class);

    public boolean crear(Nota nota){
        logger.info("Creando Nota ...");
        try {

            notaRepository.save(nota);
            logger.info("Nota Creada ...");
            return true;
        }catch (Exception e){
            logger.error("error en Creacion de Nota ...");
            return false;
        }
    }



    public boolean actualizar(Nota nota){
        try {

            notaRepository.save(nota);
            return true;
        }catch (Exception e){

            return false;
        }
    }

    public boolean borrar(String nombre,long id){
        try {
           Nota nota =  notaRepository.findByNombreAndId(nombre,id);
           notaRepository.delete(nota);
           return true;
        }catch (Exception e){

            return false;
        }
    }

    public List<MNota> obtener(){
       // List<MNota> notas = null;
       //List<Nota> notasEn = notaRepository.findAll();
        return  convertidor.convertirLista(notaRepository.findAll());
    }


    public MNota obtenerPorNombreTitulo(String nombre,String titulo){
        return new MNota(notaRepository.findByNombreAndTitulo(nombre, titulo));
    }

    public List<MNota> obtenerTitulo(String titulo){
        return  convertidor.convertirLista(notaRepository.findByTitulo(titulo));
    }



    public MNota obtenerPorNombre(String nombre){
        return new MNota(notaRepository.findByNombre(nombre));
    }

    public List<MNota> obtenerPorPaginacion(Pageable pageable){
        return convertidor.convertirLista(notaRepository.findAll(pageable).getContent());
    }
}
