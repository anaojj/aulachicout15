package br.com;

import java.io.*;

public class Atv15{
    public static void main(String[] args) {
        String arquivoOrigem = "arquivo_grande.bin";
        String arquivoDestino = "copia_arquivo_grande.bin";

        try {
            // Criar streams de entrada e saída usando buffers para melhorar o desempenho
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(arquivoOrigem));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(arquivoDestino));

            byte[] buffer = new byte[8192]; // Buffer de 8 KB

            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Fechar os streams
            in.close();
            out.close();

            System.out.println("Arquivo copiado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}