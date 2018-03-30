/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.util.List;

import static java.util.ServiceLoader.Provider;
import static java.util.ServiceLoader.load;
import static java.util.stream.Collectors.toList;

/**
 * @author Emil
 */
public interface ServiceLocator {

    static <E> E getService(Class<E> service) {
        return load(service).findFirst().orElseThrow();
    }

    static <E> List<E> getServices(Class<E> service) {
        return load(service).stream()
                .map(Provider::get)
                .collect(toList());
    }
}