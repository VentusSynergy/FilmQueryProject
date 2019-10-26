package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
    app.launch();
	}

	private void test() throws SQLException {
//	  System.out.println(db.findActorsByFilmId(1));
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int user;
		System.out.println("MENU");
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
			System.out.println(film);
			startUserInterface(input);
			break;
		case 2:
			break;
		case 3:
			System.out.println("exiting");
			break;
		default:
			System.out.println("Not an option, try again");
			startUserInterface(input);
			break;
		}

	}

}
