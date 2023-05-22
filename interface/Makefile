DIRSRC=src
DIRTST=tst
DIRBUILD=build
TESTER=tec.LancerTests
TU=tec.TestJauge tec.TestPosition tec.TestMonteeFatigue tec.TestArretPrudent
TR=tec.TestAutobus tec.TestPassagerStandard tec.TestPassagerIndecis tec.TestPassagerStresse

SRCCLASS=$(DIRSRC)/*/*.java $(DIRSRC)/*.java

SRCTEST=$(DIRTST)/*.java

all: source test

alltest: source test recette utest simple

# .phony: source test

source: $(SRCCLASS)
	javac -d $(DIRBUILD) $^

test: source $(SRCTEST)
	javac -d $(DIRBUILD) -cp $(DIRBUILD) $(SRCTEST)

recette: test
	java -ea -cp $(DIRBUILD) $(TESTER) $(TR)

utest: test
	java -ea -cp $(DIRBUILD) $(TESTER) $(TU)

simple: source
	java -ea -cp build SimpleSansCollecte
	java -ea -cp build SimpleCollecteEstUn
	java -ea -cp build SimpleCollecteAUn

#SimpleGreffonEstUn: source
#	java -ea -cp build SimpleGreffonEstUn #test rapide compilation greffon
#code updaté->règle à changer (voir le simple qui rassemble le tout).


clean:
	rm -rf build/*
