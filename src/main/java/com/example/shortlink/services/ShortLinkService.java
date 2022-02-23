package com.example.shortlink.services;

import com.example.shortlink.entity.Link;
import com.example.shortlink.repositiry.ShortLinkEntityImpl;
import com.example.shortlink.repositiry.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkService {

  //ShortLinkRepository repository;

  ShortLinkEntityImpl repository;

//  @Autowired
//  public void setRepository(ShortLinkRepository repository) {
//    this.repository = repository;
//  }

  public Link save(Link link) {
    repository.save(link);
    return link;
  }

  public Link read(String sLink) {
    return repository.findByShortLink(sLink);
  }
}
