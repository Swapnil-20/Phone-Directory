package com.Project.PhoneDirectory.repository;

import com.Project.PhoneDirectory.model.UserDetails;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class  UserDetailsRepository{

    UserDetailsRepository(){
        System.out.print("***** User Details Repository *****");
    }

    @PersistenceUnit(unitName = "phonedirectory")
    private EntityManagerFactory entityManagerFactory;

    public List<UserDetails> getAllUserDetails(Integer userId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<UserDetails> query = entityManager.createQuery("SELECT p from UserDetails p JOIN FETCH p.userLogin puser WHERE puser.id = :userId",UserDetails.class);
        query.setParameter("userId", userId);
        List<UserDetails> result = query.getResultList();
        return result;
    }

    public void createDetails(UserDetails newEntry){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(newEntry);
            transaction.commit();
        }catch(Exception e){
            System.out.print(e.getMessage());
            transaction.rollback();
        }

    }
    public void deleteDetails(Integer userId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            UserDetails userDetails = entityManager.find(UserDetails.class, userId);
            entityManager.remove(userDetails);
            transaction.commit();
        }catch(Exception e){
            System.out.print(e.getMessage());
            transaction.rollback();
        }
    }

    public UserDetails getPost(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(UserDetails.class, userId);
    }


}
