package com.example.demo.converter;

import com.example.demo.entity.Nota;
import com.example.demo.model.MNota;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Convertidor {
    public List<MNota> convertirLista(List<Nota> notas){
        List<MNota> mnotas = new ArrayList<>();

        for (Nota nota : notas){
            mnotas.add(new MNota(nota));
        }
        return mnotas;
    }
}
