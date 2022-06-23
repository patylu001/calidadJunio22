package com.anahuac.calidad.libros;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.anahuac.calidad.libros.entities.Book;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class TestLibroParams {

	public String n;
	public String a;
	public LocalDate f;
	
	public TestLibroParams(String nombre, String autor, LocalDate fecha) {
		n = nombre;
		a = autor;
		f = fecha;
	
	}
	// Set parameters to test
		@Parameters
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][]{
				{"libro1","autor1",LocalDate.of(2008, Month.MAY, 8)},			// Integers
				{"libro2","autor2",LocalDate.of(2008, Month.MAY, 8)},			// Negative Integer
				{"libro3","autor3",LocalDate.of(2008, Month.MAY, 8)}
				
				}); 
			
		}
		
		
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Book libro = new Book(n,a,f);
		
		assertThat(libro.getAuthor(),is(a));
	}

}
