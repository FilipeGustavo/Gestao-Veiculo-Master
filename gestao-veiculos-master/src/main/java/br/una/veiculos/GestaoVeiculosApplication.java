package br.una.veiculos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.una.veiculos.model.AnimalEstimacao;
import br.una.veiculos.model.Cidade;
import br.una.veiculos.model.Condominio;
import br.una.veiculos.model.Endereco;
import br.una.veiculos.model.Estado;
import br.una.veiculos.model.Morador;
import br.una.veiculos.model.UnidadeHabitacional;
import br.una.veiculos.model.Veiculo;
import br.una.veiculos.repository.AnimalEstimacaoRepository;
import br.una.veiculos.repository.CidadeRepository;
import br.una.veiculos.repository.CondominioRepository;
import br.una.veiculos.repository.EnderecoRepository;
import br.una.veiculos.repository.EstadoRepository;
import br.una.veiculos.repository.MoradorRepository;
import br.una.veiculos.repository.UnidadeHabitacionalRepository;
import br.una.veiculos.repository.VeiculoRepository;

@SpringBootApplication
public class GestaoVeiculosApplication implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepo;/*Esta variável receberá os objetos veículos no banco de dados?*/
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private AnimalEstimacaoRepository animaisRepo;
	@Autowired
	private CondominioRepository condominiosRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;
	@Autowired
	private MoradorRepository moradorRepo;
	@Autowired
	private UnidadeHabitacionalRepository unidadeHabRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(GestaoVeiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {/*O que vem a ser este Exception?*/
		
		
		Estado est1 = new Estado(1L, "MG");
		Estado est2 = new Estado(2L, "GO");
		estadoRepo.saveAll(Arrays.asList(est1, est2));
		
		Cidade c1 = new Cidade(1L, "Uberlândia",       est1);
		c1 = cidadeRepo.save(c1);
		Cidade c2 = new Cidade(2L, "Araguari",         est1);		
		Cidade c3 = new Cidade(4L, "Catalão",          est2);
		Cidade c4 = new Cidade(5L, "Caldas Novas",     est2);
		
		cidadeRepo.saveAll(Arrays.asList( c1, c2, c3, c4));
		
		Endereco end1 = new Endereco(1L, "Rua Afonso Pena", 500, "Casa", "Centro", "38402-012", c1);
		end1 = enderecoRepo.save(end1);
		
		Condominio cond1 = new Condominio (1L, "Paradiso", false, end1);
		condominiosRepo.save(cond1);
		
		Condominio cond2 = new Condominio (2L, "Terra Nova II", false, end1);
		condominiosRepo.save(cond2);
		
		String t1 =  "34 9.9876-1514";
		String t2 =  "34 3212-1212";
		String t3 =  "34 9.9136-4050";
		
		
		List<String> listaTelefones = new ArrayList<String>();
		listaTelefones.add(t1);
		listaTelefones.add(t2);
		listaTelefones.add(t3);
		
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		df.setLenient (false);
		
		Date data = df.parse("18/02/1990");
		
		UnidadeHabitacional un1 =  new UnidadeHabitacional(1L, "Ap 8J", "5D", true);
		unidadeHabRepo.save(un1);
		
		List<UnidadeHabitacional> unidades = new ArrayList<>();
		unidades.add(un1);

		Morador m1 = new Morador(2L, "gulima", "Thxe3458frm", false, false, "Gustavo Lima", "245.786.123-09", data,  listaTelefones, cond1,  unidades);
		m1 = moradorRepo.save(m1);
		
		Morador m2 = new Morador(3L, "filipe", "senha123", false, false, "Filipe Gustavo", "116.245.145-12", data,  listaTelefones, cond2,  unidades);
		m2 = moradorRepo.save(m2);
		
			
		
		Veiculo veic1 = new Veiculo(1L, "HPG-0272", "Sandero", "Renault", "2018", m1);
		Veiculo veic2 = new Veiculo(2L, "OTG-7854", "Hornet", "Honda", "2013", m2);
		veiculoRepo.saveAll(Arrays.asList(veic1, veic2));
				
        df.setLenient (false);		
		data = df.parse("05/05/2018");
		
		AnimalEstimacao animal1 = new AnimalEstimacao(1L, "Chester", "Pug", "PEQUENO",  data, m1);
		
		df.setLenient (false);		
		data = df.parse("12/04/2018");
	    AnimalEstimacao animal2 = new AnimalEstimacao(2L, "Rex", "Beagle","PEQUENO", data, m2 );
		animaisRepo.saveAll(Arrays.asList(animal1, animal2));
		
			
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
