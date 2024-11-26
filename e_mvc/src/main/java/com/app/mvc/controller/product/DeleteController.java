package com.app.mvc.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.mvc.Action;
import com.app.mvc.Result;
import com.app.mvc.repository.ProductDAO;

public class DeleteController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ProductDAO 객체 생성
        ProductDAO productDAO = new ProductDAO();
        
        // 요청 파라미터에서 ID 값 가져오기
        Long id = Long.valueOf(req.getParameter("id"));
        
        // 상품 삭제
        productDAO.delete(id);
        
        // 삭제 후 리스트 페이지로 리다이렉트
        Result result = new Result();
        result.setPath("/list.product");
        result.setRedirect(true);
        
        return result;
    }

}
