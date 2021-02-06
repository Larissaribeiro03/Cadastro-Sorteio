package com.orangeTalents.Desafio.usuarioSorteio.controller;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.orangeTalents.Desafio.usuarioSorteio.model.usuarioSorteio;
import com.orangeTalents.Desafio.usuarioSorteio.repository.UsuarioSorteioRepository;
import com.orangeTalents.Desafio.usuarioSorteio.service.UsuarioSorteioService;

@Controller
public class usuarioSorteioController{

	@Autowired
	private UsuarioSorteioService usuarioSorteioService;
	@Autowired
	public usuarioSorteioController() {}
	
	@RequestMapping("/")
	public String exibirPaginaInicial(){
				return "Inicio"; //exibição da página inicial
		}
	
	@RequestMapping(value="/exibirFormularioAdicionar") //Ação executada após clique no link/botão "Vamos à sorte!!!" da página Inicio.html ou Consulta.html
	public String exibirFormularioAdicionar( Model model ){
		
		usuarioSorteio instanciaUsuarioSorteio = new usuarioSorteio(); //instancia a classe usuárioSorteio
		model.addAttribute("usuarioSorteio", instanciaUsuarioSorteio); //
		return "CadastroSorteio"; //carrega a página CadastroSorteio.html
	}

	@RequestMapping(value="/adicionarSorteio", method = RequestMethod.POST) //Ação executada após clicar no botão "Sortear" da página CadastroSorteio.html
	public String adicionarSorteio( @ModelAttribute("usuarioSorteio") usuarioSorteio usuarioSorteio ){ //captura o nome e e-mail inseridos pelo usuário e guarda no objeto usuárioSorteio
		
		Random gerador = new Random(); //instancia a classe Random
		usuarioSorteio.setSorteio(gerador.nextInt(100)); //gerador de numero aleatório de 0 a 100 e grava no atributo "sorteio" do objeto "usuarioSorteio"
		usuarioSorteioService.salvarSorteioNoBanco(usuarioSorteio); //salva as informações capturadas pela variavel "usuarioSorteio"
		
	    return "CadastroSorteio";
	}
	@RequestMapping(value="/exibirConsultar") //Ação executada após clicar no link/botão "Consulte seus números" da página Inicio.Html ou CadastroSorteio.html
	public String exibirConsultar( Model model ){
		return "Consulta"; //Carrega a página Consulta.html
	}
}