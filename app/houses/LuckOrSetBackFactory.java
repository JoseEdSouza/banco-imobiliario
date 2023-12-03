package app.houses;

import app.interfaces.IHouse;
import java.util.ArrayList;

public class LuckOrSetBackFactory{
    private final ArrayList<String> message = new ArrayList<String>();
    private final ArrayList<Integer> values = new ArrayList<Integer>();
    public void createMessage(){
        message.add("Investimento em terrenos lunares: Receba R$ 50.000,00 da NASA");
        message.add("Gaste R$ 50.000 para adequar suas propriedades a um parque temático");
        message.add("Vizinho produtor de filmes: Receba R$ 15.000,00 pelos direitos de filmagem da sua casa");
        message.add("Seu imóvel virou cenário de filme de ação. Desembolse R$ 115.000");
        message.add("Fundou a primeira agência imobiliária lunar: Receba R$ 100.000,00 de comissão");
        message.add("Venceu um concurso de jardinagem! Invista R$ 17.000 em um jardim");
        message.add("Descobriu portal para mundo mágico: Receba R$ 20.000,00 em aluguel de fadas");
        message.add("Aliens escolheram sua propriedade como moradia. Pague R$ 70.000 pra se livrar deles");
        message.add("Seu cachorro ganhou um concurso de arquitetura: Receba R$ 40.000,00 em prêmios caninos");
        message.add("Inquilino abriu um restaurante exótico. Despache R$ 19.000 pra reforma");
        message.add("Encontrou um baú de ouro no quintal: Ganhe R$ 75.000,00");
        message.add("Transforme suas propriedades em espaços de arte urbana por R$ 80.000. ");
        message.add("Participou concurso de decoração: Receba R$ 25.000,00 pelo seu estilo impecável");
        message.add("Seu imóvel será palco de um show de fogos de artifício. Gaste tudo! R$ 100.000");
        message.add("Construiu uma casa na árvore para extraterrestres: Ganhe R$ 60.000,00 em aluguel alienígena");
        message.add("Pinguins se mudaram para seu terreno. Invista R$ 30.000 em pista de patinação");
        message.add("Inventou uma tinta que deixa a casa invisível: Evite o pagamento de aluguel este turno");// rrrr
        message.add("Inquilino abre escola de magia. Pague R$ 40.500 por reformas");
        message.add("Abriu uma pizzaria no porão: Receba R$ 15.000,00 pelo sucesso das suas pizzas subterrâneas");
        message.add("Transforme sua propriedade em um parque aquático por R$ 11.000.");
        message.add("Seu jardim virou um parque temático: Receba R$ 35.000,00 pelas entradas");
        message.add("Show das Poderosas. Garanta seu ingresso por R$ 60.000");
        message.add("Ganhou uma competição de jardinagem extraterrestre: Receba R$ 45.000,00 em prêmios intergalácticos");
        message.add("Cientistas malucos alugaram sua propriedade para experimentos. Pague R$ 86.500 pelos danos causados");
        message.add("Descobriu uma fonte de água mineral no quintal: Venda por R$ 80.000,00");
        message.add("Inquilino abre escola de circo. Desembolse R$ 17.000 por aulas de malabares");
        message.add("Seu vizinho é um bruxo: Receba R$ 55.000,00 em aluguel de poções mágicas");
        message.add("VScode travou! Invista R$ 70.000 em um RTX 4060 para resolver");
        message.add("Construiu um labirinto no jardim: Receba R$ 25.000,00 pelos ingressos");
        message.add("Pneu do carro furou: Pague R$ 25.000 pelo concerto");

    }
    public void createValues(){
        values.add(50000);
        values.add(50000);
        values.add(15000);
        values.add(11.000);
        values.add(10.000);
        values.add(17000);
        values.add(20000);
        values.add(70000);
        values.add(40000);
        values.add(19000);
        values.add(75000);
        values.add(80000);
        values.add(25000);
        values.add(10.000);
        values.add(60000);
        values.add(30000);
        values.add(alguel);// rrr
        values.add(40500);
        values.add(15000);
        values.add(11000);
        values.add(35000);
        values.add(60000);
        values.add(45000);
        values.add(86500);
        values.add(80000);
        values.add(17000);
        values.add(55000);
        values.add(70000);
        values.add(25000);
        values.add(25000);
    }

    public ArrayList<IHouse> getMessage(){
        return cards;
    }

}
