for /r %%a in (*.java) do ( javac "%%a" )
start rmiregistry
java -cp ".;rmiserver\mysql-connector-java-5.1.42-bin.jar" rmiserver/ServerOperation