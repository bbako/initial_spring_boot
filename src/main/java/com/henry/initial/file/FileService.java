package com.henry.initial.file;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Integer saveFile(FileVO fileVO) {
        return fileRepository.saveFile(fileVO);
    }

    @Transactional
    public FileVO getFile(Long id) {
//        File file = fileRepository.findById(id).get();
//
//        FileDto fileDto = FileDto.builder()
//                .id(id)
//                .origFilename(file.getOrigFilename())
//                .filename(file.getFilename())
//                .filePath(file.getFilePath())
//                .build();
//        return fileDto;
        return null;
    }
}
