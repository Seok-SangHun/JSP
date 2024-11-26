package com.app.jdbc.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.student.config.Configuration;
import com.app.jdbc.student.vo.StudentVO;

public class StudentDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    // 전체 학생 조회
    public List<StudentVO> selectAll() {
        String query = "SELECT ID, STUDENT_NAME, STUDENT_SCORE FROM TBL_STUDENT";
        StudentVO studentVO = null;
        List<StudentVO> studentList = new ArrayList<>();
        try { 
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                studentVO = new StudentVO();
                studentVO.setId(resultSet.getLong(1));             // ID
                studentVO.setStudentName(resultSet.getString(2));  // STUDENT_NAME
                studentVO.setStudentScore(resultSet.getInt(3));    // STUDENT_SCORE
                studentList.add(studentVO);
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
        return studentList;
    }

    // 학생 추가
    public void insert(StudentVO studentVO) {
        String query = "INSERT INTO TBL_STUDENT (ID, STUDENT_NAME, STUDENT_SCORE) VALUES (SEQ_STUDENT.NEXTVAL, ?, ?)";
        try {
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentVO.getStudentName());
            preparedStatement.setInt(2, studentVO.getStudentScore());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert(StudentVO) SQL 오류");
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

    // 학생 조회 by ID
    public StudentVO selectById(Long id) {
        String query = "SELECT ID, STUDENT_NAME, STUDENT_SCORE FROM TBL_STUDENT WHERE ID = ?";
        StudentVO studentVO = null;

        try {
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                studentVO = new StudentVO();
                studentVO.setId(resultSet.getLong(1));             // ID
                studentVO.setStudentName(resultSet.getString(2));  // STUDENT_NAME
                studentVO.setStudentScore(resultSet.getInt(3));    // STUDENT_SCORE
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
        return studentVO;
    }

    // 학생 정보 수정
    public void update(StudentVO studentVO) {
        String query = "UPDATE TBL_STUDENT SET STUDENT_NAME = ?, STUDENT_SCORE = ? WHERE ID = ?";
        try {
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentVO.getStudentName());  // 1번째 자리: STUDENT_NAME
            preparedStatement.setInt(2, studentVO.getStudentScore());    // 2번째 자리: STUDENT_SCORE
            preparedStatement.setLong(3, studentVO.getId());             // 3번째 자리: ID

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update(StudentVO) SQL 오류");
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

    // 학생 삭제
    public void delete(Long id) {
        String query = "DELETE FROM TBL_STUDENT WHERE ID = ?";
        try {
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete(Long) SQL 오류");
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
}

