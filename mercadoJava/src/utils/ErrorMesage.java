package utils;

public class ErrorMesage {

    // BACKGROUND
    private static final String reset = "\u001B[0m";
    private static final String redBackground= "\u001B[41m";

    // COR DA FONTE
    private static final String black = "\u001B[30m";

    public String getReset() {
        return reset;
    }
    public String getRedBackground() {
        return redBackground;
    }
    public String getBlack() {
        return black;
    }

    public static void errorMensagem(){
        System.out.println();
        System.out.println(redBackground + black +"|                        OPÇÃO INVALIDA!!                      |" +
                reset);
        System.out.println(redBackground + black +"|         PORFAVOR NÃO DIGITAR O QUE NÃO ESTÁ SENDO PEDIDO     |"+
                reset);
        System.out.println(redBackground + black +"|                         VOLTE AO MENU                        |" +
                reset);
        System.out.println();
    }
    public static void errorMensagem2(){
        System.out.println();
        System.out.println(redBackground + black +"|                       OPÇÃO INVALIDA!!                      |" +
                reset);
        System.out.println(redBackground + black +"|                 TE REDICIONAREMOS PARA O MENU               |"+
                reset);
        System.out.println();
    }

    public static void errorMensagem3(){
        System.out.println();
        System.out.println(redBackground + black +"|                     PRODUTO NÃO ENCONTRADO                  |" +
                reset);
        System.out.println(redBackground + black +"|                 VERIFIQUE SE O ID ESTÁ CORRETO              |"+
                reset);
        System.out.println();
    }

    public static void errorMensagem4(){
        System.out.println();
        System.out.println(redBackground + black +"|                       SENHA INCORRETA                       |" +
                reset);
        System.out.println(redBackground + black +"|                        Senha : 12345                        |"+
                reset);
        System.out.println();
    }

    public static void errorMensagem5(){
        System.out.println();
        System.out.println(redBackground + black +"|               NÃO EXISTEM PRODUTOS DISPONIVEIS              |" +
                reset);
        System.out.println(redBackground + black +"|                     PARA SEREM REMOVIDOS                    |"+
                reset);
        System.out.println();
    }
}
