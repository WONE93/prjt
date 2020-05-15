package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;
import emp.EmpVO;



public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;

	// 등록
	public int memberInsert(MemberVO member) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into member (id, pwd, name, hobby,  gender, religion, introduction, regdt)"
					+ " values ( ?, ?, ?, ?, ?, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getHobby());
			psmt.setString(5, member.getGender());
			psmt.setString(6, member.getReligion());
			psmt.setString(7, member.getIntroduction());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}

	// 전체조회
	public ArrayList<MemberVO> getMemberList(int start, int end, String name) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>(); // 1.어레이리스트에 담기
		try {
			conn = ConnectionManager.getConnnect();
			String strWhere = " where 1 = 1 "; 
			if(name != null && ! name.isEmpty() ) {
				strWhere += " and name = ? ";	
		}
		String sql =  "select B.* from ( select A.* ,rownum RN from ( "
				+ " select * from member " + strWhere + " order by id "
				+ " ) A ) B where RN between ? and ? ";	
				
		psmt = conn.prepareStatement(sql);
		System.out.println(sql);
		int post = 1;
		if(name != null && ! name.isEmpty() ) {
			psmt.setString(post++, name);
		}
		psmt.setInt(post++, start);
		psmt.setInt(post++, end); //1페이지 2페이지 나누기 처리		
		ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO(); // 4. 위치 while 안으로
				vo.setId(rs.getString("id"));
				vo.setGender(rs.getString("gender"));
				vo.setHobby(rs.getString("hobby"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setReligion(rs.getString("religion"));
				vo.setRegdt(rs.getString("regdt")); // 결과값에 담기
				list.add(vo); // 5.리스트에 담기
			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return list;
	}

	// 한건조회
	public MemberVO getMember(String id) {
		MemberVO vo = new MemberVO();
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리 준비
			String sql = "select * from member where id=?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, id); // 첫번재 물음표 값이 id다
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setGender(rs.getString("gender"));
				vo.setHobby(rs.getString("hobby"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setReligion(rs.getString("religion"));
				vo.setRegdt(rs.getString("regdt")); // 결과값에 담기
			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return vo;
	}

	// 수정
	public int memberUpdate(MemberVO member) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update member set pwd=?, name=?, " + "hobby=?,  gender=?, religion=?, " + "introduction=?"
					+ " where id=?"; // id는 pk라서 수정불가

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(7, member.getId());
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getHobby());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getReligion());
			psmt.setString(6, member.getIntroduction());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}
	
	//페이징전체건수
		public int getCount(String name) {
			int cnt = 0;
			try {
				
				conn = ConnectionManager.getConnnect();
				String strWhere = " where 1 = 1 ";
				if(name != null && ! name.isEmpty() ) {
					strWhere += " and name = ? ";
				}
				
				String sql = "select count(*) from member" + strWhere;
				psmt = conn.prepareStatement(sql);
				
				int post = 1;
				if(name != null && ! name.isEmpty() ) {
					psmt.setString(post++, name);
				}
				
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
					cnt = rs.getInt(1); 
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(conn);
			}
			return cnt;
			
		}

}
