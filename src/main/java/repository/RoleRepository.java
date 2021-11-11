package repository;



import model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/airline";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public RoleRepository(){
        try {
            connection = DriverManager.getConnection(JdbcURl, username, password);
            statement = connection.createStatement();
            // System.out.println("S-a conectat");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void executeStatement(String execute){

        try{
            statement.execute(execute);

        }catch (SQLException e){
            System.out.println("Nu am reusit "+ execute);
        }
    }

    public void insert(Role role){
        String insert="";
        insert+="insert into role (title, description) values (";
        insert+=String.format("'%s','%s'",role.getTitle(),role.getDescription());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String id){
        String delete="";
        delete+=String.format("delete form role where id=%d");
        delete+=";";
        executeStatement(delete);


    }

    public void updateTitle(String old, String new_title){
        String update="";
        update+=String.format("update role set title='%s'",new_title);
        update+=String.format("where title='%s'",old);
        executeStatement(update);
    }

    public void updateDescription(int id, String desctiption){
        String update="";
        update+=String.format("update role set desription='%s'",desctiption);
        update+=String.format("where id=%d",id);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from role");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Role> allRoles(){

        ResultSet set=all();
        List<Role> roles=new ArrayList<>();
        try{
            while(set.next()){
                roles.add(new Role(set.getString(1),set.getString(2)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return roles;
    }

}
