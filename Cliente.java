/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.ArrayList;
import persistencia.Arquivo;

/**
 *
 * @author JOhnny e Rodrigo
 */
public class Cliente extends Pessoa {
    
    public int codigo;
    
    // construtor da classe Cliente
    public Cliente() {
        codigo = -1;
        nome   = "";
        cpf = "";
        endereco = "";
    }
    
    // construtor com parametros
    public Cliente(int c, String n, String cp) {
        codigo = c;
        nome = n;
        cpf = cp;
    }
    
    public String exibeDadosCliente() {
        String linha;
        
        linha = codigo + " CPF:" + cpf + " Nome:" + nome + " End.:" + endereco + " Tel.:" + telefone;
        
        return linha;
    }
    
    public boolean validaDadosCliente() {
        if (codigo == 0 || nome.equals("") || cpf.equals("") || endereco.equals("")) {
            return false;
        } else {
            return true;
        }
    }
    
    public void salvar() {
        Arquivo arq = new Arquivo("C:\\Users\\316163116\\Documents\\NetBeansProjects\\ProjetoJRViagens\\Arquivos\\clientes.txt");        
        arq.salvar(codigo+";"+cpf + ";" + nome + ";" + endereco + ";" + telefone);
    }
    
    public void buscarClientes(int idx, String chave) {
        Arquivo arq = new Arquivo("C:\\Users\\316163116\\Documents\\NetBeansProjects\\ProjetoJRViagens\\Arquivos\\clientes.txt");        
        
        String[] retorno;
        
        retorno = arq.pesquisar(idx, chave);
        
        codigo      = Integer.parseInt(retorno[0]);
        cpf         = retorno[1];
        nome        = retorno[2];
        endereco    = retorno[3];
        telefone    = retorno[4];
                
    }
    
    public ArrayList<String> listarClientes() {
        Arquivo arq = new Arquivo("C:\\Users\\316163116\\Documents\\NetBeansProjects\\ProjetoJRViagens\\Arquivos\\clientes.txt");        
        return arq.listarTodos();
    }
}

