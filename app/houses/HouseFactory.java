package app.houses;

import app.interfaces.IHouse;
import app.utils.Type;

import java.util.ArrayList;

public class HouseFactory {
    private final ArrayList<IHouse> houses = new ArrayList<IHouse>();

    public ArrayList<IHouse> createHouse() {
        houses.add(new GainEvent("Inicio"));
        houses.add(new Property("Açude do Cedro", 100000, 15000, 1, Type.BASIC));
        houses.add(new Property("Praça do Leão", 75000, 14000, 1, Type.BASIC));
        houses.add(new Share("Companhia Petrolífera", 200000, 40000));
        houses.add(new Property("Praça da Estação", 60000, 10000, 1, Type.BASIC));
        houses.add(new Property("Centro Cultural Rachel de Queiroz", 240000, 18000, 1, Type.HIGH_MEDIUM));
        houses.add(new LuckyOrSetback());
        houses.add(new Property("Chalé da Pedra", 220000, 17000, 1, Type.HIGH_MEDIUM));
        houses.add(new GainEvent("Restituição Imposto de Renda"));
        houses.add(new Property("Rua Basilio Pinto", 200000, 18000, 1, Type.HIGH_MEDIUM));
        houses.add(new PrisonVisit());
        houses.add(new LuckyOrSetback());
        houses.add(new Property("Rua Rui Barbosa", 200000, 17000, 1, Type.MEDIUM));
        houses.add(new Property("Av Plácido Castelo", 180000, 15000, 1, Type.MEDIUM));
        houses.add(new Share("Enel", 200000, 40000));
        houses.add(new Property("Av José Caetano Almeida", 180000, 16000, 1, Type.MEDIUM));
        houses.add(new LostEvent());
        houses.add(new Property("Av José de Freitas", 400000, 24000, 1, Type.ADVANCED));
        houses.add(new Property("Bairro Centro", 350000, 22000, 1, Type.ADVANCED));
        houses.add(new Property("Bairro Combate", 120000, 15000, 1, Type.HIGH_BASIC));
        houses.add(new Holiday());
        houses.add(new Share("Cagece", 200000, 50000));
        houses.add(new Share("Companhia de Mineração", 200000, 50000));
        houses.add(new LuckyOrSetback());
        houses.add(new Property("Bairro Campo Velho", 140000, 18000, 1, Type.HIGH_BASIC));
        houses.add(new Property("Planalto Renascer", 160000, 19000, 1, Type.HIGH_BASIC));
        houses.add(new LuckyOrSetback());
        houses.add(new Property("Pedra do Cruzeiro", 140000, 15000, 1, Type.HIGH_BASIC));
        houses.add(new Share("Pontocom", 150000, 30000));
        houses.add(new Prison());
        houses.add(new Property("Pedra da Galinha Choca", 320000, 25000, 1, Type.ADVANCED));
        houses.add(new LuckyOrSetback());
        houses.add(new Property("Pedra da Baleia", 300000, 21000, 1, Type.ADVANCED));
        houses.add(new Property("Pedra Faladeira", 300000, 20000, 1, Type.ADVANCED));
        houses.add(new Property("Lagoa do Monólitos", 280000, 19000, 1, Type.HIGH_MEDIUM));
        houses.add(new Share("Crédito de carbono", 150000, 20000));
        houses.add(new LuckyOrSetback());
        houses.add(new Property("Santuário N.Sra Imaculada", 260000, 21000, 1, Type.HIGH_MEDIUM));
        return houses;
    }

}
