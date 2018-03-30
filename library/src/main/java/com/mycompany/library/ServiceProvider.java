/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

import static java.util.ServiceLoader.*;
import static java.util.stream.Collectors.*;

/**
 *
 * @author Emil
 */
public class ServiceProvider {


    public static <E> E getService(Class<E> iface) {
        return load(iface).findFirst().orElse(null);
    }

    public static <E> List<E> getServices(Class<E> iface) {
        return load(iface).stream()
                .map(Provider::get)
                .collect(toList());
    }
}
