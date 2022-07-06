package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;



public class Util {

   //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
   //private static final String URL = "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
   //private static final String USERNAME = "kkolesov";
   //private static final String PASSWORD = "Maculatura133232*";
   //public static Connection getConnection() {
   //    Connection connection = null;
   //    try {
   //        Class.forName(DRIVER);
   //        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
   //        connection.setAutoCommit(false);
   //    } catch (SQLException | ClassNotFoundException e) {
   //        e.printStackTrace();
   //    }
   //    return connection;
   //}

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
                settings.put(Environment.USER, "kkolesov");
                settings.put(Environment.PASS, "Maculatura133232*");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Throwable e) {
                e.printStackTrace();
            }
        } else {
            sessionFactory.close();
        }
        return sessionFactory;
    }
}


