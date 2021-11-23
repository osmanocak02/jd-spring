package com.cybertek.repository;

import com.cybertek.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Post, Long> {
}
