package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionFactory;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AbstractDAO<T> {
        protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
        private final Class<T> type;

        @SuppressWarnings("unchecked")
        public AbstractDAO() {
            this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }

        private String createSelectQuery(String field) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ");
            sb.append(" * ");
            sb.append(" FROM ");
            sb.append(type.getSimpleName());
            sb.append(" WHERE " + field + " =?");
            return sb.toString();
        }
        private String createSelectQueryforAll() {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ");
            sb.append(" * ");
            sb.append(" FROM ");
            sb.append(type.getSimpleName());
            return sb.toString();
        }

        private String createDeleteQuery(String field) {
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE ");
            sb.append(" FROM ");
            sb.append(type.getSimpleName());
            sb.append(" WHERE " + field + " =?");
            return sb.toString();
        }

        private String createUpdateQuery() {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append(type.getSimpleName());
            sb.append(" SET ");
            for (Field field: type.getDeclaredFields()) {
                sb.append(field.getName()+"=?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(" WHERE id=?");
            return sb.toString();
        }

        private String createInsertQuery() {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ");
            sb.append(type.getSimpleName());
            sb.append(" VALUES( ");
            for (int i=0; i<type.getDeclaredFields().length-1; i++) {
                sb.append("?,");
            }
            sb.append("?)");
            return sb.toString();
        }
/**
   * Metoda findAll() este o metodă esențială în cadrul clasei AbstractDAO și are rolul
 * de a recupera toate înregistrările din tabela asociată clasei type. Această metodă urmărește
 * un flux bine definit pentru a obține și a returna rezultatele dorite.
*/
        public ArrayList<T> findAll() {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            String query = createSelectQueryforAll();
            ArrayList<T> rez= new ArrayList<>();
            try {
                connection = ConnectionFactory.getConnection();
                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    T instance = type.getDeclaredConstructor().newInstance();
                    for (Field field : type.getDeclaredFields()) {
                        String fieldName = field.getName();
                        Object value = resultSet.getObject(fieldName);
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                        Method setter = propertyDescriptor.getWriteMethod();
                        setter.invoke(instance, value);
                    }
                    rez.add(instance);
                }

            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
            } catch (IntrospectionException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionFactory.close(resultSet);
                ConnectionFactory.close(statement);
                ConnectionFactory.close(connection);
            }
            return rez ;
        }
/**
   * Metoda deleteById(int id) este responsabilă de ștergerea unei înregistrări din
 * tabela asociată clasei type, utilizând identificatorul specificat id. Această metodă
 * urmează un flux bine definit pentru a executa ștergerea și returna rezultatul acesteia.
  */
        public int  deleteById(int id) {
            Connection connection = null;
            PreparedStatement statement = null;
            int resultSet = 0;
            String query = createDeleteQuery("id");
            try {
                connection = ConnectionFactory.getConnection();
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                resultSet=statement.executeUpdate();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteById " + e.getMessage());
            } finally {
                ConnectionFactory.close(statement);
                ConnectionFactory.close(connection);
            }
            return resultSet;
        }
        /**
   * Metoda findById(int id) este responsabilă de găsirea și returnarea unei înregistrări
         * din tabela asociată clasei type, utilizând identificatorul specificat id. Această
         * metodă urmează un flux bine definit pentru a executa interogarea și a returna rezultatul.
         * */
        public T findById(int id) {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            String query = createSelectQuery("id");
            try {
                connection = ConnectionFactory.getConnection();
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                return createObjects(resultSet).get(0);
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
            } finally {
                ConnectionFactory.close(resultSet);
                ConnectionFactory.close(statement);
                ConnectionFactory.close(connection);
            }
            return null;
        }

    /**Metoda createObjects(ResultSet resultSet) este responsabilă de transformarea rezultatului
     * obținut dintr-un obiect ResultSet într-o listă de obiecte de tip T. Această metodă utilizează
     * informații despre clasa T și rezultatul interogării pentru a crea și inițializa obiecte
     * corespunzătoare înregistrărilor găsite.
     * */

    private List<T> createObjects(ResultSet resultSet) {
            List<T> list = new ArrayList<T>();
            Constructor[] ctors = type.getDeclaredConstructors();
            Constructor ctor = null;
            for (int i = 0; i < ctors.length; i++) {
                ctor = ctors[i];
                if (ctor.getGenericParameterTypes().length == 0)
                    break;
            }
            try {
                while (resultSet.next()) {
                    ctor.setAccessible(true);
                    T instance = (T)ctor.newInstance();
                    for (Field field : type.getDeclaredFields()) {
                        String fieldName = field.getName();
                        Object value = resultSet.getObject(fieldName);
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                        Method method = propertyDescriptor.getWriteMethod();
                        method.invoke(instance, value);
                    }
                    list.add(instance);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            return list;
        }

    /**Metoda insert(T t) este utilizată pentru a insera un obiect de tip T
     * în baza de date. Aceasta primește ca parametru obiectul pe care dorim să-l
     * inserăm și îl adaugă în baza de date utilizând valorile câmpurilor obiectului.
     * */

        public int insert(T t) {
            Connection connection = null;
            PreparedStatement statement = null;
            int resultSet = 0;
            String query = createInsertQuery();
            try {
                connection = ConnectionFactory.getConnection();
                statement = connection.prepareStatement(query);
                int index=1;
                for (Field field : t.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj;
                    obj = field.get(t);
                    statement.setObject(index, obj);
                    index++;
                }
                resultSet = statement.executeUpdate();
            } catch (SQLException | IllegalAccessException e) {
                LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
            } finally {
                ConnectionFactory.close(statement);
                ConnectionFactory.close(connection);
            }
            return resultSet;
        }

    /**Metoda update(T t) este utilizată pentru a actualiza un obiect de tip T în baza de date.
     * Aceasta primește ca parametru obiectul pe care dorim să-l actualizăm și efectuează
     * modificările corespunzătoare în baza de date.
     * */
        public int  update(T t) {
            Connection connection = null;
            PreparedStatement statement = null;
            int resultSet = 0;
            String query = createUpdateQuery();
            try {
                connection = ConnectionFactory.getConnection();
                statement = connection.prepareStatement(query);
                int index=1;
                Class<?> objT = t.getClass();
                Field[] fields = objT.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    Object obj;
                    obj = fields[i].get(t);
                    statement.setObject(index, obj);
                    index++;
                }
                statement.setObject(5, fields[0].get(t));
                resultSet = statement.executeUpdate();
            } catch (SQLException | IllegalAccessException e) {
                LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
            } finally {
                ConnectionFactory.close(statement);
                ConnectionFactory.close(connection);
            }
            return resultSet;
        }

    /**Metoda makeTable(List<T> list) este utilizată pentru a crea și returna un obiect JTable
     * pe baza unei liste de obiecte de tip T. Această metodă este utilă în contextul creării
     * unei interfețe grafice pentru afișarea datelor din lista într-un tabel.
     * */
        public JTable makeTable(List< T> list) {
            JTable t ;
            Class<?> objT = list.get(0).getClass();
            Field[] fields = objT.getDeclaredFields();
            Vector columnNames = new Vector(fields.length);

            for (int i = 0; i < fields.length; i++) {
                columnNames.addElement(fields[i].getName());
            }
            Vector<Vector<Object>> data = new Vector<>();
            for (T obj : list) {
                Vector<Object> rowData = new Vector(fields.length);
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    try {
                        rowData.addElement(fields[i].get(obj));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                data.addElement(rowData);
            }
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            t = new JTable(model);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            t.setDefaultRenderer(Object.class, renderer);

            return t;
        }
    }

