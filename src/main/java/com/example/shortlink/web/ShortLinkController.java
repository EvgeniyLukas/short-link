package com.example.shortlink.web;

import com.example.shortlink.entity.Link;
import com.example.shortlink.entity.ShortLinkBuilder;
import com.example.shortlink.services.ShortLinkService;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ShortLinkController {

  private ShortLinkService service;

  private final ShortLinkBuilder builder;

  Integer shortLinkSize = 6;

  public ShortLinkController() {
    this.builder = new ShortLinkBuilder();
  }

  @Autowired
  public void setService(ShortLinkService service) {
    this.service = service;
  }


  @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Link> createShortLink(@RequestBody Link link) {
    String generateLink = builder.generate(shortLinkSize);
    if (generateLink != null) {
      String shorterLink = URLDecoder.decode(link.getBaseLink(), Charset.defaultCharset());
      link = new Link(link.getId(), generateLink, shorterLink);
      return ResponseEntity.ok(service.save(link));
    } else {
      return null;
    }

  }

  @GetMapping("/{short_link}")
  public ResponseEntity<Link> read(@PathVariable("short_link") String shortLink) {
    Link readShortLink = service.read(shortLink);
    if (readShortLink == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(readShortLink);
    }
  }

}
