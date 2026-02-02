package db;

import model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public void insert(Member member) {
        String sql = "INSERT INTO members (name, age, weight, membership) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setDouble(3, member.getWeight());
            ps.setBoolean(4, member.hasMembership());
            ps.executeUpdate();

            System.out.println("Member saved to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Member m = new Member(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("weight"),
                        rs.getBoolean("has_membership")
                );
                members.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members;

    }

    public boolean updateMember(int id, String name, int age, double weight, boolean membership) {
        String sql = "UPDATE member set name = ?, age = ?, weight = ?, membership = ? WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, weight);
            ps.setBoolean(4, membership);
            ps.setInt(5, id);

            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

    public boolean deleteMember(int id) {
        String sql = "DELETE FROM members WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Member> searchByName(String name) {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members WHERE name ILIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Member m = new Member(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("weight"),
                        rs.getBoolean("has_membership")
                );
                members.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members;
    }

    public List<Member> searchByWeightRange(double min, double max) {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members WHERE weight BETWEEN ? AND ? ORDER BY weight DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Member m = new Member(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("weight"),
                        rs.getBoolean("has_membership")
                );
                members.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members;
    }

    public List<Member> searchByMinWeight(double min) {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members WHERE weight >= ? ORDER BY weight DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Member m = new Member(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("weight"),
                        rs.getBoolean("has_membership")
                );
                members.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members;
    }
}
