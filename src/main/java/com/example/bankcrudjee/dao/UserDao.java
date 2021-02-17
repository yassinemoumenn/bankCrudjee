package com.example.bankcrudjee.dao;


import com.example.bankcrudjee.model.User;
import com.example.bankcrudjee.model.Entreprise;
import com.example.bankcrudjee.model.Persone;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

        public void updateUser(User user) throws SQLException;
        public void deleteUser(int id) throws SQLException;
        public User selectUserType(String type);
        public List<User> allUser() throws SQLException;
        public void insertUserPersone(Persone persone) throws SQLException;
        public void insertUserEntreprise(Entreprise entreprise) throws SQLException;

    }

