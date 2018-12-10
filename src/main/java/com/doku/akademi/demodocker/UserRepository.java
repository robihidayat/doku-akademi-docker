package com.doku.akademi.demodocker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DemoDockerApplication.Users, Long> {
    /**
     *
     * @param userName
     * @return
     */
    DemoDockerApplication.Users findByUserName(String userName);

}