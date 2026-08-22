package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentForm extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, nameLabel, courseLabel, marksLabel;
    JTextField idText, nameText, courseText, marksText;
    JButton insertButton, viewButton, updateButton, deleteButton, clearButton;
    JTextArea outputArea;

    String url = "jdbc:mysql://localhost:3306/college"
            + "?characterEncoding=UTF-8&useSSL=false";

    String user = "root";
    String password = "root";

    public StudentForm() {

        setTitle("Student CRUD Operation");
        setSize(650, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(
                new Color(255, 220, 230)
        );

        titleLabel = new JLabel("STUDENT CRUD OPERATION");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(170, 20, 350, 30);
        add(titleLabel);

        idLabel = new JLabel("Student ID:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 14));
        idLabel.setBounds(50, 80, 100, 30);
        add(idLabel);

        idText = new JTextField();
        idText.setBounds(160, 80, 200, 30);
        add(idText);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setBounds(50, 120, 100, 30);
        add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(160, 120, 200, 30);
        add(nameText);

        courseLabel = new JLabel("Course:");
        courseLabel.setFont(new Font("Arial", Font.BOLD, 14));
        courseLabel.setBounds(50, 160, 100, 30);
        add(courseLabel);

        courseText = new JTextField();
        courseText.setBounds(160, 160, 200, 30);
        add(courseText);

        marksLabel = new JLabel("Marks:");
        marksLabel.setFont(new Font("Arial", Font.BOLD, 14));
        marksLabel.setBounds(50, 200, 100, 30);
        add(marksLabel);

        marksText = new JTextField();
        marksText.setBounds(160, 200, 200, 30);
        add(marksText);

        insertButton = new JButton("Insert");
        insertButton.setBounds(400, 80, 100, 35);
        insertButton.setBackground(new Color(255, 105, 150));
        insertButton.setForeground(Color.WHITE);
        add(insertButton);

        viewButton = new JButton("View");
        viewButton.setBounds(400, 125, 100, 35);
        viewButton.setBackground(new Color(255, 182, 193));
        add(viewButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(400, 170, 100, 35);
        updateButton.setBackground(new Color(255, 182, 193));
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(400, 215, 100, 35);
        deleteButton.setBackground(new Color(255, 182, 193));
        add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(400, 260, 100, 35);
        add(clearButton);

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(50, 320, 550, 150);
        add(scrollPane);

        insertButton.addActionListener(this);
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    private Connection getConnection()
            throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(
                url,
                user,
                password
        );
    }

    private void insertRecord() {

        try {

            int id = Integer.parseInt(idText.getText());
            String name = nameText.getText();
            String course = courseText.getText();
            int marks = Integer.parseInt(marksText.getText());

            String sql = "INSERT INTO student "
                    + "(id, name, course, marks) "
                    + "VALUES (?, ?, ?, ?)";

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setInt(4, marks);

            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Record inserted successfully!"
                );
            }

            ps.close();
            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    private void viewRecords() {

        try {

            Connection con = getConnection();
            Statement st = con.createStatement();

            String sql = "SELECT * FROM student";

            ResultSet rs = st.executeQuery(sql);

            outputArea.setText("");

            outputArea.append(
                    "ID\tNAME\tCOURSE\tMARKS\n"
            );

            outputArea.append(
                    "----------------------------------------\n"
            );

            while (rs.next()) {

                outputArea.append(
                        rs.getInt("id")
                        + "\t"
                        + rs.getString("name")
                        + "\t"
                        + rs.getString("course")
                        + "\t"
                        + rs.getInt("marks")
                        + "\n"
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    private void updateRecord() {

        try {

            int id = Integer.parseInt(idText.getText());
            String name = nameText.getText();
            String course = courseText.getText();
            int marks = Integer.parseInt(marksText.getText());

            String sql = "UPDATE student "
                    + "SET name=?, course=?, marks=? "
                    + "WHERE id=?";

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, marks);
            ps.setInt(4, id);

            int result = ps.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Record updated successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student ID not found!"
                );
            }

            ps.close();
            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    private void deleteRecord() {

        try {

            int id = Integer.parseInt(idText.getText());

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete?",
                    "Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice != JOptionPane.YES_OPTION) {
                return;
            }

            String sql = "DELETE FROM student WHERE id=?";

            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Record deleted successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student ID not found!"
                );
            }

            ps.close();
            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    private void clearFields() {

        idText.setText("");
        nameText.setText("");
        courseText.setText("");
        marksText.setText("");
        outputArea.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == insertButton) {
            insertRecord();

        } else if (e.getSource() == viewButton) {
            viewRecords();

        } else if (e.getSource() == updateButton) {
            updateRecord();

        } else if (e.getSource() == deleteButton) {
            deleteRecord();

        } else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}