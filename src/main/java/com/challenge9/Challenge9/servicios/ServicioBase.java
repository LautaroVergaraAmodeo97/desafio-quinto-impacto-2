package com.challenge9.Challenge9.servicios;

import java.util.List;

public interface ServicioBase <E>{

    List<E> findAll() throws Exception;
    E findById(long id) throws Exception;

    E guardar(E entity) throws Exception;

    E actualizar(E entity,long id) throws Exception;

    boolean borrar (long id) throws Exception;





}
