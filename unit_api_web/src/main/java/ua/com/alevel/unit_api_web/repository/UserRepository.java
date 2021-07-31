package ua.com.alevel.unit_api_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.unit_api_web.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { }
