
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;


public class DataB {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
//            Connection con =DriverManager.getConnection("jdbc:mysql//localhost/3306","root","root");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","root");

            int roll,marks,ch,number,i;
            String name;
           do{
               
                	Scanner sc = new Scanner(System.in);
			System.out.print("press 1\tFor Insert data into Table\n"+"press 2\tFor Select all data from Table\n"+"press 3\tFor delete data from Table\n"+"press 4\tFor Update data in Table\n"+"press 5\tFor Select data from Table Using Roll No , Name And Marks\n"+"press 6\tFor Exit\n");
                        ch =sc.nextInt(); 
                      if(ch<=6 && ch>=1)
                      {  
                                        if(ch==1){
                                                    System.out.print("Number 0f student Insert data");
                                                    number=sc.nextInt();
                                                    System.out.println("Please Enter "+number+" Student Data Only");
                                                    String sql="insert into student values(?,?,?)";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    for(i=1; i<=number;i++)
                                                    {
                                                      System.out.println("Enter Student roll No ");
                                                      roll=sc.nextInt();
                                                      System.out.println("Enter Student Name ");
                                                      name=sc.next();
                                                      System.out.println("Enter Student marks ");
                                                      marks=sc.nextInt();
                                                      ps.setInt(1,roll);
                                                      ps.setString(2,name);
                                                      ps.setInt(3,marks);
                                                      int rs=ps.executeUpdate();
                                                       if(rs>0) 
                                                          System.out.println("Recored insert....\n");
                                                    }
                                        }
                                        
                                        else if(ch==2){

                                                    String sql="select * from student";
                                                    Statement st = con.createStatement();

                                                    ResultSet rs = st.executeQuery(sql);
                                                    ResultSetMetaData rsdm = rs.getMetaData();
                                                    System.out.println("\t\t"+rsdm.getColumnName(1)+"\t\t"+rsdm.getColumnName(2)+"\t\t"+rsdm.getColumnName(3));
                                                    while(rs.next())
                                                       {
                                                           System.out.print("\t\t"+rs.getString(1));
                                                           System.out.print("\t\t"+rs.getString(2));
                                                           System.out.println("\t\t"+rs.getString(3));
                                           //                System.out.println("\t\t"+rs.getString(4)); 
                                                       }    
                                        }
                                        else if(ch==5){
                                                     
                                                    System.out.println("press 1\tFor Select data from Table Using Student Roll Number \n"+"press 2\tFor Select data from Table Using Student Name \n"+"press 3\tFor Select data from Table Using Student Marks \n");
                                                    ch=sc.nextInt();
                                                    if(ch==1)
                                                    {
                                                                String sql="select * from student where roll=?";
                                                                PreparedStatement ps=con.prepareStatement(sql);
                                                                System.out.print("Enter Student Roll No. :");
                                                                roll=sc.nextInt();
                                                                ps.setInt(1,roll);
                                                                ResultSet rs = ps.executeQuery();
                                                                ResultSetMetaData rsdm = rs.getMetaData();
                                                                System.out.println("\t\t"+rsdm.getColumnName(1)+"\t\t"+rsdm.getColumnName(2)+"\t\t"+rsdm.getColumnName(3));
                                                                while(rs.next())
                                                                   {
                                                                       System.out.print("\t\t"+rs.getString(1));
                                                                       System.out.print("\t\t"+rs.getString(2));
                                                                       System.out.println("\t\t"+rs.getString(3));
                                                       //                System.out.println("\t\t"+rs.getString(4)); 
                                                                   }  
                                                    }
                                                    else    if(ch==2)
                                                    {
                                                                String sql="select * from student where name=?";
                                                                PreparedStatement ps=con.prepareStatement(sql);
                                                                System.out.print("Enter Student Name :");
                                                                name=sc.next();
                                                                ps.setString(1,name);
                                                                ResultSet rs = ps.executeQuery();
                                                                ResultSetMetaData rsdm = rs.getMetaData();
                                                                System.out.println("\t\t"+rsdm.getColumnName(1)+"\t\t"+rsdm.getColumnName(2)+"\t\t"+rsdm.getColumnName(3));
                                                                while(rs.next())
                                                                   {
                                                                       System.out.print("\t\t"+rs.getString(1));
                                                                       System.out.print("\t\t"+rs.getString(2));
                                                                       System.out.println("\t\t"+rs.getString(3));
                                                       //                System.out.println("\t\t"+rs.getString(4)); 
                                                                   }  
                                                    }
                                                    else    if(ch==3)
                                                    {
                                                                String sql="select * from student where marks=?";
                                                                PreparedStatement ps=con.prepareStatement(sql);
                                                                System.out.print("Enter Student Marks :");
                                                                marks=sc.nextInt();
                                                                ps.setInt(1,marks);
                                                                ResultSet rs = ps.executeQuery();
                                                                ResultSetMetaData rsdm = rs.getMetaData();
                                                                System.out.println("\t\t"+rsdm.getColumnName(1)+"\t\t"+rsdm.getColumnName(2)+"\t\t"+rsdm.getColumnName(3));
                                                                while(rs.next())
                                                                   {
                                                                       System.out.print("\t\t"+rs.getString(1));
                                                                       System.out.print("\t\t"+rs.getString(2));
                                                                       System.out.println("\t\t"+rs.getString(3));
                                                       //                System.out.println("\t\t"+rs.getString(4)); 
                                                                   }  
                                                    }                            
                                                    
                                        }
                                        else if(ch==3)
                                        {
                                            System.out.print("press 1\tFor delete data from Table with roll number\n"+"press 2\tFor delete data from Table with marks\n"+"press 3\tFor delete data from Table with name\n");
                                                    ch =sc.nextInt();
                                                    if(ch==1)
                                                    {
                                                    String sql="delete from student where roll=?";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    System.out.print("Enter Student Roll No= ");
                                                     roll=sc.nextInt();
                                                     ps.setInt(1,roll);
                                                     int rs=ps.executeUpdate();
                                                      if(rs>0) 
                                                          System.out.println("Recored deleted....\n");
                                                    }
                                                    else if(ch==2)
                                                    {
                                                    String sql="delete from student where marks=?";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    System.out.println("Enter Student Marks= ");
                                                     marks=sc.nextInt();
                                                     ps.setInt(1,marks);
                                                     int rs=ps.executeUpdate();
                                                      if(rs>0) 
                                                          System.out.println("Recored deleted....\n");
                                                    }
                                                    else if(ch==3)
                                                    {
                                                     String sql="delete from student where name=?";
                                                     PreparedStatement ps=con.prepareStatement(sql);
                                                     System.out.print("Enter Student Name= ");
                                                     name=sc.next();
                                                     ps.setString(1,name);
                                                     int rs=ps.executeUpdate();
                                                     if(rs>0) 
                                                          System.out.println("Recored deleted....\n");
                                                    }

                                        }
                                        else if(ch==4)
                                           {
                                                    System.out.print("press 1\tFor Update Student Roll number\n"+"press 2\tFor Update Student Name\n"+"press 3\tFor Update Student Marks\n");
                                                    ch =sc.nextInt();
                                                    if(ch==1)
                                                    {
                                                        System.out.println("press 1\tFor You know Student Name\n"+"press 2\tFor You Know Student Marks");
                                                        ch=sc.nextInt();
                                                        if(ch==1)
                                                        {
                                                            String sql="update Student set roll=? where name=?";
                                                            PreparedStatement ps=con.prepareStatement(sql);
                                                            System.out.println("Enter Student Roll No For Updaate ");
                                                            roll=sc.nextInt();
                                                            System.out.print("Enter Student Name= ");
                                                             name=sc.next();
                                                             ps.setInt(1,roll);
                                                             ps.setString(2,name);
                                                             int rs=ps.executeUpdate();
                                                             if(rs>0) 
                                                                  System.out.println("Recored Update....\n");
                                                        }
                                                        else if(ch==2)
                                                        {
                                                            String sql="update Student set roll=? where marks=?";
                                                            PreparedStatement ps=con.prepareStatement(sql);
                                                            System.out.println("Enter Student Roll No For Updaate ");
                                                            roll=sc.nextInt();
                                                            System.out.print("Enter Student Marks= ");
                                                             marks=sc.nextInt();
                                                             ps.setInt(1,roll);
                                                             ps.setInt(2,marks);
                                                             int rs=ps.executeUpdate();
                                                             if(rs>0) 
                                                                  System.out.println("Recored Update....\n");
                                                        }
                                                     }
                                                   else if(ch==2)
                                                       {       
                                                          System.out.println("press 1\tFor You know Student Roll No\n"+"press 2\tFor You Know Student Marks");
                                                          ch=sc.nextInt();
                                                          if(ch==1)
                                                          {
                                                            String sql="update Student set name=? where roll=?";
                                                            PreparedStatement ps=con.prepareStatement(sql);
                                                            System.out.println("Enter Student Name For Updaate ");
                                                            name=sc.next();
                                                            System.out.print("Enter Student Roll= ");
                                                             roll=sc.nextInt();
                                                             ps.setInt(1,roll);
                                                             ps.setString(2,name);
                                                             int rs=ps.executeUpdate();
                                                             if(rs>0) 
                                                                  System.out.println("Recored Update....\n");
                                                            }
                                                          else  if(ch==2)
                                                          {
                                                            String sql="update Student set name=? where marks=?";
                                                            PreparedStatement ps=con.prepareStatement(sql);
                                                            System.out.println("Enter Student Name For Updaate ");
                                                            name=sc.next();
                                                            System.out.print("Enter Student Marks= ");
                                                             marks=sc.nextInt();
                                                             ps.setInt(2,marks);
                                                             ps.setString(1,name);
                                                             int rs=ps.executeUpdate();
                                                             if(rs>0) 
                                                                  System.out.println("Recored Update....\n");
                                                           }
                                                        }
                                                         else if(ch==3)
                                                       {     
                                                          System.out.println("You press 3 for Update Student Marks "); 
                                                          System.out.println("press 1\tFor You know Student Roll No\n"+"press 2\tFor You Know Student Name");
                                                          ch=sc.nextInt();
                                                          if(ch==1)
                                                          {
                                                            String sql="update Student set marks=? where roll=?";
                                                            PreparedStatement ps=con.prepareStatement(sql);
                                                            System.out.println("Enter Student Marks For Updaate ");
                                                            marks=sc.nextInt();
                                                            System.out.print("Enter Student Roll= ");
                                                             roll=sc.nextInt();
                                                             ps.setInt(1,roll);
                                                             ps.setInt(2,marks);
                                                             int rs=ps.executeUpdate();
                                                             if(rs>0) 
                                                                  System.out.println("Recored Update....\n");
                                                            }
                                                          else  if(ch==2)
                                                          {
                                                            String sql="update Student set marks=? where name=?";
                                                            PreparedStatement ps=con.prepareStatement(sql);
                                                            System.out.println("Enter Student Marks For Updaate ");
                                                            marks=sc.nextInt();
                                                            System.out.print("Enter Student Name= ");
                                                             name=sc.next();
                                                             ps.setInt(1,marks);
                                                             ps.setString(2,name);
                                                             int rs=ps.executeUpdate();
                                                             if(rs>0) 
                                                                  System.out.println("Recored Update....\n");
                                                           }
                                                        }
                //                                 
                //                                   String sql="update Student set marks=? where name=?";
                                         }
                      }
                      else
                      {
                          System.out.println("Plese Enter Right Choise Like -> 1,2,3,4,5\n");
                       
                      }
           
	}while(ch!=6);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(""+e);
//            Logger.getLogger(Test3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
