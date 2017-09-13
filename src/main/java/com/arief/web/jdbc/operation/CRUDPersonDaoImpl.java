package com.arief.web.jdbc.operation;

import com.arief.web.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDPersonDaoImpl implements PersonDAO {

    private Connection con ;

    public CRUDPersonDaoImpl(Connection con) {
        this.con = con;
    }

    public void save(Person p) {
        int eksekusi = 0;
        try {
            PreparedStatement pst = con.prepareStatement("insert into person values (?,?,?)");


            pst.setInt(1,p.getKode());
            pst.setString(2,p.getNama());
            pst.setString(3,p.getGender());

            eksekusi = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.err.println("Rows Affected : " + eksekusi);
        }
    }

    public List<Person> getAll() {
        List<Person> data = new ArrayList<Person>();
        try {
            String sql = "select * from person";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
              int kode = rs.getInt("kode");
              String nama = rs.getString("nama");
              String gender = rs.getString("gender");

                data.add(new Person(kode,nama,gender));
            }

            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person getOne(int kode) {
        Person p = null;
        try {
            String sql = "select * from person where kode = ? ";
            PreparedStatement pst = con.prepareStatement(sql);


            pst.setInt(1,kode);

            ResultSet rs  = pst.executeQuery();

            if(rs.next()){
                int kodePerson = rs.getInt("kode");
                String namaPerson =  rs.getString("nama");
                String genderPerson = rs.getString("gender");
                p = new Person(kodePerson,namaPerson,genderPerson);
            }
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int kode) {
        int rAffec = 0 ;

        try {
            Statement st = con.createStatement();
            rAffec = st.executeUpdate("delete from person where kode = '"+kode+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.err.println("Rows Affected : " + rAffec);
        }
    }

    public void update(int oldKode, Person newPerson) {

       int rAffect = 0 ;

       Person findOne = getOne(oldKode);


       findOne.setNama(newPerson.getNama());
       findOne.setGender(newPerson.getGender());

       String sql = "update person set nama = ? , gender = ? where kode = ? ";

        try {
            PreparedStatement pst = con.prepareStatement(sql);


            pst.setString(1,newPerson.getNama());
            pst.setString(2,newPerson.getGender());
            pst.setInt(3,oldKode);

            rAffect = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.err.println("Rows Affected : " + rAffect);
        }
    }
}
