<h1>Multithreaded-Client-Server-Messaging-Application</h1> 
A prototype of the multithreaded client-server messaging application for Sheffield Hallam University Student Community will be designed and implemented using client-server architecture and network software development techniques. As the architecture suggests, the prototype will consist of a multithreaded server and clients communicating over a network. The system will allow clients to publish messages, subscribe to channels, and read messages through the channels to which they have subscribed. 

<h2>Server Specification:</h2> 
The server and clients will exchange message requests and responses using JSON format based on a fixed protocol specified in a separate document (included in the supplementary material). You will implement, using Java, a server that allows multiple clients to connect concurrently on port 12345 (you may choose a different port number) and that correctly responds to the requests as detailed in the protocol specification. You may assume that messages only have JSON encoded object with “from”, “when” and “body” (please see the client specifications below). For the server, an optional persistence as an extension is recommended. In this regard, the server should be able to back up messages to a persistence storage such as a database or a file on the disk. If the server is killed, and restarted, it should be able to automatically recover the persisted messages. 

<h2>Client Specification:</h2> 
The client to be implemented in Java should connect to the server above running on localhost and port number 12345 (you may choose a different port number). The client should allow a user to login to a particular channel, subscribe to and unsubscribe from other channels, publish messages, and read messages that have been published on the subscribed channels. This functionality must be implemented to communicate with servers using the JSON protocol in the server specification above. The users of your application should be able to interact with the client through a console. In addition, the application console should automatically display (without user’s intervention) messages that have been published on their respective subscribed channels. For the client, you may decide to implement an optional extension such as the capability to search messages, e.g., display all messages containing specific hashtag. Other extensions are allowed but you should discuss these with your tutors to clarify which feature counts as an extension. 

<h3>Folder Contents</h3>
<hr>
->Jars (containing the Jars file for Json)
<br>->1234.txt (containing the backup of the chat)
<br>->Server
<br>->Client

<h3>How to run this Folder</h3>
<hr>
-> Delete the .classpath file in the folder
<br>
-> Open Eclipse and choose the workspace where you have extracted the folder

-> After the Eclipse is open in your workspace, follow the following steps

		1) Go to the 'File' option on the top of menu
		2) Click on the 'Open project from File System'
		3) Click on the Directory and then choose your folder
		4) Project will be successfully opened in your eclipse

-> Now, open the Server Package and right click on the server.java and run it as java application
<br>-> After running the server sucessfully,  go to the Client Package and click on the client.java and 
   run it as java application
<br>-> For running the multiple clients, you can run the client.java multiple times

<h3>Features Implemented for Client</h3> 
<hr>
-> I have implemented the Chat searching extension for the client, in which the client can search for any keyword and all 
chats that are closely related to the keyword will be shown. 
<br>-> Multiple Clients can communicate with each other on the same port and can response to each other as well.

<h3>Features Implemented for Server</h3> 
<hr>
-> I have also implemented the persistence extension for the server.
Server should be able to back up messages to a persistence storage on local staorge in a file on the disk. 
