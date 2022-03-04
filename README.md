# Java sockets and RMI
#### Fundamentals of Distributed Systems '21-'22
Nik Dijkema (s3230007)  
Bauke Risselada (s4586743)  
Max Verbeek (s3487520)

University of Groningen




### Automated Instructions (Windows)

Each of the implementations is accompanied by two scripts:  

- ```build.sh``` for compilation.
- ```run.sh``` for running.

Each of the implementations can be run as follows:  

1. Open a command prompt.
2. ```cd``` to one of the implementations:

    - ```./src/sockets/```
    - ```./src/rmi/at-most-once/```
    - ```./src/rmi/at-least-once/```

3. Run ```build.sh```.
4. Run ```run.sh```.

The server output should display the message it received, and the client output should display the length of the message it sent, as returned by the server.




### Manual Instructions (Windows)

##### Sockets
The socket-based implementation can be run as follows:

1. Open a command prompt.
2. ```cd``` to the ```./src/sockets/``` directory.
3. Compile the server with ```javac Server.java```.
4. Compile the client with ```javac Client.java```.
5. Start the server with ```java Server```.
6. Open a *second* command prompt window.
7. Run the client with ```java Client```.

The server output should display the message it received, and the client output should display the length of the message it sent, as returned by the server.

##### RMI

The Remote Method Invocation-based implementations can be run as follows:

1. Open a command prompt.
2. ```cd``` to the ```./src/rmi/at-most-once``` OR  ```./src/rmi/at-least-once``` directory.
3. Compile the source code with ```javac -d dist LetterCounter.java Server.java Client.java```.
4. Run ```cd dist```.
5. Run ```start rmiregistry``` to start the RMI Registry service.
6. Run ```cd ..```.
7. Start the server with ```start java -classpath dist -Djava.rmi.server.codebase=file:dist/ fds.lab2.rmi.Server```.
8. Run the client with ```java -classpath dist fds.lab2.rmi.Client```.

The server output should display the message it received, and the client output should display the length of the message it sent, as returned by the server.