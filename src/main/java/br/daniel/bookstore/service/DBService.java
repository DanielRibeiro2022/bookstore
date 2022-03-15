package br.daniel.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.daniel.bookstore.domain.Categoria;
import br.daniel.bookstore.domain.Livro;
import br.daniel.bookstore.repositories.CategoriaRepository;
import br.daniel.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private  CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
			Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
			Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
			Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");
			
			Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsum", cat1);
			Livro l2 = new Livro(null, "Engenharia de Softeware", "Não sei ", "Loren ipsum", cat1);
			Livro l3 = new Livro(null, "The Time Machine", "Test", "Loren ipsum", cat2);
			Livro l4 = new Livro(null, "The War of The World", "Robert Martin", "Loren ipsum", cat2);
			Livro l5 = new Livro(null, "I,Robot", "Robert Martin", "Loren ipsum", cat2);
			
			cat1.getLivros().addAll(Arrays.asList(l1,l2));
			cat1.getLivros().addAll(Arrays.asList(l3,l4,l5));
			
			this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
			
			this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}	
}
