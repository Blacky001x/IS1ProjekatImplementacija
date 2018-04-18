package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractListModel;

import model.Genres;

public class GenresListModel extends AbstractListModel<String> {

	private static final long serialVersionUID = 1L;
	
	private List<Genres> genres;
	
	public GenresListModel() {
		
//		genres = Stream.of(Genres.values())
//                .map(Enum::name)
//                .collect(Collectors.toList());
		
		genres = Arrays.asList(Genres.values());
		
	}

	@Override
	public int getSize() {
		return genres.size();
	}

	@Override
	public String getElementAt(int index) {
		return genres.get(index).name();
	}

	
	
}
