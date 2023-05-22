DIRSRC?=src
DIRTST=tst
DIRBUILD=build
TU=tec.TestJauge tec.TestPosition tec.TestMonteeFatigue tec.TestArretPrudent
TR=tec.TestAutobus tec.TestPassagerStandard tec.TestPassagerIndecis tec.TestPassagerStresse

SRCCLASS=$(DIRSRC)/*.java

SRCTEST=$(DIRTST)/*.java

CLIENT=SimpleInterface.java

all: source test

alltest: source test recette utest simple

source: $(SRCCLASS)
	javac -d $(DIRBUILD) $^

test: source $(SRCTEST)
	javac -d build/ -cp build/ $(SRCTEST)

recette: test $(DIRBUILD)
	for tstr in $(TR); do java -ea -cp build $$tstr; done

utest: test $(DIRBUILD)
	for tstu in $(TU); do java -ea -cp build $$tstu; done

simple: source
	java -ea -cp build Simple

3_comportements__tests: simpleAbstract simpleIndecis simpleStresse

simpleAbstract: source
	java -ea -cp build/ SimpleAbstract

simpleIndecis: source
	java -ea -cp build/ SimpleIndecis

simpleStresse: source
	java -ea -cp build/ SimpleStresse

clean:
	rm -rf build/*
