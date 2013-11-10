import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.thinker.cmd.Command;


public class PropertiesTest {

	public static void main(String[] args) throws Exception{
		
		
		Map<String, Command> map = new HashMap<String, Command>();
		
		Properties prop = new Properties();
		
		InputStream in = new FileInputStream("command.properties");
		
		prop.load(in);
		
		
		Iterator keyIt = prop.keySet().iterator();
				
		
		while(keyIt.hasNext()){
			
			String key = (String)keyIt.next();
			
			String value = prop.getProperty(key);
			
			//System.out.println(key);
			//System.out.println(value);
			
			map.put(key,  (Command)( Class.forName(value).newInstance()));
		}

		String target = "/study";
		
		Command targetCmd = map.get(target);
		
		targetCmd.doJob();
		

	}

}
