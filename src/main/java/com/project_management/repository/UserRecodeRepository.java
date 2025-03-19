package com.project_management.repository;

import com.project_management.dto.UserRecord;
import com.project_management.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRecodeRepository {
    @PersistenceContext
    private EntityManager em;

    public List<UserRecord>  findAll(){
        String sql = "SELECT id, email, password FROM user where email like :email";
        Query query = em.createNativeQuery(sql, UserRecord.class);
        query.setParameter("email", "a%");
        return (List<UserRecord>) query.getResultList();
    }
}
