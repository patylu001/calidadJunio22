package com.anahuac.calidad.libros;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//Import mockito
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.anahuac.calidad.libros.entities.Book;
import com.anahuac.calidad.libros.entities.BookShelf;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

public class TestBookShelfMock {

	public BookShelf bs;
	@Before
	public void setUp() throws Exception {
		bs = Mockito.mock(BookShelf.class);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// Set the behavior of the instance
				when(bs.sortByAuthor()).thenAnswer(new Answer<List<Book>>() {
								// Method within the class
								public List<Book> answer(InvocationOnMock invocation) throws Throwable{
									// Set behavior in every invocation 
									List<Book> sorted = new ArrayList<Book>();
									sorted.add(new Book("Alicia en el país de las maravillas2", "autor1", LocalDate.of(2008, Month.MAY, 8)));
									sorted.add(new Book("Alicia en el país de las maravillas2", "autor10", LocalDate.of(2008, Month.MAY, 8)));
									sorted.add(new Book("Alicia en el país de las maravillas2", "autor2", LocalDate.of(2008, Month.MAY, 8)));
									sorted.add(new Book("Alicia en el país de las maravillas2", "autor4", LocalDate.of(2008, Month.MAY, 8)));
									// Return the invoked value
									return sorted; 
								}
							}
						);
				// Exercise the test of mock	
				// Verify
				List<Book> libros = bs.sortByAuthor();
				assertThat("autor1",is(libros.get(0).getAuthor()));
				assertThat("autor10",is(libros.get(1).getAuthor()));
				assertThat("autor2",is(libros.get(2).getAuthor()));
				assertThat("autor4",is(libros.get(3).getAuthor()));
	}

}
