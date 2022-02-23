package com.example.shortlink.repositiry;

import com.example.shortlink.entity.Link;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkRepository extends JpaRepository<Link, Long> {

  //Link findByShortLink(String shortLink);

}
