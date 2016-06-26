/**
 * Created by
 *
 * @author Franco Iturrizaga
 * @date 27/05/16 01:58 AM Copyright (C) 2016 All rights reserved.
 */

package com.iturrizaga.checkstyletest;

import java.util.*;

public class Preg3 {

  public static void main(String[] args) {
    TreeMap<Integer, Integer> mapa = new TreeMap<Integer, Integer>();
    Preg3 p = new Preg3();
    System.out.println(p.getNumMasPopular(5, new int[] {3, 4, 3, 5, 1, 3, 4, 5, 5, 5, 5, 5}));
  }

  public int getNumMasPopular(final int tamanio, final int... lista) {

    TreeMap<Integer, Integer> contador = new TreeMap<Integer, Integer>();

    for (int valor : lista) {
      int cantidad = contador.get(valor) != null ? contador.get(valor) : 0;
      contador.put(valor, ++cantidad);
    }

    int result = 0;

    SortedSet<Map.Entry<Integer, Integer>> sortedEntries = new TreeSet<Map.Entry<Integer, Integer>>(

        new Comparator<Map.Entry<Integer, Integer>>() {

          public int compare(final Map.Entry<Integer, Integer> o1,
                             final Map.Entry<Integer, Integer> o2) {
            int res = o2.getValue().compareTo(o1.getValue());

            return res != 0 ? res : 1;
          }
        }

    );

    sortedEntries.addAll(contador.entrySet());

    System.out.println("sortedEntries -> " + sortedEntries);

    return sortedEntries.iterator().next().getKey();

  }


}

