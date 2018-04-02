/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
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
