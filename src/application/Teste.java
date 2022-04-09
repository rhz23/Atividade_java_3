package application;

import entities.Carga;
import entities.Passeio;
import utils.Leitura;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        Leitura lt = new Leitura();

        List<Passeio> listPasseios = new ArrayList<>();
        List<Carga> listCarga = new ArrayList<>();

        int opt = 0;

        while (opt !=7){
            System.out.println("\n\nSistema de Gestão de Veículos - Menu Inicial\n");
            System.out.println("1. Cadastrar Veículo de Passeio");
            System.out.println("2. Cadastrar Veículo de Carga");
            System.out.println("3. Imprimir Todos os Veículos de Passeio");
            System.out.println("4. Imprimir Todos os Veículos de Carga");
            System.out.println("5. Imprimir Veículo de Passeio pela Placa");
            System.out.println("6. Imprimir Veículo de Carga pela Placa");
            System.out.println("7. Sair do Sistema");

            opt = Integer.parseInt(lt.entDados("\nEntre com a opção desejada: "));

            switch (opt){
                case 1:
                    String continua;
                    do{
                        System.out.println("\n\n==================================\n");
                        String placa = lt.entDados("Entre com o valor da placa: ");
                        String marca = lt.entDados("Entre com o nome da marca: ");
                        String modelo = lt.entDados("Entre com o nome do modelo: ");
                        String cor = lt.entDados("Entre com a cor do veiculo: ");
                        float velocMax = Float.parseFloat(lt.entDados("Entre com a velocidade maxima: "));
                        int qtdRodas = Integer.parseInt(lt.entDados("Entre com a quantidade de rodas: "));
                        int qtdPist = Integer.parseInt(lt.entDados("Entre com a quantidade de pistões do motor do veiculo: "));
                        int potencia = Integer.parseInt(lt.entDados("Entre com a potencia do veiculo: "));
                        int qtdPassageiros = Integer.parseInt(lt.entDados("Entre com a quantidade de passageiros do veiculo: "));
                        
                        boolean existe = false;
                        for (Passeio veicPasseio: listPasseios) {
                            if (placa.equals(veicPasseio.getPlaca())){
                                existe = true;
                                break;
                            }
                        }
                        if (existe){
                            System.out.println("\nJã existe um veiculo informado com a mesma placa!");
                        }else{
                            Passeio passeio = new Passeio(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia, qtdPassageiros);
                            listPasseios.add(passeio);
                            System.out.println("\nVeiculo de passeio placa " + placa + " adicionado!");
                        }

                        continua = lt.entDados("\nDeseja adicionar outro veiculo de passeio? (SIM ou NAO)");
                    }while(continua.equals("SIM"));

                    break;

                case 2:

                    do{
                        System.out.println("\n\n==================================\n");
                        String placa = lt.entDados("Entre com o valor da placa do veiculo: ");
                        String marca = lt.entDados("Entre com o nome da marca do veiculo: ");
                        String modelo = lt.entDados("Entre com o modelo do veiculo: ");
                        String cor = lt.entDados("Entre com a cor do veiculo: ");
                        float velocMax = Float.parseFloat(lt.entDados("Entre com a velocidade maxima do veiculo: "));
                        int qtdRodas = Integer.parseInt(lt.entDados("Entre com a quantidade de rodas do veiculo: "));
                        int qtdPist = Integer.parseInt(lt.entDados("Entre com a quantidade de pistões do motor do veiculo: "));
                        int potencia = Integer.parseInt(lt.entDados("Entre com a potencia do veiculo: "));
                        int cargaMax = Integer.parseInt(lt.entDados("Entre com a carga maxima suportada pelo veiculo: "));
                        int tara = Integer.parseInt((lt.entDados("Entre com o peso de tara do veiculo: ")));

                        boolean existe = false;

                        for (Carga veicCarga: listCarga) {
                            if (placa.equals(veicCarga.getPlaca())){
                                existe = true;
                                break;
                            }
                        }
                        if (existe){
                            System.out.println("\nJã existe um veiculo de carga  informado com a mesma placa!");
                        }else{
                            Carga carga = new Carga(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia, cargaMax, tara);
                            listCarga.add(carga);
                            System.out.println("\nVeiculo de carga placa " + placa + " adicionado!");
                        }

                        continua = lt.entDados("\nDeseja adicionar outro veiculo de carga? (SIM ou NAO)");

                    }while (continua.equals("SIM"));

                    break;

                case 3:

                    System.out.println("\n\n==================================\n");
                    System.out.println("Os veiculos de passeio cadastrados são:");
                    for (Passeio veicPasseio: listPasseios) {
                        System.out.println(veicPasseio);
                    }
                    System.out.println("\nFim da lista de veiculos==========");
                    lt.entDados("Tecle enter para retornar ao menu inicial:");

                    break;

                case 4:

                    System.out.println("\n\n==================================\n");
                    System.out.println("Os veiculos de carga cadastrados são:");
                    for (Carga veicCarga: listCarga) {
                        System.out.println(veicCarga    );
                    }
                    System.out.println("\nFim da lista de veiculos==========");
                    lt.entDados("Tecle enter para retornar ao menu inicial:");

                    break;

                case 5:

                    System.out.println("\n\n==================================");
                    String placaPasseio = lt.entDados("Entre com a placa do veiculo de passeio: ");
                    for (Passeio veicPasseio: listPasseios) {
                        if (placaPasseio.equals(veicPasseio.getPlaca())){
                            System.out.println("\nSeguem os dados do veiculo:");
                            System.out.printf("%s", veicPasseio.getPlaca());
                            System.out.printf("Veiculo Passeio{placa=%s, marca=%s, modelo=%s, cor=%s, velocMax=%.2f km/h, qtdRodas=%d, motor=Motor{qtdPist= %d, potencia= d%c cv}, qtdPassageiros= %d, velocidade = %.2f m/h}",
                                    veicPasseio.getPlaca(), veicPasseio.getMarca(), veicPasseio.getModelo(), veicPasseio.getCor(), veicPasseio.getVelocMax(), veicPasseio.getQtdRodas(), veicPasseio.getMotor().getQtdPist(), veicPasseio.getMotor().getPotencia(), veicPasseio.getQtdPassegeiros(), veicPasseio.calcVel(veicPasseio.getVelocMax()));
                            }
                    }
                    lt.entDados("\n\nTecle enter para retornar ao menu inicial:");

                    break;

                case 6:

                    System.out.println("\n\n==================================");
                    String placaCarga = lt.entDados("Entre com a placa do veiculo de carga: ");
                    for (Carga veicCarga: listCarga) {
                        if (placaCarga.equals(veicCarga.getPlaca())){
                            System.out.println("\nSeguem os dados do veiculo:");
                            System.out.printf("Veiculo Carga{placa=%s, marca=%s, modelo=%s, cor=%s, velocMax=%.2f km/h, qtdRodas=%d, motor=Motor{qtdPist= %d, potencia= d%c cv}, cargaMax= %d, tara= %d, velocidade = %.2f cm/h}",
                                    veicCarga.getPlaca(), veicCarga.getMarca(), veicCarga.getModelo(), veicCarga.getCor(), veicCarga.getVelocMax(), veicCarga.getQtdRodas(), veicCarga.getMotor().getQtdPist(), veicCarga.getMotor().getPotencia(), veicCarga.getCargaMax(), veicCarga.getTara(), veicCarga.calcVel(veicCarga.getVelocMax()));
                        }
                    }
                    lt.entDados("\n\nTecle enter para retornar ao menu inicial:");

                    break;

                case 7:

                    System.out.println("\n\nSaindo do sistema==================");
                    System.out.println("Aplicação encerrada");

                    break;

                default:
                    System.out.println("Entre com uma das opções abaixo:");

                    break;
            }
        }
    }
}
