package gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import data.GlobalData;
import model.Genres;
import model.Movie;

public class AllMoviesForm extends JFrame {

	private static final long serialVersionUID = 594294440033104181L;

	private JFrame demo;
	
	public AllMoviesForm() {
		demo = new JFrame();
		demo.setTitle("Demo App");
		demo.setSize(600, 400);
		demo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel main = new JPanel();

		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));

		JPanel left = new JPanel();
		JPanel right = new JPanel();

		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

		JList<Movie> list1 = new JList<>();
		JList<String> list2 = new JList<>();

		MovieListModel movieModel = new MovieListModel();
		GenresListModel genresModel = new GenresListModel();

		list1.setModel(movieModel);
		list2.setModel(genresModel);
		
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane s1 = new JScrollPane(list1);
		JScrollPane s2 = new JScrollPane(list2);

		JButton btnFilter = new JButton("FILTRIRAJ");
		JButton btnReset = new JButton("RESET");

		btnReset.addActionListener(event -> {
			movieModel.reset();
			list1.clearSelection();
			list2.clearSelection();
			list1.validate();
		});

		btnFilter.addActionListener(event -> {
			List<String> selectedGenres = list2.getSelectedValuesList();
			List<Genres> filter = new ArrayList<>();
			for (String genre : selectedGenres) {
				filter.add(Genres.valueOf(genre));
			}
			movieModel.filterByGenre(filter);
			list1.validate();
			list1.clearSelection();
			list2.clearSelection();
		});

		JPanel filterOptions = new JPanel();
		filterOptions.setLayout(new BoxLayout(filterOptions, BoxLayout.X_AXIS));
		// filterOptions.add(Box.createHorizontalGlue());
		filterOptions.add(btnReset);
		// filterOptions.add(Box.createHorizontalGlue());
		filterOptions.add(btnFilter);
		// filterOptions.add(Box.createHorizontalGlue());

		left.add(s1);
		right.add(s2);

		JButton btnMoreDetails = new JButton("IZABERI");
		
		btnMoreDetails.addActionListener(e -> {
			Movie movie = list1.getSelectedValue();
			new MovieDetailsForm(movie);
		});
		
		left.add(btnMoreDetails);
		right.add(filterOptions);

		right.setMaximumSize(new Dimension(right.getWidth(), Integer.MAX_VALUE));

		main.add(left);
		main.add(Box.createHorizontalStrut(12));
		main.add(right);
		
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		
		if (GlobalData.activeUser == null) {
			JButton btnLogin = new JButton("PRIJAVA");
			JButton btnRegister = new JButton("REGISTRACIJA");
			
			btnLogin.addActionListener(e -> {
				LoginForm f = new LoginForm();
				f.setVisible(true);
				demo.dispose();
				
			});
			
			btnRegister.addActionListener(e -> {
				RegisterForm f = new RegisterForm();
				f.setVisible(true);
				demo.dispose();
				
			});
			
			top.add(btnRegister);
			top.add(btnLogin);
		} else {
			JLabel currentUser = new JLabel(GlobalData.activeUser.getUsername());
			
			JButton btnLogout = new JButton("ODJAVI SE");
			btnLogout.addActionListener(e -> {
				GlobalData.activeUser = null;
				// may be stupid to dispose current frame and create a new one just to refresh data
				// but don't have any better idea
				AllMoviesForm form = new AllMoviesForm();
				form.setVisible(true);
				demo.dispose();
			});
			
			top.add(currentUser);
			top.add(btnLogout);
		}
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.add(top);
		content.add(main);
		
		demo.add(content);
		demo.setVisible(true);
	}
	
	public void setVisible(boolean visible) {
		demo.setVisible(visible);
	}

	public static void main(String[] args) {
		
		AllMoviesForm form = new AllMoviesForm();
		form.setVisible(true);
		
//		AllMoviesForm form = new AllMoviesForm();
//		form.setVisible(true);
		
		// JFrame demo = new JFrame();
		// demo.setTitle("Demo App");
		// demo.setSize(600, 400);
		// demo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//
		// JPanel main = new JPanel();
		//
		// main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
		//
		// JPanel left = new JPanel();
		// JPanel right = new JPanel();
		//
		// left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		// right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		//
		// JList<Movie> list1 = new JList<>();
		// JList<String> list2 = new JList<>();
		//
		// MovieListModel movieModel = new MovieListModel();
		// GenresListModel genresModel = new GenresListModel();
		//
		// list1.setModel(movieModel);
		// list2.setModel(genresModel);
		//
		// JScrollPane s1 = new JScrollPane(list1);
		// JScrollPane s2 = new JScrollPane(list2);
		//
		// JButton btnFilter = new JButton("FILTRIRAJ");
		// JButton btnReset = new JButton("RESET");
		//
		// btnReset.addActionListener(event -> {
		// movieModel.reset();
		// list1.clearSelection();
		// list2.clearSelection();
		// });
		//
		// btnFilter.addActionListener(event -> {
		// List<String> selectedGenres = list2.getSelectedValuesList();
		// movieModel.filterByGenre(selectedGenres);
		// list1.validate();
		// list1.clearSelection();
		// list2.clearSelection();
		// });
		//
		// JPanel filterOptions = new JPanel();
		// filterOptions.setLayout(new BoxLayout(filterOptions, BoxLayout.X_AXIS));
		//// filterOptions.add(Box.createHorizontalGlue());
		// filterOptions.add(btnReset);
		//// filterOptions.add(Box.createHorizontalGlue());
		// filterOptions.add(btnFilter);
		//// filterOptions.add(Box.createHorizontalGlue());
		//
		// left.add(s1);
		// right.add(s2);
		//
		// JButton btnReserve = new JButton("REZERVISI");
		// left.add(btnReserve);
		// right.add(filterOptions);
		//
		// right.setMaximumSize( new Dimension(right.getWidth(), Integer.MAX_VALUE) );
		//
		//
		// main.add(left);
		// main.add(Box.createHorizontalStrut(12));
		// main.add(right);
		//
		// demo.add(main);
		// demo.setVisible(true);

	}

}
