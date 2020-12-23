package entidade;

import persistencia.Arquivo;

/**
 *
 * @author JOhnny e Rodrigo
 */
public class Usuario {
    
    // atributos
    public String login;
    public String senha;
    public String Nome;
    public String Cpf;
    public String Endereco;
    public String Telefone;
    
    // construtor
    public Usuario(String l, String s) {
        login = l;
        senha = s;
    }

        
    
    public boolean validaDadosUsuario() {
        if (login.equals("") || senha.equals("") || Nome.equals("") || Cpf.equals("") || Endereco.equals("") || Telefone.equals("")) {
            return false;
        } else {
            return true;
        }
    }
    
    
    //autenticar Usuario
    public boolean autenticarUsuario(String usuarioDigitado, String senhaDigitada) {
        Arquivo arq = new Arquivo("C:\\Users\\316163116\\Documents\\NetBeansProjects\\ProjetoJRViagens\\Arquivos\\usuario.txt");
        String[] resultado = arq.pesquisar(0, usuarioDigitado);
        if (resultado == null) {
            // nao encontrou 
            return false;
        }
        // armazena login: resultado[0]
        // armazena senha: resultado[1]         
        if (resultado[1].equals(senhaDigitada)) {
            return true;
        }        
        return false;        
    }
    
    // cadastrar Usuario
    public void cadastrarUsuario() {
        Arquivo arq = new Arquivo("C:\\Users\\316163116\\Documents\\NetBeansProjects\\ProjetoJRViagens\\Arquivos\\usuario.txt");
        arq.salvar(login +";"+senha+";"+Nome+";"+Cpf+";"+Endereco+";"+Telefone);
    }
    
    // redefinir a Senha    
    
}
