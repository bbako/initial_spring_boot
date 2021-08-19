package com.henry.initial.file;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FileRepository{

    private SqlSession sqlSession;

    public Integer saveFile(FileVO fileVO) {
        sqlSession.insert("fileMapper.addFile", fileVO);
        Integer fileId = fileVO.getFileId();
        return fileId;
    }
}
