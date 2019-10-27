package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int user = 0;
		System.out.println("\nMENU");
		System.out.println("1. Look up film by ID");
		System.out.println("2. Look up a film by search keyword");
		System.out.println("3. Exit the application");
		System.out.println();
		try {
			user = input.nextInt();
		} catch (InputMismatchException e) {
			input.nextLine();
			System.out.println();
		}

		switch (user) {
		case 1:
			filmById(input);

			break;
		case 2:
			Scanner sc = new Scanner(System.in);
			String search;
			System.out.print("Enter search criteria: ");
			search = sc.nextLine();
			System.out.println();
			List<Film> f = db.search(search);
			if (f == null) {
				System.err.println("Try a different search input\n");
			} else {
				for (Film f2 : f) {
					System.out.println(f2);
					if (f2.getActor() != null) {
						for (Actor a : f2.getActor()) {
							System.out.println(a);
						}
					}
					else {
						System.out.println("No actors");
					}
				}

			}

			break;
		case 3:
			System.out.println("exiting");
			break;
		default:
			System.err.println("Not an option, try again");
			break;
		}
		if (user != 3) {
			launch();
		}
		

	}
	public void filmById(Scanner input) {
		int id = 0;
		System.out.print("Enter film id: ");
		try {
			id = input.nextInt();
		} catch (InputMismatchException e) {
			input.nextLine();
			System.out.println();
		}

		Film film = db.findFilmById(id);
		if (film == null) {
			System.err.println("\nInvalid ID, please try again\n");
			filmById(input);
		} else {
			System.out.println(film);
			if(film.getActor() != null) {
			for (Actor a  : film.getActor()) {
				System.out.println(a);
			}
			}
			else {
				System.out.println("No actors");
			}
		}
	}

}
