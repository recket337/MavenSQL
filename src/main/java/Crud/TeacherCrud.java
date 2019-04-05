package Crud;

import Entity.Pupil;
import Entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherCrud implements Body<Teacher>{
        @Override
        public void create(Teacher obj, Connection connection) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teachers (id, name, mainsubject, age)\n" + "VALUES (?, ?, ?, ?)");

                preparedStatement.setInt(1,obj.getId());

                preparedStatement.setString(2,obj.getName());

                preparedStatement.setString(3, obj.getMainSubject());

                preparedStatement.setInt(4, obj.getAge());

                preparedStatement.execute();

                preparedStatement.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public Teacher read(int id, Connection connection) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teachers\n" + "WHERE id = ?");

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next())

                    return new Teacher(id, resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));

                resultSet.close();

                preparedStatement.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }
            return null;
        }

        @Override
        public void update(Teacher obj, Connection connection) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(

                        " UPDATE teachers\n" + "SET name = ?,mainsubject = ?,age = ?\n" + "WHERE id = ?");

                preparedStatement.setString(1, obj.getName());

                preparedStatement.setString(2, obj.getMainSubject());

                preparedStatement.setInt(3, obj.getAge());

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

                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM teachers WHERE id = ?");

                preparedStatement.setInt(1, id);

                preparedStatement.execute();

                preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
