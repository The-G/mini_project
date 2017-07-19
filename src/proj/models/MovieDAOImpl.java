package proj.models;

import proj.models.MovieDAOImpl;

public class MovieDAOImpl implements MovieDAO {

	private static MovieDAOImpl movieDAO = null;

	public static MovieDAOImpl getInstance() { // singleton
		if (movieDAO == null) {
			movieDAO = new MovieDAOImpl();
		}
		return movieDAO;
	}
	
	
}
