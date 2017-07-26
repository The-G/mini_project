package proj.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KeywordDAO {


	private static KeywordDAO instance = new KeywordDAO();

	public static KeywordDAO getInstance() {
		return instance;

	}

	public List<KeywordVO> inkeyword() {
		String sql = "select keyword_en,keyword_ko from keyword where keyword_en=null";
		List<KeywordVO> list = new ArrayList<KeywordVO>();
		Connection cn = null;
		Statement ps = null;
		ResultSet rs = null;

		try {
			cn = DBManager.getConnection();
			ps = cn.createStatement();
			rs = ps.executeQuery(sql);
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
	public void outkeyword(String en){ /*en과 ko를 둘다 받아와서 DB에 넣기*/
		String sql = "update set keyword_en=? where keyword_ko=? ";
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = DBManager.getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(3, en);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(cn, ps);
		}
	}
}
