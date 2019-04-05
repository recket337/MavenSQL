package Crud;

import Entity.Pupil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PupilCrud implements Body<Pupil>{
    @Override
    public void create(Pupil obj, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pupils (id, firstname, lastname, avgmark)\n" + "VALUES (?, ?, ?, ?)");

            preparedStatement.setInt(1,obj.getId());

            preparedStatement.setString(2,obj.getFisrtName());

            preparedStatement.setString(3, obj.getLastName());

            preparedStatement.setInt(4, obj.getAvgMark());

            preparedStatement.execute();

            preparedStatement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Pupil read(int id, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pupils\n" + "WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())

                return new Pupil(id, resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));

            resultSet.close();

            preparedStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return null;
    }

    @Override
    public void update(Pupil obj, Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(

                    " UPDATE pupils\n" + "SET firstname = ?,lastname = ?,avgmark = ?\n" + "WHERE id = ?");

            preparedStatement.setString(1, obj.getFisrtName());

            preparedStatement.setString(2, obj.getLastName());

            preparedStatement.setInt(3, obj.getAvgMark());

            preparedStatement.setInt(4, obj.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id, Connection connection) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM pupils WHERE id = ?");

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
