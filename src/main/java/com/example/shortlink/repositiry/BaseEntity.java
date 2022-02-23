package com.example.shortlink.repositiry;

import com.example.shortlink.entity.Link;
import java.util.List;

public interface BaseEntity<V, Id> {

  void save(V v);

  Link update(V v);

  V findById(Id id);

  List<V> findAll();
}
