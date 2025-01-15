//DBTestController.java
package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.DeptDao;
import com.example.model.Dept;

@RestController
public class DBTestController {


	@Autowired
	DeptDao deptDao;

	@GetMapping("/test")
	public List<Dept> DBTestJSON(){
		return deptDao.getBoardList();
	}
	
	@PostMapping("/test")
	public Map<String, Object> registBoard(@RequestBody Dept dept){
		Map<String, Object> response = new HashMap<>();
		try {
	        deptDao.registBoard(dept); // DB에 게시글 등록
	        response.put("status", "success");
	        response.put("message", "게시글이 성공적으로 등록되었습니다.");
	    } catch (Exception e) {
	        response.put("status", "error");
	        response.put("message", "게시글 등록 중 오류가 발생했습니다.");
	    }
		return response;
	}
	
	@GetMapping("/test/{bno}")
	public Dept getBoardDetail(@PathVariable("bno") Long bno) {
		return deptDao.getBoardDetail(bno);
	}
	
	@PutMapping("/test")
    public Map<String, Object> updateBoard(@RequestBody Dept dept) {
        Map<String, Object> response = new HashMap<>();
        try {
            deptDao.updateBoard(dept); // DB에서 게시글 수정
            response.put("status", "success");
            response.put("message", "게시글이 성공적으로 수정되었습니다.");
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "게시글 수정 중 오류가 발생했습니다.");
        }
        return response;
    }

    @DeleteMapping("/test/{bno}")
    public Map<String, Object> deleteBoard(@PathVariable("bno") Long bno) {
        Map<String, Object> response = new HashMap<>();
        try {
            deptDao.deleteBoard(bno); // DB에서 게시글 삭제
            response.put("status", "success");
            response.put("message", "게시글이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "게시글 삭제 중 오류가 발생했습니다.");
        }
        return response;
    }
	
}