import jdk.dynalink.beans.StaticClass;

import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Date;
import java.util.stream.Stream;
class grade{
    static char getgrade(double p){
        if(p>=91&&p<=100){
            return 'O';
        }
        else if(p>=81&&p<=90){
            return 'A';
        }
        else if(p>=71&&p<=80){
            return 'B';
        }
        else if(p>=61&&p<=70){
            return 'C';
        }
        else if(p>=51&&p<=60){
            return 'D';
        }
        else if(p>=41&&p<=50){
            return 'P';
        }
        else{
            return 'F';
        }
    }
}
//admin
class admin {
    static String user = "";
    static Connection con;

    admin(String user, Connection con) {
        this.user = user;
        this.con = con;
    }

    static void display() {
        try {

            Scanner sc = new Scanner(System.in);
            Statement st = con.createStatement();
            String qry = "select username,id from loginall where username=\"" + user + "\"";
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                System.out.println("Username: " + rs.getString(1));
                System.out.println("ID: " + rs.getInt(2));
            }
            int op = 0;
            while (op != 9) {
                System.out.println("\nSelect any option:\n1.Students List\n2.Staff\n3.View Result of Students\n4.Update Marks\n5.View Attendence\n6.Update attendence of student\n7.Add new Staff member \n8.Add new student\n9.Quit");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("\n\n********************Students List******************************");
                        String q = "select * from Studentallinfo";
                        ResultSet r = st.executeQuery(q);
                        while (r.next()) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Name: " + r.getString("Name") + " \nId: " + r.getInt("Id") + " \nAge:" + r.getInt("age") +" \nAddress: " + r.getString("address") + "\nStream: " + r.getString("Stream"));
                        }
                        System.out.println("------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("\n\n***************Staff List*******************");
                        String q1 = "select * from staffallinfo";
                        ResultSet r2 = st.executeQuery(q1);
                        while (r2.next()) {
                            System.out.println("------------------------------------------------");
                            System.out.println("Name: " + r2.getString("Name") + " \nId: " + r2.getInt("Id") + " \nAge:" + r2.getInt("Age") +" \nStubject: " + r2.getString("Subject") + "\nStream: " + r2.getString("Stream"));
                        }
                        System.out.println("------------------------------------------------");
                        break;
                    case 3:
                        try {
                            System.out.print("Enter the Id of student to check the result: ");
                            int sid = sc.nextInt();
                            System.out.println("\n\nThe Result of Student whose Id is " + sid);
                            String qury = "select Stream from studentallinfo where Id=" + sid;
                            //exp2
                            ResultSet r3 = st.executeQuery(qury);
                            r3.next();
                            String stream = r3.getString("Stream");

                            if (stream.equals("Medical")) {
                                qury = "select * from studentresult where Id=" + sid;
                                r3 = st.executeQuery(qury);
                                while (r3.next()) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                    System.out.println("Physics: " + r3.getInt("Physics") + " \nBiology:" + r3.getInt("Biology") + " \nChemistry: " + r3.getInt("Chemistry") + "\nComputer: " + r3.getInt("Computer"));
                                    System.out.println("Total: " + r3.getInt("Total"));
                                    double percentage = r3.getDouble("Percentage");
                                    System.out.println("Percentage: " + percentage);
                                    grade grd = new grade();
                                    char Grade = grd.getgrade(percentage);
                                    System.out.println("Grade: " + Grade);
                                    if (Grade == 'F') {
                                        System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                    } else {
                                        System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                    }
                                }
                            }
                            else if (stream.equals("Non-medical")) {
                                qury = "select * from studentresult where Id=" + sid;
                                r3 = st.executeQuery(qury);
                                while (r3.next()) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                    System.out.println("Physics: " + r3.getInt("Physics") + " \nMaths:" + r3.getInt("Maths") + " \nChemistry: " + r3.getInt("Chemistry") + "\nComputer: " + r3.getInt("Computer"));
                                    System.out.println("Total: " + r3.getInt("Total"));
                                    double percentage = r3.getDouble("Percentage");
                                    System.out.println("Percentage: " + percentage);
                                    grade grd = new grade();
                                    char Grade = grd.getgrade(percentage);
                                    System.out.println("Grade: " + Grade);
                                    if (Grade == 'F') {
                                        System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                    } else {
                                        System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                    }
                                }
                                System.out.println("------------------------------------------------");
                            }
                            else if (stream.equals("Commerce")) {
                                qury = "select * from studentresult where Id=" + sid;
                                r3 = st.executeQuery(qury);
                                while (r3.next()) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                    System.out.println("Accounts: " + r3.getInt("Accounts") + " \nBuiness Studies: " + r3.getInt("Buiness Studies") + " \nEconomics: " + r3.getInt("Economics") + "\nComputer: " + r3.getInt("Computer"));
                                    System.out.println("Total: " + r3.getInt("Total"));
                                    double percentage = r3.getDouble("Percentage");
                                    System.out.println("Percentage: " + percentage);
                                    grade grd = new grade();
                                    char Grade = grd.getgrade(percentage);
                                    System.out.println("Grade: " + Grade);
                                    if (Grade == 'F') {
                                        System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                    } else {
                                        System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                    }
                                }
                                System.out.println("------------------------------------------------");
                            }
                        } catch (Exception e) {
                            System.out.println("Student Not present in list");

                        }
                        break;
                    case 4:
                        System.out.print("Enter the Id of student to Update Student marks: ");
                        int sid = sc.nextInt();
                        System.out.println("------------------------------------------------");
                        System.out.println("Enter the subject whose marks need to be Updated:");

                        String Sub=sc.next();
                        PreparedStatement sm=con.prepareStatement("UPDATE studentresult set "+Sub+"=? where Id="+sid);
                        System.out.print("Enter marks to be updated: ");
                        int mrks=sc.nextInt();
                        if(mrks>100){
                            throw new Exception("Invailed marks");
                        }
                        sm.setInt(1,mrks);

                        sm.executeUpdate();
                        System.out.println("Marks Updated successfully");
                        System.out.println("------------------------------------------------");
                        break;

                    case 5:
                        System.out.print("Enter the Id of student to check the attendence: ");
                         sid = sc.nextInt();
                        System.out.println("\n\nThe Atendence of Student whose Id is " + sid);
                         String qury = "select * from studentallinfo where Id=" + sid;
                         ResultSet r3 = st.executeQuery(qury);
                        r3.next();
                        System.out.println("Name: "+r3.getString("Name")+"\nStream: "+r3.getString("Stream"));
                        System.out.println("------------------------------------------------");
                        qury = "select * from studentattendence where Id=" + sid;

                        r3 = st.executeQuery(qury);
                        r3.next();
                        System.out.println("Present: "+r3.getInt("Present")+"\nAbsent: "+r3.getInt("Absent")+"\nTotal:"+(r3.getInt("Present")+r3.getInt("Absent")));
                        int per=r3.getInt("Percentage");
                        System.out.println("Percentage: "+per);
                        if(per<=75){
                            System.out.println("Your Attendence is low please focus on your studies");
                        }
                        else
                        {
                            System.out.println("your Attendence is good keep it up");
                        }
                        System.out.println("------------------------------------------------");
                    break;
                    case 6:
                        System.out.print("Enter the Id of student to Update Student Attendence: ");
                        sid = sc.nextInt();
                        System.out.println("------------------------------------------------");
                         sm=con.prepareStatement("UPDATE studentattendence set Present=?,Absent=? where Id="+sid);
                        System.out.println("Enter Number of classes present and Number of classes absent :- ");
                        System.out.println("No of classes attended: ");
                        int atn=sc.nextInt();
                        System.out.println("No of classes left: ");
                        int at=sc.nextInt();
                        sm.setInt(1,atn);
                        sm.setInt(2,at);
                        sm.executeUpdate();
                        System.out.println("Attendence Updated succesfully");
                        System.out.println("------------------------------------------------");
                        break;
                    case 7:
                        System.out.println("Adding a New Staff member");
                        System.out.println("------------------------------------------------");
                        qury="INSERT into staffallinfo (Name,Age, Subject, Stream) VALUE (?,?,?,?)";
                        System.out.println("Enter Name:");
                        String nam=sc.next();
                        System.out.println("Enter Age:");
                        int age=sc.nextInt();
                        System.out.println("Enter Subject:");
                        String sub = sc.next();
                        System.out.println("Enter Stream:");
                        String strm = sc.next();
                        sm=con.prepareStatement(qury);
                        sm.setString(1, nam);
                        sm.setInt(2,age );
                        sm.setString(3, sub);
                        sm.setString(4, strm);
                        sm.executeUpdate();
                        System.out.println("Staff member added succesfully");
                        qury="select Id from staffallinfo where Name=\""+nam+"\" and Subject=\""+sub+"\"";
                        r3 = st.executeQuery(qury);
                        r3.next();
                        System.out.println("ID genrate is:"+r3.getInt("Id"));
                        System.out.println("------------------------------------------------");
                        break;
                    case 8:
                        System.out.println("Adding a New Student");
                        System.out.println("------------------------------------------------");
                        qury="INSERT into studentallinfo (name, age, address, stream) VALUE (?,?,?,?)";
                        System.out.println("Enter Name:");
                         nam=sc.next();
                        System.out.println("Enter Age:");
                         age=sc.nextInt();
                        System.out.println("Enter Address:");
                        sub = sc.next();
                        System.out.println("Enter Stream:");
                        strm = sc.next();
                        sm=con.prepareStatement(qury);
                        sm.setString(1, nam);
                        sm.setInt(2,age );

                        sm.setString(3, sub);
                        sm.setString(4, strm);
                        sm.executeUpdate();
                        qury="select Id from studentallinfo where Name=\""+nam+"\" and Stream=\""+strm+"\"";
                        r3 = st.executeQuery(qury);
                        r3.next();
                        int id=r3.getInt("Id");
                        System.out.println("ID genrate is:"+id);
                        qury="INSERT into studentresult (name, id, physics, biology, maths, accounts, `buiness studies`, chemistry, computer, economics) VALUE (?,?,?,?,?,?,?,?,?,?)";
                        System.out.println("Enter Physcis marks:");
                        int phy=sc.nextInt();
                        System.out.println("Enter biology marks:");
                        int bio=sc.nextInt();
                        System.out.println("Enter Maths marks:");
                        int mat=sc.nextInt();
                        System.out.println("Enter accounts marks:");
                        int acu=sc.nextInt();
                        System.out.println("Enter Buiness studies marks:");
                        int bs=sc.nextInt();
                        System.out.println("Enter Chemistary marks:");
                        int chem=sc.nextInt();
                        System.out.println("Enter Computer marks:");
                        int comp=sc.nextInt();
                        System.out.println("Enter Economics marks:");
                        int eco=sc.nextInt();
                        sm=con.prepareStatement(qury);
                        sm.setString(1, nam);
                        sm.setInt(2,id );
                        sm.setInt(3,phy);
                        sm.setInt(4,bio);
                        sm.setInt(5,mat);
                        sm.setInt(6,acu);
                        sm.setInt(7,bs);
                        sm.setInt(8,chem);
                        sm.setInt(9,comp);
                        sm.setInt(10,eco);
                        sm.executeUpdate();
                        qury="INSERT into studentattendence (name, id, present, absent) VALUE (?,?,?,?)";
                        System.out.println("Enter Present:");
                        int pre = sc.nextInt();
                        System.out.println("Enter Absent:");
                        int ab = sc.nextInt();
                        sm=con.prepareStatement(qury);
                        sm.setString(1, nam);
                        sm.setInt(2,id);
                        sm.setInt(3, pre);
                        sm.setInt(4, ab);
                        sm.executeUpdate();
                        System.out.println("Staff member added succesfully");
                        System.out.println("------------------------------------------------");
                        break;
                 }
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}

//student
class student{
    static String user = "";
    static Connection con;

    student(String user, Connection con) {
        this.user = user;
        this.con = con;
    }
    static void display() {
        try {

            Scanner sc = new Scanner(System.in);
            Statement st = con.createStatement();
            String qry = "select username,id from loginall where username=\"" + user + "\"";
            ResultSet rs = st.executeQuery(qry);
            rs.next();
                System.out.println("Username: " + rs.getString(1));
                System.out.println("ID: " + rs.getInt(2));
               int id=rs.getInt("Id");


            int op = 0;
            while (op != 3) {
                System.out.println("\nSelect any option:\n1.View Result\n2.View Attendece\n3.Quit");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        try {
                            System.out.println("\n\nYoyr Result :");
                            String qury = "select Stream from studentallinfo where Id=" + id;
                            //exp2
                            ResultSet r3 = st.executeQuery(qury);
                            r3.next();
                            String stream = r3.getString("Stream");

                            if (stream.equals("Medical")) {
                                qury = "select * from studentresult where Id=" + id;
                                r3 = st.executeQuery(qury);
                                while (r3.next()) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                    System.out.println("Physics: " + r3.getInt("Physics") + " \nBiology:" + r3.getInt("Biology") + " \nChemistry: " + r3.getInt("Chemistry") + "\nComputer: " + r3.getInt("Computer"));
                                    System.out.println("Total: " + r3.getInt("Total"));
                                    double percentage = r3.getDouble("Percentage");
                                    System.out.println("Percentage: " + percentage);
                                    grade grd = new grade();
                                    char Grade = grd.getgrade(percentage);
                                    System.out.println("Grade: " + Grade);
                                    if (Grade == 'F') {
                                        System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                    } else {
                                        System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                    }
                                }
                            }
                            else if (stream.equals("Non-medical")) {
                                qury = "select * from studentresult where Id=" + id;
                                r3 = st.executeQuery(qury);
                                while (r3.next()) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                    System.out.println("Physics: " + r3.getInt("Physics") + " \nMaths:" + r3.getInt("Maths") + " \nChemistry: " + r3.getInt("Chemistry") + "\nComputer: " + r3.getInt("Computer"));
                                    System.out.println("Total: " + r3.getInt("Total"));
                                    double percentage = r3.getDouble("Percentage");
                                    System.out.println("Percentage: " + percentage);
                                    grade grd = new grade();
                                    char Grade = grd.getgrade(percentage);
                                    System.out.println("Grade: " + Grade);
                                    if (Grade == 'F') {
                                        System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                    } else {
                                        System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                    }
                                }
                                System.out.println("------------------------------------------------");
                            }
                            else if (stream.equals("Commerce")) {
                                qury = "select * from studentresult where Id=" + id;
                                r3 = st.executeQuery(qury);
                                while (r3.next()) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                    System.out.println("Accounts: " + r3.getInt("Accounts") + " \nBuiness Studies: " + r3.getInt("Buiness Studies") + " \nEconomics: " + r3.getInt("Economics") + "\nComputer: " + r3.getInt("Computer"));
                                    System.out.println("Total: " + r3.getInt("Total"));
                                    double percentage = r3.getDouble("Percentage");
                                    System.out.println("Percentage: " + percentage);
                                    grade grd = new grade();
                                    char Grade = grd.getgrade(percentage);
                                    System.out.println("Grade: " + Grade);
                                    if (Grade == 'F') {
                                        System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                    } else {
                                        System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                    }
                                }
                                System.out.println("------------------------------------------------");
                            }
                        } catch (Exception e) {
                            System.out.println("Student Not present in list");

                        }
                        break;

                    case 2:
                        System.out.println("\n\nYour Atendence  is: ");
                        String qury = "select * from studentallinfo where Id=" + id;
                        ResultSet r3 = st.executeQuery(qury);
                        r3.next();
                        System.out.println("Name: "+r3.getString("Name")+"\nStream: "+r3.getString("Stream"));
                        System.out.println("------------------------------------------------");
                        qury = "select * from studentattendence where Id=" + id;

                        r3 = st.executeQuery(qury);
                        r3.next();
                        System.out.println("Present: "+r3.getInt("Present")+"\nAbsent: "+r3.getInt("Absent")+"\nTotal:"+(r3.getInt("Present")+r3.getInt("Absent")));
                        int per=r3.getInt("Percentage");
                        System.out.println("Percentage: "+per);
                        if(per<=75){
                            System.out.println("Your Attendence is low please focus on your studies");
                        }
                        else
                        {
                            System.out.println("your Attendence is good keep it up");
                        }
                        System.out.println("------------------------------------------------");
                        break;
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

//Staff
class staff{
    static String user = "";
    static Connection con;
    staff(String user, Connection con) {
        this.user = user;
        this.con = con;
    }
        static void display () {
            try {

                Scanner sc = new Scanner(System.in);
                Statement st = con.createStatement();
                String qry = "select username,id from loginall where username=\"" + user + "\"";
                ResultSet rs = st.executeQuery(qry);
                rs.next();
                System.out.println("Username: " + rs.getString(1));
                System.out.println("ID: " + rs.getInt(2));
                int id=rs.getInt("Id");


                int op = 0;
                while (op != 7) {
                    System.out.println("\nSelect any option:\n1.List of students\n2.View Result of student\n3.Update Result Student\n4.View attendence of student\n5.Update Ateendence\n6.Add student into list\n7.Quit");
                    op = sc.nextInt();
                    switch (op) {
                        case 1:
                            System.out.println("\n\n********************Students List******************************");
                            String q = "select * from Studentallinfo";
                            ResultSet r = st.executeQuery(q);
                            while (r.next()) {
                                System.out.println("------------------------------------------------");
                                System.out.println("Name: " + r.getString("Name") + " \nId: " + r.getInt("Id") + " \nAge:" + r.getInt("age") +" \nAddress: " + r.getString("address") + "\nStream: " + r.getString("Stream"));
                            }
                            System.out.println("------------------------------------------------");
                            break;
                        case 2:
                            try {
                                System.out.print("Enter the Id of student to check the result: ");
                                int sid = sc.nextInt();
                                System.out.println("\n\nThe Result of Student whose Id is " + sid);
                                String qury = "select Stream from studentallinfo where Id=" + sid;
                                //exp2
                                ResultSet r3 = st.executeQuery(qury);
                                r3.next();
                                String stream = r3.getString("Stream");

                                if (stream.equals("Medical")) {
                                    qury = "select * from studentresult where Id=" + sid;
                                    r3 = st.executeQuery(qury);
                                    while (r3.next()) {
                                        System.out.println("------------------------------------------------");
                                        System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                        System.out.println("Physics: " + r3.getInt("Physics") + " \nBiology:" + r3.getInt("Biology") + " \nChemistry: " + r3.getInt("Chemistry") + "\nComputer: " + r3.getInt("Computer"));
                                        System.out.println("Total: " + r3.getInt("Total"));
                                        double percentage = r3.getDouble("Percentage");
                                        System.out.println("Percentage: " + percentage);
                                        grade grd = new grade();
                                        char Grade = grd.getgrade(percentage);
                                        System.out.println("Grade: " + Grade);
                                        if (Grade == 'F') {
                                            System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                        } else {
                                            System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                        }
                                    }
                                }
                                else if (stream.equals("Non-medical")) {
                                    qury = "select * from studentresult where Id=" + sid;
                                    r3 = st.executeQuery(qury);
                                    while (r3.next()) {
                                        System.out.println("------------------------------------------------");
                                        System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                        System.out.println("Physics: " + r3.getInt("Physics") + " \nMaths:" + r3.getInt("Maths") + " \nChemistry: " + r3.getInt("Chemistry") + "\nComputer: " + r3.getInt("Computer"));
                                        System.out.println("Total: " + r3.getInt("Total"));
                                        double percentage = r3.getDouble("Percentage");
                                        System.out.println("Percentage: " + percentage);
                                        grade grd = new grade();
                                        char Grade = grd.getgrade(percentage);
                                        System.out.println("Grade: " + Grade);
                                        if (Grade == 'F') {
                                            System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                        } else {
                                            System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                        }
                                    }
                                    System.out.println("------------------------------------------------");
                                }
                                else if (stream.equals("Commerce")) {
                                    qury = "select * from studentresult where Id=" + sid;
                                    r3 = st.executeQuery(qury);
                                    while (r3.next()) {
                                        System.out.println("------------------------------------------------");
                                        System.out.println("Name of Student: " + r3.getString("Name") + "\nId: " + r3.getInt("Id"));
                                        System.out.println("Accounts: " + r3.getInt("Accounts") + " \nBuiness Studies: " + r3.getInt("Buiness Studies") + " \nEconomics: " + r3.getInt("Economics") + "\nComputer: " + r3.getInt("Computer"));
                                        System.out.println("Total: " + r3.getInt("Total"));
                                        double percentage = r3.getDouble("Percentage");
                                        System.out.println("Percentage: " + percentage);
                                        grade grd = new grade();
                                        char Grade = grd.getgrade(percentage);
                                        System.out.println("Grade: " + Grade);
                                        if (Grade == 'F') {
                                            System.out.println("We are Very Sorry " + r3.getString("Name") + ". You are Failed this time");
                                        } else {
                                            System.out.println("Congratulations " + r3.getString("Name") + " You are Passes in Examinations");
                                        }
                                    }
                                    System.out.println("------------------------------------------------");
                                }
                            } catch (Exception e) {
                                System.out.println("Student Not present in list");

                            }
                            break;
                        case 3:
                            System.out.print("Enter the Id of student to Update Student marks: ");
                            int sid = sc.nextInt();
                            System.out.print("Enter the subject whose marks need to be Updated:");
                            System.out.println("------------------------------------------------");
                            String Sub=sc.next();
                            PreparedStatement sm=con.prepareStatement("UPDATE studentresult set "+Sub+"=? where Id="+sid);
                            System.out.println(sm);
                            System.out.print("Enter marks to be updated: ");
                            int mrks=sc.nextInt();
                            if(mrks>100){
                                throw new Exception("Invailed marks");
                            }
                            sm.setInt(1,mrks);

                            sm.executeUpdate();
                            System.out.println("Marks Updated successfully");
                            System.out.println("------------------------------------------------");
                            break;
                        case 4:
                            System.out.print("Enter the Id of student to check the attendence: ");
                            sid = sc.nextInt();
                            System.out.println("\n\nThe Atendence of Student whose Id is " + sid);
                            String qury = "select * from studentallinfo where Id=" + sid;
                            ResultSet r3 = st.executeQuery(qury);
                            r3.next();
                            System.out.println("Name: "+r3.getString("Name")+"\nStream: "+r3.getString("Stream"));
                            System.out.println("------------------------------------------------");
                            qury = "select * from studentattendence where Id=" + sid;

                            r3 = st.executeQuery(qury);
                            r3.next();
                            System.out.println("Present: "+r3.getInt("Present")+"\nAbsent: "+r3.getInt("Absent")+"\nTotal:"+(r3.getInt("Present")+r3.getInt("Absent")));
                            int per=r3.getInt("Percentage");
                            System.out.println("Percentage: "+per);
                            if(per<=75){
                                System.out.println("Your Attendence is low please focus on your studies");
                            }
                            else
                            {
                                System.out.println("your Attendence is good keep it up");
                            }
                            System.out.println("------------------------------------------------");
                            break;
                        case 5:
                            System.out.print("Enter the Id of student to Update Student Attendence: ");
                            sid = sc.nextInt();
                            System.out.println("------------------------------------------------");
                            sm=con.prepareStatement("UPDATE studentattendence set Present=?,Absent=? where Id="+sid);
                            System.out.print("Enter Number of classes present and Number of classes absent :- ");
                            System.out.println("No of classes attended: ");
                            int atn=sc.nextInt();
                            System.out.println("No of classes left: ");
                            int at=sc.nextInt();
                            sm.setInt(1,atn);
                            sm.setInt(2,at);
                            sm.executeUpdate();
                            System.out.println("Attendence Updated succesfully");
                            System.out.println("------------------------------------------------");
                            break;
                        case 6:
                            System.out.println("Adding a New Student");
                            System.out.println("------------------------------------------------");
                            qury="INSERT into studentallinfo (name, age, address, stream) VALUE (?,?,?,?)";
                            System.out.println("Enter Name:");
                            String nam=sc.next();
                            System.out.println("Enter Age:");
                            int age=sc.nextInt();
                            System.out.println("Enter Address:");
                            String su = sc.next();
                            System.out.println("Enter Stream:");
                            String strm = sc.next();
                            sm=con.prepareStatement(qury);
                            sm.setString(1, nam);
                            sm.setInt(2,id);

                            sm.setString(3, su);
                            sm.setString(4, strm);
                            sm.executeUpdate();
                            qury="select Id from studentallinfo where Name=\""+nam+"\" and Stream=\""+strm+"\"";
                            r3 = st.executeQuery(qury);
                            r3.next();
                            int i=r3.getInt("Id");
                            System.out.println("ID genrate is:"+i);
                            qury="INSERT into studentresult (name, id, physics, biology, maths, accounts, `buiness studies`, chemistry, computer, economics) VALUE (?,?,?,?,?,?,?,?,?,?)";
                            System.out.println("Enter Physcis marks:");
                            int phy=sc.nextInt();
                            System.out.println("Enter biology marks:");
                            int bio=sc.nextInt();
                            System.out.println("Enter Maths marks:");
                            int mat=sc.nextInt();
                            System.out.println("Enter accounts marks:");
                            int acu=sc.nextInt();
                            System.out.println("Enter Buiness studies marks:");
                            int bs=sc.nextInt();
                            System.out.println("Enter Chemistary marks:");
                            int chem=sc.nextInt();
                            System.out.println("Enter Computer marks:");
                            int comp=sc.nextInt();
                            System.out.println("Enter Economics marks:");
                            int eco=sc.nextInt();
                            sm=con.prepareStatement(qury);
                            sm.setString(1, nam);
                            sm.setInt(2,i );
                            sm.setInt(3,phy);
                            sm.setInt(4,bio);
                            sm.setInt(5,mat);
                            sm.setInt(6,acu);
                            sm.setInt(7,bs);
                            sm.setInt(8,chem);
                            sm.setInt(9,comp);
                            sm.setInt(10,eco);
                            sm.executeUpdate();
                            qury="INSERT into studentattendence (name, id, present, absent) VALUE (?,?,?,?)";
                            System.out.println("Enter Present:");
                            int pre = sc.nextInt();
                            System.out.println("Enter Absent:");
                            int ab = sc.nextInt();
                            sm=con.prepareStatement(qury);
                            sm.setString(1, nam);
                            sm.setInt(2,i);
                            sm.setInt(3, pre);
                            sm.setInt(4, ab);
                            sm.executeUpdate();
                            System.out.println("Student added succesfully");
                            System.out.println("------------------------------------------------");
                            break;
                    }

                }

            } catch (Exception e) {

            }
        }
    }
//login
class login {
   public static String U="";
    static boolean present(Connection con, String str) {
        try {
            Scanner sc = new Scanner(System.in);
            Statement st = con.createStatement();
            int flag = 0;
            System.out.println("you are loging in as "+str);
            System.out.print("Enter the User name: ");
            String user = sc.next();
            String qry = "select username from loginall where Profession=\""+str+"\"";
            ResultSet rs = st.executeQuery(qry);

            //check that the user exsits

            while (rs.next()) {
                if (user.equals(rs.getString(1))) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                throw new Exception("Username not found");
            }

            //---------------------------------------------
            //password
            System.out.print("Enter the password: ");
            String pass = sc.next();
            String qry2 = "select passcode from loginall where username=\""+user+"\"";
            ResultSet rs2 = st.executeQuery(qry2);
            flag = 0;
            while (rs2.next()) {
                if (pass.equals(rs2.getString(1))) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                throw new Exception("Password incorrect");
            }
            U=user;
            return true;
        }
        catch (Exception e ) {
            System.out.println(e);
            return false;
        }
    }
    static String getusr(){
        return U;
    }

}
//sign up
class signup{
    static int i;
    static boolean present( Connection con,String s){
        try{
            Scanner sc = new Scanner(System.in);
            Statement st = con.createStatement();
            System.out.println("Enter your ID:");
            int id=sc.nextInt();
            String query="select name from "+s+" where Id="+id;
            ResultSet rs=st.executeQuery(query);
            rs.next();
            i=id;
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    static int getid(){
        return i;
    }
    static void add(Connection con,String un,String pass,String pr){

        try {
            String qury = "INSERT into loginall (username, passcode, id, Profession) VALUE (?,?,?,?)";
            PreparedStatement sm = con.prepareStatement(qury);
            sm.setString(1, un);
            sm.setString(2, pass);
            sm.setInt(3, i);
            sm.setString(4, pr);
            sm.executeUpdate();
        }
        catch (Exception e){

        }
        }
}
public class start {
    public static void main(String[] args) {
try {
    // data base connection
    //------------------------------------------------------------
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/login";
    Connection con = DriverManager.getConnection(url, "root", "baljinder");

    //-------------------------------------------------------------
    int p = 0;
    login lo = new login();
    signup sup = new signup();
    Scanner sc = new Scanner(System.in);
    while (p != 3) {

        System.out.println("HELLO THERE PLEASE SELECT\n1.login\n2.signup\n3.Quit");

        p = sc.nextInt();

        if (p == 1) {
            System.out.println("choose your proffession \n1.Admin \n2.Staff \n3.Student");
            int prof = sc.nextInt();
            if (prof == 1) {

                if (lo.present(con, "Admin")) {
                    String user = lo.getusr();
                    admin admn = new admin(user, con);
                    admn.display();
                } else {
                    throw new Exception("Failed");
                }
            } else if (prof == 2) {
                if (lo.present(con, "Staff")) {
                    String user = lo.getusr();
                    staff u = new staff(user, con);
                    u.display();
                } else {
                    throw new Exception("Failed");
                }
            } else if (prof == 3) {
                if (lo.present(con, "Student")) {
                    String user = lo.getusr();
                    student stu = new student(user, con);
                    stu.display();
                } else {
                    throw new Exception("Failed");
                }
            } else {
                throw new Exception("Enter valid choice");
            }
        } else if (p == 2) {
            System.out.println("choose your proffession  \n1.Staff \n2.Student");

            int prof = sc.nextInt();
            if (prof == 1) {

                if (sup.present(con, "staffallinfo")) {
                    System.out.println("Enter your Username:");
                    String user = sc.next();
                    String pass = "";
                    while (true) {
                        System.out.println("Enter your Password");
                        pass = sc.next();
                        System.out.println("Confirm password");
                        String p2 = sc.next();
                        if (pass.equals(p2)) {
                            break;
                        } else {
                            System.out.println("Password didnt match");
                        }

                    }
                    sup.add(con, user, pass, "Staff");
                    System.out.println("Account added sucesfully");
                } else {
                    throw new Exception("Failed");
                }
            } else if (prof == 2) {
                if (sup.present(con, "studentallinfo")) {
                    System.out.println("Enter your Username:");
                    String user = sc.next();
                    String pass = "";
                    while (true) {
                        System.out.println("Enter your Password");
                        pass = sc.next();
                        System.out.println("Confirm password");
                        String p2 = sc.next();
                        if (pass.equals(p2)) {
                            break;
                        } else {
                            System.out.println("Password didnt match");
                        }

                    }
                    sup.add(con, user, pass, "Staff");
                    System.out.println("Account added sucesfully");
                } else {
                    throw new Exception("Failed");
                }
            } else {
                throw new Exception("Enter valid choice");
            }
        } else {

        }

    }
    sc.close();
    }
    catch(Exception e){
        System.out.println(e);
    }
    }

}
