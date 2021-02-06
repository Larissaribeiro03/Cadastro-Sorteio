package com.orangeTalents.Desafio.usuarioSorteio.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orangeTalents.Desafio.usuarioSorteio.model.usuarioSorteio;
import com.orangeTalents.Desafio.usuarioSorteio.repository.UsuarioSorteioRepository;

@Service // valida os dados e executa as regras de negócio
public class UsuarioSorteioService {

	@Autowired
	private UsuarioSorteioRepository usuarioSorteioRepository;
	public UsuarioSorteioService() {}

	public void salvarSorteioNoBanco(usuarioSorteio usuarioSorteio) {
		usuarioSorteioRepository.save(usuarioSorteio);
	}
}
