
package dd_util;

public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "rspatil005@gmail.com";
	public static String password = "rspatil05";
	public static String[] to ={"patilrs005@gmail.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="D:\\JAVA PROGRAMS\\GoogleAssignment_DataDriven\\Reports.zip";
	public static String attachmentName="reports.zip";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/gaurav";
	
	
	
}
