package dao.impl;

import dao.api.UserDAO;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Optional;
import entity.dao.User;

/*
 * Implementation of DAO layer of User using SQL Database
 */
@Singleton
public class UserSQL implements UserDAO {
    private JPAApi jpaApi;

    @Inject
    public UserSQL(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public User persist(User user){
        return jpaApi.em().merge(user);
    }

    @Override
    public Optional<User> getByEmail(String email){
        Query q = jpaApi.em().createQuery("select user from User user where user.email = :email");
        q.setParameter("email", email);

        try {
            return Optional.of((User) q.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> getByEmailAndPassword(String email, String password){
        Query q = jpaApi.em().createQuery("select user from User user " +
                "where user.email = :email and user.passwordDigest = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);

        try {
            return Optional.of((User) q.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
