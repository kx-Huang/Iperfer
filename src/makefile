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

default: classes run

classes: $(CLASSES:.java=.class)

run:
	$(J) Iperfer -c -h [hostname] -p 8080 -t 1000
clean:
	$(RM) *.class