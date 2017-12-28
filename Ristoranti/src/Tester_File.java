import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tester_File {
    public static void main(String[] args) throws IOException {
        String fileName="E:\\Java\\Ristoranti\\src\\menu1.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while((line=br.readLine())!=null){
            String[] parts = line.split("\t");
            String flag=parts[0];
            System.out.println(flag);
            String nome=parts[1];
            System.out.println(nome);
        }
        br.close();
    }
}
