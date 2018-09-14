package com.example.demo.repository;

import com.example.demo.entity.Nota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Serializable>, PagingAndSortingRepository<Nota,Serializable> {

    public abstract  Nota findByNombre (String nombre);
    public abstract List<Nota> findByTitulo(String titulo);
    public abstract Nota findByNombreAndTitulo(String nombre,String titulo);
    public abstract Nota findByNombreAndId(String nombre,Long id);

    public abstract Page<Nota> findAll(Pageable pageable);
}
