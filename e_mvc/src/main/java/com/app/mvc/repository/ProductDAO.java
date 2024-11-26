package com.app.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.app.mvc.domain.ProductVO;
import com.app.mvc.mybatis.config.MyBatisConfiguration;

public class ProductDAO {
	private SqlSession sqlSession;
	
	// MyBatisConfiguration을 통해 SqlSession을 얻음
	public ProductDAO() {
		// 자동 커밋 설정으로 세션을 열어줌 (true)
		sqlSession = MyBatisConfiguration.getSqlSessionFactory().openSession(true);
	}
	
	// 상품 추가 메서드
	// "product.insert" 쿼리를 실행하여 상품 정보를 DB에 삽입
	public void insert(ProductVO productVO) {
		sqlSession.insert("product.insert", productVO);
	}
	
	// 상품 전체 조회 메서드
	// "product.selectAll" 쿼리를 실행하여 모든 상품 정보를 리스트로 반환
	public List<ProductVO> selectAll(){
		return sqlSession.selectList("product.selectAll");
	}
	
	// 상품 조회
	// 개별 상품 조회 메서드로, 주어진 상품 ID를 사용해 해당 상품을 DB에서 조회
	public ProductVO selectById(Long id) {
		return sqlSession.selectOne("product.selectById", id);
	}
	
	// 상품 수정
	// "product.update" 쿼리를 실행하여 주어진 상품 정보로 DB의 상품 정보를 수정
	public void update(ProductVO productVO) {
		sqlSession.update("product.update", productVO);
	}
	
	// 상품 삭제
	// 주어진 상품 ID를 사용해 해당 상품을 DB에서 삭제
	public void delete(Long id) {
		sqlSession.delete("product.delete", id);
	}
}
