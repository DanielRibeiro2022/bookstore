package br.daniel.bookstore.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.daniel.bookstore.domain.Livro;
import br.daniel.bookstore.repositories.LivroRepository;
import br.daniel.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " +Livro.class.getName()));
		
	}

}
