package server.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TreeNodeDAO implements AbstractDAO<TreeNodeDTO> {
    private Properties properties;

    public TreeNodeDAO(Properties properties){
        this.properties = properties;
    }

    @Override
    public void create(TreeNodeDTO data) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSET INTO service(parentId,data) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {

            if (data.getParentId() == 0) {

                statement.setInt(1, 0);
                statement.setString(2, data.getData());
                statement.execute();

                ResultSet result = statement.getGeneratedKeys();

                if (result.next()) {
                    data.setId(result.getInt(1));
                    data.getTreeNode().setId(result.getInt(1));
                }

            } else {
                statement.setInt(1, data.getParentId());
                statement.setString(2, data.getData());
                statement.execute();

                ResultSet result = statement.getGeneratedKeys();
                if (result.next()){
                    data.getTreeNode().setId(result.getInt(1));
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Пока сделал метод, который возращает String.Нужно будет переделать метод для возврата объекта

    @Override
    public List<String> getRoot() {
        List<String> parent = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT data FROM service WHERE parentId = ?")) {
            statement.setInt(1,0);

            ResultSet result = statement.executeQuery();
            while (result.next()){
                final String data = result.getString("data");
                parent.add(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Пока сделал метод, который возращает String.Нужно будет переделать метод для возврата объекта

    @Override
    public List<String> getChildren(TreeNodeDTO object) {
        List<String> children = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT data FROM service WHERE parentId")){
            statement.setInt(1,object.getId());
            ResultSet result = statement.executeQuery();

            while (result.next()){
                final String data = result.getString("data");
                children.add(data);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return children;
    }

    private Connection getConnection(){
        final String url = properties.getProperty("url");
        final String user = properties.getProperty("user");
        final String password = properties.getProperty("password");
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
