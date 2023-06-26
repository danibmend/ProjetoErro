package main;

import modelo.Produto;
import utils.ErrorMesage;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;


    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu(); // CRIAR O MÉOTOD MENU NA MAIN PARA RODAR AO LIGAR.
    }

    private static void menu(){
        System.out.println();
        System.out.println();
        System.out.println("|=============================================================|");
        System.out.println("|---------------------- SUPERMERCADOS ------------------------|");
        System.out.println("|---------------------- DANIEL  BMEND ------------------------|");
        System.out.println("|                                                             |");
        System.out.println("|                                                             |");
        System.out.println("|        Selecione o número da ação que deseja realizar       |");
        System.out.println("|                                                             |");
        System.out.println("|       1- CADASTRAR          |          2- GERENCIR          |");
        System.out.println("|       3- PRODUTOS           |          4- CARRINHO          |");
        System.out.println("|                                                             |");
        System.out.println("|                          5- SAIR                            |");
        System.out.println("|                                                             |");
        System.out.println("|=============================================================|");
        System.out.println();
        System.out.print("DIGITE AQUI O NÚMERO: ");

        int option = input.nextInt(); // MUDAR PRA DIGITAR APENAS UM NUMERO

        switch (option){
            // AREA DO DONO DO MERCADO
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                gerenciarProdutos();
                break;
                // AREA DO CLIENTE
            case 3:
                selecionarProdutos();
                break;
            case 4:
                verCarrinho();
                break;
            case 5:
                sairMercado(); // CRIAR A MENSAGEM DE VOLTE SEMPRE E O SYSTEM.EXIT PARA PARAR O PROGRAMA.
            default:
                ErrorMesage.errorMensagem();
                menu();
                break;
        }

    }

    private static void cadastrarProdutos(){ // PEDIR SENHA DE PESSOAL AUTORIZADO PARA CADASTRAR (SENHA 12345)
        System.out.println("\n|=============================================================|");
        System.out.println("|------------------- CADASTRO DE PRODUTOS --------------------|");
        System.out.println("|                                                             |");
        System.out.println();
        System.out.println("|          VOCÊ ESTÁ NA ÁREA DE CADASTRO DE PRODUTOS          |");
        System.out.println("|   PARA CADASTRAR DIGITE 1   |  PARA VOLTAR AO MENU DIGITE 0 |");
        System.out.println();
        System.out.print("|DIGITE AQUI A OPÇÃO: ");

        int option = input.nextInt();

        // IFELSE SOBRE A OPÇÃO QUE O USUARIO FAZER
        if (option == 1) {
            System.out.println("|------------------------ CADASTRANDO ------------------------|");

            System.out.print("\n| Digite o nome do produto: ");//O USUARIO IRA DIGITAR O NOME E SERÁ ARMAZENADO NA VARIAVEL nome
            String nome = input.next();

            System.out.print("| Digite o preço do produto (apenas numero e ','): ");
            //O USUARIO IRA DIGITAR O VALOR E SERÁ ARMAZENADO NA VARIAVEL preco
            Double preco = input.nextDouble();

            Produto produto = new Produto(nome, preco);//Um objeto da classe PRODUTO será criado
            produtos.add(produto); //O objeto criado será adicionado a arraylist produtos

            System.out.printf("\nO produto (%s) foi cadastrado com sucesso!\n", nome);
            System.out.println("\n| PARA CADASTRAR OUTRO PRODUTO DIGITE 2    |    PARA VOLTAR AO MENU DIGITE 0 |");


            //IFELSE PARA SABER SE O USUARIO VAI QUERER CADASTRAR UM NOVO PRODUTO OU VOLTAR AO MENU
            int optioninside = input.nextInt();
            if (optioninside == 2){
                cadastrarProdutos();
            }else if(optioninside == 0){
                menu();
            }else {
                ErrorMesage.errorMensagem2();
                menu();
            }

        } else if (option == 0) {
            System.out.println("Você selecionou a opção de voltar ao menu");
            menu();
        } else {
            ErrorMesage.errorMensagem();
            cadastrarProdutos();
        }

    }

    private static void gerenciarProdutos() { // PEDIR SENHA DE PESSOAL AUTORIZADO PARA GERENCIAR (SENHA 12345)
        System.out.println("\n|=============================================================|");
        System.out.println("|---------------------- ACESSO RESTRITO ----------------------|");
        System.out.println("|                                                             |");
        System.out.println("|  DIGITE A SENHA PARA ACESSAR A GERÊNCIA                     |");
        System.out.println("|  Senha: 12345                                              |");

        int senha = input.nextInt();
        if (senha == 12345) {
            if (produtos.size() > 0) {
                System.out.println("Lista de produtos: \n");
                for (Produto produto : produtos) {
                    System.out.println(produto);
                }
                System.out.println(produtos.size() + " produtos cadastrados, digite 1 para cadastrar um novo produto," +
                        "\ndigite 2 para remover um produto" +
                        " ou digite 0 para voltar."); // COLOCAR UM IFELSE E UM SCANNER DA OPÇÃO

                int opcao = input.nextInt();
                if (opcao == 1){
                    cadastrarProdutos();
                } else if (opcao == 2) {
                    System.out.println("Vou criar esse método ainda");
                } else if (opcao == 0) {
                    menu();
                } else {
                    ErrorMesage.errorMensagem2();
                    menu();
                }

            } else {
                System.out.println("Nenhum produto cadastrado, porfavor digite 0 para voltar.");
                int menu = input.nextInt();
                if (menu == 00){
                    menu();
                }else {
                    ErrorMesage.errorMensagem2();
                    menu();
                }
            }


        } else {
            ErrorMesage.errorMensagem4();
            gerenciarProdutos();
        }
    }

    private static void selecionarProdutos(){
        if (produtos.size() > 0){
            System.out.println("|=============================================================|");
            System.out.println("|------------------- PRODUTOS DISPONIVEIS --------------------|");
            System.out.println("|                                                             |");

            for (Produto produto: produtos) {
                System.out.println();
                System.out.printf("|%s\n", produto);
            }
            System.out.println("Produtos no carrinho: " + carrinho.size());
            System.out.println();
            System.out.println("|DIGITE O ID DO PRODUTO PARA COLOCAR NO CARRINHO              |");
            System.out.println("|Digite '0' para voltar ao menu                               |");
            System.out.println("|Obs: Adicione um de cada vez                                 |");


            int id = input.nextInt(); // O usuario irá digitar o ID do produto para colocar no carrinho
            boolean isPresent = false, flag = false; // Boolean para verificar se tem coisa no carrinho;

            if(id == 0){
                menu();
            }else{
                for (Produto produto: produtos) {
                    if (id == produto.getId()){
                        flag = true;
                        int qtd;
                        try {
                            qtd = carrinho.get(produto); // Checa se o produto está no carrinho e incrementa quantidade.
                            System.out.println(carrinho.get(produto));
                            carrinho.put(produto, qtd +1);
                            System.out.println("Produto (" + produto.getNome() + ") adicionado!");
                        }catch (NullPointerException e){
                            // Se o produto for primeiro do carrinho
                            carrinho.put(produto, 1);
                            System.out.println("Produto (" + produto.getNome() + ") adicionado!");
                        }
                        System.out.println("Produtos no carrinho: " + carrinho.size());
                        isPresent = true;

                        if (isPresent){
                            System.out.println();
                            System.out.println("Deseja adicionar outro produto ao carrinho?");
                            System.out.println("Digite 1 para sim ou 0 para ir ao carrinho comprar.\n");
                            int option = input.nextInt();

                            if (option == 1){
                                selecionarProdutos();
                            } else {
                                verCarrinho();
                            }
                        }
                        break;
                    }
                }
                if(flag == false) {
                    ErrorMesage.errorMensagem3();
                    selecionarProdutos();
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados!");
            menu();
        }
    }


    private static void  verCarrinho(){
        System.out.println("|=============================================================|");
        System.out.println("|------------------- CARRINHO DE COMPRAS ---------------------|");
        System.out.println("|                                                             |");
        System.out.println();
        if (carrinho.size() > 0){
            for (Produto produto : carrinho.keySet()){
                System.out.println("Produto: " + produto.getNome() + " " + Utils.doubleString(produto.getPreco())
                        + "\nQuantidade: " + carrinho.get(produto));
                System.out.println();
            }
            System.out.println();
            System.out.println("Verifique os itens do seu carrinho, " +
                               "\npara comprar digite 1, para remover um item digite 2" +
                               "\npara adicionar algo digite 3, para voltar ao menu digite 0");
            int option = input.nextInt();

            if (option == 0){
                menu();
            } else if (option == 1) {
                finalizarCompra();
            } else if (option == 2){
                removerProdutos();
            } else if (option == 3) {
                selecionarProdutos();
            } else {
                ErrorMesage.errorMensagem();
                verCarrinho();
            }

        }else {
            System.out.println("Seu carrinho está vazio!\nPara colocar produtos digite 1 e para voltar ao menu digite 0");
            int option = input.nextInt();
            if (option == 1){
                selecionarProdutos();
            } else if (option == 0) {
                menu();
            } else {
                ErrorMesage.errorMensagem2();
                menu();
            }

        }

    }


    private static void removerProdutos(){

    }

    private static void finalizarCompra(){
        Double valorCompra = 0.0;
        System.out.println("|=============================================================|");
        System.out.println("|--------------------- FINALIZAR COMPRA ----------------------|");
        System.out.println("|                                                             |");

        for (Produto produto : carrinho.keySet()){
            int qtd = carrinho.get(produto);
            valorCompra += produto.getPreco() * qtd;
            System.out.println(produto.getNome());
            System.out.println("Quantidade: " + qtd);
            System.out.println("Total: " + produto.getPreco() * qtd);
            System.out.println();
        }
        System.out.println();
        System.out.println("O valor da sua compra é:" +
                           "\n------------------------");
        System.out.println(Utils.doubleString(valorCompra));
        System.out.println("Para comprar digite 1       |      Para voltar ao menu digite 0");
        int lastOption = input.nextInt();

        if (lastOption == 0){
            menu();
        } else if (lastOption == 1) {
            carrinho.clear();
            System.out.println("Obrigado pela preferência e volte sempre! " +
                    "\nDigite 0 para ir ao menu ou digite qualquer coisa para sair do mercado!");

            int finish = input.nextInt();

            if (finish == 0)
                menu();


        } else {
            ErrorMesage.errorMensagem();
            finalizarCompra();
        }

    }

    private static void sairMercado(){

    }

}

