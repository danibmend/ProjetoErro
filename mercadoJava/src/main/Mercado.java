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
        menu();
    }
    
    private static void menu(){

        // PRODUTOS JÁ EXISTENTES NO MERCADO
        Produto arroz = new Produto("Arroz" ,10);
        produtos.add(arroz);
        Produto feijao = new Produto("Feijão" ,10);
        produtos.add(feijao);
        Produto batata = new Produto("Batata" ,8);
        produtos.add(batata);
        Produto boi = new Produto("Bife de boi" ,15);
        produtos.add(boi);

        // MENU
        boolean flag = true;
        while(flag){
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
            try{
                int option = input.nextInt(); // MUDAR PRA DIGITAR APENAS UM NUMERO
                // ESTÉTICA PURA
                for (int i=0; i < 10; i++){
                    System.out.println();
                }

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
                    flag = false; // CRIAR A MENSAGEM DE VOLTE SEMPRE E O SYSTEM.EXIT PARA PARAR O PROGRAMA.
                    default:
                    ErrorMesage.errorMensagem();
                    break;
                }
            }catch(Exception e){
                ErrorMesage.errorMensagem();
                input.next();
            }
        }
    }
    
    private static void cadastrarProdutos() { // PEDIR SENHA DE PESSOAL AUTORIZADO PARA CADASTRAR (SENHA 12345)
        boolean flag = true;
        while (flag) {
            System.out.println("\n|=============================================================|");
            System.out.println("|---------------------- ACESSO RESTRITO ----------------------|");
            System.out.println("|                                                             |");
            System.out.println("|  DIGITE A SENHA PARA ACESSAR OS CADASTROS                   |");
            System.out.println("|  Senha: 12345                                               |");

            try {

                int senha = input.nextInt();
                // ESTÉTICA PURA
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }
                if (senha == 12345) {
                    System.out.println("\n|=============================================================|");
                    System.out.println("|------------------- CADASTRO DE PRODUTOS --------------------|");
                    System.out.println("|                                                             |");
                    System.out.println();
                    System.out.println("|          VOCÊ ESTÁ NA ÁREA DE CADASTRO DE PRODUTOS          |");
                    System.out.println("|   PARA CADASTRAR DIGITE 1   |  PARA VOLTAR AO MENU DIGITE 0 |");
                    System.out.println();
                    System.out.print("|DIGITE AQUI A OPÇÃO: ");

                    int option = input.nextInt();
                    // ESTÉTICA PURA
                    for (int i = 0; i < 10; i++) {
                        System.out.println();
                    }

                    // IFELSE SOBRE A OPÇÃO QUE O USUARIO FAZER
                    if (option == 1) {
                        System.out.println("|------------------------ CADASTRANDO ------------------------|");
                        input.nextLine();
                        System.out.print("\n| Digite o nome do produto: ");//O USUARIO IRA DIGITAR O NOME E SERÁ ARMAZENADO NA VARIAVEL nome
                        String nome = input.nextLine();


                        System.out.print("| Digite o preço do produto (apenas numero e ','): ");
                        //O USUARIO IRA DIGITAR O VALOR E SERÁ ARMAZENADO NA VARIAVEL preco
                        Double preco = input.nextDouble();

                        Produto produto = new Produto(nome, preco);//Um objeto da classe PRODUTO será criado
                        produtos.add(produto); //O objeto criado será adicionado a arraylist produtos

                        System.out.printf("\nO produto (%s) foi cadastrado com sucesso!\n", produto.getNome());
                        System.out.println("\n| PARA CADASTRAR OUTRO PRODUTO DIGITE 2    |    PARA VOLTAR AO MENU DIGITE 0 |");


                        //IFELSE PARA SABER SE O USUARIO VAI QUERER CADASTRAR UM NOVO PRODUTO OU VOLTAR AO MENU
                        int optioninside = input.nextInt();
                        // ESTÉTICA PURA
                        for (int i = 0; i < 10; i++) {
                            System.out.println();
                        }

                        if (optioninside == 2) {
                            cadastrarProdutos();
                        } else if (optioninside == 0) {
                            menu();
                        } else {
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

                } else {
                    ErrorMesage.errorMensagem4();
                    gerenciarProdutos();
                }
            } catch (Exception a) {
                input.nextInt();
                cadastrarProdutos();
            }
        }
    }

    private static void gerenciarProdutos() { // PEDIR SENHA DE PESSOAL AUTORIZADO PARA GERENCIAR (SENHA 12345)
        System.out.println("\n|=============================================================|");
        System.out.println("|---------------------- ACESSO RESTRITO ----------------------|");
        System.out.println("|                                                             |");
        System.out.println("|  DIGITE A SENHA PARA ACESSAR A GERÊNCIA                     |");
        System.out.println("|  Senha: 12345                                               |");
        
        int senha = input.nextInt();
        // ESTÉTICA PURA
        for (int i=0; i < 10; i++){
            System.out.println();
        }

        if (senha == 12345) {
            if (produtos.size() > 0) {
                System.out.println("|=============================================================|");
                System.out.println("|--------------------- LISTA DE PRODUTOS ---------------------|");
                System.out.println("|                                                             |");
                for (Produto produto : produtos) {
                    System.out.println("\n" + produto);
                }
                System.out.println("\n" + produtos.size() + " produtos em estoque,\n" +
                        "\nDigite 1 para cadastrar um novo produto," +
                        "\nDigite 2 para remover um produto" +
                        "\nDigite 0 para voltar ao menu."); // COLOCAR UM IFELSE E UM SCANNER DA OPÇÃO
                
                int opcao = input.nextInt();
                // ESTÉTICA PURA
                for (int i=0; i < 10; i++){
                    System.out.println();
                }

                if (opcao == 1){
                    cadastrarProdutos();
                } else if (opcao == 2) {
                    removerProdutosEstoque();
                } else if (opcao == 0) {
                    menu();
                } else {
                    ErrorMesage.errorMensagem2();
                    menu();
                }
                
            } else {
                System.out.println("Nenhum produto cadastrado, porfavor digite 0 para voltar.");
                int menu = input.nextInt();
                // ESTÉTICA PURA
                for (int i=0; i < 10; i++){
                    System.out.println();
                }

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
    
    private static void selecionarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("|=============================================================|");
            System.out.println("|------------------- PRODUTOS DISPONIVEIS --------------------|");
            System.out.println("|                                                             |");

            for (Produto produto : produtos) {
                System.out.println();
                System.out.printf("|%s\n", produto);
            }
            System.out.println("\nProdutos no carrinho: " + carrinho.size());
            System.out.println();
            System.out.println("|DIGITE O ID DO PRODUTO PARA COLOCAR NO CARRINHO              |");
            System.out.println("|Digite '0' para voltar ao menu                               |");
            System.out.println("|Obs: Adicione um de cada vez                                 |");


            int id = input.nextInt(); // O usuario irá digitar o ID do produto para colocar no carrinho


            boolean isPresent = false, flag = false; // Boolean para verificar se tem coisa no carrinho;

            if (id == 0) {
                menu();
            } else {
                for (Produto produto : produtos) {
                    if (id == produto.getId()) {
                        flag = true;
                        int qtd;
                        try {
                            qtd = carrinho.get(produto); // Checa se o produto está no carrinho e incrementa quantidade.
                            carrinho.put(produto, ++qtd);
                            System.out.println("\nProduto (" + produto.getNome() + ") adicionado!");
                        } catch (NullPointerException e) {
                            // Se o produto for primeiro do carrinho
                            carrinho.put(produto, 1);
                            System.out.println("\nProduto (" + produto.getNome() + ") adicionado!");
                        }

                        isPresent = true;

                        if (isPresent) {
                            System.out.println("\nProdutos no carrinho: " + carrinho.size());
                            System.out.println("\nDeseja adicionar outro produto ao carrinho?");
                            System.out.println("| Digite 1 para adicionar mais" +
                                               "\n| Digite 2 para ir ao carrinho comprar." +
                                               "\n| Digite 0 para ir ao menu");
                            int option = input.nextInt();

                            if (option == 1) {
                                selecionarProdutos();
                            } else if(option == 2){
                                verCarrinho();
                            }else if(option == 0){
                                menu();
                            } else {
                                ErrorMesage.errorMensagem2();
                            }
                        }
                        break;
                    }
                }
                if (flag == false) {
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
                               "\n- Digite 1 para comprar" +
                               "\n- Digite 2 para remover algo" +
                               "\n- Digite 3 para adicionar algo" +
                               "\n- Digite 0 para voltar ao menu");
            int option = input.nextInt();
            // ESTÉTICA PURA
            for (int i=0; i < 10; i++){
                System.out.println();
            }


            if (option == 0){
                menu();
            } else if (option == 1) {
                finalizarCompra();
            } else if (option == 2){
                removerProdutosCarrinho();
            } else if (option == 3) {
                selecionarProdutos();
            } else {
                ErrorMesage.errorMensagem();
                verCarrinho();
            }

        }else {
            System.out.println("Seu carrinho está vazio!\nPara colocar produtos digite 1 e para voltar ao menu digite 0");
            int option = input.nextInt();
            // ESTÉTICA PURA
            for (int i=0; i < 10; i++){
                System.out.println();
            }

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


    private static void removerProdutosEstoque(){
        if (produtos.size() > 0) {
            System.out.println("|=============================================================|");
            System.out.println("|---------------- REMOVER PRODUTOS DO ESTOQUE ----------------|");
            System.out.println("|                                                             |");
            for (Produto produto : produtos) {
                System.out.println("\n" + produto);
            }
            System.out.println("\n" + produtos.size() + " produtos em estoque,\n");
            System.out.println("| Digite o ID do produto que deseja remover, ou 0 para voltar");
            int removeOption = input.nextInt();

            for (Produto produto : produtos) {
                if (removeOption == produto.getId()){
                    produtos.remove(produto);
                    // ESTÉTICA PURA
                    for (int i=0; i < 10; i++){
                        System.out.println();
                    }
                    System.out.println(produto.getNome() + " foi removido com sucesso!");
                    System.out.println("| Produtos em estoque: " + produtos.size());
                    System.out.println("\n| Digite 1 para remover outro produto" +
                                       "\n| Digite 2 para voltar a gerência" +
                                       "\n| Digite 0 para voltar ao menu");

                    int option = input.nextInt();

                    if (option == 1){
                        removerProdutosEstoque();
                    } else if (option == 2) {
                        gerenciarProdutos();
                    } else if (option == 0){
                        menu();
                    } else {
                        ErrorMesage.errorMensagem2();
                        menu();
                    }


                }else if (removeOption == 0){
                    gerenciarProdutos();
                } else {
                    ErrorMesage.errorMensagem3();
                    removerProdutosEstoque();
                }
            }

        }else {
            ErrorMesage.errorMensagem5();
            menu();
        }
    }

    private static void removerProdutosCarrinho(){
        if (produtos.size() > 0) {
            System.out.println("|=============================================================|");
            System.out.println("|--------------- REMOVER PRODUTOS DO CARRINHO ----------------|");
            System.out.println("|                                                             |");
            for (Produto produto : carrinho.keySet()){
                System.out.println("Produto: " + produto.getNome() + " " + Utils.doubleString(produto.getPreco())
                        + "\nID: " + produto.getId() +"\nQuantidade: " + carrinho.get(produto));
                System.out.println();
            }
            System.out.println("\n" + carrinho.size() + " produtos no carrinho,\n");
            System.out.println("| Digite o ID do produto que deseja remover, ou 0 para voltar");
            int removeOption = input.nextInt();

            for (Produto produto : carrinho.keySet()) {
                if (removeOption == produto.getId()){
                    int qtds = 1;
                    if(qtds == carrinho.get(produto)){
                        carrinho.remove(produto);
                    }else {
                         carrinho.get(produto); // carrinho.get(produto) fala a quantidade, ai seria isso -1, mas da erro;
                    }
                    // ESTÉTICA PURA
                    for (int i=0; i < 10; i++){
                        System.out.println();
                    }
                    System.out.println(produto.getNome() + " foi removido com sucesso!");
                    System.out.println();
                    System.out.println("\n| Digite 1 para remover outro produto" +
                            "\n| Digite 2 para finalizar a compra" +
                            "\n| Digite 0 para voltar ao menu");

                    int option = input.nextInt();

                    if (option == 1){
                        removerProdutosCarrinho();
                    } else if (option == 2) {
                        finalizarCompra();
                    } else if (option == 0){
                        menu();
                    } else {
                        ErrorMesage.errorMensagem2();
                        menu();
                    }


                }else if (removeOption == 0){
                    gerenciarProdutos();
                } else {
                    ErrorMesage.errorMensagem3();
                    removerProdutosCarrinho();
                }
            }

        }else {
            ErrorMesage.errorMensagem5();
            menu();
        }
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
        // ESTÉTICA PURA
        for (int i=0; i < 10; i++){
            System.out.println();
        }


        if (lastOption == 0){
            menu();
        } else if (lastOption == 1) {
            carrinho.clear();
            System.out.println("Obrigado pela preferência e volte sempre! " +
                    "\nDigite 0 para ir ao menu ou digite qualquer coisa para sair do mercado!");

            int finish = input.nextInt();
            if (finish == 0){
                menu();
            }
        } else {
            ErrorMesage.errorMensagem();
            finalizarCompra();
        }
    }
    
    private static void sairMercado(){
        
    }
    
}

