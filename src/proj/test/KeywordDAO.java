package proj.test;

import java.util.List;

public interface KeywordDAO {

	void outkeyword(List< KeywordVO> list ) throws Exception;

	List<KeywordVO> inkeyword() throws Exception;
	
	
}
