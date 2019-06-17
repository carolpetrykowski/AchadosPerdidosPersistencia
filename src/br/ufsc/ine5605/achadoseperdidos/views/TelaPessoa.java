/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.achadoseperdidos.views;

import br.ufsc.ine5605.achadoseperdidos.models.Aluno;
import br.ufsc.ine5605.achadoseperdidos.models.Funcionario;
import br.ufsc.ine5605.achadoseperdidos.models.Visitante;
import br.ufsc.ine5605.achadoseperdidos.controllers.ControladorPessoa;
import java.util.InputMismatchException;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author Henrique Meireles
 */public class TelaPessoa extends TelaGlobal{

   // private Scanner teclado; > Deletado para JFrame
     private JButton btnVoltar;
     private JLabel lblNome;
     private JTextField txtNome;
     private JLabel lblTelefone;
     private JTextField txtTelefone;
     private JLabel lblMatricula;
     private JTextField txtMatricula;
     private JLabel lblSiape;
     private JTextField txtSiape;
     private JLabel lblCpf;
     private JTextField txtCpf;
     private JButton btnCadastrarAluno;
     private JButton btnCadastrarFuncionario;
     private JButton btnCadastrarVisitante;
    

    public TelaPessoa() {
         super("Tela Pessoa");
        
         
    }

    public void initComponents() {
       
        //teclado = new Scanner(System.in);
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        //Criando a Barra de Menu Superior e Adicionando suas opcoes
        JMenuBar menPessoa = new JMenuBar();
        setJMenuBar(menPessoa);
        
        JMenu aluno = new JMenu("Aluno");
        menPessoa.add(aluno);
        
        JMenu funcionario = new JMenu("Funcionario");
        menPessoa.add(funcionario);
        
        JMenu visitante = new JMenu("Visitante");
        menPessoa.add(visitante);
        
        JMenuItem cadastrarAluno = new JMenuItem("Cadastrar Aluno");        
        aluno.add(cadastrarAluno);
        cadastrarAluno.setActionCommand("1");
        
        JMenuItem cadastrarFuncionario = new JMenuItem("Cadastrar Funcionario");        
        funcionario.add(cadastrarFuncionario);
        cadastrarFuncionario.setActionCommand("2");
        
        JMenuItem cadastrarVisitante = new JMenuItem("Cadastrar Visitante");        
        visitante.add(cadastrarVisitante);
        cadastrarVisitante.setActionCommand("3");
       
        
        
        btnVoltar = new JButton();
        btnVoltar.setText("Voltar");
        btnVoltar.setActionCommand("5");
        
        //container.add(btnVoltar);
        
        GerenciadorBotoes gerenciadorBotoes = new GerenciadorBotoes();
        cadastrarAluno.addActionListener(gerenciadorBotoes);
        cadastrarFuncionario.addActionListener(gerenciadorBotoes);
        cadastrarVisitante.addActionListener(gerenciadorBotoes);
        
        setSize(360, 150);
        
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        /*int escolhaTipo;

        System.out.println("----------TELA PESSOA----------");
        System.out.println("1 - Cadastrar uma Pessoa");
        System.out.println("2 - Excluir uma Pessoa");
        System.out.println("3 - Alterar uma Pessoa");
        System.out.println("4 - Listar Pessoas");
        System.out.println("0 - Voltar");
        System.out.println("-------------------------------");
        System.out.print("Digite o número da operação desejada: ");
        escolhaTipo = recebeValorInteiro();
        switch (escolhaTipo) {
            case 1:
                System.out.println("----------CADASTRAR PESSOA----------");
                System.out.println("1 - Cadastrar um Aluno");
                System.out.println("2 - Cadastrar um Funcionario");
                System.out.println("3 - Cadastrar um Visitante");
                System.out.println("0 - Voltar");
                System.out.println("------------------------------------");
                System.out.print("Digite o número da operação desejada: ");
                int opcao = recebeValorInteiro();
                switch (opcao) {
                    case 1:
                        this.incluirAluno();
                        break;
                    case 2:
                        this.incluirFuncionario();
                        break;
                    case 3:
                        this.incluirVisitante();
                        break;
                    case 0:
                        this.menuInicial();
                        break;
                    default:
                        System.out.println("Operacao invalida!");
                }
                break;
            case 2:
                System.out.println("----------EXCLUIR PESSOA----------");
                System.out.println("1 - Excluir Aluno");
                System.out.println("2 - Excluir Funcionario");
                System.out.println("3 - Excluir Visitante");
                System.out.println("0 - Voltar");
                System.out.println("------------------------------------");
                System.out.print("Digite o número da operação desejada: ");
                opcao = recebeValorInteiro();
                switch (opcao) {
                    case 1:
                        this.excluirAluno();
                        break;
                    case 2:
                        this.excluirFuncionario();
                        break;
                    case 3:
                        this.excluirVisitante();
                        break;
                    case 0:
                        this.menuInicial();
                        break;
                    default:
                        System.out.println("Operacao invalida!");
                }
                break;
            case 3:
                System.out.println("----------ALTERAR PESSOA----------");
                System.out.println("1 - Alterar um Aluno");
                System.out.println("2 - Alterar um Funcionario");
                System.out.println("3 - Alterar um Visitante");
                System.out.println("0 - Voltar");
                System.out.println("------------------------------------");
                System.out.print("Digite o número da operação desejada: ");
                opcao = recebeValorInteiro();
                switch (opcao) {
                    case 1:
                        this.alterarAluno();
                        break;
                    case 2:
                        this.alterarFuncionario();
                        break;
                    case 3:
                        this.alterarVisitante();
                        break;
                    case 0:
                        this.menuInicial();
                        break;
                    default:
                        System.out.println("Operacao invalida!");
                }
                break;
            case 4:
                System.out.println("----------LISTAR PESSOA----------");
                System.out.println("1 - Listar Alunos");
                System.out.println("2 - Listar Funcionarios");
                System.out.println("3 - Listar Visitantes");
                System.out.println("0 - Voltar");
                System.out.println("------------------------------------");
                System.out.print("Digite o número da operação desejada: ");
                opcao = recebeValorInteiro();
                switch (opcao) {
                    case 1:
                        this.listarAlunos();
                        break;
                    case 2:
                        this.listarFuncionarios();
                        break;
                    case 3:
                        this.listarVisitantes();
                        break;
                    case 0:
                        this.menuInicial();
                        break;
                    default:
                        System.out.println("Operacao invalida!");
                }
                break;
            case 0:
                (ControladorPessoa.getInstancia().getControladorPrincipal()).inicia();
                break;
            default:
                System.out.println("--------------------------------------");
                System.out.println("Operação inválida!");
                break;
        }
      */
    }

    public void incluirAluno() {
        //Componentes da tela
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        lblNome = new JLabel();
        c.gridx = 0;
        c.gridy = 0;
        container.add(lblNome, c);
        
        txtNome = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        container.add(txtNome, c);
        
        lblTelefone = new JLabel();
        c.gridx = 0;
        c.gridy = 1;
        container.add(lblTelefone, c);
        
        txtTelefone = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        container.add(txtTelefone, c);
        
        lblMatricula = new JLabel();
        c.gridx = 0;
        c.gridy = 2;
        container.add(lblMatricula, c);
       
        txtMatricula = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        container.add(txtMatricula, c);
        
        btnCadastrarAluno = new JButton();
        c.gridx = 1;
        c.gridy = 3;
        container.add(btnCadastrarAluno, c);
        //Conteudo dos componentes
        lblNome.setText("Nome: ");
        lblTelefone.setText("Telefone: ");
        lblMatricula.setText("Matricula: ");
        btnCadastrarAluno.setText("Cadastrar Aluno");
        
        //Acao do Botao
        GerenciadorBotaoCadastrarAluno gerenciadorBtnCadastrarAluno = new GerenciadorBotaoCadastrarAluno();
        btnCadastrarAluno.addActionListener(gerenciadorBtnCadastrarAluno);
                
        //Adicionando componentes a tela
   
        
        //Configuracoes da tela
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
    }

    public void excluirAluno() {
        System.out.println("----------EXCLUIR ALUNO----------");
        System.out.println("Matricula: ");
        int matricula = recebeValorInteiro();
        ControladorPessoa.getInstancia().excluirAluno(matricula);
    }

    public void listarAlunos() {
        System.out.println("----------LISTA DE ALUNOS----------");
        System.out.println("Nome               Telefone               Matricula");
        ControladorPessoa.getInstancia().listarAlunos();
    }

    public void alterarAluno() {
        System.out.println("----------ALTERAR ALUNO----------");
        System.out.println("Digite a Matricula do aluno que deseja alterar: ");
        int matricula = recebeValorInteiro();
        Aluno aluno = ControladorPessoa.getInstancia().encontrarAlunoPelaMatricula(matricula);
        this.exibirDadosAluno(aluno.getNomePessoa(), aluno.getTelefonePessoa(), aluno.getMatricula());
        System.out.println("----------------------------------");
        System.out.println("Novo Nome: ");
        String novoNome = recebeValorString();
        System.out.println("Novo Telefone: ");
        long novoTelefone = recebeValorLong();
        System.out.println("Nova Matricula: ");
        int novaMatricula = recebeValorInteiro();
        ControladorPessoa.getInstancia().alterarAluno(aluno, novoNome, novoTelefone, novaMatricula);
        this.exibirDadosAluno(novoNome, novoTelefone, novaMatricula);
    }

    public void incluirFuncionario() {
        //Componentes da tela
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        lblNome = new JLabel();
        c.gridx = 0;
        c.gridy = 0;
        container.add(lblNome, c);
        
        txtNome = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        container.add(txtNome, c);
        
        lblTelefone = new JLabel();
        c.gridx = 0;
        c.gridy = 1;
        container.add(lblTelefone, c);
        
        txtTelefone = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        container.add(txtTelefone, c);
        
        lblSiape = new JLabel();
        c.gridx = 0;
        c.gridy = 2;
        container.add(lblSiape, c);
       
        txtSiape = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        container.add(txtSiape, c);
        
        btnCadastrarFuncionario = new JButton();
        c.gridx = 1;
        c.gridy = 3;
        container.add(btnCadastrarFuncionario, c);
        //Conteudo dos componentes
        lblNome.setText("Nome: ");
        lblTelefone.setText("Telefone: ");
        lblSiape.setText("Siape: ");
        btnCadastrarFuncionario.setText("Cadastrar Funcionario");
        
        //Acao do Botao
        GerenciadorBotaoCadastrarFuncionario gerenciadorBtnCadastrarFuncionario = new GerenciadorBotaoCadastrarFuncionario();
        btnCadastrarFuncionario.addActionListener(gerenciadorBtnCadastrarFuncionario);
        
                
        //Adicionando componentes a tela
   
        
        //Configuracoes da tela
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
        /*System.out.println("----------CADASTRAR FUNCIONARIO----------");
        System.out.println("Nome: ");
        String nome = recebeValorString();
        System.out.println("Telefone: ");
        long telefone = recebeValorLong();
        System.out.println("Siape: ");
        int siape = recebeValorInteiro();
        ControladorPessoa.getInstancia().cadastrarFuncionario(nome, telefone, siape);*/
    }

    public void excluirFuncionario() {
        System.out.println("----------EXCLUIR FUNCIONARIO----------");
        System.out.println("Siape: ");
        int siape = recebeValorInteiro();
        ControladorPessoa.getInstancia().excluirFuncionario(siape);
    }

    public void listarFuncionarios() {
        System.out.println("----------LISTA DE FUNCIONARIOS----------");
        System.out.println("Nome               Telefone               Siape");
        ControladorPessoa.getInstancia().listarFuncionarios();
    }

    public void alterarFuncionario() {
        System.out.println("----------ALTERAR FUNCIONARIO----------");
        System.out.println("Digite o Siape do funcionario que deseja alterar: ");
        int siape = recebeValorInteiro();
        Funcionario funcionario = ControladorPessoa.getInstancia().encontrarFuncionarioPeloSiape(siape);
        this.exibirDadosFuncionario(funcionario.getNomePessoa(), funcionario.getTelefonePessoa(), funcionario.getSiape());
        System.out.println("----------------------------------");
        System.out.println("Novo Nome: ");
        String novoNome = recebeValorString();
        System.out.println("Novo Telefone: ");
        long novoTelefone = recebeValorLong();
        System.out.println("Novo Siape: ");
        int novoSiape = recebeValorInteiro();
        ControladorPessoa.getInstancia().alterarFuncionario(funcionario, novoNome, novoTelefone, novoSiape);
        this.exibirDadosFuncionario(novoNome, novoTelefone, novoSiape);
    }

    public void incluirVisitante() {
        //Componentes da tela
        Container containerIncluirVisitante = getContentPane();
        containerIncluirVisitante.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        lblNome = new JLabel();
        c.gridx = 0;
        c.gridy = 0;
        containerIncluirVisitante.add(lblNome, c);
        
        txtNome = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        containerIncluirVisitante.add(txtNome, c);
        
        lblTelefone = new JLabel();
        c.gridx = 0;
        c.gridy = 1;
        containerIncluirVisitante.add(lblTelefone, c);
        
        txtTelefone = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        containerIncluirVisitante.add(txtTelefone, c);
        
        lblCpf = new JLabel();
        c.gridx = 0;
        c.gridy = 2;
        containerIncluirVisitante.add(lblCpf, c);
       
        txtCpf = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        containerIncluirVisitante.add(txtCpf, c);
        
        btnCadastrarVisitante = new JButton();
        c.gridx = 1;
        c.gridy = 3;
        containerIncluirVisitante.add(btnCadastrarVisitante, c);
        //Conteudo dos componentes
        lblNome.setText("Nome: ");
        lblTelefone.setText("Telefone: ");
        lblCpf.setText("Cpf: ");
        btnCadastrarVisitante.setText("Cadastrar Funcionario");
        
        //Acao do Botao
        GerenciadorBotaoCadastrarVisitante gerenciadorBtnCadastrarVisitante = new GerenciadorBotaoCadastrarVisitante();
        btnCadastrarVisitante.addActionListener(gerenciadorBtnCadastrarVisitante);
        
                
        //Adicionando componentes a tela
   
        
        //Configuracoes da tela
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
        /*System.out.println("----------CADASTRAR VISITANTE----------");
        System.out.println("Nome: ");
        String nome = recebeValorString();
        System.out.println("Telefone: ");
        long telefone = recebeValorLong();
        System.out.println("Cpf: ");
        int cpf = recebeValorInteiro();
        ControladorPessoa.getInstancia().cadastrarVisitante(nome, telefone, cpf);*/
    }

    public void excluirVisitante() {
        System.out.println("----------EXCLUIR VISITANTE----------");
        System.out.println("Cpf: ");
        long cpf = recebeValorLong();
        ControladorPessoa.getInstancia().excluirVisitante(cpf);
    }

    public void listarVisitantes() {
        System.out.println("----------LISTA DE VISITANTES----------");
        System.out.println("Nome               Telefone               Cpf");
        ControladorPessoa.getInstancia().listarVisitantes();
    }

    public void alterarVisitante() {
        System.out.println("----------ALTERAR VISITANTE----------");
        System.out.println("Digite o Cpf do visitante que deseja alterar: ");
        int cpf = recebeValorInteiro();
        Visitante visitante = ControladorPessoa.getInstancia().encontrarVisitantePeloCpf(cpf);
        this.exibirDadosVisitante(visitante.getNomePessoa(), visitante.getTelefonePessoa(), visitante.getCpf());
        System.out.println("----------------------------------");
        System.out.println("Novo Nome: ");
        String novoNome = recebeValorString();
        System.out.println("Novo Telefone: ");
        long novoTelefone = recebeValorLong();
        System.out.println("Novo Cpf: ");
        int novoCpf = recebeValorInteiro();
        ControladorPessoa.getInstancia().alterarVisitante(visitante, novoNome, novoTelefone, novoCpf);
        this.exibirDadosVisitante(novoNome, novoTelefone, novoCpf);
    }

    public void exibirDadosAluno(String nome, long telefone, int matricula) {
        System.out.println("------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Matricula: " + matricula);
    }

    public void exibirDadosVisitante(String nome, long telefone, long cpf) {
        System.out.println("------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Cpf: " + cpf);
    }

    public void exibirDadosFuncionario(String nome, long telefone, int siape) {
        System.out.println("------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Siape: " + siape);
    }
    private class GerenciadorBotoes implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent ae){
            ControladorPessoa.getInstancia().exibirTelas(ae.getActionCommand());
        }
    }
    private class GerenciadorBotaoCadastrarAluno implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae){
            String nome = txtNome.getText();
            long telefone = Long.parseLong(txtTelefone.getText());
            int matricula = Integer.parseInt(txtMatricula.getText());
            
            ControladorPessoa.getInstancia().cadastrarAluno(nome, telefone, matricula);
        }

    }
    private class GerenciadorBotaoCadastrarFuncionario implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae){
            String nome = txtNome.getText();
            long telefone = Long.parseLong(txtTelefone.getText());
            int siape = Integer.parseInt(txtSiape.getText());
            
            ControladorPessoa.getInstancia().cadastrarFuncionario(nome, telefone, siape);
        }

    }
    private class GerenciadorBotaoCadastrarVisitante implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae){
            String nome = txtNome.getText();
            long telefone = Long.parseLong(txtTelefone.getText());
            int cpf = Integer.parseInt(txtCpf.getText());
            
            ControladorPessoa.getInstancia().cadastrarVisitante(nome, telefone, cpf);
        }

    }

}
