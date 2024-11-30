package com.meusalugueis.demo.service;
import org.springframework.web.multipart.MultipartFile;

public interface SalvarArquivosService {
    
    String save_corretor(MultipartFile file);

    String save_imovel(MultipartFile file);
}
