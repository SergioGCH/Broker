#"make" para compilarlo
#"make broker" para compilar y ejecutar el broker
#"make serverA" para compilar y ejecutar el servidorA
#"make serverB" para compilar y ejecutar el servidorB
#"make client" para compilar y ejecutar el cliente
#"make clean" para eliminar el ejecutable y archivos objeto.

JFLAGS = -g
JC = javac
JVM = java
MAIN_BROKER = Broker
MAIN_SERVER_A = ServidorA
MAIN_SERVER_B = ServidorB
MAIN_CLIENT = Cliente
HOST_BROKER = "155.210.154.192:32008"
HOST_SERVER_A = "155.210.154.193:32008"
HOST_SERVER_B = "155.210.154.193:32007"
CLASSES = Animal.java \
	AnimalImplementor.java \
	Broker.java \
	Cliente.java \
	ContadorDeLetras.java \
	ContadorDeLetrasImplementor.java \
	Servicio.java \
	Servicio.java \
	ServidorA.java \
	ServidorB.java \

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

default: classes

classes: $(CLASSES:.java=.class)

broker: $(MAIN_BROKER).class
	$(JVM) $(MAIN_BROKER) $(HOST_BROKER)

serverA: $(MAIN_SERVER_A).class
	$(JVM) $(MAIN_SERVER_A) $(HOST_BROKER) $(HOST_SERVER_A)

serverB: $(MAIN_SERVER_B).class
	$(JVM) $(MAIN_SERVER_B) $(HOST_BROKER) $(HOST_SERVER_B)

rmi:
	rmiregistry 32008
	
rmi2:
	rmiregistry 32010

client: $(MAIN_CLIENT).class
	$(JVM) $(MAIN_CLIENT) $(HOST_BROKER) $(in)

clean:
	$(RM) *.class

