package studentresumeform;

import javax.swing.*;
import java.awt.*;

public class StudentResumeForm extends JFrame {

    JTextField txtName, txtDOB, txtEmail, txtPhone, txtCGPA;
    JComboBox<String> cbDepartment, cbEducation;
    JTextArea txtResume;

    JRadioButton male, female, other;

    JCheckBox java, python, cpp, html, sql;
    JCheckBox english, hindi, marathi;

    JList<String> hobbyList;

    JButton submit, clear;

    public StudentResumeForm() {

        setTitle("My Resume (S113)");
        setSize(550, 780);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color pink = Color.decode("#FFB6C1");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(pink);

        JLabel heading = new JLabel("My Resume (S113)");
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBounds(160, 15, 250, 30);
        panel.add(heading);

        JLabel l1 = new JLabel("Full Name:");
        l1.setBounds(30, 60, 120, 25);
        panel.add(l1);

        txtName = new JTextField();
        txtName.setBounds(180, 60, 300, 25);
        panel.add(txtName);

        JLabel l2 = new JLabel("Gender:");
        l2.setBounds(30, 100, 120, 25);
        panel.add(l2);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        male.setBackground(pink);
        female.setBackground(pink);
        other.setBackground(pink);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(other);

        male.setBounds(180, 100, 70, 25);
        female.setBounds(260, 100, 90, 25);
        other.setBounds(360, 100, 70, 25);

        panel.add(male);
        panel.add(female);
        panel.add(other);

        JLabel l3 = new JLabel("Date of Birth:");
        l3.setBounds(30, 140, 120, 25);
        panel.add(l3);

        txtDOB = new JTextField();
        txtDOB.setBounds(180, 140, 300, 25);
        panel.add(txtDOB);

        JLabel l4 = new JLabel("Email:");
        l4.setBounds(30, 180, 120, 25);
        panel.add(l4);

        txtEmail = new JTextField();
        txtEmail.setBounds(180, 180, 300, 25);
        panel.add(txtEmail);

        JLabel l5 = new JLabel("Phone:");
        l5.setBounds(30, 220, 120, 25);
        panel.add(l5);

        txtPhone = new JTextField();
        txtPhone.setBounds(180, 220, 300, 25);
        panel.add(txtPhone);

        JLabel l6 = new JLabel("Department:");
        l6.setBounds(30, 260, 120, 25);
        panel.add(l6);

        cbDepartment = new JComboBox<>(new String[]{
                "Computer", "IT", "Mechanical", "Civil", "Electronics"
        });
        cbDepartment.setBounds(180, 260, 300, 25);
        panel.add(cbDepartment);

        JLabel l7 = new JLabel("Education:");
        l7.setBounds(30, 300, 120, 25);
        panel.add(l7);

        cbEducation = new JComboBox<>(new String[]{
                "High School", "Diploma", "Graduate", "Post Graduate"
        });
        cbEducation.setBounds(180, 300, 300, 25);
        panel.add(cbEducation);

        JLabel l8 = new JLabel("CGPA:");
        l8.setBounds(30, 340, 120, 25);
        panel.add(l8);

        txtCGPA = new JTextField();
        txtCGPA.setBounds(180, 340, 300, 25);
        panel.add(txtCGPA);

        JLabel l9 = new JLabel("Skills:");
        l9.setBounds(30, 380, 120, 25);
        panel.add(l9);

        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        cpp = new JCheckBox("C++");
        html = new JCheckBox("HTML");
        sql = new JCheckBox("SQL");

        java.setBackground(pink);
        python.setBackground(pink);
        cpp.setBackground(pink);
        html.setBackground(pink);
        sql.setBackground(pink);

        java.setBounds(180, 380, 70, 25);
        python.setBounds(250, 380, 80, 25);
        cpp.setBounds(340, 380, 70, 25);
        html.setBounds(180, 410, 70, 25);
        sql.setBounds(250, 410, 70, 25);

        panel.add(java);
        panel.add(python);
        panel.add(cpp);
        panel.add(html);
        panel.add(sql);

        JLabel l10 = new JLabel("Languages:");
        l10.setBounds(30, 450, 120, 25);
        panel.add(l10);

        english = new JCheckBox("English");
        hindi = new JCheckBox("Hindi");
        marathi = new JCheckBox("Marathi");

        english.setBackground(pink);
        hindi.setBackground(pink);
        marathi.setBackground(pink);

        english.setBounds(180, 450, 90, 25);
        hindi.setBounds(280, 450, 70, 25);
        marathi.setBounds(360, 450, 90, 25);

        panel.add(english);
        panel.add(hindi);
        panel.add(marathi);

        JLabel l11 = new JLabel("Hobbies:");
        l11.setBounds(30, 490, 120, 25);
        panel.add(l11);

        String hobbies[] = {"Reading", "Coding", "Music", "Sports", "Travel"};
        hobbyList = new JList<>(hobbies);
        JScrollPane hobbyPane = new JScrollPane(hobbyList);
        hobbyPane.setBounds(180, 490, 300, 70);
        panel.add(hobbyPane);

        JLabel l12 = new JLabel("Resume:");
        l12.setBounds(30, 580, 120, 25);
        panel.add(l12);

        txtResume = new JTextArea();
        JScrollPane resumePane = new JScrollPane(txtResume);
        resumePane.setBounds(180, 580, 300, 70);
        panel.add(resumePane);

        submit = new JButton("Submit");
        clear = new JButton("Clear");

        submit.setBounds(110, 670, 120, 35);
        clear.setBounds(290, 670, 120, 35);

        panel.add(submit);
        panel.add(clear);

        submit.addActionListener(e -> {

            String gender = "";
            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            else if (other.isSelected())
                gender = "Other";

            String skills = "";
            if (java.isSelected()) skills += "Java ";
            if (python.isSelected()) skills += "Python ";
            if (cpp.isSelected()) skills += "C++ ";
            if (html.isSelected()) skills += "HTML ";
            if (sql.isSelected()) skills += "SQL ";

            String language = "";
            if (english.isSelected()) language += "English ";
            if (hindi.isSelected()) language += "Hindi ";
            if (marathi.isSelected()) language += "Marathi ";

            String hobby = hobbyList.getSelectedValuesList().toString();

            JOptionPane.showMessageDialog(this,
                    "Resume Submitted Successfully!\n\n"
                    + "Name : " + txtName.getText()
                    + "\nGender : " + gender
                    + "\nDOB : " + txtDOB.getText()
                    + "\nEmail : " + txtEmail.getText()
                    + "\nPhone : " + txtPhone.getText()
                    + "\nDepartment : " + cbDepartment.getSelectedItem()
                    + "\nEducation : " + cbEducation.getSelectedItem()
                    + "\nCGPA : " + txtCGPA.getText()
                    + "\nSkills : " + skills
                    + "\nLanguages : " + language
                    + "\nHobbies : " + hobby
                    + "\nResume : " + txtResume.getText());
        });

        clear.addActionListener(e -> {

            txtName.setText("");
            txtDOB.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtCGPA.setText("");
            txtResume.setText("");

            bg.clearSelection();

            java.setSelected(false);
            python.setSelected(false);
            cpp.setSelected(false);
            html.setSelected(false);
            sql.setSelected(false);

            english.setSelected(false);
            hindi.setSelected(false);
            marathi.setSelected(false);

            hobbyList.clearSelection();

            cbDepartment.setSelectedIndex(0);
            cbEducation.setSelectedIndex(0);
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentResumeForm();
    }
}