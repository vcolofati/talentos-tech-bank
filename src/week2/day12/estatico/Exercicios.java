package week2.day12.estatico;

public class Exercicios {
    public static void exercicio2() {

    /* 4.) Escreva a classe ConversaoDeUnidadesDeArea com métodos estáticos para conversão
    das unidades de área segundo a lista abaixo.
      * 1 metro quadrado = 10,76 pés quadrados
      * 1 pé quadrado = 929 centímetros quadrados
      * 1 milha quadrada = 640 acres
      * 1 acre = 43.560 pés quadrados
     */
        final double value = 1;
        System.out.printf("%.2f metro(s) quadrado(s) são %.2f pé(s) quadrado(s).%n",
                value, ConversaoDeUnidadesDeArea.metrosQuadradosParaPesQuadrados(value));

        System.out.printf("%.2f pé(s) quadrado(s) são %.2f centímetro(s) quadrado(s).%n",
                value, ConversaoDeUnidadesDeArea.pesQuadradosParaCmQuadrados(value));

        System.out.printf("%.2f milha(s) quadrado(s) são %.2f acre(s).%n",
                value, ConversaoDeUnidadesDeArea.milhasQuadradasParaAcres(value));

        System.out.printf("%.2f acre(s) são %.2f pé(s) quadrado(s).%n",
                value, ConversaoDeUnidadesDeArea.acresParaPesQuadrados(value));

    }

    public static void main(String[] args) {
        exercicio2();
    }
}
