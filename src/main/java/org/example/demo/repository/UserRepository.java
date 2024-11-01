package org.example.demo.repository;

import org.example.demo.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Spring Bean
public interface UserRepository extends JpaRepository<User, Integer> {
    // 添加分页和搜索方法
    Page<User> findByUserNameContainingIgnoreCaseOrUserEmailContainingIgnoreCaseOrUserPhoneContainingIgnoreCase(
            String userName, String userEmail, String userPhone, Pageable pageable);
}