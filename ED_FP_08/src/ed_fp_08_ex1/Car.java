package ed_fp_08_ex1;

public class Car implements Comparable<Car>{
    private String name;
    private int cilindrada;

    /**
     * Método construtor
     * @param name
     * @param cilindrada
     */
    public Car(String name, int cilindrada) {
        this.name = name;
        this.cilindrada = cilindrada;
    }

    /**
     * Método getter para obter o nome do carro
     * @return nome do carro
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método setter para atribuir um nome ao carro
     * @param name nome a adtribuir ao carro
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método getter para obter a cilindrada do carro
     * @return cilindrada do carro
     */
    public int getCilindrada() {
        return this.cilindrada;
    }

    /**
     * Método setter para atribuir um cilindrada ao carro
     * @param cilindrada cilindrada a atribuir ao carro
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Método que compara a cilindrada de diferentes carros
     * @param c
     * @return 
     */
    @Override
    public int compareTo(Car c) {
        if (this.cilindrada == c.cilindrada) {
            return 0;
        } else if (this.cilindrada > c.cilindrada) {
            return 1;
        } else{
            return -1;
        }
    }  
}
