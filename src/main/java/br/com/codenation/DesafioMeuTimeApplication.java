package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import javafx.util.Pair;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private Map<Long, Integer> idTimes = new HashMap<Long, Integer>();
	private Map<Long, Integer> idJogadores = new HashMap<Long, Integer>();
	private Map<Long, Long> identificaTimeDoJogador = new HashMap<Long, Long>();
	private Map<Long, Long> identificaCapitaoDoTime = new HashMap<Long, Long>();
	private Map<Long, String> nomeJogadores = new HashMap<Long, String>();
	private Map<Long, String> nomeTimes = new HashMap<Long, String>();
	private Map<Long, BigDecimal> salarioJogador = new HashMap<Long, BigDecimal>();
	private Map<Long, Pair<String, String>> coresCamisaTimes = new HashMap<Long, Pair<String, String>>();

	private List<Pair<Long, Integer>> topJogadoresHabilidades = new ArrayList<>();
	private List<Time> times = new ArrayList<>();
	private List<Jogador> jogadores = new ArrayList<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		if(idTimes.containsKey(id)){
			throw new IdentificadorUtilizadoException();
		}
		coresCamisaTimes.put(id, new Pair<String, String>(corUniformePrincipal, corUniformeSecundario));
		idTimes.put(id, 1);
		nomeTimes.put(id,nome);
		Time time = new Time();
		time.setId(id);
		time.setNome(nome);
		time.setDataCriacao(dataCriacao);
		time.setCorUniformePrincipal(corUniformePrincipal);
		time.setCorUniformeSecundario(corUniformeSecundario);
		times.add(time);

	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		if(idJogadores.containsKey(id)){
			throw new IdentificadorUtilizadoException();
		}

		if(!idTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}

		topJogadoresHabilidades.add(new Pair<Long, Integer>(id, nivelHabilidade));
		idJogadores.put(id, 1);
		identificaTimeDoJogador.put(id, idTime);
		nomeJogadores.put(id, nome);
		salarioJogador.put(id, salario);

		Jogador jogador = new Jogador();
		jogador.setId(id);
		jogador.setDataNascimento(dataNascimento);
		jogador.setNome(nome);
		jogador.setIdTime(idTime);
		jogador.setNivelHabilidade(nivelHabilidade);
		jogador.setSalario(salario);
		jogadores.add(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		if(!idJogadores.containsKey(idJogador)){
			throw new JogadorNaoEncontradoException();
		}

		Long time = identificaTimeDoJogador.get(idJogador);
		identificaCapitaoDoTime.put(time, idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		if(!idTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}

		if(!identificaCapitaoDoTime.containsKey(idTime)) {
			throw new CapitaoNaoInformadoException();
		}

		return identificaCapitaoDoTime.get(idTime);
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {

	    Jogador jogador = jogadores.stream().filter(j -> j.getId().equals(idJogador))
											.findAny()
											.orElse(null);

		if(jogador == null) {
			throw new JogadorNaoEncontradoException();
		}

		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {

		Time time = times.stream().filter(t -> t.getId().equals(idTime))
									.findAny().orElse(null);

		if(time == null){
			throw new TimeNaoEncontradoException();
		}

		return time.getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(!idTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}

		List<Long> jogadoresDoTime = jogadores.stream()
									.filter(jogador -> jogador.getIdTime().equals(idTime))
									.sorted(Comparator.comparing(Jogador::getId))
									.map(Jogador::getId)
									.collect(Collectors.toList());
		return jogadoresDoTime;
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(!idTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}

		Pair<Long,Integer> melhorJogador = new Pair<Long,Integer>(new Long(0),0);

		for(Jogador jogador: jogadores){
			if(jogador.getIdTime().equals(idTime)){
				if(jogador.getNivelHabilidade().compareTo(melhorJogador.getValue()) == 1){
					melhorJogador = new Pair(jogador.getId(),jogador.getNivelHabilidade());
				}else if(jogador.getNivelHabilidade().equals(melhorJogador.getValue())
						&& jogador.getId().compareTo(melhorJogador.getKey()) == -1){
					melhorJogador = new Pair(jogador.getId(),jogador.getNivelHabilidade());
				}
			}
		}
		return melhorJogador.getKey();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		if(!idTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}

		Pair<Long,LocalDate> jogadorVelho = new Pair<Long,LocalDate>(new Long(0), LocalDate.MAX);

		for(Jogador jogador: jogadores){
			if(jogador.getIdTime().equals(idTime)) {
				if (jogador.getDataNascimento().isBefore(jogadorVelho.getValue())) {
					jogadorVelho = new Pair<Long, LocalDate>(jogador.getId(), jogador.getDataNascimento());
				} else if (jogador.getDataNascimento().isEqual(jogadorVelho.getValue())
						&& jogador.getId().compareTo(jogadorVelho.getKey()) == -1) {
					jogadorVelho = new Pair<Long, LocalDate>(jogador.getId(), jogador.getDataNascimento());
				}
			}
		}
		return jogadorVelho.getKey();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List<Long> todosTimes = new ArrayList<>();
		for(Time time: times){
			todosTimes.add(time.getId());
		}
		todosTimes.sort(Long::compareTo);
		return todosTimes;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(!idTimes.containsKey(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		Pair<Long,BigDecimal> maiorSalario = new Pair<Long,BigDecimal>(new Long(0), new BigDecimal(0));
		for(Jogador jogador: jogadores){
			if(jogador.getIdTime().equals(idTime)){
				if(jogador.getSalario().compareTo(maiorSalario.getValue()) == 1){
					maiorSalario = new Pair(jogador.getId(),jogador.getSalario());
				}else if(jogador.getSalario().equals(maiorSalario.getValue()) && jogador.getId().compareTo(maiorSalario.getKey()) == -1){
					maiorSalario = new Pair(jogador.getId(),jogador.getSalario());
				}
			}
		}
		return maiorSalario.getKey();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(!idJogadores.containsKey(idJogador)){
			throw new JogadorNaoEncontradoException();
		}

		return salarioJogador.get(idJogador);
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> jogadoresDoTime = new ArrayList<>();
		topJogadoresHabilidades.sort(new Comparator<Pair<Long, Integer>>() {

			@Override
			public int compare(Pair<Long, Integer> o1, Pair<Long, Integer> o2) {
				if(o1.getValue().compareTo(o2.getValue()) == 1){
					return -1;
				}else if(o1.getValue().equals(o2.getValue())){
					if(o1.getKey().compareTo(o2.getKey()) == -1){
						return -1;
					}else{
						return 1;
					}
				}

				return 0;
			}
		});
		int i = 0;
		for(Pair<Long, Integer> topJogador : topJogadoresHabilidades){
			i++;
			jogadoresDoTime.add(topJogador.getKey());
			if(i==top.intValue())break;
		}
		return jogadoresDoTime;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		if(!idTimes.containsKey(timeDaCasa)) {
			throw new TimeNaoEncontradoException();
		}

		if(!idTimes.containsKey(timeDeFora)) {
			throw new TimeNaoEncontradoException();
		}

		Pair<String,String> camisasTimeDaCasa = coresCamisaTimes.get(timeDaCasa);
		Pair<String,String> camisasTimeDeFora = coresCamisaTimes.get(timeDeFora);

		if(camisasTimeDaCasa.getKey().equals(camisasTimeDeFora.getKey())){
			return camisasTimeDeFora.getValue();
		}

		return  camisasTimeDeFora.getKey();
	}

}