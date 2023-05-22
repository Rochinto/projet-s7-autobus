
import java.io.Writer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public final class EcritureFichier {

  private static void ecrireDuTexte(Writer w) {
    PrintWriter p = new PrintWriter(w);

    p.println("une chaine");
    p.println(10.89);
    p.println("un entier " + 10);
    p.println("un autre " + -156);
    p.println(89);
    p.flush();
  }

  public static void main(String[] args) throws IOException {
    FileWriter f = new FileWriter("log.txt");

    ecrireDuTexte(f);
    f.close();
  }
}
