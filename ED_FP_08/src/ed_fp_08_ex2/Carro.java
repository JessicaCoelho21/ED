package ed_fp_08_ex2;

public class Carro implements Comparable<Carro>{
    private String name;
    private int cilindrada;

    /**
     * Método construtor
     * @param name
     * @param cilindrada 
     */
    public Carro(String name, int cilindrada) {
        this.name = name;
        this.cilindrada = cilindrada;
    }

    /**
     * Método pata obter o nome
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Método para atribuir um nome
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método para obter a cilindrada
     * @return 
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * Método para atribuir uma cilindrada
     * @param cilindrada 
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Método para comparar
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Carro o) {
        if (this.cilindrada == o.cilindrada) {
            return 0;
        }
        
        else if (this.cilindrada > o.cilindrada) {
            return 1;
        }
        
        else{
            return -1;
        }
    }
}
