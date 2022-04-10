package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 접근 못하는 거 아님. 잘 됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
