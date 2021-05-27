# Broker
1. Modificar las variables PORT_BROKER, PORT_SERVER_A, PORT_SERVER_B, HOST_BROKER, HOST_SERVER_A y HOST_SERVER_B dentro del Makefile.
2. Registrar en RMI ejecutando "make rmi &"  "make rmiA &"  "make rmiB &" en las respectivas máquinas .
4. "make broker" en máquina HOST_BROKER
5. "make serverA" en máquina HOST_SERVER_A
6. "make serverB" en máquina HOST_SERVER_B
7. "make client a=ANIMAL w=CADENATEXTO n=DIGITO " en otra máquina.
