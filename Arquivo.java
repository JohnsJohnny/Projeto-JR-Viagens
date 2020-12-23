/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Descrição: classe que manipula os dados no arquivo
 * @author JOhnny e Rodrigo
 */
public class Arquivo {

    private String nomeArquivo;
    
    public Arquivo(String n) {
        nomeArquivo = n;
    }
    
    
    public ArrayList<String> listarTodos() {         
        ArrayList<String> lista = new ArrayList<>();        
        try {
            // Passo 1: Verificar se o arquivo existe
            File arquivo = new File(nomeArquivo);
            boolean arquivoExiste = arquivo.exists();
            if (arquivoExiste == false) {
                arquivo.createNewFile();
            }
            // Passo 2: Abrir o arquivo para leitura
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            // Passo 3: Ler o arquivo
            String linha;
            do {
                linha = br.readLine();
                lista.add(linha);
            } while(linha != null);
            // Passo 4: Fechar o arquivo
            br.close();
            fr.close();
        }catch(Exception e) {
        }
        return lista;
    }
    
    public boolean salvar(String linha) {
        try {
            // Passo 1: descobrir se o arquivo existe
            File arquivo;
            arquivo = new File(nomeArquivo);
            boolean arquivoExiste = arquivo.exists();
            if (arquivoExiste == false) {
                // cria o arquivo caso ele não exista
                arquivo.createNewFile();
            }
            // Passo 2: abrir o arquivo para escrita
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            // Passo 3: gravar no arquivo
            bw.write(linha);
            bw.newLine();
            // Passo 4: fechar o arquivo
            bw.close();
            fw.close();
        } catch(Exception e) {        
        }        
        return true;
    }
    
    public String[] pesquisar(int numeroCampo, String chaveBusca) {
        try {
            // PASSO 1: verificar se o arquivo existe
            File arqLeitura = new File(nomeArquivo);
            if (arqLeitura.exists() == false) {
                arqLeitura.createNewFile();
            }
            // PASSO 2: Abrir arquivo para leitura
            FileReader fr = new FileReader(arqLeitura);
            BufferedReader br = new BufferedReader(fr);
            // PASSO 3: Ler o arquivo
            String linha;
            String[] campos;
            do {
                linha = br.readLine();
                if (linha != null) {
                    campos = linha.split(";");
                    if (campos[numeroCampo].equals(chaveBusca)) {
                        // encontrou!
                        return campos;
                    }                    
                }
            } while (linha != null);
            // PASSO 4: Fechar o arquivo
            br.close();
            fr.close();        
        } catch (Exception e) {
        }
        return null;
    }
    
}
