import Indentidades.Conquista;
import DAO.ConqDAO;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        String nome, descricao;
        int resp;
        do {
            resp = 0;
            System.out.println("Nome e dps uma pequena descrição: ");
            nome = sc.nextLine();
            descricao = sc.nextLine();
            int relacao = sc.nextInt();
            System.out.println("quer cadastrar este item ??");
            resp = sc.nextInt();
            sc.nextLine();
            if(resp != 0 ){
                Conquista conq = new Conquista();
                conq.setNome(nome);
                conq.setDescri(descricao);
                conq.setIDrelacao(relacao);
                new ConqDAO().cadastrarConq(conq);
            }
        } while (resp != 0);*/
        //System.out.println(ConqDAO.recuperarConq()); //Nao esta funcionando junto com o cadastramento.
        /*Conquista conq = ConqDAO.pesquisaConq(4);
        System.out.printf("Nome-%s\nIDrelação-%d\nDescrição-%s", conq.getNome(), conq.getIDrelacao(), conq.getDescri());*/
        //ConqDAO.deletarConq(99);
    }
}
