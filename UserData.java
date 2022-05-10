import java.util.Scanner;

public class UserData<T> {
    Scanner keyboard = new Scanner(System.in);
    private String description;//nome, login, senha, telefone, cpf, endereço, etc
    private T value;

    public UserData(T valor, String d) {
        setValue(valor);
        setDescription(d);
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T valor) {
        this.value = valor;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}