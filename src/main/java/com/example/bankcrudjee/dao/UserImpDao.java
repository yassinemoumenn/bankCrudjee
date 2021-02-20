package com.example.bankcrudjee.dao;

import com.example.bankcrudjee.model.User;
import com.example.bankcrudjee.model.Persone;
import com.example.bankcrudjee.model.Entreprise;
import com.example.bankcrudjee.dao.UserDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.example.bankcrudjee.connection.connection.connect;


public class UserImpDao implements UserDao {


    private static final String INSERT_ENTRP = "INSERT INTO entreprise" + "  (entrepr_type, entrepr_solde, entrepr_nom  ,user_numero) VALUES (?, ?, ?, ?)";
    private static final String INSERT_PERSO = "INSERT INTO personal" + "  (pers_type, perso_nom, perso_prenom, user_numero, user_solde) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_SQL ="update application_web set user_type = ?,user_numero= ?, user_solde =? where user_id = ?";
    private static final String SELECT_USER_SQL ="select user_type,user_numero,user_solde from application_web where user_type =?";
    private static final String SELECT_ALL_USER ="select * from application_web";
    private static final String DELETE_USER_SQL ="delete from application_web where user_id = ?";

    public void insertUserEntreprise (Entreprise entreprise) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ENTRP)) {
            preparedStatement.setString(1, entreprise.getUserType());
            preparedStatement.setLong(2, entreprise.getNumeroUser());
            preparedStatement.setDouble(3, entreprise.getSolde());
            preparedStatement.setString(4, entreprise.getNom());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void insertUserPersone(Persone persone) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSO)) {
            preparedStatement.setString(1, persone.getUserType());
            preparedStatement.setLong(2, persone.getNumeroUser());
            preparedStatement.setDouble(3, persone.getSolde());
            preparedStatement.setString(4, persone.getNom());
            preparedStatement.setString(5, persone.getPrenom());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateUser(User user) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {
            statement.setString(1, user.getUserType());
            statement.setLong(2, user.getNumeroUser());
            statement.setDouble(3, user.getSolde());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        }

    }
    public void deleteUser(int id) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public User selectUserType(String type) {
        User user = null;
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);) {
            preparedStatement.setString(1, type);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String user_type = rs.getString("user_type");
                long user_numero = rs.getLong("user_numero");
                double user_solde = rs.getDouble("user_solde");
                user = new User(user_numero , user_solde, user_type);
            }
        } catch (SQLException e) {

        }
        return user;
    }
    public List<User> allUser() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
        {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                while (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    String user_type = rs.getString("user_type");
                    long user_numero = rs.getLong("user_numero");
                    double user_solde = rs.getDouble("user_solde");
                    users.add(new User(user_id, user_numero, user_solde, user_type));

                }
            }
            return users;
        }
    }



}
