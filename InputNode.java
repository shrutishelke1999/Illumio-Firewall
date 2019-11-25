

public class InputNode{
	private String direction;
	private String protocol;
	private String port;
	private String IPaddress;
	
	public InputNode(String direction, String protocol, String port, String IPaddress) {
		this.direction = direction;
		this.protocol = protocol;
		this.port = port;
		this.IPaddress = IPaddress;
	}
	
	public String toString() {
		return "Direction: " + this.direction + ", Protocol: " + this.protocol + ", Port: " + this.port + ", IP Address: " + this.IPaddress;
	}
  
    public String getDirection() {
    	return this.direction;
    }
    
    public String getProtocol() {
    	return this.protocol;
    }
    
    public String getPort() {
    	return this.port;
    }
    
    public String getIPaddress() {
    	return this.IPaddress;
    }
    
    
    //returns true if packet direction is same as input direction; false otherwise
    public boolean compareDirection(String d) {
    	if(!d.equals("inbound")&&!d.equals("outbound")) {
    		System.out.println("Invalid direction");
    		return false;
    	}
    	return (d.equals(this.direction));
    }
    
    
    
    //returns true if packet protocol is same as input protocol; false otherwise
    public boolean compareProtocol(String p) {
    	if(!p.equals("tcp")&&!p.equals("udp")) {
    		System.out.println("Invalid protocol");
    		return false;
    	}
    	return (p.equals(this.protocol));
    }
    
    
    
    //returns true if packet port is equal to input port or falls in the input port range; false otherwise
    public boolean comparePort(int p) {
    	
    	int i=-1;
    	int j=-1;
    	
    	String[] temp = this.port.split("-");
    	i = Integer.parseInt(temp[0]);
    	
    	//if input port is a range
    	if(temp.length==2) {
    		j = Integer.parseInt(temp[1]);
    		return (p>=i && p<=j);
    	}
    	
    	//if input port is not a range
    	else return (p==i);
    }
    
    
    //returns true if packet IP address is the same as input IP Address or falls in its range; false otherwise
    public boolean compareIP(String ip) {
    	
    	String[] temp = this.IPaddress.split("-");
    	
    	//if input IP Address is a range
    	if(temp.length==2) {
    		String[] current = ip.split("\\.");
    		String[] ipStart = temp[0].split("\\.");
    		String[] ipEnd = temp[1].split("\\.");
    		int min=-1;
        	int max=-1;
        	int curr=-1;
    		
    		for(int i=0;i<4;i++) {
    			
    			min = Integer.parseInt(ipStart[i]);
    			max = Integer.parseInt(ipEnd[i]);
    			curr = Integer.parseInt(current[i]);
    			
    			if(curr<min || curr>max) {
    				return false;
    			}
    		}
    		
    		return true;
    	}
    	
    	//if there is no range, just compare strings
    	return (this.IPaddress.equals(ip));
    	
    }
    
    //checks whether given guidelines follow the rules from input node
    public boolean checker(String dir, String pro, int por, String ip) {
    	
    	if(this.compareDirection(dir)) {
    		if(this.compareProtocol(pro)) {
    			if(this.comparePort(por)) {
    				if(this.compareIP(ip)) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    
    //used for testing
    public static void main(String args[]) {
    	
    	InputNode rule1 = new InputNode("inbound","tcp","80","192.168.1.2");
    	boolean boo1 = rule1.checker("inbound", "tcp", 80, "192.168.1.2");
    	System.out.println(boo1); //prints true
    	
    	InputNode rule2 = new InputNode("outbound","tcp","10000-20000","192.168.10.11");
    	boolean boo2 = rule2.checker("outbound", "tcp", 10234, "192.168.10.11");
    	System.out.println(boo2); //prints true
    	
    	InputNode rule3 = new InputNode("inbound","udp","53","192.168.1.1-192.168.2.5");
    	boolean boo3 = rule3.checker("inbound", "udp", 53, "192.168.3.1");
    	System.out.println(boo3); //prints false
    	boolean boo4 = rule3.checker("inbound", "udp", 53, "192.168.2.1");
    	System.out.println(boo4); //prints true;
    	
    	
    }
    
    
    
}
