# Illumio-Firewall

This is my coding challenge for Illumio. 

It is basically a Firewall that only takes in a packet containing attributes specified by rules given in the csv file.

There are two classes in this project. 
1. InputNode.java: This class defines the main data structure and helper functions for the project.
                   The constructor takes in 4 string arguments: direction, protocol, port, IP Address.
                   It has comparison methods to check for appropriate input.
                   For ports, it checks whether the input argument int is equal to the given node's port specifications, or falls in its                      range.
                   For IP Addresses, it checks whether input string is equal to argument string if input has no range. If there is a range,                    it checks whether falls in the IP Address range of input according to challenge specifications.
                   Lastly, the checker() method only returns true if given arguments satisfy ALL the requirements to be accepted by the                        input node using all the other comparison methods. This is the main helper method for accept_packet in the Firewall                        class.
        
2. Firewall.java: This class has two functions. 
                  The constructor takes in a String file path for a CSV File as an argument.
                  It iterates over each line in the CSV file and creates an InputNode with rules specified in the CSV File.
                  It stores all these inputNodes in an array list called rules.
                  It checks for Exceptions in reading file and closes the reader.
                  The accept_packet function takes in 4 arguments as required by the project.
                  It iterates over every node in rules to see if any node will accept the given arguemnts using checker() method from                     InputNode.java. If the packet can be accepted by any rule, it returns true. False otherwise.
                  
                  
I tested the InputNode functions using various print statements in the main functions. Passed in different packets for sample inputs and printed out the boolean statemnets to check if the checker() method worked. It worked for all the inputs I tested, including ports and IP Addresses that had ranges. This was all done under the assumption that each input rule and packet arguments were valid given the specifications of the project.

For the Firewall class, I did not get a chance to test the reader. However, it does throw an exception for invalid file. Assuming that all functions work correctly from the InputNode class, and the reader reads correctly, accept_packet should also return the correct boolean for a given packet.

To make my solution more efficient, I could've done a few things differently if I had the time. I would have perhaps sorted rules according to port ranges or values, and then used the accept_packet function for only those rule nodes that were applicable. This would have saved time and space, if I figured out an efficient sorting method.

The most interesting part of this challenge was creating a data structure that worked to make my solutions easier, and made the comparisons for port ranges and IP Addresses easier. I believe I was able to accomplish that using InputNode.java


Here is a ranking for my preferences to work with the different teams at Illumio: 1. Data
                                                                                  2. Platform
                                                                                  3. Policy
                                                                                  
I am highly interested in working for the Data team. As a Computer Science and Math student, I have an affinity for and absolutely enjoy building stories and finding patterns from numbers and large data, and would love to be part of a team that deals with data analysis and visualization. Having studied data structures and looking forward to studying Data Management and principles of Data Science in the upcoming semester before Summer 2020, I am certain that I will have gained skills that would be valuable to the Data team at Illumio.

In addition to the Data team, I would also be honored to work for the other two teams as well, as all of them are very relevant to the courses I am taking, and will surely offer invaluable experience and exposure to the tech industry. I am also currently studying and will have completed classes such as Reasoning Under Uncertainity, Software Engineering and Algorithms by Summer 2020, which will come in handy as an intern for the Policy and Platform teams as well.
