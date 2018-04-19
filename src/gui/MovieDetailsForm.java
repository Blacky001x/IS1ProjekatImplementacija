package gui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import data.GlobalData;
import model.Movie;
import model.Reservation;
import model.Showtime;
import repository.ReservationRepositoryMock;

public class MovieDetailsForm {

	private JFrame frame;

	private Movie movie;
	

	/**
	 * Create the application.
	 */
	public MovieDetailsForm(Movie movie) {
		this.movie = movie;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFilmName = new JLabel();
		lblFilmName.setText(movie.getName());
		lblFilmName.setBounds(81, 36, 258, 14);
		frame.getContentPane().add(lblFilmName);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setForeground(Color.PINK);
		panel.setBounds(81, 238, 258, 161);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		JList<Showtime> list = new JList<>();
		list.setModel(new ShowtimeListModel(movie.getShowtimes()));
		JScrollPane scroll = new JScrollPane(list);
		panel.add(scroll);
		
		
		frame.getContentPane().add(panel);
		
		JTextPane txtFilmDescription = new JTextPane();
		txtFilmDescription.setText(movie.getDescription());
		txtFilmDescription.setBounds(81, 105, 258, 99);
		txtFilmDescription.setEditable(false);
		frame.getContentPane().add(txtFilmDescription);
		
		JButton btnReservation = new JButton("Rezervisi");
		btnReservation.setBounds(250, 435, 89, 23);
		
		btnReservation.addActionListener(e -> {
			if (GlobalData.activeUser == null) {
				JOptionPane.showMessageDialog(frame, "Niste prijavljeni!", "Neuspesno", JOptionPane.ERROR_MESSAGE);
				return;
			}
			ReservationRepositoryMock repo = new ReservationRepositoryMock();
			Reservation reservation = repo.add(GlobalData.activeUser, list.getSelectedValue());
			int n = JOptionPane.showConfirmDialog(
				    frame,
				    "Da li zelite odmah i da platite vasu rezervaciju?",
				    "Placanje",
				    JOptionPane.YES_NO_OPTION);
			
			if (n == JOptionPane.YES_OPTION) {
				reservation.setPaid(true);
				JOptionPane.showMessageDialog(frame,
					    "Hvala Vam! Placanje je uspesno proteklo.",
					    "Placanje",
					    JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame,
					    "Vasa rezervacija je uspesno sacuvana.\n\nPlacanje ce biti izvrseno kada dodjete na predstavu.\nStoga, ne zaboravite da ponesete sa sobom dovoljno novca za kartu! :)",
					    "Placanje",
					    JOptionPane.PLAIN_MESSAGE);
			}
			

		});
		
		frame.getContentPane().add(btnReservation);
		
		JButton btnComment = new JButton("Komentarisi");
		btnComment.setBounds(81, 435, 98, 23);
		frame.getContentPane().add(btnComment);
		
		frame.setVisible(true);
	}
}
