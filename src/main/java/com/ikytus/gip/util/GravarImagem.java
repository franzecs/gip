package com.ikytus.gip.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GravarImagem {

	@Autowired 
	private ServletContext context;
	
	public String img;
	
	private Base64 base64;

	@SuppressWarnings("static-access")
	public String gravaBase64(MultipartFile file) {
		
		try {
			img = new String(base64.encode(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public void gravaArquivo(MultipartFile file) {
		try {
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(context.getRealPath("/img/") + file.getOriginalFilename());
			Files.write(path, bytes);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getImg() {
		return img;
	}
}
