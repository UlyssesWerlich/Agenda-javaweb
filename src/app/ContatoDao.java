package app;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ContatoDao {

    private final String INSERT = "INSERT INTO contato (nome, telefone, email) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE contato SET nome=?, telefone=?, email=? WHERE ID=?";
    private final String DELETE = "DELETE FROM contato WHERE ID=?";
    private final String LIST = "SELECT * FROM contato";
    private final String LISTBYID = "SELECT * FROM contato WHERE ID=?";

    public void addContato(Contato contato) {
        if (contato != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(INSERT);

                pstm.setString(1, contato.getNome());
                pstm.setString(2, contato.getTelefone());
                pstm.setString(3, contato.getEmail());

                pstm.execute();
                Conexao.fechaConexao(conn, pstm);
            } catch (Exception e) {
                System.out.println( "Erro ao inserir contato no banco de dados\n" + e.getMessage());
            }
        } else {
            System.out.println("O contato enviado por parâmetro está vazio");
        }
    }

    public void editContato(Contato contato) {
        if (contato != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(UPDATE);

                pstm.setString(1, contato.getNome());
                pstm.setString(2, contato.getTelefone());
                pstm.setString(3, contato.getEmail());
                pstm.setInt(4, contato.getId());

                pstm.execute();
                Conexao.fechaConexao(conn);
            } catch (Exception e) {
                System.out.println("Erro ao atualizar contato no banco de dados\n" + e.getMessage());
            }
        } else {
            System.out.println( "O contato enviado por parâmetro está vazio");
        }
    }

    public void removeContato(int id) {
        Connection conn = null;
        try {
            conn = Conexao.getConexao();
            PreparedStatement pstm;
            pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, id);

            pstm.execute();
            Conexao.fechaConexao(conn, pstm);
        } catch (Exception e) {
            System.out.println("Erro ao excluir contato do banco de dados\n" +e.getMessage());
        }
    }

    public ArrayList<Contato> getAgenda(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();

                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                contatos.add(contato);
            }
            Conexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            System.out.println("Erro ao listar contatos\n" + e.getMessage());
        }
        return contatos;
    }

    public Contato getContato(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Contato contato = new Contato();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
            }
            Conexao.fechaConexao(conn,pstm,rs);
        } catch (Exception e) {
            System.out.println( "Erro ao listar contatos\n" + e.getMessage());
        }
        return contato;
    }

}
