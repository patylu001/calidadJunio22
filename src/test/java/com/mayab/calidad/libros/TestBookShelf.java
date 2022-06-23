package com.anahuac.calidad.libros;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.anahuac.calidad.libros.entities.Book;
import com.anahuac.calidad.libros.entities.BookShelf;
import com.anahuac.calidad.libros.entities.BookShelfCapacityReached;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestBookShelf {
	
	//1. Agregar un libro a BookShelf y probar que el tamaño haya aumentado.
	
	
	//2. Crear una instancia de BookShelf con capacidad 3, intentar agregar 4 libros y probar que se 
	//arroje la excepción esperada.
	
	//3. Probar la función arrange (ordenar los libros por nombre, alfabeticamente)

	public BookShelf bs;
	@Before
	public void setUp() throws Exception {
		// Create new object
		bs = new BookShelf(); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddLibro() {
		Book libro1 = new Book("Alicia en el país de las maravillas", "autor1", LocalDate.of(2008, Month.MAY, 8));

		bs.add(libro1);
		
		assertThat(bs.books().size(), is(1));
	}
	
	@Test(expected = BookShelfCapacityReached.class)
	public void testCapExc() {
		bs = new BookShelf(3);
		Book libro1 = new Book("Alicia en el país de las maravillas", "autor1", LocalDate.of(2008, Month.MAY, 8));
		Book libro2 = new Book("Alicia en el país de las maravillas2", "autor1", LocalDate.of(2008, Month.MAY, 8));
		Book libro3 = new Book("Alicia en el país de las maravillas3", "autor1", LocalDate.of(2008, Month.MAY, 8));
		Book libro4 = new Book("Alicia en el país de las maravillas4", "autor1", LocalDate.of(2008, Month.MAY, 8));

		
		bs.add(libro1);
		bs.add(libro2);
		bs.add(libro3);
		bs.add(libro4);
		
		
	}
	
	@Test
	public void testOrden() {
		Book libro1 = new Book("Alicia en el país de las maravillas10", "autor1", LocalDate.of(2008, Month.MAY, 8));
		Book libro2 = new Book("Alicia en el país de las maravillas2", "autor1", LocalDate.of(2008, Month.MAY, 8));
		Book libro3 = new Book("Alicia en el país de las maravillas1", "autor1", LocalDate.of(2008, Month.MAY, 8));
		Book libro4 = new Book("Alicia en el país de las maravillas4", "autor1", LocalDate.of(2008, Month.MAY, 8));

		bs.add(libro1);
		bs.add(libro2);
		bs.add(libro3);
		bs.add(libro4);
		
		List<Book> ordenados = bs.arrange();
	
		assertThat(libro3,is(ordenados.get(0)));
		assertThat(libro1,is(ordenados.get(1)));
		assertThat(libro2,is(ordenados.get(2)));
		assertThat(libro4,is(ordenados.get(3)));
	}
		
		
		
	
	
}
