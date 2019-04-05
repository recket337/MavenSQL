import Crud.PupilCrud;
import Entity.Pupil;

import java.sql.*;


public class Main {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/school";

    static final String USER = "postgres";

    static final String PASS = "123";

    public static Connection connect() {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(DB_URL, USER, PASS);


        } catch (Exception e) {

            System.out.println("Problems with connection");

            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {

/*        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connected");

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("select * from pupils");
            int i = 1;
            while (result.next()) {
                System.out.println("#" + i + " - " + result.getInt("id") + " " + result.getString(2)
                        + " " + result.getString("lastname"));
            }

        } catch (Exception e) {

            System.out.println("Problems with connection");

            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/

        Pupil pupil = new Pupil (2, "Vova", "Putin", 4);
       Pupil pupil2 = new Pupil (2, "Dima", "Medvedev", 4);

        PupilCrud pupilCrud = new PupilCrud();

        pupilCrud.create(pupil,connect());

        pupilCrud.update(pupil2,connect());

        pupilCrud.read(2);

        pupilCrud.delete(2, connect());




        try {
            connect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}