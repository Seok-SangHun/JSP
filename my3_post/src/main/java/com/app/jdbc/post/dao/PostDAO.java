package com.app.jdbc.post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.post.config.Configuration;
import com.app.jdbc.post.vo.PostVO;

public class PostDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	// 전체 게시물 조회
	public List<PostVO> selectAll() {
		String query = "SELECT ID, POST_TITLE, POST_LIKED FROM TBL_POST";
		PostVO postVO = null;
		List<PostVO> posts = new ArrayList<>();
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				postVO = new PostVO();
				postVO.setId(resultSet.getLong(1));        // ID
				postVO.setPostTitle(resultSet.getString(2)); // POST_TITLE
				postVO.setPostLiked(resultSet.getInt(3));   // POST_LIKED
				posts.add(postVO);
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

		return posts;
	}

	// 게시물 추가
	public void insert(PostVO post) {
		String query = "INSERT INTO TBL_POST (ID, POST_TITLE, POST_LIKED) "
				+ "VALUES(SEQ_POST.NEXTVAL, ?, ?)";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, post.getPostTitle());
			preparedStatement.setInt(2, post.getPostLiked());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert(PostVO) SQL 오류");
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

	// 게시물 조회 by ID
	public PostVO selectById(Long id) {
		String query = "SELECT ID, POST_TITLE, POST_LIKED FROM TBL_POST WHERE ID = ?";
		PostVO postVO = null;

		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				postVO = new PostVO();
				postVO.setId(resultSet.getLong(1));        // ID
				postVO.setPostTitle(resultSet.getString(2)); // POST_TITLE
				postVO.setPostLiked(resultSet.getInt(3));   // POST_LIKED
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

		return postVO;
	}

	// 게시물 수정
	public void update(PostVO postVO) {
		String query = "UPDATE TBL_POST SET POST_TITLE = ?, POST_LIKED = ? WHERE ID = ?";
		try {
			connection = Configuration.getConnection();
			preparedStatement = connection.prepareStatement(query);
			// 순서대로 제목, 좋아요 수, ID 설정
			preparedStatement.setString(1, postVO.getPostTitle()); // 1번째 자리: POST_TITLE
			preparedStatement.setInt(2, postVO.getPostLiked());    // 2번째 자리: POST_LIKED
			preparedStatement.setLong(3, postVO.getId());          // 3번째 자리: ID

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update(PostVO) SQL 오류");
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

	// 게시물 삭제
	public void delete(Long id) {
		String query = "DELETE FROM TBL_POST WHERE ID = ?";
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

