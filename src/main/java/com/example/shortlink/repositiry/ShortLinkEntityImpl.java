package com.example.shortlink.repositiry;

import com.example.shortlink.entity.Link;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShortLinkEntityImpl implements ShortLinkEntity {

List<Link> links = new ArrayList<>();

  @Override
  public void save(Link link) {
    links.add(link);
  }

  @Override
  public Link update(Link link) {
    return links.set(link.getId().intValue(), link);
  }

  @Override
  public Link findById(Long id) {
    return links.get(id.intValue());
  }

  @Override
  public List<Link> findAll() {
    return null;
  }

  public Link findByShortLink(String sLink) {
    return null;
  }
}
