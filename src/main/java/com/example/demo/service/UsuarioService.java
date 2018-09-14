package com.example.demo.service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user =  usuarioRepository.findByUsuario(username);
        return new User(user.getUsuario(),user.getContrasena(),user.isActivo(),
                user.isActivo(),user.isActivo(),user.isActivo(),buildgrante(user.getRol()));
    }

    public List<GrantedAuthority> buildgrante(byte rol){
        String[] roles={"LECTOR","USUARIO","ADMINISTRADOR"};
        List<GrantedAuthority> auths = new ArrayList<>();

        for (int i =0 ;i<rol ;i++){
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }
        return  auths;
    }
}
