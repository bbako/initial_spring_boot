package com.henry.initial.file;

import com.henry.initial.product.ProductVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileController {

    @Value("${spring.servlet.multipart.location}")
    private String FILE_PATH;

//    @Autowired
//    ProductService productService;

    @PostMapping(value = "/uploadAjaxAction")
    public void uploadAjaxPost(MultipartFile[] uploadFile, ProductVO productVO) {

        List<ProductVO> list = new ArrayList<>();

        for (MultipartFile multipartFile : uploadFile) {

            String uploadFileName = multipartFile.getOriginalFilename();

            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);

            productVO.setFileName(uploadFileName);

            UUID uuid = UUID.randomUUID();

            uploadFileName = uuid.toString() + "_" + uploadFileName;

            try {

                File saveFile = new File(uploadFileName);

                multipartFile.transferTo(saveFile);

                ProductVO saveProductVO = new ProductVO(
                        productVO.getProductName(),
                        productVO.getProductComment(),
                        uploadFileName,
                        FILE_PATH);

//                productService.addProduct(saveProductVO);

                list.add(productVO);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

    @GetMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileName, HttpServletRequest request) {

        File file = new File(fileName);

        ResponseEntity<byte[]> result = null;

        try {
            HttpHeaders header = new HttpHeaders();

            header.add("Content-Type", Files.probeContentType(file.toPath()));

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return result;

    }

}

