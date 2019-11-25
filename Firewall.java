import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Firewall {
	public List<InputNode> rules;
	
	 /**
	   A constructor, taking a single string argument, which is a file path to a CSV file whose
	   contents are as described above, e.g, in Ruby, this would be Firewall.new(“/path/to/fw.csv”).
	   1. Note that you do not need to define a static ‘new’ method –
	      simply use the constructor syntax in the language that you chose.
	   2. Remember that you may assume that all content in the input file is valid.
	    @throws IOException 
	   
	   **/
		
		public Firewall(String filePath) throws IOException {
			FileReader file = new FileReader(filePath);
			BufferedReader br = new BufferedReader(file);
			
			//stores all the input rules from CSV file
			rules = new ArrayList<InputNode>();
			
			String nextLine="";
			String[] temp=new String[4];
			
			
			//Reference: https://stackabuse.com/reading-and-writing-csvs-in-java/
			while((nextLine=br.readLine())!=null) {
				temp = nextLine.split(",");
				InputNode toAdd = new InputNode(temp[0],temp[1],temp[2],temp[3]);
				rules.add(toAdd);
			}
			
			br.close();
		}
		
		
		/**
		   A function, accept_packet, that takes exactly four arguments and returns a boolean:
	       true, if there exists a rule in the file that this object was initialized with that allows traffic 
	       with these particular properties, and false otherwise.
	       1. direction (string): “inbound” or “outbound”
	       2. protocol (string): exactly one of “tcp” or “udp”, all lowercase
	       3. port (integer) – an integer in the range [1, 65535]
	       4. ip_address (string): a single well formed IPv4 address.
	       **/
		
		public boolean accept_packet(String direction, String protocol, int port, String ip_address) {
			
			for(int i=0;i<rules.size();i++) {
				if(rules.get(i).checker(direction, protocol, port, ip_address)) {
					return true;
				}
			}
			
			return false;
		}
		
		
}
