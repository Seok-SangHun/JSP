package com.app.jdbc.product.dao;

import java.io.ObjectInputFilter.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.product.config.Configuration;
import com.app.jdbc.product.vo.ProductVO;

public class ProductDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
//	전체 상품 조회
	public List<ProductVO> selectAll(){
		String query="SELECT ID, PRODUCT_NAME, PRODUCT_PRICE "
				+ "FROM TBL_PRODUCT";
		ProductVO productVO = null;
		List<ProductVO> products = new ArrayList<>();
		try {
			connection=Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				productVO = new ProductVO();
				productVO.setId(resultSet.getLong(1));
				productVO.setProductName(resultSet.getString(2));
				productVO.setProductPrice(resultSet.getInt(3));
				products.add(productVO);
			}
		} catch (SQLException e) {
			System.out.println("selectAll() SQL 오류");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}

		return products;
	}
	
// 상품 추가
	public void insert(ProductVO product) {
		String query = "INSERT INTO SCOTT.TBL_PRODUCT "
				+ "(ID, PRODUCT_NAME, PRODUCT_PRICE) "
				+ "VALUES(SEQ_PRODUCT.NEXTVAL, ?, ?)";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setInt(2, product.getProductPrice());
			preparedStatement.executeUpdate();
		
		}catch (SQLException e) {
			System.out.println("insert(GuestVO) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
	
//	상품 조회
	public ProductVO selectById(Long id) {
		String query = "SELECT ID, PRODUCT_NAME, PRODUCT_PRICE "
				+ "FROM TBL_PRODUCT "
				+ "WHERE ID = ?";
		ProductVO productVO = null;
		
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				productVO = new ProductVO();
				productVO.setId(resultSet.getLong(1));
				productVO.setProductName(resultSet.getString(2));
				productVO.setProductPrice(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			System.out.println("selectById(Long) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}

		return productVO;
	}
	
//	상품 정보 수정
	public void update(ProductVO productVO) {
		String query = "UPDATE TBL_PRODUCT "
				+ "SET PRODUCT_NAME=?, PRODUCT_PRICE=? "
				+ "WHERE ID=?";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			// 순서대로 상품명, 가격, ID 설정
	        preparedStatement.setString(1, productVO.getProductName());  // 1번째 자리: PRODUCT_NAME
	        preparedStatement.setInt(2, productVO.getProductPrice());    // 2번째 자리: PRODUCT_PRICE
	        preparedStatement.setLong(3, productVO.getId());             // 3번째 자리: ID
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("update(productVO) SQL 오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
	}
	
//	상품 삭제
	public void delete(Long id) {
		String query ="DELETE FROM SCOTT.TBL_PRODUCT "
				+ "WHERE ID=?";
		try {
		       // 데이터베이스 연결 얻기
		       connection = Configuration.getConnection();
		       preparedStatement = connection.prepareStatement(query);
		       // ID 설정
		       preparedStatement.setLong(1, id);
		
		       // 쿼리 실행
		       preparedStatement.executeUpdate();
		
		   } catch (SQLException e) {
		       System.out.println("delete(Long) SQL 오류");
		       e.printStackTrace();
		   } catch (Exception e) {
		       System.out.println("알 수 없는 오류");
		       e.printStackTrace();
		   } finally {
		       // 리소스 정리
		       try {
		           if (preparedStatement != null) {
		               preparedStatement.close();
		           }
		           if (connection != null) {
		               connection.close();
		           }
		       } catch (SQLException e) {
		           e.printStackTrace();
		           throw new RuntimeException();
		       }
		   }
		}
		
}
	

