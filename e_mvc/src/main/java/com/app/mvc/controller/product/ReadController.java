package com.app.mvc.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.mvc.Action;
import com.app.mvc.Result;
import com.app.mvc.domain.ProductVO;
import com.app.mvc.repository.ProductDAO;

public class ReadController implements Action {

    @Override
    public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ProductDAO 객체 생성
        ProductDAO productDAO = new ProductDAO();
        
        // 요청 파라미터에서 ID 값 가져오기
        Long id = Long.valueOf(req.getParameter("id"));
        
        // 해당 ID로 상품 정보 조회
        ProductVO productVO = productDAO.selectById(id);
        
        // 상품 정보를 request 객체에 저장
        req.setAttribute("product", productVO);
        
        // 결과를 전달할 페이지 경로 설정 (read.jsp)
        Result result = new Result();
        result.setPath("read.jsp");
        return result;
    }
}

