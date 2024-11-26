package com.app.jdbc.menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.jdbc.menu.config.Configuration;
import com.app.jdbc.menu.vo.MenuVO;

public class MenuDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    // 전체 메뉴 조회
    public List<MenuVO> selectAll() {
        String query = "SELECT ID, MENU_NAME, MENU_PRICE FROM TBL_MENU";
        MenuVO menuVO = null;
        List<MenuVO> menuList = new ArrayList<>();
        try {
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                menuVO = new MenuVO();
                menuVO.setId(resultSet.getLong(1));           // ID
                menuVO.setMenuName(resultSet.getString(2));   // MENU_NAME
                menuVO.setMenuPrice(resultSet.getInt(3));     // MENU_PRICE
                menuList.add(menuVO);
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
        return menuList;
    }

    // 메뉴 추가
    public void insert(MenuVO menuVO) {
        String query = "INSERT INTO TBL_MENU (ID, MENU_NAME, MENU_PRICE) VALUES (SEQ_MENU.NEXTVAL, ?, ?)";
        try {
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, menuVO.getMenuName());
            preparedStatement.setInt(2, menuVO.getMenuPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert(MenuVO) SQL 오류");
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

    // 메뉴 조회 by ID
    public MenuVO selectById(Long id) {
        String query = "SELECT ID, MENU_NAME, MENU_PRICE FROM TBL_MENU WHERE ID = ?";
        MenuVO menuVO = null;

        try {
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                menuVO = new MenuVO();
                menuVO.setId(resultSet.getLong(1));           // ID
                menuVO.setMenuName(resultSet.getString(2));   // MENU_NAME
                menuVO.setMenuPrice(resultSet.getInt(3));     // MENU_PRICE
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
        return menuVO;
    }

    // 메뉴 수정
    public void update(MenuVO menuVO) {
        String query = "UPDATE TBL_MENU SET MENU_NAME = ?, MENU_PRICE = ? WHERE ID = ?";
        try {
            connection = Configuration.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, menuVO.getMenuName());  // 1번째 자리: MENU_NAME
            preparedStatement.setInt(2, menuVO.getMenuPrice());    // 2번째 자리: MENU_PRICE
            preparedStatement.setLong(3, menuVO.getId());          // 3번째 자리: ID

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update(MenuVO) SQL 오류");
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

    // 메뉴 삭제
    public void delete(Long id) {
        String query = "DELETE FROM TBL_MENU WHERE ID = ?";
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

