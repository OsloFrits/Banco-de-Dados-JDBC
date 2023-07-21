import Indentidades.Conquista;
import DAO.ConqDAO;
import db.DB;

import java.sql.Connection;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Connection conn = DB.getConn();
        /*Scanner sc = new Scanner(System.in);
        String nome, descricao;
        int resp;
        do {
            Connection conn = DB.getConn();
            resp = 0;
            System.out.println("Nome da conquista e dps uma pequena descrição: ");
            nome = sc.nextLine();
            descricao = sc.nextLine();
            System.out.println("quer cadastrar este item ??");
            resp = sc.nextInt();
            sc.nextLine();
            if(resp != 0 ){
                Conquista conq = new Conquista();
                conq.setNome(nome);
                conq.setDescri(descricao);
                new ConqDAO().cadastrarConq(conq);
            }
        } while (resp != 0);*/
        DB.closeConnection();
    }
}
