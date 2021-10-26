/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertmp3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import convertmp3.RemoveEspecialCaracter;
/**
 *
 * @author Familia
 */

public class ConvertMP3 {

   public static void main(String[] args) throws IOException {
       RemoveEspecialCaracter remove = new RemoveEspecialCaracter();
       remove.inputNames();
       
       File MeuArquivo;
        // Aqui A variavel recebe o nome do diret�rio dos arquivos
        MeuArquivo = new File("C:\\Users\\Familia\\Downloads\\Video\\Edit\\vds");
        File[] Lista;
        // Aqui a string Lista recebe o nome de todos os arquivos presentes na pasta "MeuArquivo"
        // chcp 1252
        Lista = MeuArquivo.listFiles();
       String Arq2 = " ";
       String novaString = null;
        int cont = 0;
        Arq2 += "CHCP 65001 \n";
        for(File fileTmp: Lista){
           cont ++; 
           //System.out.println(fileTmp.getName());
           
           Arq2 +="ffmpeg -i \""+fileTmp.getName()+"\" -vn -ar 44100 -ac 2 -b:a 192k \""+fileTmp.getName()+".MP3\" \n";// Aqui a variavel arq2 � incrementada linearmente de cada nome de arquivo
           novaString = new String(Arq2.getBytes());
           //System.out.println(fileTmp.getName());
           // ISO-8859-1
           if(fileTmp.exists()){
               System.out.println(">> "+Arq2);
           }
        }
        Arq2 += "\n pause";
        novaString += "\n pause";
        System.out.println(Arq2+" -- "+novaString);
        File entrada = new File ("C:\\Users\\Familia\\Downloads\\Video\\Edit\\script de conversao.bat");// arquivo criado
      
            try (FileWriter gravar1 = new FileWriter(entrada)) {
            gravar1.write(novaString);
            gravar1.flush();// 
        }
         
    }
    
}
