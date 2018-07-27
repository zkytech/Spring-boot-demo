package com.BugManageSystem.Service;

import com.BugManageSystem.Entity.Types;
import com.BugManageSystem.Entity.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetType{
    // 操作Types对象
    @Autowired
    TypesRepository typesRepository;
    public String getTypenameById(Integer id){
        Types types = typesRepository.findTypesById(id);
        return types.getBugtype();
    }
}
