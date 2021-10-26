/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertmp3;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Familia
 */

public class RemoveEspecialCaracter {
   
            
     public static String converte(String text) { 
		
		
	    return text.replaceAll("[ãâàáä]", "a")   
	                .replaceAll("[êèéë]", "e")   
	                .replaceAll("[îìíï]", "i")   
	                .replaceAll("[õôòóö]", "o")   
	                .replaceAll("[ûúùü]", "u")   
	                .replaceAll("[ÃÂÀÁÄ]", "A")   
	                .replaceAll("[ÊÈÉË]", "E")   
	                .replaceAll("[ÎÌÍÏ]", "I")   
	                .replaceAll("[ÕÔÒÓÖ]", "O")   
	                .replaceAll("[ÛÙÚÜ]", "U")   
	                .replace('ç', 'c')   
	                .replace('Ç', 'C')   
	                .replace('ñ', 'n')   
	                .replace('Ñ', 'N')
                        .replaceAll("’","")
                        .replaceAll("“", "")
                        .replaceAll("”", "")
	                .replaceAll("!", "")	
                        .replaceAll("  ", ".")
	                .replaceAll ("\\[\\´\\`\\?!\\@\\#\\$\\%\\¨\\*","")
	                .replaceAll("\\(\\)\\=\\{\\}\\[\\]\\~\\^\\]","")
	                .replaceAll("[\\;\\-\\_\\+\\'\\ª\\º\\:\\;\\/]","");
	  
 }
     
   public static void inputNames(){
      File MeuArquivo;
        // Aqui A variavel recebe o nome do diret�rio dos arquivos
        MeuArquivo = new File("C:\\Users\\Familia\\Downloads\\Video\\Edit\\vds");
        File[] Lista;
        // Aqui a string Lista recebe o nome de todos os arquivos presentes na pasta "MeuArquivo"
        // chcp 1252
        Lista = MeuArquivo.listFiles();
       String Arq2 = "";
       String novaString = "";
        int cont = 0;
        for(File fileTmp: Lista){
           cont ++;            
           Arq2 += fileTmp.getName();
           System.out.println("Original: "+Arq2);
           novaString = converte(Arq2);
           File rename = new File(fileTmp.getParent(),novaString);
            boolean success = fileTmp.renameTo(rename);   
               if (!success){
                   System.out.println("nao foi possivel renomear o arquivo: "+ novaString);
                   
               }
           
           Arq2 = "";
            System.out.println("renomeado para: "+novaString);
            novaString = "";
        }
       System.out.println("\n .....................FILANIZADO!\n pause");
    
   }
    public static void main(String[] args) {
        
    }
}
