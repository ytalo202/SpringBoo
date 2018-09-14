package com.example.demo.repository;

import com.example.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {

    public abstract Usuario findByUsuario(String usuario);
}
