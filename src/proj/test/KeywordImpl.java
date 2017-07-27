package proj.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KeywordImpl implements KeywordDAO {


	private static KeywordImpl instance = new KeywordImpl();

	public static KeywordImpl getInstance() {
		return instance;

	}
	@Override
	public List<KeywordVO> inkeyword() {
		String sql = "select keyword_ko,keyword_en,movie_id from keyword where keyword_en is null";
		List<KeywordVO> list = new ArrayList<KeywordVO>();
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
//			String url="jdbc:log4jdbc:oracle:thin:@70.12.50.62:1521:xe";
//			String uid="bigdata";
//			String pwd="bigdata";
//			cn = DBManager.getConnection(url,uid,pwd);
			cn = DBManager.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				KeywordVO keywordVO = new KeywordVO();

				keywordVO.setKeyword_en(rs.getString("keyword_en"));
				keywordVO.setKeyword_ko(rs.getString("keyword_ko"));
				keywordVO.setMovie_id(rs.getLong("movie_id"));
				list.add(keywordVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(cn, ps, rs);
		}
		return list;
	}
	
	@Override
	public void outkeyword(List< KeywordVO> list ){ /*en과 ko를 둘다 받아와서 DB에 넣기*/
		String sql = "update keyword set keyword_en=? where keyword_ko=? and keyword_en is null";
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = DBManager.getConnection();
			ps = cn.prepareStatement(sql);
			for(KeywordVO keywordVO:list) {
				ps.setString(2,keywordVO.getKeyword_ko());
				ps.setString(1,keywordVO.getKeyword_en());
				ps.executeUpdate();
			}
			System.out.println("업데이트성공");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(cn, ps);
		}
	}

	
}