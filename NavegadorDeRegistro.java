import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa {
    public static void inicializacaoDeRegistros() {
        try {
            String strSqlInicializacao = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlInicializacao = conexao.createStatement();
            ResultSet rstSqlInicializacao = stmSqlInicializacao.executeQuery(strSqlInicializacao);
            if (rstSqlInicializacao.next()) {
                txtId.setText(rstSqlInicializacao.getString("id"));
                txtNome.setText(rstSqlInicializacao.getString("nome"));
                txtEmail.setText(rstSqlInicializacao.getString("email"));
                notificarUsuario("Primeiro registro posicionado com sucesso!");
                habilitarAvancar();
            } else {
                notificarUsuario("Não foram encontrados registros.");
            }
            stmSqlInicializacao.close();
        } catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }

    public static void vaParaPrimeiroRegistro() {
        inicializacaoDeRegistros();
    }

    public static void vaParaProximoRegistro() {
        try {
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where `id` > " + txtId.getText() + " order by `id` asc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlProximoRegistro = conexao.createStatement();
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                notificarUsuario("Primeiro registro posicionado com sucesso!");
                habilitarTodos();
            } else {
                habilitarVoltar();
                notificarUsuario("Não foram encontrados registros.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }

    public static void vaParaUltimoRegistro() {
        try {
            String strSqlUltimoRegistro = "select * from `db_senac`.`tbl_senac` order by `id` desc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlUltimoRegistro = conexao.createStatement();
            ResultSet rstSqlUltimoRegistro = stmSqlUltimoRegistro.executeQuery(strSqlUltimoRegistro);
            if (rstSqlUltimoRegistro.next()) {
                txtId.setText(rstSqlUltimoRegistro.getString("id"));
                txtNome.setText(rstSqlUltimoRegistro.getString("nome"));
                txtEmail.setText(rstSqlUltimoRegistro.getString("email"));
                notificarUsuario("Primeiro registro posicionado com sucesso!");
                habilitarVoltar();
            } else {
                notificarUsuario("Não foram encontrados registros.");
            }
            stmSqlUltimoRegistro.close();
        } catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }

    public static void vaParaRegistroAnterior() {
        try {
            String strSqlRegistroAnterior = "select * from `db_senac`.`tbl_senac` where `id` < " + txtId.getText() + " order by `id` desc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlRegistroAnterior = conexao.createStatement();
            ResultSet rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery(strSqlRegistroAnterior);
            if (rstSqlRegistroAnterior.next()) {
                txtId.setText(rstSqlRegistroAnterior.getString("id"));
                txtNome.setText(rstSqlRegistroAnterior.getString("nome"));
                txtEmail.setText(rstSqlRegistroAnterior.getString("email"));
                notificarUsuario("Primeiro registro posicionado com sucesso!");
                habilitarTodos();
            } else {
                habilitarAvancar();
                notificarUsuario("Não foram encontrados registros.");
            }
            stmSqlRegistroAnterior.close();
        } catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
        
    }
    public static void pesquisarRegistro(String termoPesquisa) {
        try {
            if (termoPesquisa != null && !termoPesquisa.trim().isEmpty()) {
                String strSqlPesquisa = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `nome` LIKE '%" + termoPesquisa + "%' OR `email` LIKE '%" + termoPesquisa + "%' ORDER BY `id` ASC;";
                Connection conexao = MySQLConnector.conectar();
                Statement stmSqlPesquisa = conexao.createStatement();
                ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
    
                if (rstSqlPesquisa.next()) {
                    txtId.setText(rstSqlPesquisa.getString("id"));
                    txtNome.setText(rstSqlPesquisa.getString("nome"));
                    txtEmail.setText(rstSqlPesquisa.getString("email"));
                    notificarUsuario("Registro encontrado!");
                    habilitarTodos();
                } else {
                    notificarUsuario("Nenhum registro encontrado.");
                }
                stmSqlPesquisa.close();
            } else {
                notificarUsuario("O campo de pesquisa está vazio.");
            }
        } catch (Exception e) {
            notificarUsuario("Erro ao realizar a pesquisa. Tente novamente.");
            System.err.println("Erro: " + e);
        }
    }
    
}