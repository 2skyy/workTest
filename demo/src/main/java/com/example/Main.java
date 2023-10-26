package com.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/daelim";
        String user = "haneul";
        String password = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            // 사용자 테이블 조회
            String query = "SELECT * FROM 사용자;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // 결과 출력
            while (resultSet.next()) {
                int 사용자_ID = resultSet.getInt("사용자_ID");
                String 이름 = resultSet.getString("이름");
                int 나이 = resultSet.getInt("나이");
                String 성별 = resultSet.getString("성별");
                String 주소 = resultSet.getString("주소");

                System.out.format("사용자_ID: %d, 이름: %s, 나이: %d, 성별: %s, 주소: %s%n", 사용자_ID, 이름, 나이, 성별, 주소);
            }

            conn.close();
            System.out.println("프로그램이 성공적으로 실행되었습니다.");

        } catch (Exception e) {
            System.err.println("오류가 발생했습니다: " + e.getMessage());
        }
    }
}
