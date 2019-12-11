package be.ehb.blog_post.model;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostDAO extends CrudRepository<BlogPost, Integer> {
}
