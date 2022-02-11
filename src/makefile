JFLAGS = -g
JC = javac
J = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Iperfer.java \
	server.java \
	client.java

default: classes

classes: $(CLASSES:.java=.class)

client: classes
	$(J) Iperfer -c -h localhost -p 8080 -t 2

server: classes
	$(J) Iperfer -s -p 8080

clean:
	$(RM) *.class
