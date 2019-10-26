package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
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
		Scanner sc = new Scanner(System.in);
		int user;
		System.out.println("\nMENU");
		System.out.println("1. Look up film by ID");
		System.out.println("2. Look up a film by search keyword");
		System.out.println("3. Exit the application");
		System.out.println();
		user = input.nextInt();

		switch (user) {
		case 1:
			int id;
			System.out.print("Enter film id: ");

			
			id = input.nextInt();
			Film film = db.findFilmById(id);
			if (film == null) {
				System.out.println("There are no films have that id\n");
			} else {
				System.out.println(film);
			}
			startUserInterface(input);
			break;
		case 2:
			String search;
			System.out.print("Enter search crtiteria: ");
			search = sc.nextLine();
			List<Film> f = db.search(search);
			if (f == null) {
				System.out.println("Try something else\n");
			} else {
				for (Film f2 : f) {
					System.out.println(f2);
					for (Actor a : f2.getActor()) {
						System.out.println(a);
					}
				}

			}

			startUserInterface(input);

			break;
		case 3:
			System.out.println("exiting");
			break;
		default:
			System.out.println("Not an option, try again");
			startUserInterface(input);
			break;
		}
		sc.close();

	}

}
