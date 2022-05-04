package com.Poc.multipartjson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

private String product;

private MultipartFile[] images;

private MultipartFile thumb;
}
