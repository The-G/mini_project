package proj.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class KeywordImpl implements KeywordDAO{
	private static KeywordImpl keywordDAO = null;
	private String driver = null;
	private String url = null;
	private String username = null;
	private String password = null;
	
	private DataSource ds = null;
	
	private KeywordImpl() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/mydbcp");
		} catch(Exception e) {
			e.printStackTrace();
		}
}
	private void dbClose(ResultSet rs, PreparedStatement ps, Connection cn) {
		if (rs != null) try{rs.close();} catch(Exception e){}
		if (ps != null) try{ps.close();} catch(Exception e){}
		if (cn != null) try{cn.close();} catch(Exception e){}
	}

	@Override
	public void inkeyword(proj.models.KeywordDAO keywordDAO) throws Exception {
		// TODO Auto-generated method stub
		
	}
	private Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static KeywordImpl getInstance() {
		if (keywordDAO == null) {
			keywordDAO = new KeywordImpl();
		}
		return keywordDAO;
	}
	public List<KeywordVO> getKeyword_en() throws Exception {
		Connection cn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<KeywordVO> list = new ArrayList<KeywordVO>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT keyword_ko,keyword_en,movie_id");
		sql.append(" FROM   keyword_en==null and movie_id=#movie_id#");
		
		//movie_id 받아오는거 연습
		

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()) {
				KeywordVO keywordVO = new KeywordVO();
				keywordVO.setKeyword_ko(rs.getString("keyword_ko"));
				keywordVO.setKeyword_en(rs.getString("keyword_en"));
				keywordVO.setMovie_id(rs.getLong("movie_id"));
				list.add(keywordVO);
			}
		} finally {
			dbClose(rs, ps, cn);
		}
		return list;
	}
	public List<KeywordVO> getKeyword_ch() throws Exception {
		Connection cn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<KeywordVO> list = new ArrayList<KeywordVO>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT keyword_ko,keyword_cn,movie_id");
		sql.append(" FROM   keyword_ch==null and movie_id=#movie_id#");
		
		//movie_id 받아오는거 연습
		
		
		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()) {
				KeywordVO keywordVO = new KeywordVO();
				keywordVO.setKeyword_ko(rs.getString("keyword_ko"));
				keywordVO.setKeyword_ch(rs.getString("keyword_ch"));
				keywordVO.setMovie_id(rs.getLong("movie_id"));
				list.add(keywordVO);
			}
		} finally {
			dbClose(rs, ps, cn);
		}
		return list;
	}
}
	