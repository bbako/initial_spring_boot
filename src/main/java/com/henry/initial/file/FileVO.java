package com.henry.initial.file;

import lombok.*;

@Data
@NoArgsConstructor
public class FileVO {
    private Integer fileId;
    private String fileName;
    private String filePath;
}
