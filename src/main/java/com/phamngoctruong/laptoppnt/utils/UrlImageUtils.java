package com.phamngoctruong.laptoppnt.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.phamngoctruong.laptoppnt._enum.EOrderStatus;
import com.phamngoctruong.laptoppnt.model.Brand;
import com.phamngoctruong.laptoppnt.model.Category;
import com.phamngoctruong.laptoppnt.model.Order;
import com.phamngoctruong.laptoppnt.model.Product;
import com.phamngoctruong.laptoppnt.model.ProductImage;
import com.phamngoctruong.laptoppnt.model.Transaction;
import com.phamngoctruong.laptoppnt.model.User;
import com.phamngoctruong.laptoppnt.services.ProductServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
public class UrlImageUtils {
	public Boolean saveImage(MultipartFile[] multipartFiles, boolean key, String extenpath, long id)
			throws IOException {
		for (MultipartFile multipartFile : multipartFiles) {
			if (key) {
				String uploadDir = "D:\\Java Web\\Website laptop\\Website laptop\\WebsiteLaptop\\WebsiteLaptop\\src\\main\\resources\\static\\product\\laptop"
						+ extenpath + "\\";
				String fileName = multipartFile.getOriginalFilename().replace(' ', '_');
				save(uploadDir, multipartFile, fileName);
			} else {
				String uploadDir = "D:\\Java Web\\Website laptop\\Website laptop\\WebsiteLaptop\\WebsiteLaptop\\src\\main\\resources\\static\\images\\banner";
				String fileName = multipartFile.getOriginalFilename().replace(' ', '_');
				save(uploadDir, multipartFile, fileName);
			}

		}
		return key;
	}

	public void save(String uploadDir, MultipartFile multipartFile, String fileName) throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}
	
}
