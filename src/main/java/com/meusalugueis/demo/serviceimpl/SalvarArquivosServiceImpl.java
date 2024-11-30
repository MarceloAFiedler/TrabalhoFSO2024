package com.meusalugueis.demo.serviceimpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.meusalugueis.demo.service.SalvarArquivosService;


@Service
public class SalvarArquivosServiceImpl implements SalvarArquivosService{
    
    @Value("${corretores}")
    private String PASTA_CORRETORES;

    @Value("${imoveis}")
    private String PASTA_IMOVEIS;
    
    private Path root = null;

    @Override
    public String save_corretor(MultipartFile file) {
        File dir = new File(PASTA_CORRETORES);
        if (! dir.exists()){
            dir.mkdir();
        }
        root = Paths.get(PASTA_CORRETORES);
        UUID uuid = UUID.randomUUID();
        String novoNome = String.format("%s.%s", uuid.toString(), file.getOriginalFilename().split("\\.")[1]);
        Path nomeArquivo = this.root.resolve(novoNome);
        try {
            Files.copy(file.getInputStream(), nomeArquivo);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível salvar o arquivo. Error: " + e.getMessage());
        }
        return nomeArquivo.toAbsolutePath().toString();
    }

    @Override
    public String save_imovel(MultipartFile file) {
        File dir = new File(PASTA_IMOVEIS);
        if (! dir.exists()){
            dir.mkdir();
        }
        root = Paths.get(PASTA_IMOVEIS);
        UUID uuid = UUID.randomUUID();
        String novoNome = String.format("%s.%s", uuid.toString(), file.getOriginalFilename().split("\\.")[1]);
        Path nomeArquivo = this.root.resolve(novoNome);
        try {
            Files.copy(file.getInputStream(), nomeArquivo);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível salvar o arquivo. Error: " + e.getMessage());
        }
        return nomeArquivo.toAbsolutePath().toString();
    }
    
}
