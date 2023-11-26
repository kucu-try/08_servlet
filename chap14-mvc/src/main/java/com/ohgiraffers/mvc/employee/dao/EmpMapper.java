package com.ohgiraffers.mvc.employee.dao;

import com.ohgiraffers.mvc.employee.dto.EmpDTO;
import com.ohgiraffers.mvc.employee.dto.EmpDeleteDTO;
import com.ohgiraffers.mvc.employee.dto.EmpInsertDTO;
import com.ohgiraffers.mvc.employee.dto.EmpUpdateDTO;
import com.ohgiraffers.mvc.employee.service.EmpService;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper {


    EmpDTO selectByEmpId(int empId);

    List<EmpDTO> selectAllEmp();

    int insert(EmpInsertDTO insert);

    int update(EmpUpdateDTO update);

    int delete(EmpDeleteDTO delete);
}
