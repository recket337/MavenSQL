package Crud;

import Entity.Subject;
import Entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectCrud implements Body<Subject> {
        @Override
        public void create(Subject obj, Connection connection) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO subjects (id, subject, hours)\n" + "VALUES (?, ?, ?)");

                preparedStatement.setInt(1,obj.getId());

                preparedStatement.setString(2,obj.getSubject());

                preparedStatement.setInt(3, obj.getHours());

                preparedStatement.execute();

                preparedStatement.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public Subject read(int id, Connection connection) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM subjects\n" + "WHERE id = ?");

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next())

                    return new Subject(id, resultSet.getString(2), resultSet.getInt(3));

                resultSet.close();

                preparedStatement.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }
            return null;
        }

        @Override
        public void update(Subject obj, Connection connection) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(

                        " UPDATE subjects\n" + "SET subject = ?,hours = ?\n" + "WHERE id = ?");

                preparedStatement.setString(1, obj.getSubject());

                preparedStatement.setInt(2, obj.getHours());

                preparedStatement.setInt(3, obj.getId());

                preparedStatement.executeUpdate();

                preparedStatement.close();

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

        @Override
        public void delete(int id, Connection connection) {
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM subjects WHERE id = ?");

                preparedStatement.setInt(1, id);

                preparedStatement.execute();

                preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
