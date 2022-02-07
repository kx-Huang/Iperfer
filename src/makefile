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
	$(J) Iperfer

clean:
	$(RM) *.class