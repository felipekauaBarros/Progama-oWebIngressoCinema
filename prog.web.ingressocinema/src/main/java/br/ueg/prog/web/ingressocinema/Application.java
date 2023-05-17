package br.ueg.prog.web.ingressocinema;

import br.ueg.prog.web.ingressocinema.model.cadastroIngresso;
import br.ueg.prog.web.ingressocinema.repository.IngressoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean //objeto que faz qualquer coisa
	public CommandLineRunner commandLineRunner(IngressoRepository ingressoRepository) {
		return args -> {
			System.out.println("Executado");
			System.out.println(ingressoRepository);
			cadastroIngresso ingresso = new cadastroIngresso();
			ingresso.setIdCodigo(1L);
			ingresso.setNomeCliente("Felipe kauã");
			ingresso.setSalaFime("Sala 05");
			ingresso.setAssentoSala("F06");
			ingresso.setTipoIngresso("Meia");
			ingresso.setData_horaFilme("01/04/2023 as 21:00h");
			ingresso.setCategoriaFilme("Terror");
			ingresso.setNomeFilme("Scream 6");

			ingresso = new cadastroIngresso();
			ingresso.setIdCodigo(2L);
			ingresso.setNomeCliente("Sara");
			ingresso.setSalaFime("Sala 05");
			ingresso.setAssentoSala("F07");
			ingresso.setTipoIngresso("Meia");
			ingresso.setData_horaFilme("14/04/2023 as 20:00h");
			ingresso.setCategoriaFilme("Ação");
			ingresso.setNomeFilme("John Wick 4");
			/*Optional<cadastroIngresso> ingressoById = ingressoRepository.findCadastroIngressoByidCodigo(ingresso.getIdCodigo());
			Integer idCount = ingressoRepository.countId(ingresso.getIdCodigo());
			if(idCount>0) {
				System.out.println("Ingresso nao existe");
			}
			if(ingressoById.isPresent()){
				cadastroIngresso ingressoCliente = ingressoById.get();
				System.out.println("Ingresso pertence: "+ingressoCliente.getNomeCliente());
			}else {
				ingressoRepository.save(ingresso);
			}
			try{
				ingressoRepository.save(ingresso);
			}catch (Exception e) {
				e.printStackTrace();
			}*/

			System.out.println("Ingresso 2: " +ingresso);
			imprimir_Lista(ingressoRepository);
			ingressoRepository.delete(ingresso);
			imprimir_Lista(ingressoRepository);
		};
	}

	private static void imprimir_Lista(IngressoRepository ingresso_repository) {
		List<cadastroIngresso> lista = ingresso_repository.findAll();
		lista.forEach(item ->{
			System.out.println("Ingressos: " +item);
		});
	}

}
