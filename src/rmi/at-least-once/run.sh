cd dist

start rmiregistry

cd ..

sleep 3

start java -classpath dist -Djava.rmi.server.codebase=file:dist/ fds.lab2.rmi.Server

sleep 3

start java -classpath dist fds.lab2.rmi.Client