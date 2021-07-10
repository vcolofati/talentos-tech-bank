package week2.day12.estatico;

public class ConversaoDeUnidadesDeArea {

    public static double metrosQuadradosParaPesQuadrados(double value) {
        return value * 10.76;
    }

    public static double pesQuadradosParaCmQuadrados(double value) {
        return value * 929;
    }

    public static double milhasQuadradasParaAcres(double value) {
        return value * 640;
    }

    public static double acresParaPesQuadrados(double value) {
        return value * 43560;
    }
}
