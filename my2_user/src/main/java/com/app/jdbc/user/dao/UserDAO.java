package com.app.jdbc.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.user.config.Configuration;
import com.app.jdbc.user.vo.UserVO;


public class UserDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	// 전체 사용자 조회
	public List<UserVO> selectAll() {
		String query = "SELECT ID, USER_NAME, USER_AGE FROM TBL_USER";
		UserVO userVO = null;
		List<UserVO> users = new ArrayList<>();
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userVO = new UserVO();
				userVO.setId(resultSet.getLong(1));       // ID
				userVO.setUserName(resultSet.getString(2)); // USER_NAME
				userVO.setUserAge(resultSet.getInt(3));    // USER_AGE
				users.add(userVO);
			}
		} catch (SQLException e) {
			System.out.println("selectAll() SQL 오류");
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

		return users;
	}

	// 사용자 추가
	public void insert(UserVO user) {
		String query = "INSERT INTO TBL_USER (ID, USER_NAME, USER_AGE) "
				+ "VALUES(SEQ_USER.NEXTVAL, ?, ?)";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setInt(2, user.getUserAge());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert(UserVO) SQL 오류");
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

	// 사용자 조회 by ID
	public UserVO selectById(Long id) {
		String query = "SELECT ID, USER_NAME, USER_AGE FROM TBL_USER WHERE ID = ?";
		UserVO userVO = null;

		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				userVO = new UserVO();
				userVO.setId(resultSet.getLong(1));       // ID
				userVO.setUserName(resultSet.getString(2)); // USER_NAME
				userVO.setUserAge(resultSet.getInt(3));    // USER_AGE
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

		return userVO;
	}

	// 사용자 정보 수정
	public void update(UserVO userVO) {
		String query = "UPDATE TBL_USER SET USER_NAME = ?, USER_AGE = ? WHERE ID = ?";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			// 순서대로 사용자명, 나이, ID 설정
			preparedStatement.setString(1, userVO.getUserName()); // 1번째 자리: USER_NAME
			preparedStatement.setInt(2, userVO.getUserAge());     // 2번째 자리: USER_AGE
			preparedStatement.setLong(3, userVO.getId());         // 3번째 자리: ID

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update(UserVO) SQL 오류");
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

	// 사용자 삭제
	public void delete(Long id) {
		String query = "DELETE FROM TBL_USER WHERE ID = ?";
		try {
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

