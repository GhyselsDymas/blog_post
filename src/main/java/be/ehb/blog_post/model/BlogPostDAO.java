package be.ehb.blog_post.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogPostDAO extends CrudRepository<BlogPost, Integer> {

    @Query("SELECT b FROM BlogPost b ORDER BY b.date desc")
    Iterable<BlogPost> findAllByDate();
}
