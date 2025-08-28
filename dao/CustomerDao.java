package sales.dao;

import sales.entities.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDao{
    private final Connection conn;

    public CustomerDao(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Customer>selectAll() throws SQLException {
        if(conn == null){
            return null;
        }

        String select = "select * from customers";
        ArrayList<Customer> customers = new ArrayList<>();

        try(Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(select);){
            while (rs.next()){
                Customer customer = new Customer();

                customer.setId(rs.getInt("Customer_ID"));
                customer.setName(rs.getString("Customer_Name"));
                customer.setContact(rs.getString("Contact_Name"));
                customer.setAddress(rs.getString("Address"));
                customer.setCity(rs.getString("City"));
                customer.setPostCode(rs.getString("Post_Code"));
                customer.setCountry(rs.getString("Country"));

                customers.add(customer);
            }
        }catch (SQLException e){
            throw new SQLException("Cannot display customer" + e.getMessage());
        }
        return customers;
    }

    public boolean insert(Customer customer) throws SQLException{
        if(conn == null){
            return false;
        }

        String insert = "insert into customers(Customer_Name, Contact_Name, Address, City, Post_Code, Country)" + "values(?,?,?,?,?,?)";

        int index = 1;
        try(PreparedStatement ps = conn.prepareStatement(insert);){
            ps.setString(index++, customer.getName());
            ps.setString(index++, customer.getContact());
            ps.setString(index++, customer.getAddress());
            ps.setString(index++, customer.getCity());
            ps.setString(index++, customer.getPostCode());
            ps.setString(index++, customer.getCountry());

            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException e){
            throw new SQLException("Can not update customer" + e.getMessage());
        }

        return false;
    }

    public boolean update(int id, Customer customer) throws SQLException {
        if (conn == null) {
            return false;
        }

        String update = "UPDATE customers SET Customer_Name = ?, Contact_Name = ?, Address = ?, City = ?, Post_Code = ?, Country = ? WHERE Customer_ID = ?";
        int index = 1;

        try (PreparedStatement ps = conn.prepareStatement(update)) {
            ps.setString(index++, customer.getName());
            ps.setString(index++, customer.getContact());
            ps.setString(index++, customer.getAddress());
            ps.setString(index++, customer.getCity());
            ps.setString(index++, customer.getPostCode());
            ps.setString(index++, customer.getCountry());
            ps.setInt(index, id);

            return ps.executeUpdate() > 0; // nếu có ít nhất 1 dòng bị ảnh hưởng => thành công
        } catch (SQLException e) {
            throw new SQLException("Can not update customer" + e.getMessage());
        }
    }

    public boolean delete(int id) throws SQLException {
        if (conn == null) {
            return false;
        }

        String delete = "delete from customers where Customer_ID = ?";
        int index = 1;
        try (PreparedStatement ps = conn.prepareStatement(delete);) {
            ps.setInt(index++, id);

            if (ps.executeUpdate() > 0) {
                    return true;
            }
        } catch (SQLException e) {
            throw new SQLException("Can not delete customer" + e.getMessage());
        }
        return false;
        }
    }
