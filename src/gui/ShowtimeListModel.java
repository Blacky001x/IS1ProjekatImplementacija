package gui;

import java.util.List;

import javax.swing.AbstractListModel;

import model.Showtime;

public class ShowtimeListModel extends AbstractListModel<Showtime> {
	
	private static final long serialVersionUID = 1L;
	
	private List<Showtime> showtimes;
	
	public ShowtimeListModel(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}

	@Override
	public int getSize() {
		return showtimes.size();
	}

	@Override
	public Showtime getElementAt(int index) {
		return showtimes.get(index);
	}

}
